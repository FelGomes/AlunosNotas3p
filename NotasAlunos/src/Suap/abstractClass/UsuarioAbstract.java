
package Suap.abstractClass;
import Suap.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
        
/**
 *
 * @author Carlos
 * @since 14-04 at 12:21
 * 
 */
public abstract class UsuarioAbstract {
    
    private String nome, cpf, endereco, dataNascimento;
    private String sexo;
    private int usuario_id;
    
    public UsuarioAbstract(String nome, String cpf, String endereco, String dataNascimento, String sexo, int usuario_id) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.usuario_id = usuario_id;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
     public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
   

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getId() {
        return usuario_id;
    }

    public void setId(int id) {
        this.usuario_id = id;
    }

    
    /**
     * Método para inserir na tabela Usuario
     * @throws SQLException 
     */
    public void inserir() throws SQLException{
        Connection conexao = new Conexao().getConexao();
        String sql = "Insert into usuarios values (usuarios_nome, usuarios_endereco, usuarios_cpf, usuarios_sexo, usuarios_nascimento) values (?,?,?,?,?)";
        try {
            PreparedStatement stmt = null;
            stmt.setString(1, this.getNome());
            stmt.setString(2, this.getEndereco());
            stmt.setString(3, this.getCpf());
            stmt.setString(4, String.valueOf(this.getSexo()));
            stmt.setString(5, this.getDataNascimento());
        } catch (Exception e) {
            System.out.println("Erro ao fazer a inserção de dados no Banco! " + e.getMessage());
        }
        
            
            
    }
    
    /**
     * Método para remover campo da tabela instituicao recebendo um ID
     * @param usuario_id
     */
    
