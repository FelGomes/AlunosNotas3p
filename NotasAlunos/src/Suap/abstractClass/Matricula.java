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
    
    public void inserir(){
        String sql = "INSERT INTO matricula (matricula_data, aluno_id, instituicao_id) VALUES (?, ?, ?)";
         try (Connection conexao = new Conexao().getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            
            stmt.setString(1, this.getData());
            stmt.setInt(2, this.getAlunoId());
            stmt.setInt(3, this.getInstituicaoId());
            stmt.execute();
            
        } catch (SQLException e) {
            System.out.println("Erro ao inserir matricula: " + e.getMessage());
        }
    }
    
    public void deletar(int matricula_id){
         String sql = "DELETE FROM matricula WHERE matricula_id = ?";
        try (Connection conexao = new Conexao().getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            
            stmt.setInt(1, matricula_id);
            stmt.execute();
            
        } catch (SQLException e) {
            System.out.println("Erro ao deletar matricula: " + e.getMessage());
        }
    }
    public void alterar(int matricula_id){
         String sql = "UPDATE matricula SET matricula_data = ?, aluno_id = ?, instituicao_id = ? WHERE matricula_id = ?";
        try (Connection conexao = new Conexao().getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            
            stmt.setString(1, this.getData());
            stmt.setInt(2, this.getAlunoId());
            stmt.setInt(3, this.getInstituicaoId());
            stmt.setInt(4, matricula_id);
            stmt.execute();
            
        } catch (SQLException e) {
            System.out.println("Erro ao alterar matricula: " + e.getMessage());
        }
    }
    public void listar(int matricula_id) {
        String sql = matricula_id > 0 ? "SELECT * FROM matricula WHERE matricula_id = ?" : "SELECT * FROM matricula";
        try (Connection conexao = new Conexao().getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            
            if (matricula_id > 0) stmt.setInt(1, matricula_id);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                System.out.println("=======================================");
                System.out.println("ID: " + rs.getInt("matricula_id"));
                System.out.println("Data: " + rs.getString("matricula_data"));
                System.out.println("Aluno ID: " + rs.getInt("aluno_id"));
                System.out.println("Instituicao ID: " + rs.getInt("instituicao_id"));
                System.out.println("=======================================");
            }
            
        } catch (SQLException e) {
            System.out.println("Erro ao listar matriculas: " + e.getMessage());
        }
    }
    
    
    
}

