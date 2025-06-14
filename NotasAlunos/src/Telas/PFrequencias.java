package Telas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Suap.abstractClass.Alunos;
import Suap.abstractClass.Professores;

public class PFrequencias {

    // Método para consultar todas as frequências
    public ArrayList<EFrequencias> consultarFrequencia() {
        ArrayList<EFrequencias> lista = new ArrayList<>();
        
        Connection conn =  Conexao.obterConexaoMySQL();
                
        String SQL = "SELECT f.*, p.professores_id, a.alunos_id FROM frequencias f " +
                     "JOIN professores p ON f.professores_id = p.professores_id " +
                     "JOIN alunos a ON f.alunos_id = a.alunos_id ORDER BY f.frequencias_id";

        try (PreparedStatement pstm = conn.prepareStatement(SQL)) {
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                EFrequencias freq = new EFrequencias();
                freq.setFrequencias_id(rs.getInt("frequencias_id"));
                freq.setTotal_aulas(rs.getInt("total_aulas"));
                freq.setAulas_ministradas(rs.getInt("aulas_ministradas"));
                freq.setFrequencias_faltas(rs.getInt("frequencias_faltas"));
                freq.setPrctg_presenca(rs.getFloat("prctg_presenca"));
                freq.setFrequencias_disciplinas(rs.getString("frequencias_disciplinas"));

                // Criar e setar o objeto Professores
                Professores prof = new Professores();
                prof.setIdProfessor(rs.getInt("professores_id"));
                // aqui você pode carregar mais campos se quiser
                freq.setProfessores(prof);

                // Criar e setar o objeto Alunos
                Alunos aluno = new Alunos();
                aluno.setId(rs.getInt("alunos_id"));
                // aqui você pode carregar mais campos se quiser
                freq.setAluno(aluno);

                lista.add(freq);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Erro consultarFrequencia: " + e.getMessage());
        } finally {
            Conexao.fecharConexao();
        }
        return lista;
    }

    // Método para incluir frequência
    public String incluirFrequencia(EFrequencias freq) {
        String resultado;
        Connection conn = Conexao.obterConexaoMySQL();

        String SQL = "INSERT INTO frequencias (total_aulas, aulas_ministradas, frequencias_faltas, prctg_presenca, frequencias_disciplinas, professores_id, alunos_id) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstm = conn.prepareStatement(SQL)) {
            pstm.setInt(1, freq.getTotal_aulas());
            pstm.setInt(2, freq.getAulas_ministradas());
            pstm.setInt(3, freq.getFrequencias_faltas());
            pstm.setFloat(4, freq.getPrctg_presenca());
            pstm.setString(5, freq.getFrequencias_disciplinas().toUpperCase());
            pstm.setInt(6, freq.getProfessores().getIdProfessor());
            pstm.setInt(7, freq.getAluno().getId());

            int linhas = pstm.executeUpdate();
            if (linhas > 0) {
                resultado = "Inclusão efetuada com sucesso!";
            } else {
                resultado = "Falha na inclusão.";
            }
        } catch (SQLException e) {
            resultado = "Erro na inclusão: " + e.getMessage();
        } finally {
            Conexao.fecharConexao();
        }
        return resultado;
    }

    // Método para alterar frequência
    public String alterarFrequencia(EFrequencias freq) {
        String resultado;
        Connection conn = Conexao.obterConexaoMySQL();

        String SQL = "UPDATE frequencias SET total_aulas = ?, aulas_ministradas = ?, frequencias_faltas = ?, prctg_presenca = ?, frequencias_disciplinas = ?, professores_id = ?, alunos_id = ? WHERE frequencias_id = ?";

        try (PreparedStatement pstm = conn.prepareStatement(SQL)) {
            pstm.setInt(1, freq.getTotal_aulas());
            pstm.setInt(2, freq.getAulas_ministradas());
            pstm.setInt(3, freq.getFrequencias_faltas());
            pstm.setFloat(4, freq.getPrctg_presenca());
            pstm.setString(5, freq.getFrequencias_disciplinas().toUpperCase());
            pstm.setInt(6, freq.getProfessores().getIdProfessor());
            pstm.setInt(7, freq.getAluno().getId());
            pstm.setInt(8, freq.getFrequencias_id());

            int linhas = pstm.executeUpdate();
            if (linhas > 0) {
                resultado = "Alteração efetuada com sucesso!";
            } else {
                resultado = "Nenhum registro encontrado para alterar.";
            }
        } catch (SQLException e) {
            resultado = "Erro na alteração: " + e.getMessage();
        } finally {
            Conexao.fecharConexao();
        }
        return resultado;
    }

    // Método para excluir frequência pelo id
    public String excluirFrequencia(int frequencias_id) {
        String resultado;
        Connection conn = Conexao.obterConexaoMySQL();

        String SQL = "DELETE FROM frequencias WHERE frequencias_id = ?";

        try (PreparedStatement pstm = conn.prepareStatement(SQL)) {
            pstm.setInt(1, frequencias_id);

            int linhas = pstm.executeUpdate();
            if (linhas > 0) {
                resultado = "Exclusão efetuada com sucesso!";
            } else {
                resultado = "Nenhum registro encontrado para exclusão.";
            }
        } catch (SQLException e) {
            resultado = "Erro na exclusão: " + e.getMessage();
        } finally {
            Conexao.fecharConexao();
        }
        return resultado;
    }
}
