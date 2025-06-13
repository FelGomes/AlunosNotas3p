package Telas;

import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Suap.Conexao;

/**
 *
 * @author Dheniel
 */
public class PBoletim {
    public List<String[]> listarBoletimParaTabela(int alunoId) throws SQLException {
        List<String[]> dadosBoletim = new ArrayList<>();
        String sql = "SELECT "
                + "    u.usuarios_nome, "
                + "    u.usuarios_sexo, "
                + "    a.alunos_sala, "
                + "    a.alunos_turma, "
                + "    n.nota_media, "
                + "    f.frequencias_faltas, "
                + "    f.total_aulas, "
                + "    f.frequencias_disciplinas "
                + "FROM alunos a "
                + "JOIN usuarios u ON a.fk_alunos_usuarios_id = u.usuarios_id "
                + "LEFT JOIN notas n ON n.fk_notas_alunos_id = a.alunos_id "
                + "LEFT JOIN frequencias f ON f.fk_frequencias_alunos_id = a.alunos_id "
                + "WHERE a.alunos_id = ?";
        try (Connection conexao = new Conexao().getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, alunoId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    String nome = rs.getString("usuarios_nome");
                    String sexo = rs.getString("usuarios_sexo");
                    String sala = rs.getString("alunos_sala");
                    String turma = rs.getString("alunos_turma");
                    String media = rs.getString("nota_media");
                    String faltas = rs.getString("frequencias_faltas");
                    String totalAulas = rs.getString("total_aulas");
                    String disciplina = rs.getString("frequencias_disciplinas");

                    dadosBoletim.add(new String[]{nome, sexo, sala, turma, media, faltas, totalAulas, disciplina});
                }
            }
        }
        return dadosBoletim;
    }
}
