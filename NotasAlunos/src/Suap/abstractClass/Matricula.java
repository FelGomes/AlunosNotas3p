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
  
  
  
  
}


