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
    
    private String boletins_situacao;


    Alunos alunos = new Alunos();
    Notas notas = new Notas();
    Frequencias frequencias = new Frequencias();
    
    public Boletim(){
    }
    
    /**
     * 
     * @param boletins_id
     */
    public void listarBoletim(int boletins_id){
        

        if (boletins_id > 0) {
            String sql = "SELECT"
                    + "    u.usuarios_nome AS 'NOME',\n"
                    + "    u.usuarios_sexo AS 'SEXO',\n"
                    + "    a.alunos_sala AS 'SALA',\n"
                    + "    a.alunos_turma AS 'TURMA',\n"
                    + "    n.notas_media AS 'MEDIA',\n"
                    + "    f.frequencias_faltas AS 'FALTAS',\n"
                    + "    f.total_aulas AS 'AULAS TOTAIS'\n"
                    + "FROM alunos a\n"
                    + "JOIN usuarios u ON a.fk_alunos_usuarios_id = u.usuarios_id\n"
                    + "LEFT JOIN notas n ON n.fk_notas_alunos_id = a.alunos_id\n"
                    + "LEFT JOIN frequencias f ON f.fk_frequencias_alunos_id = a.alunos_id; = ";
            PreparedStatement pstm = null;
            ResultSet rset = null;
            
            try{
                Connection conexao = new Conexao().getConexao();
                pstm = conexao.prepareStatement(sql);
                pstm.setInt(1, boletins_id);
                pstm.executeQuery();
                
                if(rset.next()){
                    System.out.println("==================================================");
                    System.out.println("ID: " + rset.getInt("boletins_id"));
                    System.out.println("Nome Aluno: " + rset.getString("usuarios_nome"));
                    System.out.println("Sexo: " + rset.getString("usuarios_sexo"));
                    System.out.println("Situacao: " + rset.getString("boletins_situacao"));
                    System.out.println("Media de notas: " + rset.getDouble("notas_media"));
                    System.out.println("Porcentagem Frequencia: " + rset.getDouble("prctg_presenca"));
                    System.out.println("Materias: " + rset.getString("nota_disciplina"));
                    System.out.println("==================================================");
                
            
                } else {
                    System.out.println("Nenhum boletim encontrado com o ID fornecido!" + boletins_id);
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
            
        //CASO NÃO EXISTA UM ID ESPECIFICO VAI RETORNAR TODOS
    
    
        } else {
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
        }
    
    }
    
    public void deletarBoletim(int boletins_id) {
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

    }
    

