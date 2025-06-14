package Telas;

import Suap.abstractClass.Alunos;
import Suap.abstractClass.Professores;
/**
 * Classe para objetos do tipo Frequencias.
 * @author Marcus Vinícius Nunes Silva
 * @since 22/04/2025 at 12:28 AM
 */
public class EFrequencias {

    private int frequencias_id, total_aulas, aulas_ministradas, frequencias_faltas;
    private float prctg_presenca;
    private String frequencias_disciplinas;
    private Professores professores;
    private Alunos aluno;

    /**
     * Construtor vazio com todas as informações de Frequencias.
     */
    public EFrequencias() {
    }

    /**
     * Construtor que inicializa as informações de Frequencias.
     * @param frequencias_id Identificador da frequencia.
     * @param total_aulas Quantidade total de aulas.
     * @param aulas_ministradas Quantidade total de aulas ministradas.
     * @param frequencias_faltas Quantidade de faltas.
     * @param prctg_presenca Porcentagem de presença de aula.
     * @param frequencias_disciplinas Nome da disciplina.
     * @param professores Objeto professores.
     * @param aluno Objeto alunos.
     */
    public EFrequencias(int frequencias_id, int total_aulas, int aulas_ministradas, int frequencias_faltas, float prctg_presenca, String frequencias_disciplinas, Professores professores, Alunos aluno) {
        this.frequencias_id = frequencias_id;
        this.total_aulas = total_aulas;
        this.aulas_ministradas = aulas_ministradas;
        this.frequencias_faltas = frequencias_faltas;
        this.prctg_presenca = prctg_presenca;
        this.frequencias_disciplinas = frequencias_disciplinas;
        this.professores = professores;
        this.aluno = aluno;

    }

     /**
     * Método para retornar o identificador de frequencia.
     * @return frequencias_id Identificador de frequencia.
     */
    public int getFrequencias_id() {
        return frequencias_id;
    }

     /**
     * Método para definir um valor ao identificador de frequencia.
     * @param frequencias_id Identificador de frequencia.
     */
    public void setFrequencias_id(int frequencias_id) {
        this.frequencias_id = frequencias_id;
    }

     /**
     * Método para retornar a quantidade total de aulas.
     * @return total_aulas Quantidade total de aulas.
     */
    public int getTotal_aulas() {
        return total_aulas;
    }

     /**
     * Método para definir um valor a quantidade total de aulas.
     * @param total_aulas Quantidade total de aulas.
     */
    public void setTotal_aulas(int total_aulas) {
        this.total_aulas = total_aulas;
    }

     /**
     * Método para retornar o nome da disciplina.
     * @return frequencias_disciplinas Nome da disciplina.
     */
    public String getFrequencias_disciplinas() {
        return frequencias_disciplinas;
    }

     /**
     * Método para definir um valor ao nome da disciplina.
     * @param frequencias_disciplinas Nome da disciplina.
     */
    public void setFrequencias_disciplinas(String frequencias_disciplinas) {
        this.frequencias_disciplinas = frequencias_disciplinas;
    }

     /**
     * Método para definir um valor ao objeto Alunos.
     * @param aluno Objeto Alunos.
     */
    public void setAluno(Alunos aluno) {
        this.aluno = aluno;
    }

    /**
     * Método para retornar a quantidade de aulas ministradas.
     * @return aulas_ministradas Quantidade de aulas ministradas.
     */
    public int getAulas_ministradas() {
        return aulas_ministradas;
    }

     /**
     * Método para definir um valor a quantidade de aulas ministradas.
     * @param aulas_ministradas Quantidade de aulas ministradas.
     */
    public void setAulas_ministradas(int aulas_ministradas) {
        this.aulas_ministradas = aulas_ministradas;
    }

    /**
     * Método para retornar o objeto Alunos.
     * @return aluno Objeto Alunos.
     */
    public Alunos getAluno() {
        return aluno;
    }

     /**
     * Método para retornar a quantidade de faltas.
     * @return frequencias_faltas Quantidade de faltas.
     */
    public int getFrequencias_faltas() {
        return frequencias_faltas;
    }

     /**
     * Método para definir um valor a quantidade de faltas.
     * @param frequencias_faltas Quantidade de faltas.
     */
    public void setFrequencias_faltas(int frequencias_faltas) {
        this.frequencias_faltas = frequencias_faltas;
    }

    /**
     * Método para retornar a porcetagem de frequencia em aula.
     * @return prctg_presenca Porcentagem de frequencia em aula.
     */
    public float getPrctg_presenca() {
        return prctg_presenca;
    }

      /**
     * Método para definir um valor a porcentagem de frequencias em aula..
     * @param prctg_presenca Porcentagem de frequencia em aula.
     */
    public void setPrctg_presenca(float prctg_presenca) {
        this.prctg_presenca = prctg_presenca;
    }

    /**
     * Método para retornar o objeto Professores.
     * @return professores Objeto Professores.
     */
    public Professores getProfessores() {
        return professores;
    }

        /**
     * Método para definir um valor ao objeto Professores.
     * @param professores Objeto Professores.
     */
    public void setProfessores(Professores professores) {
        this.professores = professores;
    }

}
