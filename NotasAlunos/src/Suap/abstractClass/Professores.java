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
    private int idUsuario;

    public int getIdProfessor() {
        return idProfessor;
    }    
    public Professores(){
    }
    
    public Professores(String disciplinaMinistrada, String turmaEnsinada, String grauTitularidade, int idUsuario){
        this.disciplinaMinistrada = disciplinaMinistrada;
        this.turmaEnsinada = turmaEnsinada;
        this.grauTitularidade = grauTitularidade; 
        this.idUsuario = idUsuario;
    }
          
    public void setIdProfessor(int idProfessor) {
        this.idProfessor = idProfessor;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }    
    
    public Professores(String nome, String cpf, String endereco, String dataNascimento, String sexo, int usuario_id, String disciplinaMinistrada, String turmaEnsinada, String grauTitularidade) {
        super(nome, cpf, endereco, dataNascimento, sexo, usuario_id);

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

    /**
     * Método para verificar se o ID procurado existe na tabela Professores
     *
     * @param idProcurado
     * @return Retorna true caso possuir o ID for encontrado e false caso não
     */
    public boolean verificarIdProfessor(int idProcurado) {
        Connection conexao = new Conexao().getConexao();
        String sintaxeSQL = "SELECT COUNT(*) FROM professores WHERE professores_id = ?";
        boolean existe = false;

        try {
            PreparedStatement comando = conexao.prepareStatement(sintaxeSQL);
            comando.setInt(1, idProcurado);
            try (ResultSet resultado = comando.executeQuery()) {
                if (resultado.next()) {
                    int quantidade = resultado.getInt(1);
                    existe = quantidade > 0;
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao verificar ID: " + e.getMessage());
        }
        return existe;
    }

    /**
     * Método para verificar se o ID procurado existe na tabela Usuários
     *
     * @param idProcurado
     * @return Retorna true caso possuir o ID for encontrado e false caso não
     */
    public boolean verificarIdUsuario(int idProcurado) {
        Connection conexao = new Conexao().getConexao();
        String sintaxeSQL = "SELECT COUNT(*) FROM usuarios WHERE usuarios_id = ?";
        boolean existe = false;

        try {
            PreparedStatement comando = conexao.prepareStatement(sintaxeSQL);
            comando.setInt(1, idProcurado);
            try (ResultSet resultado = comando.executeQuery()) {
                if (resultado.next()) {
                    int quantidade = resultado.getInt(1);
                    existe = quantidade > 0;
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao verificar ID: " + e.getMessage());
        }
        return existe;
    }

    public void inserirProfessor() {

        Connection conexao = new Conexao().getConexao();
        String sintaxeSQL = "INSERT INTO professores (professores_disciplina, professores_turma, professores_titularidade, fk_professores_usuarios_id) values (?,?,?,?)";

        try {
            PreparedStatement comando = conexao.prepareStatement(sintaxeSQL);

            comando.setString(1, this.disciplinaMinistrada);
            comando.setString(2, this.turmaEnsinada);
            comando.setString(3, this.grauTitularidade);
            comando.setInt(4, this.idUsuario);
            int alteracao = comando.executeUpdate();

            if (alteracao > 0) {
                System.out.println("Professor cadastrado com sucesso!");
            } else {
                System.out.println("Nao foi cadastrado nenhum professor!");
            }
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar professor: " + e.getMessage());
        }

    }

    @Override
    public void deletar(int idProfessor) {
        boolean existe = verificarIdProfessor(idProfessor);
        if (existe) {
            Connection conexao = new Conexao().getConexao();
            String sintaxeSQL = "DELETE FROM professores WHERE professores_id = ?";

            try {
                PreparedStatement comando = conexao.prepareStatement(sintaxeSQL);
                comando.setInt(1, idProfessor);

                int alteracao = comando.executeUpdate();

                if (alteracao > 0) {
                    System.out.println("Tabela deletada com sucesso!");
                } else {
                    System.out.println("Erro ao deletar a tabela");
                }
                
            } catch (Exception e) {
                System.out.println("Erro ao deletar professor: " + e.getMessage());
            }
        } else {
            System.out.println("O id inserido não existe!");
        }
    }

    public void listarProfessores() {
        Connection conexao = new Conexao().getConexao();
        String sintaxeSQL = "SELECT * FROM professores INNER JOIN usuarios WHERE usuarios.usuarios_id = professores.fk_professores_usuarios_id";

        try {
            PreparedStatement comando = conexao.prepareStatement(sintaxeSQL);
            ResultSet mostrar = comando.executeQuery();

            System.out.println("\nProfessores cadastrados!\n");

            while (mostrar.next()) {
                System.out.println("==================================================");
                System.out.println("ID de Usuário: " + mostrar.getInt("usuarios_id"));
                System.out.println("Nome: " + mostrar.getString("usuarios_nome"));
                System.out.println("Endereco: " + mostrar.getString("usuarios_endereco"));
                System.out.println("CPF: " + mostrar.getString("usuarios_cpf"));
                System.out.println("Sexo: " + mostrar.getString("usuarios_sexo"));
                System.out.println("ID de Professor: " + mostrar.getString("professores_id"));
                System.out.println("Disciplina: " + mostrar.getString("professores_disciplina"));
                System.out.println("Turma: " + mostrar.getString("professores_turma"));
                System.out.println("Titularidade: " + mostrar.getString("professores_titularidade"));
                System.out.println("==================================================");
            }

            mostrar.close();
            comando.close();
            conexao.close();
        } catch (Exception e) {
            System.out.println("Erro ao listar professores: " + e.getMessage());
        }
    }
    
    @Override
    public void listar(int idListado){
        boolean existe = verificarIdProfessor(idListado);
        if(existe){
            Connection conexao = new Conexao().getConexao();
            String sintaxeSQL = "SELECT * FROM professores WHERE professores_id = ?";

            try {
                PreparedStatement comando = conexao.prepareStatement(sintaxeSQL);
                comando.setInt(1, idListado);
                ResultSet mostrar = comando.executeQuery();

                if(mostrar.next()){
                    System.out.println("ID de Professor: " + mostrar.getString("professores_id"));
                    System.out.println("Disciplina: " + mostrar.getString("professores_disciplina"));
                    System.out.println("Turma: " + mostrar.getString("professores_turma"));
                    System.out.println("Titularidade: " + mostrar.getString("professores_titularidade"));
                    System.out.println("==================================================");
                }

                mostrar.close();
                comando.close();
                conexao.close();
            }catch(Exception e){
                System.out.println("Erro ao listar professor: " + e.getMessage());
            }
        } else{
            System.out.println("O ID inserido não existe!");
        }
    }
    
    @Override
    public void alterar(int professores_id, String atributo) {
        if (atributo.equals("disciplina")) {
            Connection conexao = new Conexao().getConexao();
            String sintaxeSQL = "UPDATE professores SET professores_disciplina = ? WHERE professores_id = ?";

            try {
                PreparedStatement comando = conexao.prepareStatement(sintaxeSQL);
                comando.setString(1, this.getDisciplinaMinistrada());
                comando.setInt(2, professores_id);
                int alteracao = comando.executeUpdate();
                if (alteracao > 0) {
                    System.out.println("Tabela alterada com sucesso! ");

                } else {
                    System.out.println("Erro ao alterar a tabela!");
                }
            } catch (Exception e) {
                System.out.println("Erro ao alterar: " + e.getMessage());
            }
        } else if (atributo.equals("turma")) {
            Connection conexao = new Conexao().getConexao();
            String sintaxeSQL = "UPDATE professores SET professores_turma = ? WHERE professores_id = ?";

            try {
                PreparedStatement comando = conexao.prepareStatement(sintaxeSQL);
                comando.setString(1, this.getTurmaEnsinada());
                comando.setInt(2, professores_id);
                int alteracao = comando.executeUpdate();
                if (alteracao > 0) {
                    System.out.println("Tabela alterada com sucesso! ");

                } else {
                    System.out.println("Erro ao alterar a tabela!");
                }
            } catch (Exception e) {
                System.out.println("Erro ao alterar: " + e.getMessage());
            }
        } else if (atributo.equals("titularidade")) {
            Connection conexao = new Conexao().getConexao();
            String sintaxeSQL = "UPDATE professores SET professores_titularidade = ? WHERE professores_id = ?";

            try {
                PreparedStatement comando = conexao.prepareStatement(sintaxeSQL);
                comando.setString(1, this.getGrauTitularidade());
                comando.setInt(2, professores_id);
                int alteracao = comando.executeUpdate();
                if (alteracao > 0) {
                    System.out.println("Tabela alterada com sucesso! ");

                } else {
                    System.out.println("Erro ao alterar a tabela!");
                }
            } catch (Exception e) {
                System.out.println("Erro ao alterar: " + e.getMessage());
            }
            
        } else if (atributo.equals("tudo")) {
            Connection conexao = new Conexao().getConexao();
            String sintaxeSQL = "UPDATE professores SET professores_disciplina = ?, professores_turma = ?, professores_titularidade = ? WHERE professores_id = ?";

            try {
                PreparedStatement comando = conexao.prepareStatement(sintaxeSQL);
                comando.setString(1, this.getDisciplinaMinistrada());
                comando.setString(2, this.getTurmaEnsinada());
                comando.setString(3, this.getGrauTitularidade());
                comando.setInt(4, professores_id);
                int alteracao = comando.executeUpdate();
                if (alteracao > 0) {
                    System.out.println("Tabela alterada com sucesso! ");

                } else {
                    System.out.println("Erro ao alterar a tabela!");
                }
            } catch (Exception e) {
                System.out.println("Erro ao alterar: " + e.getMessage());
            }
        }
    }
}
