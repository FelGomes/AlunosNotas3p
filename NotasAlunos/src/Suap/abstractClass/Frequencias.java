package Suap.abstractClass;

import Suap.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Classe para objetos do tipo Frequencias.
 * @author Marcus Vinícius Nunes Silva
 * @since 22/04/2025 at 12:28 AM
 */
public class Frequencias {

    private int frequencias_id, total_aulas, aulas_ministradas, frequencias_faltas;
    private float prctg_presenca;
    private String frequencias_disciplinas;
    private Professores professores = new Professores();
    private Alunos aluno = new Alunos();
    private int alunos_id, professores_id;
    

    /**
     * Construtor vazio com todas as informações de Frequencias.
     */
    public Frequencias() {
    }

    /**
     * Construtor que inicializa as informações de Frequencias.
     * @param frequencias_id Identificador da frequencia.
     * @param total_aulas Quantidade total de aulas.
     * @param aulas_ministradas Quantidade total de aulas ministradas.
     * @param frequencias_faltas Quantidade de faltas.
     * @param prctg_presenca Porcentagem de presença de aula.
     * @param frequencias_disciplinas Nome da disciplina.
     * @param professores Objeto professores.
     * @param aluno Objeto alunos.
     */
    public Frequencias(int frequencias_id, int total_aulas, int aulas_ministradas, int frequencias_faltas, float prctg_presenca, String frequencias_disciplinas, Professores professores, Alunos aluno) {
        this.frequencias_id = frequencias_id;
        this.total_aulas = total_aulas;
        this.aulas_ministradas = aulas_ministradas;
        this.frequencias_faltas = frequencias_faltas;
        this.prctg_presenca = prctg_presenca;
        this.frequencias_disciplinas = frequencias_disciplinas;
        this.professores = professores;
        this.aluno = aluno;

    }

     /**
     * Método para retornar o identificador de frequencia.
     * @return frequencias_id Identificador de frequencia.
     */
    public int getFrequencias_id() {
        return frequencias_id;
    }

     /**
     * Método para definir um valor ao identificador de frequencia.
     * @param frequencias_id Identificador de frequencia.
     */
    public void setFrequencias_id(int frequencias_id) {
        this.frequencias_id = frequencias_id;
    }

     /**
     * Método para retornar a quantidade total de aulas.
     * @return total_aulas Quantidade total de aulas.
     */
    public int getTotal_aulas() {
        return total_aulas;
    }

     /**
     * Método para definir um valor a quantidade total de aulas.
     * @param total_aulas Quantidade total de aulas.
     */
    public void setTotal_aulas(int total_aulas) {
        this.total_aulas = total_aulas;
    }

     /**
     * Método para retornar o nome da disciplina.
     * @return frequencias_disciplinas Nome da disciplina.
     */
    public String getFrequencias_disciplinas() {
        return frequencias_disciplinas;
    }

     /**
     * Método para definir um valor ao nome da disciplina.
     * @param frequencias_disciplinas Nome da disciplina.
     */
    public void setFrequencias_disciplinas(String frequencias_disciplinas) {
        this.frequencias_disciplinas = frequencias_disciplinas;
    }

     /**
     * Método para definir um valor ao objeto Alunos.
     * @param aluno Objeto Alunos.
     */
    public void setAluno(Alunos aluno) {
        this.aluno = aluno;
    }

    /**
     * Método para retornar a quantidade de aulas ministradas.
     * @return aulas_ministradas Quantidade de aulas ministradas.
     */
    public int getAulas_ministradas() {
        return aulas_ministradas;
    }

     /**
     * Método para definir um valor a quantidade de aulas ministradas.
     * @param aulas_ministradas Quantidade de aulas ministradas.
     */
    public void setAulas_ministradas(int aulas_ministradas) {
        this.aulas_ministradas = aulas_ministradas;
    }

    /**
     * Método para retornar o objeto Alunos.
     * @return aluno Objeto Alunos.
     */
    public Alunos getAluno() {
        return aluno;
    }

     /**
     * Método para retornar a quantidade de faltas.
     * @return frequencias_faltas Quantidade de faltas.
     */
    public int getFrequencias_faltas() {
        return frequencias_faltas;
    }

     /**
     * Método para definir um valor a quantidade de faltas.
     * @param frequencias_faltas Quantidade de faltas.
     */
    public void setFrequencias_faltas(int frequencias_faltas) {
        this.frequencias_faltas = frequencias_faltas;
    }

    /**
     * Método para retornar a porcetagem de frequencia em aula.
     * @return prctg_presenca Porcentagem de frequencia em aula.
     */
    public float getPrctg_presenca() {
        return prctg_presenca;
    }

      /**
     * Método para definir um valor a porcentagem de frequencias em aula..
     * @param prctg_presenca Porcentagem de frequencia em aula.
     */
    public void setPrctg_presenca(float prctg_presenca) {
        this.prctg_presenca = prctg_presenca;
    }

