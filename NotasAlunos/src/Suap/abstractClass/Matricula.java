/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Suap.abstractClass;
import Suap.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
/**
 *
 * @author Kaua
 * @since 20/04/2025 as 11:26
 */
public class Matricula {
    private int matriculas_id;
    private String matriculas_data_inicio;
    private String matriculas_data_fim;
    private int qtd_tempo;
    private int fk_matricula_instituicao_id;
    private int fk_matricula_alunos_;
    
    //Getters e Setters.
    public int getMatriculaId(){
        return matriculas_id;
    }
    public void setMatriculasId(int matriculas_id){
        this.matriculas_id = matriculas_id;
    }
    public String getMatriculasDataInicio(){
        return matriculas_data_inicio;
    }
   public void setMatriculasDataInicio(String matriculas_data_inicio) {
        this.matriculas_data_inicio = matriculas_data_inicio;
    }
   public String getMatriculasDataFim(){
       return matriculas_data_fim;
   }
   public void setMatriculaDataFim(String matriculas_data_fim){
       this.matriculas_data_fim = matriculas_data_fim;
   }
   public int getQtdTempo(){
       return qtd_tempo;
   }
   public void setQtdTempo(int qtd_tempo){
       this.qtd_tempo = qtd_tempo;
   }
   public int getFkInstituicaoId(){
       return fk_matricula_instituicao_id;
       
   }
   public void setFkinstituicaoId(int fk_matricula_instituicao_id){
       this.fk_matricula_instituicao_id = fk_matricula_instituicao_id;
   }
  public int getFkAlunoId() {
        return fk_matricula_alunos_;
    }
  public void setFkAlunoId(int fk_matricula_alunos_){
      this.fk_matricula_alunos_ = fk_matricula_alunos_;
  }
  // INSERÇÃO
  public void inserir(){
      String sql = "INSERT INTO matricula (matriculas_data_inicio, matriculas_data_fim, qtd_tempo, fk_matricula_instituicao_id, fk_matricula_alunos_) VALUES (?, ?, ?, ?, ?)";
       try (Connection conexao = new Conexao().getConexao();
            PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, this.getMatriculasDataInicio());
            stmt.setString(2, this.getMatriculasDataFim());
            stmt.setInt(3, this.getQtdTempo());
            stmt.setInt(4, this.getFkInstituicaoId());
            stmt.setInt(5, this.getFkAlunoId());
            stmt.execute();

        } catch (SQLException e) {
            System.out.println("Erro ao inserir matricula: " + e.getMessage());
        }
    }
  // DELETE
  public void deletar (int matriculas_id){
      String sql = "DELETE FROM matricula WHERE matriculas_id = ?";
      try (Connection conexao = new Conexao().getConexao();
           PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, matriculas_id);
            stmt.execute();

        } catch (SQLException e) {
            System.out.println("Erro ao deletar matricula " + e.getMessage());
      }
  }
  // ALTERAR
  public void alterar(int matriculas_id) {
      String sql = "UPDATE matricula SET matricula_data_inicio = ?, matricula_data_fim = ?, qtd_tempo = ?, fk_matricula_instituicao_id = ?, fk_matricula_alunos_ = ? WHERE matriculas_id = ?";
      try (Connection conexao = new Conexao().getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

           stmt.setString(1, this.getMatriculasDataInicio());
           stmt.setString(2, this.getMatriculasDataFim());
           stmt.setInt(3, this.getQtdTempo());
           stmt.setInt(4, this.getFkInstituicaoId());
           stmt.setInt(5, this.getFkAlunoId());
           stmt.setInt(6, matriculas_id);
           stmt.execute();

        } catch (SQLException e) {
            System.out.println("Erro ao alterar matrícula: " + e.getMessage());
     }
  }
  // LISTAR
public void listar(int matriculas_id){
    String sql = "SELECT m.matriculas_id, m.matriculas_data_inicio, m.matriculas_data_fim, m.qtd_tempo, " +
                "a.aluno_nome, i.instituicao_nome FROM matricula m " +
                "INNER JOIN aluno a ON m.fk_matricula_alunos_ = a.aluno_id " +
                "INNER JOIN instituicao i ON m.fk_matricula_instituicao_id = i.instituicao_id";
    
        if (matriculas_id > 0){
            sql += "WHERE m.matriculas_id = ?";
         }
     try (Connection conexao = new Conexao().getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
         if (matriculas_id > 0){
             stmt.setInt(1, matriculas_id);
         }
    ResultSet rs = stmt.executeQuery();
    while (rs.next()) {
                System.out.println("=======================================");
                System.out.println("ID da Matrícula: " + rs.getInt("matriculas_id"));
                System.out.println("Data Início: " + rs.getString("matriculas_data_inicio"));
                System.out.println("Data Fim: " + rs.getString("matriculas_data_fim"));
                System.out.println("Tempo (meses): " + rs.getInt("qtd_tempo"));
                System.out.println("Aluno: " + rs.getString("aluno_nome"));
                System.out.println("Instituição: " + rs.getString("instituicao_nome"));
                System.out.println("=======================================");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar matrículas: " + e.getMessage());
      }
   }



}


