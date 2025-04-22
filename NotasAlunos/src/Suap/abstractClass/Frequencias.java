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
    private int id;
    private Alunos alunos;
    private Diario diario;
    private String data_registro;
    private boolean presente;
    private boolean falta_justificada;
    private String observacao;

    public Frequencias(int id, Alunos alunos, Diario diario, String data_registro, boolean presente, boolean falta_justificada, String observacao) {
        this.id = id;
        this.alunos = alunos;
        this.diario = diario;
        this.data_registro = data_registro;
        this.presente = presente;
        this.falta_justificada = false;
        this.observacao = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Alunos getAlunos() {
        return alunos;
    }

    public void setAlunos(Alunos alunos) {
        this.alunos = alunos;
    }

    public Diario getDiario() {
        return diario;
    }

    public void setDiario(Diario diario) {
        this.diario = diario;
    }

    public String getData_registro() {
        return data_registro;
    }

    public void setData_registro(String data_registro) {
        this.data_registro = data_registro;
    }

    public boolean isPresente() {
        return presente;
    }

    public void setPresente(boolean presente) {
        this.presente = presente;
    }

    public boolean isFalta_justificada() {
        return falta_justificada;
    }

    public void setFalta_justificada(boolean falta_justificada) {
        this.falta_justificada = falta_justificada;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
   
    
    
}
