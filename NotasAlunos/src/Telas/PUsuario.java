/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Telas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author felipe
 */
public class PUsuario {
    
    public ArrayList<EUsuario> consultarUsuarioNome(String nome) {
        
        ArrayList<EUsuario> oListaPessoa = new ArrayList();
        
        Connection conn =  Conexao.obterConexaoMySQL();
        
        String SQL = "select * from usuarios where usuarios_nome like ? order by usuarios_nome";
        
        
        try {
            ResultSet rset;
            try (PreparedStatement pstm = conn.prepareStatement(SQL, PreparedStatement.RETURN_GENERATED_KEYS)){
                pstm.setString(1, "%" + nome.toUpperCase().trim() + "%");
                rset = pstm.executeQuery();
                int i = 0;
                
                while (rset.next()){
                    
                    EUsuario usuario = new EUsuario();
                    usuario.setNome(rset.getString("usuarios_nome"));
                    usuario.setSexo(rset.getString("usuarios_sexo"));
                    usuario.setCpf(rset.getString("usuarios_cpf"));
                    usuario.setEndereco(rset.getString("usuarios_endereco"));
                    usuario.setDataNasc(rset.getString("usuarios_nascimento"));
                    
                    oListaPessoa.add(i++, usuario);
                }
                
            }
            
                rset.close();
            
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            
        } finally {
             Conexao.fecharConexao();
        }
        
        return oListaPessoa;
    }
    //consultar
    public ArrayList<EUsuario> consultarUsuario() throws SQLException {
        
        ArrayList<EUsuario> oListaPessoa = new ArrayList();
        
        Connection conn = Conexao.obterConexaoMySQL();
        
        String SQL = "Select * from usuarios order by usuarios_nome";
        
        try {
            ResultSet rset;
            try (PreparedStatement pstm = conn.prepareStatement(SQL, PreparedStatement.RETURN_GENERATED_KEYS)){
                rset = pstm.executeQuery();
                int i = 0;
                while(rset.next()){
                    
                    EUsuario usuario = new EUsuario();
                    
                    usuario.setNome(rset.getString("usuarios_nome"));
                    usuario.setSexo(rset.getString("usuarios_sexo"));
                    usuario.setCpf(rset.getString("usuarios_cpf"));
                    usuario.setEndereco(rset.getString("usuarios_endereco"));
                    usuario.setDataNasc(rset.getString("usuarios_nascimento"));
                    
                    oListaPessoa.add(i++, usuario);
                    
                } 
            } 
                rset.close();   
            
        } catch(SQLException e){
            System.out.println(e.getMessage());
            
        } finally {
            
           Conexao.fecharConexao();
        }
        return oListaPessoa;
    }
    //inserir
    public String incluirUsuario(String nome, String sexo, String cpf, String endereco, String DataNasc){
        
        String resultado;
        
        Connection conn = Conexao.obterConexaoMySQL();
        
        try{
            String SQL = "Insert into usuarios (usuarios_nome, usuarios_sexo, usuarios_cpf, usuarios_endereco, usuarios_nascimento) values (?,?,?,?,?)";
                try (PreparedStatement pstm = conn.prepareStatement(SQL, PreparedStatement.RETURN_GENERATED_KEYS)) {                
                    pstm.setString(1, nome.toUpperCase());
                    pstm.setString(2, sexo.toUpperCase());
                    pstm.setString(3, cpf.toUpperCase());
                    pstm.setString(4, endereco.toUpperCase());
                    pstm.setString(5, DataNasc.toUpperCase());
                    pstm.executeUpdate();
                }
                
                resultado = "Inclusao efetuada com sucesso!";
                
        } catch (SQLException e) {
            resultado = "Erro na inclusao: " + e.getMessage();
        }
        
        Conexao.fecharConexao();
        
        return resultado;
    }
    
    // canpo para excluir
    public String excluirUsuario(String cpf) throws SQLException {
        
        String resultado;
        
        Connection conn = Conexao.obterConexaoMySQL();
        
        try { 
            
            String SQL = "DELETE from usuarios where usuarios_cpf = ?";
            try (PreparedStatement pstm = conn.prepareStatement(SQL, PreparedStatement.RETURN_GENERATED_KEYS)) {
                pstm.setString(1,cpf.toUpperCase());
                pstm.executeUpdate();
                
            }
            resultado = "Exclusao efetuada com sucesso!";
        
        } catch(SQLException e){
            resultado = "Erro na exclusao: " + e.getMessage();
        }
        
        Conexao.fecharConexao();
        
        return resultado;
    }
    
    
    //alterar 
      public String alterarUsuario(String nome, String sexo, String cpf, String endereco, String DataNasc) {

        String resultado;

        Connection conn = Conexao.obterConexaoMySQL();

        try {

            String SQL = "update usuarios set usuarios_nome = ?, usuarios_sexo = ?,  usuarios_endereco = ?, usuarios_nascimento = ? where usuarios_cpf = ?";
            try (PreparedStatement pstm = conn.prepareStatement(SQL, PreparedStatement.RETURN_GENERATED_KEYS)) {

                pstm.setString(1, nome.toUpperCase());
                pstm.setString(2, sexo.toUpperCase());
                pstm.setString(3, endereco.toUpperCase());
                pstm.setString(4, DataNasc.toUpperCase());
                pstm.setString(5, cpf.toUpperCase());
                pstm.executeUpdate();
            }
            resultado = "Alteraçao efetuada com sucesso!";
        } catch (SQLException e) {
            resultado = "Erro na alteraçao: " + e.getMessage();

        }

        Conexao.fecharConexao();

        return resultado;
    }
    
}
