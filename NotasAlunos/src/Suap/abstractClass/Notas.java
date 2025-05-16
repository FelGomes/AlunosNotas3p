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
    private int nota_id, aluno_id, professor_id;
    
    Alunos alunos = new Alunos();
    Professores professores = new Professores();
    
    
    public Notas(){
    }
   
    public void setProfessor_id(int professor_id){
        this.professor_id = professor_id;
    }
    
    public void setAluno_id(int aluno_id){
        this.aluno_id = aluno_id;
    }
    
    public int getProfessor_id(){
        return professor_id;
    }    
    public int getAluno_id(){
        return aluno_id;
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
        String sql = "UPDATE notas SET nota_um = ?, nota_media = ? WHERE notas_id = ?";
        PreparedStatement pstm = null;
        
        try{
            Connection conexao = new Conexao().getConexao();
            pstm = conexao.prepareStatement(sql);
            pstm.setDouble(1, this.getNota_um());
            pstm.setDouble(2, this.calcularMedia(this.getNota_um(), this.getNota_dois(), this.getNota_tres(), this.getNota_quatro()));
            pstm.setInt(3, nota_id);
             int alteracao = pstm.executeUpdate();
                
                if (alteracao > 0){
                    System.out.println("Tabela alterada com sucesso! ");
                    
                } else{
                    System.out.println("Erro ao alterar a tabela!");
                }
                
        
            } catch (Exception e){
                System.out.println("Erro ao alterar nota um do aluno!" + e.getMessage());
            } 
        
        } else if (atributo.equals("nota dois") || atributo.equals("Nota dois")){
            String sql = "UPDATE notas SET nota_dois = ?, nota_media = ? WHERE notas_id = ?";
            PreparedStatement pstm = null;

            try{
                Connection conexao = new Conexao().getConexao();
                pstm = conexao.prepareStatement(sql);
                pstm.setDouble(1, this.getNota_dois());
                pstm.setDouble(2, this.calcularMedia(this.getNota_um(), this.getNota_dois(), this.getNota_tres(), this.getNota_quatro()));
                pstm.setInt(3, nota_id);
                int alteracao = pstm.executeUpdate();
                
                if (alteracao > 0){
                    System.out.println("Tabela alterada com sucesso! ");
                    
                } else{
                    System.out.println("Erro ao alterar a tabela!");
                }
                
        
            } catch (Exception e){
                System.out.println("Erro ao alterar nota dois do aluno!" + e.getMessage());
            } 
        
        
            
        } else if(atributo.equals("nota tres") || atributo.equals("Nota tres")){
            String sql = "UPDATE notas SET nota_tres = ?, nota_media = ? WHERE notas_id = ?";
            PreparedStatement pstm = null;

            try{
                Connection conexao = new Conexao().getConexao();
                pstm = conexao.prepareStatement(sql);
                pstm.setDouble(1, this.getNota_tres());
                pstm.setDouble(2, this.calcularMedia(this.getNota_um(), this.getNota_dois(), this.getNota_tres(), this.getNota_quatro()));
                pstm.setInt(3, nota_id);
                 int alteracao = pstm.executeUpdate();
                
                if (alteracao > 0){
                    System.out.println("Tabela alterada com sucesso! ");
                    
                } else{
                    System.out.println("Erro ao alterar a tabela!");
                }
                
        
            } catch (Exception e){
                System.out.println("Erro ao alterar nota tres do aluno!" + e.getMessage());
            } 

        } else if (atributo.equals("nota quatro") || atributo.equals("Nota quatro")){
            String sql = "UPDATE notas SET nota_quatro = ?, nota_media = ? WHERE notas_id = ?";
            PreparedStatement pstm = null;

            try{
                Connection conexao = new Conexao().getConexao();
                pstm = conexao.prepareStatement(sql);
                pstm.setDouble(1, this.getNota_quatro());
                pstm.setDouble(2, this.calcularMedia(this.getNota_um(), this.getNota_dois(), this.getNota_tres(), this.getNota_quatro()));
                pstm.setInt(3, nota_id);
                int alteracao = pstm.executeUpdate();
                
                if (alteracao > 0){
                    System.out.println("Tabela alterada com sucesso! ");
                    
                } else{
                    System.out.println("Erro ao alterar a tabela!");
                }
                
        
            } catch (Exception e){
                System.out.println("Erro ao alterar nota quatro do aluno!" + e.getMessage());
            } 
            
        } else if (atributo.equals("Disciplina") || atributo.equals("disciplina")){
            String sql = "UPDATE notas SET notas_disciplinas = ? WHERE notas_id = ?";
            PreparedStatement pstm = null;

            try{
                Connection conexao = new Conexao().getConexao();
                pstm = conexao.prepareStatement(sql);
                pstm.setString(1, this.getNota_disciplina());
                pstm.setInt(2, nota_id);
                int alteracao = pstm.executeUpdate();
                
                if (alteracao > 0){
                    System.out.println("Tabela alterada com sucesso! ");
                    
                } else{
                    System.out.println("Erro ao alterar a tabela!");
                }
                

            } catch (Exception e){
                System.out.println("Erro ao alterar a disciplina da nota do aluno!" + e.getMessage());
            } 
        
        
        }else if (atributo.equals("tudo") || atributo.equals("Tudo")){
            String sql = "UPDATE notas SET nota_um = ?, nota_dois = ?, nota_tres = ?, nota_quatro = ?, nota_media = ?, nota_disciplina WHERE notas_id = ?";
            PreparedStatement pstm = null;

            try{
                Connection conexao = new Conexao().getConexao();
                pstm = conexao.prepareStatement(sql);
                pstm.setDouble(1, this.getNota_um());
                pstm.setDouble(2, this.getNota_dois());
                pstm.setDouble(3, this.getNota_tres());
                pstm.setDouble(4, this.getNota_quatro());
                pstm.setDouble(5, this.calcularMedia(this.getNota_um(), this.getNota_dois(), this.getNota_tres(), this.getNota_quatro()));
                pstm.setString(6, this.getNota_disciplina());
                
                pstm.setInt(7, nota_id);
                int alteracao = pstm.executeUpdate();
                
                if (alteracao > 0){
                    System.out.println("Tabela alterada com sucesso! ");
                    
                } else{
                    System.out.println("Erro ao alterar a tabela!");
                }
                
        
        } catch (Exception e){
            System.out.println("Erro ao alterar as notas do aluno!" + e.getMessage());
        }

        } else if (atributo.equals("disciplina") || atributo.equals("Disciplina")){
            String sql = "UPDATE notas SET nota_disciplina = ? WHERE notas_id = ?";
            PreparedStatement pstm = null;

            try{
                Connection conexao = new Conexao().getConexao();
                pstm = conexao.prepareStatement(sql);
                pstm.setString(1, this.getNota_disciplina());
                pstm.setInt(2, nota_id);
                int alteracao = pstm.executeUpdate();
                
                if (alteracao > 0){
                    System.out.println("Tabela alterada com sucesso! ");
                    
                } else{
                    System.out.println("Erro ao alterar a tabela!");
                }
                
        
            } catch (Exception e){
                System.out.println("Erro ao alterar a disciplina da nota!" + e.getMessage());
            } 
            
        
        }
    }
    

        
    
    /**
     * METODO CRIADO PARA INSERIR NOTAS
     
     * @throws SQLException 
     */
    public void inserirNotas() throws SQLException{
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
            stmt.setInt(7, this.getAluno_id());
            stmt.setInt(8, this.getProfessor_id());
            int alteracao = stmt.executeUpdate();

            if (alteracao > 0) {
                System.out.println("Notas inseridas com sucesso!");
            } else {
                System.out.println("Nao foi possivel inserir notas!");
            }
            
        
        } catch (SQLException e) {
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
            
            int alteracao = pstm.executeUpdate();
            
            if (alteracao > 0){
                System.out.println("Tabela deletada com sucesso!");
            } else {
                System.out.println("Erro ao deletar a tabela");
            }
        } catch (Exception e){
            System.out.println("Erro ao deletar notas!" + e.getMessage());
            
        } 
        
    }
    /**
     * 
     * @param nota_id 
     */
    public void listarNotas(int nota_id){
        if(nota_id > 0){
        String sql = "SELECT " +
             "n.notas_id, " +
             "ua.usuarios_nome AS aluno_nome, " +
             "ua.usuarios_sexo AS aluno_sexo, " +
             "up.usuarios_nome AS professor_nome, " +
             "up.usuarios_sexo AS professor_sexo, " +
             "n.nota_um, " +
             "n.nota_dois, " +
             "n.nota_tres, " +
             "n.nota_quatro, " +
             "n.nota_media, " +
             "n.nota_disciplina " +
             "FROM notas n " +
             "INNER JOIN alunos a ON n.fk_notas_alunos_id = a.alunos_id " +
             "INNER JOIN usuarios ua ON a.fk_alunos_usuarios_id = ua.usuarios_id " +
             "INNER JOIN professores p ON n.fk_notas_professores_id = p.professores_id " +
             "INNER JOIN usuarios up ON p.fk_professores_usuarios_id = up.usuarios_id " +
             "where n.notas_id = ?";
             
        PreparedStatement pstm = null;
        ResultSet rset = null;
        
        
        try{
                Connection conexao = new Conexao().getConexao();
                pstm = conexao.prepareStatement(sql);
                pstm.setInt(1, nota_id);
                pstm.executeQuery();
                rset = pstm.executeQuery();

                if(rset.next()){
                    System.out.println("==================================================");
                    System.out.println("ID: " + rset.getInt("notas_id"));
                    System.out.println("Aluno: " + rset.getString("aluno_nome"));
                    System.out.println("Sexo: " + rset.getString("aluno_sexo"));
                    System.out.println("Primeira nota: " + rset.getDouble("nota_um"));
                    System.out.println("Segunda nota: " + rset.getDouble("nota_dois"));
                    System.out.println("Terceira nota: " + rset.getDouble("nota_tres"));
                    System.out.println("Quarta nota: " + rset.getDouble("nota_quatro"));
                    System.out.println("Media das notas: " + rset.getDouble("nota_media"));
                    System.out.println("Disciplina referente as notas: " + rset.getString("nota_disciplina"));
                    System.out.println("Professor: " + rset.getString("professor_nome"));
                    System.out.println("Sexo:" + rset.getString("professor_sexo"));
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
            String sql = "SELECT " +
             "n.notas_id, " +
             "ua.usuarios_nome AS aluno_nome, " +
             "ua.usuarios_sexo AS aluno_sexo, " +
             "up.usuarios_nome AS professor_nome, " +
             "up.usuarios_sexo AS professor_sexo, " +
             "n.nota_um, " +
             "n.nota_dois, " +
             "n.nota_tres, " +
             "n.nota_quatro, " +
             "n.nota_media, " +
             "n.nota_disciplina " +
             "FROM notas n " +
             "INNER JOIN alunos a ON n.fk_notas_alunos_id = a.alunos_id " +
             "INNER JOIN usuarios ua ON a.fk_alunos_usuarios_id = ua.usuarios_id " +
             "INNER JOIN professores p ON n.fk_notas_professores_id = p.professores_id " +
             "INNER JOIN usuarios up ON p.fk_professores_usuarios_id = up.usuarios_id;";
;
            PreparedStatement pstm = null;
            ResultSet rset = null;
            
            try{
                Connection conexao = new Conexao().getConexao();
                pstm = conexao.prepareStatement(sql);
                
                rset = pstm.executeQuery();
                
                while(rset.next()){
                    System.out.println("==================================================");
                    System.out.println("ID: " + rset.getInt("notas_id"));
                    System.out.println("Aluno: " + rset.getString("aluno_nome"));
                    System.out.println("Sexo: " + rset.getString("aluno_sexo"));
                    System.out.println("Primeira nota: " + rset.getDouble("nota_um"));
                    System.out.println("Segunda nota: " + rset.getDouble("nota_dois"));
                    System.out.println("Terceira nota: " + rset.getDouble("nota_tres"));
                    System.out.println("Quarta nota: " + rset.getDouble("nota_quatro"));
                    System.out.println("Media das notas: " + rset.getDouble("nota_media"));
                    System.out.println("Disciplina referente as notas: " + rset.getString("nota_disciplina"));
                    System.out.println("Professor: " + rset.getString("professor_nome"));
                    System.out.println("Sexo:" + rset.getString("professor_sexo"));
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
