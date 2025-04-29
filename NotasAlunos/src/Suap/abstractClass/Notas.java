package Suap.abstractClass;

import Suap.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author marco
 */
public class Notas {
    
    private double nota_um, nota_dois, nota_tres, nota_quatro, nota_media;
    private String nota_disciplina;
    private int nota_id;
    
    Alunos alunos = new Alunos();
    Professores professores = new Professores();
    
    
    public Notas(){
    }
    
    public int getNota_id(){
        return nota_id;
    }
    
    public void setNota_id(int nota_id){
        this.nota_id = nota_id;
    }

    public double getNota_um() {
        return nota_um;
    }

    public void setNota_um(double nota_um) {
        this.nota_um = nota_um;
    }

    public double getNota_dois() {
        return nota_dois;
    }

    public void setNota_dois(double nota_dois) {
        this.nota_dois = nota_dois;
    }

    public double getNota_quatro() {
        return nota_quatro;
    }

    public void setNota_quatro(double nota_quatro) {
        this.nota_quatro = nota_quatro;
    }
    
    public double getNota_tres() {
        return nota_quatro;
    }

    public void setNota_tres(double nota_tres) {
        this.nota_tres = nota_tres;
    }

    public double getNota_media() {
        return nota_media;
    }

    public void setNota_media(double nota_media) {
        this.nota_media = nota_media;
    }

    public String getNota_disciplina() {
        return nota_disciplina;
    }

    public void setNota_disciplina(String notas_disciplinas) {
        this.nota_disciplina = notas_disciplinas;
    }


    public Professores getProfessores() {
        return professores;
    }

