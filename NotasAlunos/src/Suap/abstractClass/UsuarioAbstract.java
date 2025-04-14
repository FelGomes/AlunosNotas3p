
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
    
    private String nome, cpf, endereco, sexo, dataNascimento;
    
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
    
    

    
    
    /**
     * Método para inserir na tabela Usuario
     * @throws SQLException 
     */
    public void inserir() throws SQLException{
        Connection conexao = new Conexao().getConexao();
        String sql = "Insert into usuario values (nome, endereco, cpf, sexo, dataNascimento) values (?,?,?,?,?)";
        try {
            PreparedStatement stmt = null;
            stmt.setString(1, this.getNome());
            stmt.setString(2, this.getEndereco());
            stmt.setString(3, this.getCpf());
            stmt.setString(4, this.getSexo());
            stmt.setString(5, this.getDataNascimento());
        } catch (Exception e) {
            System.out.println("Erro ao fazer a inserção de dados no Banco! " + e.getMessage());
        }
        
            
            
    }
    
}
