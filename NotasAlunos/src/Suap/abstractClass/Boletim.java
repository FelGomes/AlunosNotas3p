package Suap.abstractClass;

import Suap.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author marcos felipe
 */
public class Boletim{
    
    /*private String boletins_situacao;


    Alunos alunos = new Alunos();
    Notas notas = new Notas();
    Frequencias frequencias = new Frequencias();
    
    public Boletim(){
    }*/
    
    /**
     * 
     * @param boletins_id
     */
    public void listarBoletim(int boletins_id){
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
                + "AND f.frequencias_disciplinas = n.nota_disciplina "
                + "WHERE a.alunos_id = ?";

            PreparedStatement pstm = null;
            ResultSet rset = null;
            
            try{
                Connection conexao = new Conexao().getConexao();
                pstm = conexao.prepareStatement(sql);
                pstm.setInt(1, boletins_id);
                rset = pstm.executeQuery();
                
                while(rset.next()){
                    System.out.println("==================================================");
                    //System.out.println("ID: " + rset.getInt("boletins_id"));
                    System.out.println("Nome Aluno: " + rset.getString("usuarios_nome"));
                    System.out.println("Sexo: " + rset.getString("usuarios_sexo"));
                    System.out.println("Sala: " + rset.getString("alunos_sala"));
                    System.out.println("Turma: " + rset.getString("alunos_turma"));
                    System.out.println("Media: " + rset.getString("nota_media"));
                    System.out.println("Faltas " + rset.getString("frequencias_faltas") + "%");
                    System.out.println("Total de aulas: " + rset.getString("total_aulas"));
                    System.out.println("Disciplina: " + rset.getString("frequencias_disciplinas"));
                    System.out.println("==================================================");
                
                }

            } catch (Exception e){
                System.out.println("Erro ao fazer a listagem dos boletins " + e.getMessage());
            } finally {
            
                try{
                    if(rset != null){
                        rset.close();
                    }
                    if(pstm != null){
                        pstm.close();
                    }
                } catch (SQLException e){
                    System.out.println(e.getMessage());
                }
            }
    }
            
        //CASO NÃO EXISTA UM ID ESPECIFICO VAI RETORNAR TODOS
    
    
        /*} else {
            String sql = "SELECT * FROM BOLETIM";
            PreparedStatement pstm = null;
            ResultSet rset = null;
            
            try {
                Connection conexao = new Conexao().getConexao();
                pstm = conexao.prepareStatement(sql);
                
                rset = pstm.executeQuery();
                
                while(rset.next()){
                    System.out.println("==================================================");
                    System.out.println("ID: " + rset.getInt("boletins_id"));
                    System.out.println("Nome Aluno: " + rset.getString("usuarios_nome"));
                    System.out.println("Sexo: " + rset.getString("usuarios_sexo"));
                    System.out.println("Situacao: " + rset.getString("boletins_situacao"));
                    System.out.println("Media de notas: " + rset.getDouble("notas_media"));
                    System.out.println("Porcentagem Frequencia: " + rset.getDouble("prctg_presenca"));
                    System.out.println("Materias: " + rset.getString("nota_disciplina"));
                    System.out.println("==================================================");
                }
                
            } catch (SQLException e) {
                System.out.println("Erro ao fazer a listagem dos boletins " + e.getMessage());
                
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
        }*/
    
   //}
    
   /* public void deletarBoletim(int boletins_id) {
        String sql = "DELETE FROM boletins WHERE boletins_id = ?";
        PreparedStatement pstm = null;

        try {
            Connection conexao = new Conexao().getConexao();
            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, boletins_id);

            pstm.execute();
        } catch (Exception e) {
            System.out.println("Erro ao deletar boletins!" + e.getMessage());

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

    }*/
    
}
    