    public void setProfessores(Professores professores) {
        this.professores = professores;
    }
    
    
    public double calcularMedia(double nota_um, double nota_dois, double nota_tres, double nota_quatro){
        
       double nota_calculada = (this.getNota_um() + this.getNota_dois() + this.getNota_tres() + this.getNota_quatro()) / 4;
       
       return nota_calculada;
        
    }
    
    
    /**
     * METODO CRIADO PARA ALTERAÇÃO DE NOTAS
     * @param nota_id 
     * @param atributo
     */
    public void alterarNota (int nota_id, String atributo){
        if(atributo.equals("nota um") || atributo.equals("Nota um")){
        String sql = "UPDATE notas SET nota_um = ? WHERE notas_id = ?";
        PreparedStatement pstm = null;
        
        try{
            Connection conexao = new Conexao().getConexao();
            pstm = conexao.prepareStatement(sql);
            pstm.setDouble(1, this.getNota_um());
            pstm.setInt(2, nota_id);
            pstm.execute();
        
        } catch (Exception e){
            System.out.println("Erro ao alterar nota um do aluno!" + e.getMessage());
        } finally {
            try{
                if(pstm != null){
                pstm.close();

            }
        }  catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        
        }
        } else if (atributo.equals("nota dois") || atributo.equals("Nota dois")){
            String sql = "UPDATE notas SET nota_dois = ? WHERE notas_id = ?";
            PreparedStatement pstm = null;

            try{
                Connection conexao = new Conexao().getConexao();
                pstm = conexao.prepareStatement(sql);
                pstm.setDouble(1, this.getNota_dois());
                pstm.setInt(2, nota_id);
                pstm.execute();
        
        } catch (Exception e){
            System.out.println("Erro ao alterar nota dois do aluno!" + e.getMessage());
        } finally {
            try{
                if(pstm != null){
                pstm.close();

            }
        }  catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        
        }
            
        } else if(atributo.equals("nota tres") || atributo.equals("Nota tres")){
            String sql = "UPDATE notas SET nota_tres = ? WHERE notas_id = ?";
            PreparedStatement pstm = null;

            try{
                Connection conexao = new Conexao().getConexao();
                pstm = conexao.prepareStatement(sql);
                pstm.setDouble(1, this.getNota_tres());
                pstm.setInt(2, nota_id);
                pstm.execute();
        
        } catch (Exception e){
            System.out.println("Erro ao alterar nota tres do aluno!" + e.getMessage());
        } finally {
            try{
                if(pstm != null){
                pstm.close();

            }
        }  catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        
        }

        } else if (atributo.equals("nota quatro") || atributo.equals("Nota quatro")){
            String sql = "UPDATE notas SET nota_quatro = ? WHERE notas_id = ?";
            PreparedStatement pstm = null;

            try{
                Connection conexao = new Conexao().getConexao();
                pstm = conexao.prepareStatement(sql);
                pstm.setDouble(1, this.getNota_quatro());
                pstm.setInt(2, nota_id);
                pstm.execute();
        
        } catch (Exception e){
            System.out.println("Erro ao alterar nota quatro do aluno!" + e.getMessage());
        } finally {
            try{
                if(pstm != null){
                pstm.close();

            }
        }  catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        
        }
        } else if (atributo.equals("todas") || atributo.equals("Todas")){
            String sql = "UPDATE notas SET nota_um = ?, nota_dois = ?, nota_tres = ?, nota_quatro = ? WHERE notas_id = ?";
            PreparedStatement pstm = null;

            try{
                Connection conexao = new Conexao().getConexao();
                pstm = conexao.prepareStatement(sql);
                pstm.setDouble(1, this.getNota_um());
                pstm.setDouble(2, this.getNota_dois());
                pstm.setDouble(3, this.getNota_tres());
                pstm.setDouble(4, this.getNota_quatro());
                pstm.setInt(5, nota_id);
                pstm.execute();
        
        } catch (Exception e){
            System.out.println("Erro ao alterar as notas do aluno!" + e.getMessage());
        } finally {
            try{
                if(pstm != null){
                pstm.close();

            }
        }  catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        
        }

        } else if (atributo.equals("disciplina") || atributo.equals("Disciplina")){
            String sql = "UPDATE notas SET notas_disciplinas = ? WHERE notas_id = ?";
            PreparedStatement pstm = null;

            try{
                Connection conexao = new Conexao().getConexao();
                pstm = conexao.prepareStatement(sql);
                pstm.setString(1, this.getNota_disciplina());
                pstm.setInt(2, nota_id);
                pstm.execute();
        
        } catch (Exception e){
            System.out.println("Erro ao alterar a disciplina da nota!" + e.getMessage());
        } finally {
            try{
                if(pstm != null){
                pstm.close();

            }
        }  catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        
        }
}
    

        } 
    
