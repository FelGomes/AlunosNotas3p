/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Suap.abstractClass;

/**
 *
 * @author Kaua
 * @since 20/04/2025 as 11:26
 */
public class Matricula {
    private int matricula_id;
    private String matricula_data;
    private int aluno_id;
    private int instituicao_id;
    
    public int getId(){
        return matricula_id;
    }
    public void setId(int id){
        this.matricula_id = id;
    }
    public String getData() {
        return matricula_data;
    }
    public void setData(String data){
        this.matricula_data = data;
    }
    public int getAlunoId(){
        return aluno_id;
    }
    public void setAlunoId(int aluno_id){
        this.aluno_id = aluno_id;
    }
    public int getInstituicaoId(){
        return instituicao_id;
    }
    public void setInstituicaoId(int instituicao_id){
        this.instituicao_id = instituicao_id;
    }
    
    
    
    
    
}

