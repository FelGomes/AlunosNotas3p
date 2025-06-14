
package Telas;

/**
 *
 * @author Kauã Luiz
 */
import javax.swing.*;
public class TDiario {
    public static void montarTelaDiario(){
        JFrame janela = new JFrame("Cadastro de Diário:");
        janela.setSize(600, 400);
        janela.setLayout(null);
        
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel rotuloId = new JLabel("ID:");
        rotuloId.setBounds(30, 20, 80, 20);
        janela.add(rotuloId);
        
        JLabel rotuloLocal = new JLabel("Local:");
        rotuloLocal.setBounds(30, 140, 80, 20);
        janela.add(rotuloLocal);
        
        JLabel rotuloDisciplina = new JLabel("Disciplina:");
        rotuloDisciplina.setBounds(30, 100, 80, 20);
        janela.add(rotuloDisciplina);
        
        JLabel rotuloQtdAlunos = new JLabel("Qtd ALunos:");
        rotuloQtdAlunos.setBounds(30, 140, 80, 20);
        janela.add(rotuloQtdAlunos);
        
        JLabel rotuloProfessor = new JLabel("ID Professor:");
        rotuloProfessor.setBounds(30, 180, 80, 20);
        janela.add(rotuloProfessor);
        
        JLabel rotuloAluno = new JLabel("ID Aluno:");
        rotuloProfessor.setBounds(30, 220, 80, 20);
        janela.add(rotuloAluno);
        
        // Campos de texto
        JTextField campoId = new JTextField();
        campoId.setBounds(150, 20, 200, 20);
        janela.add(campoId);
        
        JTextField campoLocal = new JTextField();
        campoLocal.setBounds(150, 60, 200, 20);
        janela.add(campoLocal);
        
        JTextField campoDisciplina = new JTextField();
        campoDisciplina.setBounds(150, 100, 200, 20);
        janela.add(campoDisciplina);
        
        JTextField campoQtdAlunos = new JTextField();
        campoQtdAlunos.setBounds(150, 140, 200, 20);
        janela.add(campoQtdAlunos);
        
        JTextField campoProfessor = new JTextField();
        campoProfessor.setBounds(150, 180, 200, 20);
        janela.add(campoProfessor);
        
        JTextField campoAluno = new JTextField();
        campoAluno.setBounds(150, 220, 200, 20);
        janela.add(campoAluno);
       
        JButton botaoSalvar = new JButton("Salvar");
        botaoSalvar.setBounds(400, 20, 100, 30);
        janela.add(botaoSalvar);

        JButton botaoAlterar = new JButton("Alterar");
        botaoAlterar.setBounds(400, 60, 100, 30);
        janela.add(botaoAlterar);

        JButton botaoExcluir = new JButton("Excluir");
        botaoExcluir.setBounds(400, 100, 100, 30);
        janela.add(botaoExcluir);

        JButton botaoListar = new JButton("Listar");
        botaoListar.setBounds(400, 140, 100, 30);
        janela.add(botaoListar);
        
        
        
        
        
        
        
    }
    
}
