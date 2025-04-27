package Suap.abstractClass;

import Suap.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Marcus Vinícius
 * @since 22/04/2025 at 12:28 AM
 */
public class Frequencias {

    private int frequencias_id, total_aulas, aulas_ministradas, frequencias_faltas;
    private float prctg_presenca;
    private Professores professores;

    public Frequencias(int frequencias_id, int total_aulas, int aulas_ministradas, int frequencias_faltas, float prctg_presenca, Professores professores) {
        this.frequencias_id = frequencias_id;
        this.total_aulas = total_aulas;
        this.aulas_ministradas = aulas_ministradas;
        this.frequencias_faltas = frequencias_faltas;
        this.prctg_presenca = prctg_presenca;
        this.professores = professores;
        
    }

    public int getFrequencias_id() {
        return frequencias_id;
    }

    public void setFrequencias_id(int frequencias_id) {
        this.frequencias_id = frequencias_id;
    }

    public int getTotal_aulas() {
        return total_aulas;
    }

    public void setTotal_aulas(int total_aulas) {
        this.total_aulas = total_aulas;
    }

    public int getAulas_ministradas() {
        return aulas_ministradas;
    }

    public void setAulas_ministradas(int aulas_ministradas) {
        this.aulas_ministradas = aulas_ministradas;
    }

    public int getFrequencias_faltas() {
        return frequencias_faltas;
    }

    public void setFrequencias_faltas(int frequencias_faltas) {
        this.frequencias_faltas = frequencias_faltas;
    }

    public float getPrctg_presenca() {
        return prctg_presenca;
    }

    public void setPrctg_presenca(float prctg_presenca) {
        this.prctg_presenca = prctg_presenca;
    }

    public Professores getProfessores() {
        return professores;
    }

    public void setProfessores(Professores professores) {
        this.professores = professores;
    }

    public void deletarFrequencia(int id_frequencia) {
        String sql = "DELETE FROM frequencias WHERE frequencias_id = ?";
        PreparedStatement pstm = null;

        try {
            Connection conexao = new Conexao().getConexao();
            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, id_frequencia);

            pstm.execute();
        } catch (Exception e) {
            System.out.println("Erro ao deletar valores na tabela de Frequencias" + e.getMessage());
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void alterarFrequencia(int id_frequencia, String atributo) {
        if (atributo.equals("total_aulas")) {
            String sql = "UPDATE frequencias SET total_aulas = ? WHERE frequencias_id = ?";
            PreparedStatement pstm = null;
            try {
                Connection conexao = new Conexao().getConexao();
                pstm.setInt(1, this.getTotal_aulas());
                pstm.setInt(2, frequencias_id);
                pstm.execute();
            } catch (SQLException e) {
                System.out.println("Erro ao alterar o atributos total_aulas da tabela frequencias" + e.getMessage());
            } finally {
                try {
                    if (pstm != null) {
                        pstm.close();
                    }
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        } else if (atributo.equals("aulas_ministradas")) {
            String sql = "UPDATE frequencias SET aulas_ministradas = ? WHERE frequencias_id = ?";
            PreparedStatement pstm = null;
            try {
                Connection conexao = new Conexao().getConexao();
                pstm.setInt(1, this.aulas_ministradas);
                pstm.setInt(2, frequencias_id);
                pstm.execute();
            } catch (SQLException e) {
                System.out.println("Erro ao alterar o atributo aulas_ministradas da tabela frequencias" + e.getMessage());
            } finally {
                try {
                    if (pstm != null);
                    pstm.close();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        } else if (atributo.equals("frequencias_faltas")) {
            PreparedStatement pstm = null;
            try {
                Connection conexao = new Conexao().getConexao();
                pstm.setInt(1, this.frequencias_faltas);
                pstm.setInt(2, frequencias_id);
                pstm.execute();
            } catch (SQLException e) {
                System.out.println("Erro ao alterar o atributo frequencias_faltas da tabela frequencias" + e.getMessage());
            } finally {
                try {
                    if (pstm != null);
                    pstm.close();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
        public void listarFrequencias(int id_frequencia){
            if(id_frequencia > 0){
                String sql = "SELECT f.id_frequencia, f.aulas_ministradas, f.frequencias_faltas, f.prctg_presenca, f.professores, f.total_aulas FROM frequencias INNER JOIN  f WHERE  f.id_frequencia = ?";
                PreparedStatement pstm = null;
                ResultSet rset = null;
                
                try {
                    Connection conexao = new Conexao().getConexao();
                    pstm = conexao.prepareStatement(sql);
                    pstm.setInt(1, id_frequencia);
                    pstm.executeQuery();
                    
                    if(rset.next()){
                        System.out.println("ID: " + rset.getInt("id_frequencia"));
                        System.out.println("Aulas ministradas: " + rset.getInt("aulas_ministradas"));
                        System.out.println("Faltas: " + rset.getInt("frequencias_faltas"));
                        System.out.println("% Frequencia: " + rset.getInt("prctg_presenca"));
                        System.out.println("`Professor(a): " + rset.getInt("professores"));
                }else {
                        System.out.println("ID de Frequencia não encontrado");
                        
                  }
            } catch (Exception e) {
                    System.out.println("Erro ao listar os dados da tabela frequencias" + e.getMessage());
            } finally {
                    try {
                        if (rset != null){
                            rset.close();
                        }
                        if (pstm !=null){
                            pstm.close();
                        }  
                    } catch ( SQLException e) {
                        System.out.println(e.getMessage());
                    }
                }
        
            }
        } 
}
        