    /**
     * Método para retornar o objeto Professores.
     * @return professores Objeto Professores.
     */
    public Professores getProfessores() {
        return professores;
    }

        /**
     * Método para definir um valor ao objeto Professores.
     * @param professores Objeto Professores.
     */
    public void setProfessores(Professores professores) {
        this.professores = professores;
        
    }

    public int getAlunos_id() {
        return alunos_id;
    }

    public void setAlunos_id(int alunos_id) {
        this.alunos_id = alunos_id;
    }

    public int getProfessores_id() {
        return professores_id;
    }

    public void setProfessores_id(int professores_id) {
        this.professores_id = professores_id;
    }
    
    
    
    

    /**
     * Método para fazer a inserção dos valores em todas colunas da tabela frequencias, com excessão frequencias_id.
     *
     */
    public void inserirFrequencia() {
        Connection conexao = new Conexao().getConexao();
        String sql = "INSERT INTO frequencias (total_aulas, aulas_ministradas, frequencias_faltas, prctg_presenca, frequencias_disciplinas,fk_frequencias_professores_id, fk_frequencias_alunos_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt;
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, this.getTotal_aulas());
            stmt.setInt(2, this.getAulas_ministradas());
            stmt.setInt(3, this.getFrequencias_faltas());
            stmt.setFloat(4, this.calculaPrctgFrequencia(this.getTotal_aulas(), this.getFrequencias_faltas()));
            stmt.setString(5, this.getFrequencias_disciplinas());
            stmt.setInt(6, this.getProfessores_id());
            stmt.setInt(7, this.getAlunos_id());
            int alteracao = stmt.executeUpdate();

