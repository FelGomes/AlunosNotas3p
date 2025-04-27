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
    private int idProfessor;
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
    
    @Override
    public void inserir(){
        Connection conexao = new Conexao().getConexao();
        //String sintaxeSQL1 = "INSERT INTO usuarios (usuario_id, usuarios_nome, usuarios_endereco, usuarios_cpf, usuarios_sexo, usuarios_nascimento) values (?,?,?,?,?,?)";
        String sintaxeSQL2 = "INSERT INTO professores (professores_id, professores_disciplina, professores_turma, professores_titularidade, fk_professores_usuarios_id) values (?,?,?,?,?)";
        
        try{
        //PreparedStatement comando = conexao.prepareStatement(sintaxeSQL1);
        PreparedStatement comando2 = conexao.prepareStatement(sintaxeSQL2);
        
        comando2.setInt(1, this.idProfessor);
        comando2.setString(2, this.disciplinaMinistrada);
        comando2.setString(3, this.turmaEnsinada);
        comando2.setString(4, this.grauTitularidade);
        
        comando2.execute();
        comando2.close();
        conexao.close();
        }catch (Exception e){
            System.out.println("Erro ao cadastrar professor: " + e.getMessage());
        }
    }
    
    @Override
    public void deletar(int idProfessor){
        Connection conexao = new Conexao().getConexao();
        String sintaxeSQL = "DELETE FROM professores WHERE professores_id = ?";
        
        try{
            PreparedStatement comando = conexao.prepareStatement(sintaxeSQL);
            comando.setInt(1, idProfessor);  
            
            comando.execute();
            comando.close();
            conexao.close(); 
        }catch(Exception e){
            System.out.println("Erro ao deletar professor: " + e.getMessage());
        }   
    }  
    
    public void listarProfessores(){
        Connection conexao = new Conexao().getConexao();
        String sintaxeSQL = "SELECT * FROM professores";
        
        try{
            PreparedStatement comando = conexao.prepareStatement(sintaxeSQL);
            ResultSet mostrar = comando.executeQuery();
            
            System.out.println("\nProfessores cadastrados!\n");
            
            while(mostrar.next()){
                System.out.println("==================================================");
                System.out.println("ID de Usuário: " + mostrar.getInt("usuarios_id"));
                System.out.println("Nome: " + mostrar.getString("usuarios_nome"));
                System.out.println("Endereco: " + mostrar.getString("usuarios_endereco"));
                System.out.println("CPF: " + mostrar.getString("usuarios_cpf"));
                System.out.println("Sexo: " + mostrar.getString("usuarios_sexo"));
                System.out.println("Disciplina: " + mostrar.getString("professores_disciplina"));
                System.out.println("Turma: " + mostrar.getString("professores_turma"));
                System.out.println("Titularidade: " + mostrar.getString("professores_titularidade"));      
                System.out.println("==================================================");
            }
            
            mostrar.close();
            comando.close();
            conexao.close();
        }catch(Exception e){
            System.out.println("Erro ao listar professores: " + e.getMessage());
        }
    }
}
