
package Telas;

/**
 *
 * @author Kauã Luiz
 */
import Telas.EMatricula;
import java.sql.*;
import java.util.ArrayList;

public class PMatricula {
    
    public String salvarMatricula(EMatricula m) {
        try {
            Connection con = Conexao.getConexao();
            String sql = "INSERT INTO matriculas (data_inicio, data_fim, qtd_tempo, fk_instituicao_id, fk_aluno_id) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, m.getData_inicio());
            stmt.setString(2, m.getData_fim());
            stmt.setInt(3, m.getQtd_tempo());
            stmt.setInt(4, m.getFk_instituicao_id());
            stmt.setInt(5, m.getFk_aluno_id());
            stmt.executeUpdate();
            return "Matrícula salva com sucesso!";
        } catch (SQLException e) {
            return "Erro ao salvar matrícula: " + e.getMessage();
        }
    }
    
    public String alterarMatricula(EMatricula m) {
        try {
            Connection con = Conexao.getConexao();
            String sql = "UPDATE matriculas SET data_inicio=?, data_fim=?, qtd_tempo=?, fk_instituicao_id=?, fk_aluno_id=? WHERE matriculas_id=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, m.getData_inicio());
            stmt.setString(2, m.getData_fim());
            stmt.setInt(3, m.getQtd_tempo());
            stmt.setInt(4, m.getFk_instituicao_id());
            stmt.setInt(5, m.getFk_aluno_id());
            stmt.setInt(6, m.getMatriculas_id());
            stmt.executeUpdate();
            return "Matrícula alterada com sucesso!";
        } catch (SQLException e) {
            return "Erro ao alterar matrícula: " + e.getMessage();
        }
    }
    
    public String excluirMatricula(int id) {
        try {
            Connection con = Conexao.getConexao();
            String sql = "DELETE FROM matriculas WHERE matriculas_id=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            return "Matrícula excluída com sucesso!";
        } catch (SQLException e) {
            return "Erro ao excluir matrícula: " + e.getMessage();
        }
    }

    public ArrayList<EMatricula> consultarMatricula(String filtro) {
        ArrayList<EMatricula> lista = new ArrayList<>();
        try {
            Connection con = Conexao.getConexao();
            String sql = "SELECT * FROM matriculas WHERE fk_aluno_id LIKE ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, "%" + filtro + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                EMatricula m = new EMatricula();
                m.setMatriculas_id(rs.getInt("matriculas_id"));
                m.setData_inicio(rs.getString("data_inicio"));
                m.setData_fim(rs.getString("data_fim"));
                m.setQtd_tempo(rs.getInt("qtd_tempo"));
                m.setFk_instituicao_id(rs.getInt("fk_instituicao_id"));
                m.setFk_aluno_id(rs.getInt("fk_aluno_id"));
                lista.add(m);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao consultar matrícula: " + e.getMessage());
        }
        return lista;
    }
}