            if (alteracao > 0) {
                System.out.println("Frequencia inserida com sucesso!");
            } else {
                System.out.println("Nao foi inserida nenhuma frequencia");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao inserir valores na tabela frequencia" + e.getMessage());
        }
    }

    /**
     * Método para deletar os valores do identificador de frequencia(Deleta o registro total de frequencia).
     * @param id_frequencia Identificador de frequencia.
     */
    public void deletarFrequencia(int id_frequencia) {
        String sql = "DELETE FROM frequencias WHERE frequencias_id = ?";
        try {
            Connection conexao = new Conexao().getConexao();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id_frequencia);
            int alteracao = stmt.executeUpdate();

            if (alteracao > 0) {
                System.out.println("Frequencia deletada com sucesso!");
            } else {
                System.out.println("Erro ao deletar a frequencia");
            }
        } catch (Exception e) {
            System.out.println("Erro ao deletar os valores da tabela frequencia" + e.getMessage());
        }
    }

    /**
     * Método para fazer a atualização dos valores das colunas total_aulas, aulas_ministradas e frequencias_faltas da tabela frequencias.
     * @param frequencias_id
     * @param id_frequencia Identificador de frequencia.
     * @param atributo
     */
  
    public void alterarFrequencia(int frequencias_id) {
        String sql = "UPDATE frequencias SET total_aulas = ?, aulas_ministradas = ?, frequencias_faltas = ?, prctg_presenca = ? WHERE frequencias_id = ?";
        PreparedStatement pstm = null;

        try {
            // Validação básica
            if (this.getFrequencias_faltas() > this.getAulas_ministradas()) {
                System.out.println("Erro: faltas não podem ser maiores que aulas ministradas.");
                return;
            }

            Connection conexao = new Conexao().getConexao();
            pstm = conexao.prepareStatement(sql);

            pstm.setInt(1, this.getTotal_aulas());
            pstm.setInt(2, this.getAulas_ministradas());
            pstm.setInt(3, this.getFrequencias_faltas()); // número real de faltas
            pstm.setFloat(4, this.calculaPrctgFrequencia(this.getTotal_aulas(), this.getFrequencias_faltas())); // % presença
            pstm.setInt(5, frequencias_id);

            int alteracao = pstm.executeUpdate();

            if (alteracao > 0) {
                System.out.println("Tabela `frequencias` alterada com sucesso!");
            } else {
                System.out.println("Nenhuma linha foi alterada na tabela `frequencias`.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao alterar a tabela `frequencias`: " + e.getMessage());
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (SQLException e) {
                System.out.println("Erro ao fechar o PreparedStatement: " + e.getMessage());
            }
        }
    }



    /**
     * Método para fazer mostrar/listar todos os dados de frequências.
     * @param id_frequencia Identificador de frequencia.
     */
    public void listarFrequencias(int id_frequencia) {
        String sql;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {
            Connection conexao = new Conexao().getConexao();

            if (id_frequencia > 0) {
                sql = "SELECT f.frequencias_id, "
                        + "f.aulas_ministradas, "
                        + "f.frequencias_faltas, "
                        + "f.prctg_presenca, "
                        + "f.frequencias_disciplinas, "
                        + "uprof.usuarios_nome as professor_nome, "
                        + "ualuno.usuarios_nome as aluno_nome, "
                        + "f.total_aulas "
                        + "FROM frequencias f "
                        + "INNER JOIN professores p ON f.fk_frequencias_professores_id = p.professores_id "
                        + "INNER JOIN usuarios uprof ON p.fk_professores_usuarios_id = uprof.usuarios_id "
                        + "INNER JOIN alunos a ON f.fk_frequencias_alunos_id = a.alunos_id "
                        + "INNER JOIN usuarios ualuno ON a.fk_alunos_usuarios_id = ualuno.usuarios_id " 
                        + "WHERE f.frequencias_id = ?";
                pstm = conexao.prepareStatement(sql);
                pstm.setInt(1, id_frequencia);
            } else {
                sql = "SELECT f.frequencias_id, "
                        + "f.aulas_ministradas, "
                        + "f.frequencias_faltas, "
                        + "f.prctg_presenca, "
                        + "f.frequencias_disciplinas, "
                        + "uprof.usuarios_nome as professor_nome, "
                        + "ualuno.usuarios_nome as aluno_nome, "
                        + "f.total_aulas "
                        + "FROM frequencias f "
                        + "INNER JOIN professores p ON f.fk_frequencias_professores_id = p.professores_id "
                        + "INNER JOIN usuarios uprof ON p.fk_professores_usuarios_id = uprof.usuarios_id "
                        + "INNER JOIN alunos a ON f.fk_frequencias_alunos_id = a.alunos_id "
                        + "INNER JOIN usuarios ualuno ON a.fk_alunos_usuarios_id = ualuno.usuarios_id ";
                pstm = conexao.prepareStatement(sql);
            }

            rset = pstm.executeQuery();

            boolean encontrou = false;
            while (rset.next()) {
                encontrou = true;
                System.out.println("ID: " + rset.getInt("frequencias_id"));
                System.out.println("Aulas ministradas: " + rset.getInt("aulas_ministradas"));
                System.out.println("Faltas: " + rset.getInt("frequencias_faltas"));
                System.out.println("% Presença: " + rset.getInt("prctg_presenca"));
                System.out.println("Disciplina: " + rset.getString("frequencias_disciplinas")); // CORRETO
                System.out.println("Nome do Professor(a): " + rset.getString("professor_nome"));
                System.out.println("Nome do Aluno(a): " + rset.getString("aluno_nome"));
                System.out.println("Total de aulas: " + rset.getString("total_aulas"));
                System.out.println("--------------------------------------------------");
            }

            if (!encontrou && id_frequencia > 0) {
                System.out.println("ID de Frequência não encontrado");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar os dados da tabela frequencias" + e.getMessage());
        }
    }
    /**
     * Método para fazer a verificação do Identificador de frequencia no banco de dados.
     * @param id_frequencia Identificador de frequencia.
     * @return 
     */
    public boolean verificaIdFrequencia(int id_frequencia) {
        try (Connection conexao = new Conexao().getConexao(); PreparedStatement comando = conexao.prepareStatement("SELECT * FROM frequencias f WHERE f.frequencias_id = ?")) {
            comando.setInt(1, id_frequencia);
            try (ResultSet resultado = comando.executeQuery()) {
                return resultado.next();
            }
        } catch (SQLException e) {
            System.out.println("Erro ao verificar a tabela de frequências " + e.getMessage());
        }
        return false;
    }

    /**
     * Método para fazer a verificação do Identificador do professor no banco de dados.
     * @param id_professores Identificador de professor.
     * @return 
     */
    public boolean verificaIdProfessores(int id_professores) {
        try (Connection conexao = new Conexao().getConexao(); PreparedStatement comando = conexao.prepareStatement("SELECT * FROM professores p WHERE p.professores_id = ?")) {
            comando.setInt(1, id_professores);
            try (ResultSet resultado = comando.executeQuery()) {
                return resultado.next();
            }
        } catch (SQLException e) {
            System.out.println("Erro ao verificar a tabela de professores " + e.getMessage());
        }
        return false;
    }

    /**
     * Método para fazer a verificação do Identificador de aluno no banco de dados.
     * @param id_alunos Identificador de aluno.
     * @return 
     */
    public boolean verificaIdAlunos(int id_alunos) {
        try (Connection conexao = new Conexao().getConexao(); PreparedStatement comando = conexao.prepareStatement("SELECT * FROM alunos a WHERE a.alunos_id = ?")) {
            comando.setInt(1, id_alunos);
            try (ResultSet resultado = comando.executeQuery()) {
                return resultado.next();
            }
        } catch (SQLException e) {
            System.out.println("Erro ao verificar a tabela de alunos " + e.getMessage());
        }
        return false;
    }

    /**
     * Método para fazer o cálculo matemático da porcentagem de faltas.
     * @param aula_total Quantidade total de aulas.
     * @param faltas Quantidade de faltas.
     * @return Retorna a porcetagem de falta do aluno com base no cálculo (aula_total - faltas) / aula_total * 100.
     */
    public float calculaPrctgFrequencia(int aula_total, int faltas) {
        float prctg = (aula_total - faltas) / aula_total * 100;
        return prctg;
    }
}
