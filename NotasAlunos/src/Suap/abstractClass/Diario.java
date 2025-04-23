/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Suap.abstractClass;
import Suap.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Kaua
 * @since 20/04/2025 as 14:03
 */
public class Diario {
    private int diario_id;
     private String diarios_local;
    private String diarios_disciplinas;
    private int qtd_alunos;
    private int fk_diarios_professores_;
    private int fk_diarios_alunos_;
    //Getters e Setters
     public int getDiariosId() {
        return diarios_id;
    }

    public void setDiariosId(int diarios_id) {
        this.diarios_id = diarios_id;
    }

    public String getDiariosLocal() {
        return diarios_local;
    }

    public void setDiariosLocal(String diarios_local) {
        this.diarios_local = diarios_local;
    }

    public String getDiariosDisciplinas() {
        return diarios_disciplinas;
    }

    public void setDiariosDisciplinas(String diarios_disciplinas) {
        this.diarios_disciplinas = diarios_disciplinas;
    }

    public int getQtdAlunos() {
        return qtd_alunos;
    }

    public void setQtdAlunos(int qtd_alunos) {
        this.qtd_alunos = qtd_alunos;
    }

    public int getFkDiariosProfessores() {
        return fk_diarios_professores_;
    }

    public void setFkDiariosProfessores(int fk_diarios_professores_) {
        this.fk_diarios_professores_ = fk_diarios_professores_;
    }

    public int getFkDiariosAlunos() {
        return fk_diarios_alunos_;
    }

    public void setFkDiariosAlunos(int fk_diarios_alunos_) {
        this.fk_diarios_alunos_ = fk_diarios_alunos_;
    }

    //INSERÇÃO
    public void inserir() throws SQLException {
        String sql = "INSERT INTO diario (aluno_id, professor_id, instituicao_id, disciplina, descricao, data_registro) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conexao = new Conexao().getConexao(); 
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            
            stmt.setInt(1, this.getAluno_id());
            stmt.setInt(2, this.getProfessor_id());
            stmt.setInt(3, this.getInstituicao_id());
            stmt.setString(4, this.getDisciplina());
            stmt.setString(5, this.getDescricao());
            stmt.setString(6, this.getData_registro());
            
            stmt.execute();
            System.out.println("Diário inserido com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir diário: " + e.getMessage());
        }
    }
    
    //DELET
     public void deletar(int diario_id) {
        String sql = "DELETE FROM diario WHERE diario_id = ?";
        try (Connection conexao = new Conexao().getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, diario_id);
            stmt.execute();
            System.out.println("Diário removido com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao remover diário: " + e.getMessage());
        }
    }
       public void alterar(int diario_id) {
        String sql = "UPDATE diario SET aluno_id = ?, professor_id = ?, instituicao_id = ?, disciplina = ?, descricao = ?, data_registro = ? WHERE diario_id = ?";
        try (Connection conexao = new Conexao().getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            
            stmt.setInt(1, this.getAluno_id());
            stmt.setInt(2, this.getProfessor_id());
            stmt.setInt(3, this.getInstituicao_id());
            stmt.setString(4, this.getDisciplina());
            stmt.setString(5, this.getDescricao());
            stmt.setString(6, this.getData_registro());
            stmt.setInt(7, diario_id);

            stmt.execute();
            System.out.println("Diário atualizado com sucesso.");
        } catch (SQLException e){
            System.out.println("Erro ao atualizar diário: " + e.getMessage());
        }
        
     }
    
    public void listar(int diario_id) {
        String sql;

        if (diario_id > 0) {
            sql = "SELECT d.*, a.aluno_nome, p.professor_nome, i.instituicao_nome FROM diario d " +
                  "INNER JOIN aluno a ON d.aluno_id = a.aluno_id " +
                  "INNER JOIN professor p ON d.professor_id = p.professor_id " +
                  "INNER JOIN instituicao i ON d.instituicao_id = i.instituicao_id " +
                  "WHERE d.diario_id = ?";
        } else {
            sql = "SELECT d.*, a.aluno_nome, p.professor_nome, i.instituicao_nome FROM diario d " +
                  "INNER JOIN aluno a ON d.aluno_id = a.aluno_id " +
                  "INNER JOIN professor p ON d.professor_id = p.professor_id " +
                  "INNER JOIN instituicao i ON d.instituicao_id = i.instituicao_id";
        }

        try (Connection conexao = new Conexao().getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            if (diario_id > 0) {
                stmt.setInt(1, diario_id);
            }

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                System.out.println("==============================================");
                System.out.println("ID: " + rs.getInt("diario_id"));
                System.out.println("Aluno: " + rs.getString("aluno_nome"));
                System.out.println("Professor: " + rs.getString("professor_nome"));
                System.out.println("Instituição: " + rs.getString("instituicao_nome"));
                System.out.println("Disciplina: " + rs.getString("disciplina"));
                System.out.println("Descrição: " + rs.getString("descricao"));
                System.out.println("Data: " + rs.getString("data_registro"));
                System.out.println("==============================================");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar diário: " + e.getMessage());
        }
    }

}
    