    public void deletar(int usuario_id){
        String sql = "Delete from usuarios WHERE usuarios_id = ?";
        PreparedStatement pstm = null;
        
        try {
            Connection conexao = new Conexao().getConexao();
            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, usuario_id);
            
            pstm.execute();
            
            
            
        } catch (Exception e) {
            System.out.println("Erro ao deletar valores na tabela Usuarios! " + e.getMessage());
            
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
     * @param usuario_id
     * @param atributo 
     */
    
    public void alterar(int usuario_id, String atributo){
        if(atributo.equals("nome")){
            String sql = "Update usuarios set usuarios_nome = ? where usuarios_id = ?";
            PreparedStatement pstm = null;
            try {
                Connection conexao = new Conexao().getConexao();
                pstm.setString(1, this.getNome());
                pstm.setInt(2, usuario_id);
                pstm.execute();
                
            } catch (SQLException e){
                System.out.println("Erro ao alterar o atributo usuarios_nome da tabela Usuario! " + e.getMessage());
                
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
            String sql = "Update usuarios set usuarios_endereco = ? where usuarios_id = ?";
            PreparedStatement pstm = null;
            try {
                Connection conexao = new Conexao().getConexao();
                pstm.setString(1, this.getEndereco());
                pstm.setInt(2, usuario_id);
                pstm.execute();
                
            } catch (SQLException e){
                System.out.println("Erro ao alterar o atributo usuarios_endereco da tabela usuarios! " + e.getMessage());
                
            } finally {
                try{
                    if (pstm != null) {
                        pstm.close();

                    }
                } catch(SQLException e){
                    System.out.println(e.getMessage());
                }
            }
        } else if(atributo.equals("cpf")){
            String sql = "Update usuarios set usuarios_cpf = ? where usuarios_id = ?";
            PreparedStatement pstm = null;
            try {
                Connection conexao = new Conexao().getConexao();
                pstm.setString(1, this.getCpf());
                pstm.setInt(2, usuario_id);
                pstm.execute();
                
            } catch (SQLException e){
                System.out.println("Erro ao alterar o atributo usuarios_cpf da tabela Usuarios! " + e.getMessage());
                
            } finally {
                try{
                    if (pstm != null) {
                        pstm.close();

                    }
                } catch(SQLException e){
                    System.out.println(e.getMessage());
                }
            }
        } else if(atributo.equals("sexo")){
            String sql = "Update usuarios set usuarios_sexo = ? where usuarios_id = ?";
            PreparedStatement pstm = null;
            try {
                Connection conexao = new Conexao().getConexao();
                pstm.setString(1, String.valueOf(this.getSexo()));
                pstm.setInt(2, usuario_id);
                pstm.execute();
                
            } catch (SQLException e){
                System.out.println("Erro ao alterar o atributo usuarios_sexo da tabela Usuarios! " + e.getMessage());
                
            } finally {
                try{
                    if (pstm != null) {
                        pstm.close();

                    }
                } catch(SQLException e){
                    System.out.println(e.getMessage());
                }
            }
        }else if(atributo.equals("nascimento")){
            String sql = "Update usuarios set usuarios_nascimento = ? where usuarios_id = ?";
            PreparedStatement pstm = null;
            try {
                Connection conexao = new Conexao().getConexao();
                pstm.setString(1, this.getDataNascimento());
                pstm.setInt(2, usuario_id);
                pstm.execute();
                
            } catch (SQLException e){
                System.out.println("Erro ao alterar o atributo usuarios_nascimento da tabela Usuarios! " + e.getMessage());
                
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
            String sql = "Update usuarios set usuarios_nome = ?, usuarios_endereco = ?, usuarios_cpf = ?, usuarios_sexo = ?, usuarios_nascimento = ? where usuarios_id = ?";
            PreparedStatement pstm = null;
            try {
                Connection conexao = new Conexao().getConexao();
                pstm.setString(1, this.getNome());
                pstm.setString(2, this.getEndereco());
                pstm.setString(3, this.getCpf());
                pstm.setString(4, String.valueOf(this.getSexo()));
                pstm.setString(5, this.getDataNascimento());
                pstm.setInt(6, usuario_id);
                pstm.execute();
                
            } catch (SQLException e){
                System.out.println("Erro ao alterar a tabela Usuarios! " + e.getMessage());
                
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
    
    public void listar(int usuario_id){
        if(usuario_id > 0){
            String sql = "Select * from usuarios Where usuarios_id = ?";
            PreparedStatement pstm = null;
            ResultSet rset = null;
            
            try {
                Connection conexao = new Conexao().getConexao();
                pstm = conexao.prepareStatement(sql);
                pstm.setInt(1, usuario_id);
                pstm.executeQuery();
                
                if(rset.next()){
                    System.out.println("==================================================");
                    System.out.println("ID: " + rset.getInt("usuarios_id"));
                    System.out.println("Nome: " + rset.getString("usuarios_nome"));
                    System.out.println("Endereco: " + rset.getString("usuarios_endereco"));
                    System.out.println("CPF: " + rset.getString("usuarios_cpf"));
                    System.out.println("Sexo: " + rset.getString("usuarios_sexo"));
                    System.out.println("Data de nascimento: " + rset.getString("usuarios_nascimento"));
                    System.out.println("==================================================");
                }else {
                    System.out.println("Nenhuma usuario encontrado com o ID fornecido " + usuario_id);
                }
                
            } catch (Exception e) {
                System.out.println("Erro ao fazer a listagem da tabela usuarios " + e.getMessage());
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
            String sql = "Select * from usuarios";
            PreparedStatement pstm = null;
            ResultSet rset = null;
            
            try {
                Connection conexao = new Conexao().getConexao();
                pstm = conexao.prepareStatement(sql);
                
                rset = pstm.executeQuery();
                
                while(rset.next()){
                    System.out.println("==================================================");
                    System.out.println("ID: " + rset.getInt("usuarios_id"));
                    System.out.println("Nome: " + rset.getString("usuarios_nome"));
                    System.out.println("Endereco: " + rset.getString("usuarios_endereco"));
                    System.out.println("CPF: " + rset.getString("usuarios_cpf"));
                    System.out.println("Sexo: " + rset.getString("usuarios_sexo"));
                    System.out.println("Data de nascimento: " + rset.getString("usuarios_nascimento"));
                    System.out.println("==================================================");
                }
                
            } catch (SQLException e) {
                System.out.println("Erro ao fazer a listagem da tabela Usuarios " + e.getMessage());
                
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
    
     public boolean verificarUsuarios(int usuario_id) {
        try (Connection conexao = new Conexao().getConexao();
             PreparedStatement comando = conexao.prepareStatement("SELECT * FROM usuario WHERE usuarios_id = ?")) {
            comando.setInt(1, usuario_id);
            try (ResultSet resultado = comando.executeQuery()) {
                return resultado.next(); 
            }
        } catch (SQLException e) {
            System.out.println("Erro ao verificar a tabela usuarios " + e.getMessage());
        }
        return false;
    }
}
