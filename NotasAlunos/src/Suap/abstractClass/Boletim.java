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
    
    /**
     * 
     * @param boletins_id 
     */
    public void listarBoletim(int boletins_id){
        if(boletins_id > 0){
            String sql = "SELECT * FROM boletins WHERE boletins_id = ?";
            PreparedStatement pstm = null;
            ResultSet rset = null;
        
        }
    
    
    }
    
}
