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
 * @author Dheniel Rodrigues Luis 
 * @since 18/04/2025 as 20:38h
 */
public class Professores extends UsuarioAbstract {
    
    private String disciplinaMinistrada;
    private String turmaEnsinada;
    private String grauTitularidade;
    
    public Professores(){
        
    }
    
    public Professores(String nome, String cpf, String endereco, String dataNascimento, String sexo, int usuario_id, String disciplinaMinistrada, String turmaEnsinada, String grauTitularidade){
        super(nome, cpf, endereco, dataNascimento, sexo, usuario_id);
        this.disciplinaMinistrada = disciplinaMinistrada;
        this.turmaEnsinada = turmaEnsinada;
        this.grauTitularidade = grauTitularidade; 
    }

    public String getDisciplinaMinistrada() {
        return disciplinaMinistrada;
    }

    public void setDisciplinaMinistrada(String disciplinaMinistrada) {
        this.disciplinaMinistrada = disciplinaMinistrada;
    }

    public String getTurmaEnsinada() {
        return turmaEnsinada;
    }

    public void setTurmaEnsinada(String turmaEnsinada) {
        this.turmaEnsinada = turmaEnsinada;
    }

    public String getGrauTitularidade() {
        return grauTitularidade;
    }

    public void setGrauTitularidade(String grauTitularidade) {
        this.grauTitularidade = grauTitularidade;
    }
    
    
    
}
