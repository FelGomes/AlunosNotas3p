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
    private int diario_id, aluno_id, professor_id, instituicao_id;
    private String disciplina, descricao, data_registro;
    
    //Getters e Setters
    public int getDiario_id(){
        return diario_id;
    }
    
       public void setDiario_id(int diario_id) {
        this.diario_id = diario_id;
    }

    public int getAluno_id() {
        return aluno_id;
    }

    public void setAluno_id(int aluno_id) {
        this.aluno_id = aluno_id;
    }

    public int getProfessor_id() {
        return professor_id;
    }

    public void setProfessor_id(int professor_id) {
        this.professor_id = professor_id;
    }

    public int getInstituicao_id() {
        return instituicao_id;
    }

    public void setInstituicao_id(int instituicao_id) {
        this.instituicao_id = instituicao_id;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData_registro() {
        return data_registro;
    }

    public void setData_registro(String data_registro) {
        this.data_registro = data_registro;
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
    

