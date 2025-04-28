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
    private Alunos alunos;
    private Professores professores;
    private int nota_id;
    
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

    public Alunos getAlunos() {
        return alunos;
    }

    public void setAlunos(Alunos alunos) {
        this.alunos = alunos;
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
    
    public boolean verificarIdNota(int id_buscado){
        Connection conexao = new Conexao().getConexao();
        return true;
    }
    
    public void alterarNota1 (double nota_um){
        if (nota_id > 0){
        Connection conexao = new Conexao().getConexao();
        String sql = "UPDATE notas SET nota_um = ? WHERE id = ?";
        try{
        PreparedStatement stmt;
        PreparedStatement stmt1;
        stmt = conexao.prepareStatement(sql);
        stmt.setDouble(1, this.getNota_um());
        stmt.setInt(2, this.getNota_id());
        
        }
        }
    }
    
    

    
    
    public void inserir_Notas(double nota_um, double nota_dois, double nota_tres, double nota_quatro, double nota_media, String nota_disciplina) throws SQLException{
        Connection conexao = new Conexao().getConexao();
        String sql = "Insert into notas (nota_um, nota_dois, nota_tres, nota_quatro, nota_media, nota_disciplina) values (?,?,?,?,?,?)";
        try{
        PreparedStatement stmt;
        PreparedStatement stmt1;
        stmt = conexao.prepareStatement(sql);
        stmt.setDouble(1, this.getNota_um());
        stmt.setDouble(2, this.getNota_dois());
        stmt.setDouble(3, this.getNota_tres());
        stmt.setDouble(4, this.getNota_quatro());
        stmt.setDouble(5, this.getNota_media());
        stmt.setString(6, this.getNota_disciplina());
        
        stmt.execute();
        stmt.close();
        conexao.close();
            
        
        } catch (Exception e) {
            System.out.println("Erro ao fazer a inserção de notas no banco de dados!" + e.getMessage());
        }
        
    }
}
