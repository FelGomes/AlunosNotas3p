package Suap;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author felipe Ferreira
 * @since 13/04 at 20:20
 */
public class Instituicao {
    
    private int  inst_nivel;
    private String inst_nome, inst_endereco, inst_cidade, inst_uf, inst_escolaridade;
    
    
    
    Instituicao(){
        
    }
    
    Instituicao(String inst_nome, String inst_endereco, String inst_cidade, String inst_uf, String inst_escolaridade, int inst_nivel){
        this.inst_nome = inst_nome;
        this.inst_endereco = inst_endereco;
        this.inst_cidade = inst_cidade;
        this.inst_uf = inst_uf;
        this.inst_escolaridade = inst_escolaridade;
        this.inst_nivel = inst_nivel;
    }

    public int getInst_nivel() {
        return inst_nivel;
    }

    public void setInst_nivel(int inst_nivel) {
        this.inst_nivel = inst_nivel;
    }

    public String getInst_nome() {
        return inst_nome;
    }

    public void setInst_nome(String inst_nome) {
        this.inst_nome = inst_nome;
    }

    public String getInst_endereco() {
        return inst_endereco;
    }

    public void setInst_endereco(String inst_endereco) {
        this.inst_endereco = inst_endereco;
    }

    public String getInst_cidade() {
        return inst_cidade;
    }

    public void setInst_cidade(String inst_cidade) {
        this.inst_cidade = inst_cidade;
    }

    public String getInst_uf() {
        return inst_uf;
    }

    public void setInst_uf(String inst_uf) {
        this.inst_uf = inst_uf;
    }

    public String getInst_escolaridade() {
        return inst_escolaridade;
    }

    public void setInst_escolaridade(String inst_escolaridade) {
        this.inst_escolaridade = inst_escolaridade;
    }
    /**
     * Método para inserir na tabela instituição: nome, endereco, cidade, uf, escolaridade, nivel
     * @throws SQLException 
     */
    
