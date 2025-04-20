/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Suap.abstractClass;

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

    
}