    /**
     * METODO CRIADO PARA INSERIR NOTAS
     * @param nota_um
     * @param nota_dois
     * @param nota_tres
     * @param nota_quatro
     * @param nota_media
     * @param nota_disciplina
     * @throws SQLException 
     */
    public void inserirNotas(double nota_um, double nota_dois, double nota_tres, double nota_quatro, double nota_media, String nota_disciplina) throws SQLException{
        Connection conexao = new Conexao().getConexao();
        String sql = "Insert into notas (nota_um, nota_dois, nota_tres, nota_quatro, nota_media, nota_disciplina, fk_notas_alunos_id, fk_notas_professores_id) values (?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement stmt;
            stmt = conexao.prepareStatement(sql);
            stmt.setDouble(1, this.getNota_um());
            stmt.setDouble(2, this.getNota_dois());
            stmt.setDouble(3, this.getNota_tres());
            stmt.setDouble(4, this.getNota_quatro());
            stmt.setDouble(5, this.calcularMedia(nota_um, nota_dois, nota_tres, nota_quatro));
            stmt.setString(6, this.getNota_disciplina());
            stmt.setInt(7, professores.getId());
            stmt.setInt(8, alunos.getId());

            stmt.execute();
            stmt.close();
            conexao.close();
            
        
        } catch (Exception e) {
            System.out.println("Erro ao fazer a inserção de notas no banco de dados!" + e.getMessage());
        }
        
    }
    /**
     * METODO PARA DELETAR NOTAS
     * @param nota_id 
     */
    public void deletarNotas(int nota_id){
        String sql = "DELETE FROM notas WHERE notas_id = ?";
        PreparedStatement pstm = null;
        
        try{
            Connection conexao = new Conexao().getConexao();
            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, nota_id);
            
            pstm.execute();
        } catch (Exception e){
            System.out.println("Erro ao deletar notas!" + e.getMessage());
            
        } finally{
                try{
                    if(pstm != null){
                        pstm.close();
                    }
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    /**
     * 
     * @param nota_id 
     */
    public void listarNotas(int nota_id){
        if(nota_id > 0){
        String sql = "SELECT * FROM notas WHERE notas_id = ?";
        PreparedStatement pstm = null;
        ResultSet rset = null;
        
        
        try{
                Connection conexao = new Conexao().getConexao();
                pstm = conexao.prepareStatement(sql);
                pstm.setInt(1, nota_id);
                pstm.executeQuery();

                if(rset.next()){
                    System.out.println("==================================================");
                    System.out.println("ID: " + rset.getInt("notas_id"));
                    System.out.println("Primeira nota: " + rset.getDouble("primeira_nota"));
                    System.out.println("Segunda nota: " + rset.getDouble("segunda_nota"));
                    System.out.println("Terceira nota: " + rset.getDouble("terceira_nota"));
                    System.out.println("Quarta nota: " + rset.getDouble("quarta_nota"));
                    System.out.println("Media das notas: " + rset.getDouble("notas_media"));
                    System.out.println("Disciplina referente as notas: " + rset.getString("notas_disciplinas"));
                    System.out.println("==================================================");
                
                } else{
                    System.out.println("Nenhuma nota encontrada com o ID fornecido!");
                }
        
                } catch (Exception e){
                    System.out.println("Erro ao listar as notas!" + e.getMessage());
                } finally {
        
                    try{
                        if (rset != null){
                            rset.close();
                        }
                        if(pstm != null){
                            pstm.close();
                        }
                        } catch (SQLException e){
                            System.out.println(e.getMessage());
                        }
                }
        
        } else {
            String sql = "SELECT * FROM notas";
            PreparedStatement pstm = null;
            ResultSet rset = null;
            
            try{
                Connection conexao = new Conexao().getConexao();
                pstm = conexao.prepareStatement(sql);
                
                rset = pstm.executeQuery();
                
                while(rset.next()){
                    System.out.println("==================================================");
                    System.out.println("ID: " + rset.getInt("notas_id"));
                    System.out.println("Primeira nota: " + rset.getDouble("primeira_nota"));
                    System.out.println("Segunda nota: " + rset.getDouble("segunda_nota"));
                    System.out.println("Terceira nota: " + rset.getDouble("terceira_nota"));
                    System.out.println("Quarta nota: " + rset.getDouble("quarta_nota"));
                    System.out.println("Media das notas: " + rset.getDouble("notas_media"));
                    System.out.println("Disciplina referente as notas: " + rset.getString("notas_disciplinas"));
                    System.out.println("==================================================");
                 
                }
            } catch (SQLException e){
                System.out.println("Erro ao listar as NOTAS" + e.getMessage());
                
            } finally {
                try {
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
    }
    
    public boolean verificarNota(int nota_id){
        try (Connection conexao = new Conexao().getConexao();
            PreparedStatement comando = conexao.prepareStatement("SELECT * FROM notas WHERE notas_id = ?")) {
            comando.setInt(1, nota_id);
            try (ResultSet resultado = comando.executeQuery()){
                return resultado.next();
            }
            } catch (SQLException e){
                System.out.println("Erro ao verificar a tabela NOTAS " + e.getMessage());
            }
            return false;
    }
    
}