    //METODOS PARA INSERIR VALORES NA TABELA INSTITUIÇAO
    public void inserir() throws SQLException{
        Connection conexao = new Conexao().getConexao();
        String sql = "Insert into instituicao values (instituicao_nome, instituicao_endereco, instituicao_cidade, instituicao_uf, instituicao_escolaridade, instituicao_nivel) values (?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = null;
            stmt.setString(1, this.getInst_nome());
            stmt.setString(2, this.getInst_endereco());
            stmt.setString(3, this.getInst_cidade());
            stmt.setString(4, this.getInst_uf());
            stmt.setString(5, this.getInst_escolaridade());
            stmt.setInt(6,this.getInst_nivel());
        } catch (Exception e) {
            System.out.println("Erro ao fazer a inserção de dados no Banco! " + e.getMessage());
        }
        
            
            
    }
    /**
     * Método para remover campo da tabela instituicao recebendo um ID
     * @param inst_id 
     */
    //METODO PARA DELETAR CAMPOS DA TABELA INSTITUIÇAO
    public void deletar(int inst_id){
        String sql = "Delete from instituicao WHERE instituicao_id = ?";
        PreparedStatement pstm = null;
        
        try {
            Connection conexao = new Conexao().getConexao();
            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, inst_id);
            
            pstm.execute();
            
            
            
        } catch (Exception e) {
            System.out.println("Erro ao deletar valores na tabela Instituicao! " + e.getMessage());
            
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
     * Metodo para alterar os atributos da tabela instituicao
     * @param inst_id
     * @param atributo 
     */
    
    
    //METODOS PARA ALTERAR VALORES NA TABELA INSTITUIÇAO, COM CONDICOES PARA: NOME, ENDERECO, CIDADE, UF, ESCOLARIDADE, NIVEL e TUDO
    public void alterar(int inst_id, String atributo){
        if(atributo.equals("nome")){
            String sql = "Update instituicao set instituicao_nome = ? where instituicao_id = ?";
            PreparedStatement pstm = null;
            try {
                Connection conexao = new Conexao().getConexao();
                pstm.setString(1, this.getInst_nome());
                pstm.setInt(2, inst_id);
                pstm.execute();
                
            } catch (SQLException e){
                System.out.println("Erro ao alterar o atributo instituicao_nome da tabela INSTITUICAO! " + e.getMessage());
                
            } finally {
                try{
                    if (pstm != null) {
                        pstm.close();

                    }
                } catch(SQLException e){
                    System.out.println(e.getMessage());
                }
            }
            
        } else if(atributo.equals("endereco")){
            String sql = "Update instituicao set instituicao_endereco = ? where instituicao_id = ?";
            PreparedStatement pstm = null;
            try {
                Connection conexao = new Conexao().getConexao();
                pstm.setString(1, this.getInst_endereco());
                pstm.setInt(2, inst_id);
                pstm.execute();
                
            } catch (SQLException e){
                System.out.println("Erro ao alterar o atributo instituicao_endereco da tabela INSTITUICAO! " + e.getMessage());
                
            } finally {
                try{
                    if (pstm != null) {
                        pstm.close();

                    }
                } catch(SQLException e){
                    System.out.println(e.getMessage());
                }
            }
        } else if(atributo.equals("cidade")){
            String sql = "Update instituicao set instituicao_cidade = ? where instituicao_id = ?";
            PreparedStatement pstm = null;
            try {
                Connection conexao = new Conexao().getConexao();
                pstm.setString(1, this.getInst_cidade());
                pstm.setInt(2, inst_id);
                pstm.execute();
                
            } catch (SQLException e){
                System.out.println("Erro ao alterar o atributo instituicao_cidade da tabela INSTITUICAO! " + e.getMessage());
                
            } finally {
                try{
                    if (pstm != null) {
                        pstm.close();

                    }
                } catch(SQLException e){
                    System.out.println(e.getMessage());
                }
            }
        } else if(atributo.equals("uf")){
            String sql = "Update instituicao set instituicao_uf = ? where instituicao_id = ?";
            PreparedStatement pstm = null;
            try {
                Connection conexao = new Conexao().getConexao();
                pstm.setString(1, this.getInst_uf());
                pstm.setInt(2, inst_id);
                pstm.execute();
                
            } catch (SQLException e){
                System.out.println("Erro ao alterar o atributo instituicao_uf da tabela INSTITUICAO! " + e.getMessage());
                
            } finally {
                try{
                    if (pstm != null) {
                        pstm.close();

                    }
                } catch(SQLException e){
                    System.out.println(e.getMessage());
                }
            }
        }else if(atributo.equals("escolaridade")){
            String sql = "Update instituicao set instituicao_escolaridade = ? where instituicao_id = ?";
            PreparedStatement pstm = null;
            try {
                Connection conexao = new Conexao().getConexao();
                pstm.setString(1, this.getInst_escolaridade());
                pstm.setInt(2, inst_id);
                pstm.execute();
                
            } catch (SQLException e){
                System.out.println("Erro ao alterar o atributo instituicao_escolaridade da tabela INSTITUICAO! " + e.getMessage());
                
            } finally {
                try{
                    if (pstm != null) {
                        pstm.close();

                    }
                } catch(SQLException e){
                    System.out.println(e.getMessage());
                }
            }
        } else if(atributo.equals("nivel")){
            String sql = "Update instituicao set instituicao_nivel = ? where instituicao_id = ?";
            PreparedStatement pstm = null;
            try {
                Connection conexao = new Conexao().getConexao();
                pstm.setInt(1, this.getInst_nivel());
                pstm.setInt(2, inst_id);
                pstm.execute();
                
            } catch (SQLException e){
                System.out.println("Erro ao alterar o atributo instituicao_cidade da tabela INSTITUICAO! " + e.getMessage());
                
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
            String sql = "Update instituicao set instituicao_nome = ?, instituicao_endereco = ?, instituicao_cidade = ?, instituicao_uf = ?, instituicao_escolaridade = ?, instituicao_nivel = ?  where instituicao_id = ?";
            PreparedStatement pstm = null;
            try {
                Connection conexao = new Conexao().getConexao();
                pstm.setString(1, this.getInst_nome());
                pstm.setString(2, this.getInst_endereco());
                pstm.setString(3, this.getInst_cidade());
                pstm.setString(4, this.getInst_uf());
                pstm.setString(5, this.getInst_escolaridade());
                pstm.setInt(6, this.getInst_nivel());
                pstm.setInt(7, inst_id);
                pstm.execute();
                
            } catch (SQLException e){
                System.out.println("Erro ao alterar a tabela INSTITUICAO! " + e.getMessage());
                
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
     * Metodo para listar os valores de instituicao
     * @param inst_id 
     */
    
    //METODO PARA LISTAR APENAS 1 REGISTRO A PARTIR DO ID INFORMADO
    public void listar(int inst_id){
        if(inst_id > 0){
            String sql = "Select * from instituicao Where instituicao_id = ?";
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
            
        //CASO NAO SEJA PASSADO UM ID ESPECIFICO, VAI RETORNAR TODOS OS VALORES QUE HAVER NA TABELA    
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
    //MEtodo para verificar se o ID existe
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
