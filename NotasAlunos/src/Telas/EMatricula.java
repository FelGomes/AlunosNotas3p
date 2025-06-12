
package Telas;

/**
 *
 * @author Kauã Luiz
 */
public class EMatricula {
     private int matriculas_id;
    private String data_inicio;
    private String data_fim;
    private int qtd_tempo;
    private int fk_instituicao_id;
    private int fk_aluno_id;

    // Construtores
    public EMatricula() {}

    public EMatricula(int matriculas_id, String data_inicio, String data_fim, int qtd_tempo, int fk_instituicao_id, int fk_aluno_id) {
        this.matriculas_id = matriculas_id;
        this.data_inicio = data_inicio;
        this.data_fim = data_fim;
        this.qtd_tempo = qtd_tempo;
        this.fk_instituicao_id = fk_instituicao_id;
        this.fk_aluno_id = fk_aluno_id;
    }

    // Getters e Setters
    public int getMatriculas_id() {
        return matriculas_id;
    }

    public void setMatriculas_id(int matriculas_id) {
        this.matriculas_id = matriculas_id;
    }

    public String getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(String data_inicio) {
        this.data_inicio = data_inicio;
    }

    public String getData_fim() {
        return data_fim;
    }

    public void setData_fim(String data_fim) {
        this.data_fim = data_fim;
    }

    public int getQtd_tempo() {
        return qtd_tempo;
    }

    public void setQtd_tempo(int qtd_tempo) {
        this.qtd_tempo = qtd_tempo;
    }

    public int getFk_instituicao_id() {
        return fk_instituicao_id;
    }

    public void setFk_instituicao_id(int fk_instituicao_id) {
        this.fk_instituicao_id = fk_instituicao_id;
    }

    public int getFk_aluno_id() {
        return fk_aluno_id;
    }

    public void setFk_aluno_id(int fk_aluno_id) {
        this.fk_aluno_id = fk_aluno_id;
    }
}
