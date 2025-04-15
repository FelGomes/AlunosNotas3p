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
 * @author felipe 
 * @since 15/04 at 15:17
 */
public class Alunos extends UsuarioAbstract{
    
    
    private boolean alunos_matriculados;
    private String alunos_sala, alunos_turma;
    private int qtd_disciplina;

    public boolean isAlunos_matriculados() {
        return alunos_matriculados;
    }

    public void setAlunos_matriculados(boolean alunos_matriculados) {
        this.alunos_matriculados = alunos_matriculados;
    }

    public String getAlunos_sala() {
        return alunos_sala;
    }

    public void setAlunos_sala(String alunos_sala) {
        this.alunos_sala = alunos_sala;
    }

    public String getAlunos_turma() {
        return alunos_turma;
    }

    public void setAlunos_turma(String alunos_turma) {
        this.alunos_turma = alunos_turma;
    }

    public int getQtd_disciplina() {
        return qtd_disciplina;
    }

    public void setQtd_disciplina(int qtd_disciplina) {
        this.qtd_disciplina = qtd_disciplina;
    }
    
    public void inserir() throws SQLException{
        Connection conexao = new Conexao().getConexao();
        String sql = "Insert into alunos values (alunos_matriculados, alunos_sala, alunos_turma, qtd_disciplina, fk_alunos_usuarios_id) values (?,?,?,?,?)";
        try {
            PreparedStatement stmt = null;
            stmt.setBoolean(1, this.isAlunos_matriculados());
            stmt.setString(2, this.getAlunos_sala());
            stmt.setString(3, this.getAlunos_turma());
            stmt.setInt(4, this.getQtd_disciplina());
            //stmt.setString(5, this.getInst_escolaridade());
            
        } catch (Exception e) {
            System.out.println("Erro ao fazer a inserção de dados no Banco! " + e.getMessage());
        }
        
            
            
    }
    /**
     * Método para remover campo da tabela alunos recebendo um ID
     * @param alunos_id 
     */
    
