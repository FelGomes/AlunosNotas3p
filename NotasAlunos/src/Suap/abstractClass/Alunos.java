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
    
    public Alunos(){
        
    }

    public Alunos(String nome, String cpf, String endereco, String dataNascimento, String sexo, int usuario_id) {
        super(nome, cpf, endereco, dataNascimento, sexo, usuario_id);
    }

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
    //MeTODO PARA INSERIR DADOS NA TABELA
    @Override
    public void inserir() throws SQLException{
        Connection conexao = new Conexao().getConexao();
        String sql = "Insert into alunos (alunos_matriculados, alunos_sala, alunos_turma, qtd_disciplina, fk_alunos_usuarios_id) values (?,?,?,?,?)";
        try {
            PreparedStatement stmt;
            PreparedStatement stmt1;
            stmt = conexao.prepareStatement(sql);
            stmt.setBoolean(1, this.isAlunos_matriculados());
            stmt.setString(2, this.getAlunos_sala());
            stmt.setString(3, this.getAlunos_turma());
            stmt.setInt(4, this.getQtd_disciplina());
            stmt.setInt(5, this.getId());
            
        } catch (Exception e) {
            System.out.println("Erro ao fazer a inserção de dados no Banco! " + e.getMessage());
        }
        
    
            
    }
    /**
     * Método para remover campo da tabela alunos recebendo um ID
     * @param alunos_id 
     */
    //METODOS PARA DELETAR O CAMPO ESPECIFICADO
    @Override
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
    
    //Funçao para alterar os dados da tabela, com condiçoes apenas para MATRICULA, SALA, TURMA, QUANTIDADE DE DISCIPLINAS e PARA TUDO
    @Override
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
    @Override
    public void listar(int alunos_id){
        if(alunos_id > 0){
            String sql = "Select u.usuarios_nome, u.usuarios_sexo, u.usuario_endereco, u.usuario_cpf, u.usuario_nascimento,"
                    + "a.alunos_sala, a.alunos_turma FROM alunos a INNER JOIN usuarios u on a.alunos_usuarios_id = u.usuarios_id Where a.alunos_id = ?";
            //Inner join para mostrar os dados do usuarios que passam chave primaria para alunos, nessa condição, especificos com id escolhido
            PreparedStatement pstm = null;
            ResultSet rset = null;
            
            try {
                Connection conexao = new Conexao().getConexao();
                pstm = conexao.prepareStatement(sql);
                pstm.setInt(1, alunos_id);
                pstm.executeQuery();
                
                if(rset.next()){
                    System.out.println("==================================================");
                    System.out.println("ID: " + rset.getInt("alunos_id"));
                    System.out.println("Nome: " + rset.getString("usuarios_nome"));  
                    System.out.println("Sexo: " + rset.getString("usuarios_sexo"));
                    System.out.println("Endereco: " + rset.getString("usuarios_endereco"));
                    System.out.println("CPF: " + rset.getString("usuarios_cpf"));
                    System.out.println("Nascimento: " + rset.getString("usuarios_nascimento"));
                    System.out.println("Sala: " + rset.getString("alunos_sala"));
                    System.out.println("Turma: " + rset.getString("usuarios_turma"));
                    System.out.println("==================================================");
                }else {
                    System.out.println("Nenhum aluno encontrado com o ID fornecido " + alunos_id);
                }
                
            } catch (Exception e) {
                System.out.println("Erro ao fazer a listagem da tabela aluno " + e.getMessage());
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
            String sql = "Select u.usuarios_nome, u.usuarios_sexo, u.usuarios_endereco, u.usuarios_cpf, u.usuarios_nascimento,"
                    + "a.alunos_sala, a.alunos_turma FROM alunos a INNER JOIN usuarios u on a.fk_alunos_usuarios_id = u.usuarios_id";
            //Select com inner join de alunos que recebem a chave estrangeira de usuarios, nesse caso, ira mostrar todos os dados
            PreparedStatement pstm = null;
            ResultSet rset = null;
            
            try {
                Connection conexao = new Conexao().getConexao();
                pstm = conexao.prepareStatement(sql);
                
                rset = pstm.executeQuery();
                
                while(rset.next()){
                    System.out.println("==================================================");
                    System.out.println("ID: " + rset.getInt("alunos_id"));
                    System.out.println("Nome: " + rset.getString("usuarios_nome"));  
                    System.out.println("Sexo: " + rset.getString("usuarios_sexo"));
                    System.out.println("Endereco: " + rset.getString("usuarios_endereco"));
                    System.out.println("CPF: " + rset.getString("usuarios_cpf"));
                    System.out.println("Nascimento: " + rset.getString("usuarios_nascimento"));
                    System.out.println("Sala: " + rset.getString("alunos_sala"));
                    System.out.println("Turma: " + rset.getString("alunos_turma"));
                    System.out.println("==================================================");
                }
                
            } catch (SQLException e) {
                System.out.println("Erro ao fazer a listagem da tabela aluno " + e.getMessage());
                
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
        }
    }
    /**
     * Metodo para verificar a existencia do id
     * @param alunos_id
     * @return 
     */
    
    public boolean verificarAlunos(int alunos_id) {
        try (Connection conexao = new Conexao().getConexao();
             PreparedStatement comando = conexao.prepareStatement("SELECT * FROM alunos WHERE fk_alunos_usuarios_id = ?")) {
            comando.setInt(1, alunos_id);
            try (ResultSet resultado = comando.executeQuery()) {
                return resultado.next(); 
            }
        } catch (SQLException e) {
            System.out.println("Erro ao verificar a tabela alunos " + e.getMessage());
        }
        return false;
    }
}

    
    

