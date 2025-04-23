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
    private int diarios_id;
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
   public void inserir() {
        String sql = "INSERT INTO diario (diarios_local, diarios_disciplinas, qtd_alunos, fk_diarios_professores_, fk_diarios_alunos_) VALUES (?, ?, ?, ?, ?)";

        try (Connection conexao = new Conexao().getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, this.getDiariosLocal());
            stmt.setString(2, this.getDiariosDisciplinas());
            stmt.setInt(3, this.getQtdAlunos());
            stmt.setInt(4, this.getFkDiariosProfessores());
            stmt.setInt(5, this.getFkDiariosAlunos());
            stmt.execute();

            System.out.println("📘 Diário cadastrado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao inserir diário: " + e.getMessage());
        }
    }
    
    //DELET
      public void deletar(int diarios_id) {
        String sql = "DELETE FROM diario WHERE diarios_id = ?";

        try (Connection conexao = new Conexao().getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, diarios_id);
            stmt.execute();

            System.out.println("Diário deletado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao deletar diário: " + e.getMessage());
        }
    }
    
    public void listar(int diarios_id) {
    String sql = "SELECT d.diarios_id, d.diarios_local, d.diarios_disciplinas, d.qtd_alunos, " +
                 "p.professor_nome, a.aluno_nome " +
                 "FROM diario d " +
                 "INNER JOIN professor p ON d.fk_diarios_professores_ = p.professor_id " +
                 "INNER JOIN aluno a ON d.fk_diarios_alunos_ = a.aluno_id";

    if (diarios_id > 0) {
        sql += " WHERE d.diarios_id = ?";
    }

    try (Connection conexao = new Conexao().getConexao();
         PreparedStatement stmt = conexao.prepareStatement(sql)) {

        if (diarios_id > 0) {
            stmt.setInt(1, diarios_id);
        }

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            System.out.println("=======================================");
            System.out.println("ID do Diário: " + rs.getInt("diarios_id"));
            System.out.println("Local: " + rs.getString("diarios_local"));
            System.out.println("Disciplina: " + rs.getString("diarios_disciplinas"));
            System.out.println("Quantidade de Alunos: " + rs.getInt("qtd_alunos"));
            System.out.println("Professor: " + rs.getString("professor_nome"));
            System.out.println("Aluno: " + rs.getString("aluno_nome"));
            System.out.println("=======================================");
        }

    } catch (SQLException e) {
        System.out.println("Erro ao listar diário: " + e.getMessage());
    }
}
  // Método para alterar
    public void alterar(int diarios_id) {
        String sql = "UPDATE diario SET diarios_local = ?, diarios_disciplinas = ?, qtd_alunos = ?, fk_diarios_professores_ = ?, fk_diarios_alunos_ = ? WHERE diarios_id = ?";

        try (Connection conexao = new Conexao().getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, this.getDiariosLocal());
            stmt.setString(2, this.getDiariosDisciplinas());
            stmt.setInt(3, this.getQtdAlunos());
            stmt.setInt(4, this.getFkDiariosProfessores());
            stmt.setInt(5, this.getFkDiariosAlunos());
            stmt.setInt(6, diarios_id);
            stmt.execute();

            System.out.println("Diário atualizado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar diário: " + e.getMessage());
        }
    }
     // Verificação
    public boolean verificarDiario(int diarios_id) {
        String sql = "SELECT * FROM diario WHERE diarios_id = ?";

        try (Connection conexao = new Conexao().getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, diarios_id);
            ResultSet rs = stmt.executeQuery();
            return rs.next();

        } catch (SQLException e) {
            System.out.println("Erro ao verificar diário: " + e.getMessage());
        }
        return false;
    }
    
    }
    