    public void deletar(int alunos_id){
        String sql = "Delete from alunos WHERE alunos_id = ?";
        PreparedStatement pstm = null;
        
        try {
            Connection conexao = new Conexao().getConexao();
            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, alunos_id);
            
            pstm.execute();
            
            
            
        } catch (Exception e) {
            System.out.println("Erro ao deletar valores na tabela Alunos! " + e.getMessage());
            
        }finally{
            try {
                if(pstm != null){
                    pstm.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    /**
     * Metodo para alterar os atributos da tabela alunos
     * @param alunos_id
     * @param atributo 
     */
    public void alterar(int alunos_id, String atributo){
        if(atributo.equals("matricula")){
            String sql = "Update alunos set alunos_matriculados = ? where alunos_id = ?";
            PreparedStatement pstm = null;
            try {
                Connection conexao = new Conexao().getConexao();
                pstm.setBoolean(1, this.isAlunos_matriculados());
                pstm.setInt(2, alunos_id);
                pstm.execute();
                
            } catch (SQLException e){
                System.out.println("Erro ao alterar o atributo alunos_matriculados da tabela ALUNO! " + e.getMessage());
                
            } finally {
                try{
                    if (pstm != null) {
                        pstm.close();

                    }
                } catch(SQLException e){
                    System.out.println(e.getMessage());
                }
            }
            
        } else if(atributo.equals("sala")){
            String sql = "Update alunos set alunos_sala = ? where alunos_id = ?";
            PreparedStatement pstm = null;
            try {
                Connection conexao = new Conexao().getConexao();
                pstm.setString(1, this.getAlunos_sala());
                pstm.setInt(2, alunos_id);
                pstm.execute();
                
            } catch (SQLException e){
                System.out.println("Erro ao alterar o atributo alunos_sala da tabela ALUNOS! " + e.getMessage());
                
            } finally {
                try{
                    if (pstm != null) {
                        pstm.close();

                    }
                } catch(SQLException e){
                    System.out.println(e.getMessage());
                }
            }
        } else if(atributo.equals("turma")){
            String sql = "Update alunos set alunos_turma = ? where alunos_id = ?";
            PreparedStatement pstm = null;
            try {
                Connection conexao = new Conexao().getConexao();
                pstm.setString(1, this.getAlunos_turma());
                pstm.setInt(2, alunos_id);
                pstm.execute();
                
            } catch (SQLException e){
                System.out.println("Erro ao alterar o atributo alunos_turma da tabela ALUNOS " + e.getMessage());
                
            } finally {
                try{
                    if (pstm != null) {
                        pstm.close();

                    }
                } catch(SQLException e){
                    System.out.println(e.getMessage());
                }
            }
        } else if(atributo.equals("materias")){
            String sql = "Update alunos set qtd_disciplinas = ? where alunos_id = ?";
            PreparedStatement pstm = null;
            try {
                Connection conexao = new Conexao().getConexao();
                pstm.setInt(1, this.getQtd_disciplina());
                pstm.setInt(2, alunos_id);
                pstm.execute();
                
            } catch (SQLException e){
                System.out.println("Erro ao alterar o atributo qtd_disciplina da tabela ALUNOS! " + e.getMessage());
                
            } finally {
                try{
                    if (pstm != null) {
                        pstm.close();

                    }
                } catch(SQLException e){
                    System.out.println(e.getMessage());
                }
            }
        
        } else if(atributo.equals("tudo")){
            String sql = "Update alunos set alunos_matriculados = ?, alunos_sala = ?, alunos_turma = ?, qtd_disciplinas = ? where alunos_id = ?";
            PreparedStatement pstm = null;
            try {
                Connection conexao = new Conexao().getConexao();
                pstm.setBoolean(1,this.isAlunos_matriculados());
                pstm.setString(2, this.getAlunos_sala());
                pstm.setString(3, this.getAlunos_turma());
                pstm.setInt(4, this.getQtd_disciplina());
                pstm.setInt(5, alunos_id);
                pstm.execute();
                
            } catch (SQLException e){
                System.out.println("Erro ao alterar a tabela ALUNOS! " + e.getMessage());
                
            } finally {
                try{
                    if (pstm != null) {
                        pstm.close();

                    }
                } catch(SQLException e){
                    System.out.println(e.getMessage());
                }
            }
        }        
        
    } 
    /**
     * Metodo para listar os valores de alunos
     * @param alunos_id
     */
    public void listar(int alunos_id){
        if(alunos_id > 0){
            String sql = "Select usuarios_nome, usuarios_sexo = ?";
            PreparedStatement pstm = null;
            ResultSet rset = null;
            
            try {
                Connection conexao = new Conexao().getConexao();
                pstm = conexao.prepareStatement(sql);
                pstm.setInt(1, inst_id);
                pstm.executeQuery();
                
                if(rset.next()){
                    System.out.println("==================================================");
                    System.out.println("ID: " + rset.getInt("instituicao_id"));
                    System.out.println("Nome: " + rset.getString("instituicao_nome"));
                    System.out.println("Endereco: " + rset.getString("instituicao_endereco"));
                    System.out.println("Cidade: " + rset.getString("instituicao_cidade"));
                    System.out.println("Uf: " + rset.getString("instituicao_uf"));
                    System.out.println("Escolaridade: " + rset.getString("instituicao_escolaridade"));
                    System.out.println("Nivel: " + rset.getString("instituicao_nivel"));
                    System.out.println("==================================================");
                }else {
                    System.out.println("Nenhuma instituicao encontrado com o ID fornecido " + inst_id);
                }
                
            } catch (Exception e) {
                System.out.println("Erro ao fazer a listagem da tabela instituicao " + e.getMessage());
            } finally {
                
                try {
                    if (rset != null){
                        rset.close();
                    }
                    if (pstm != null){
                        pstm.close();
                    }
                    
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
            
            
        } else {
            String sql = "Select * from instituicao";
            PreparedStatement pstm = null;
            ResultSet rset = null;
            
            try {
                Connection conexao = new Conexao().getConexao();
                pstm = conexao.prepareStatement(sql);
                
                rset = pstm.executeQuery();
                
                while(rset.next()){
                    System.out.println("==================================================");
                    System.out.println("ID: " + rset.getInt("instituicao_id"));
                    System.out.println("Nome: " + rset.getString("instituicao_nome"));
                    System.out.println("Endereco: " + rset.getString("instituicao_endereco"));
                    System.out.println("Cidade: " + rset.getString("instituicao_cidade"));
                    System.out.println("Uf: " + rset.getString("instituicao_uf"));
                    System.out.println("Escolaridade: " + rset.getString("instituicao_escolaridade"));
                    System.out.println("Nivel: " + rset.getString("instituicao_nivel"));
                    System.out.println("==================================================");
                }
                
            } catch (SQLException e) {
                System.out.println("Erro ao fazer a listagem da tabela INSTITUICAO " + e.getMessage());
                
            } finally {
                try {
                    if (rset != null){
                        rset.close();
                    }
                    if (pstm != null){
                        rset.close();
                    }
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                
                }   
            }
        }
    }
    /**
     * Metodo para verificar a existencia do id
     * @param inst_id
     * @return 
     */
    
    public static boolean verificarInstituicao(int inst_id) {
        try (Connection conexao = new Conexao().getConexao();
             PreparedStatement comando = conexao.prepareStatement("SELECT * FROM fornecedores WHERE fornecedores_id = ?")) {
            comando.setInt(1, inst_id);
            try (ResultSet resultado = comando.executeQuery()) {
                return resultado.next(); 
            }
        } catch (SQLException e) {
            System.out.println("Erro ao verificar a tabela instituicao: " + e.getMessage());
        }
        return false;
    }
}

    
    

