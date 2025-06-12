
package Telas;

/**
 *
 * @author Kauã Luiz
 */
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.text.MaskFormatter;

public class TMatricula {
    public static void MontarTelaMatricula() throws IOException {
        JFrame janela = new JFrame("Cadastro de Matrícula");
        janela.setSize(600, 550);
        janela.setLayout(null);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Labels
        JLabel rotuloID = new JLabel("ID:");
        rotuloID.setBounds(30, 20, 80, 20);
        janela.add(rotuloID);
        
        JLabel rotuloDataInicio = new JLabel("Data Início:");
        rotuloDataInicio.setBounds(30, 60, 80, 20);
        janela.add(rotuloDataInicio);
        
        JLabel rotuloDataFim = new JLabel("Data Início:");
        rotuloDataFim.setBounds(30, 100, 80, 20);
        janela.add(rotuloDataFim);
        
        JLabel rotuloQtdTempo = new JLabel("Qtd Tempo:");
        rotuloQtdTempo.setBounds(30, 140, 80, 20);
        janela.add(rotuloQtdTempo);
        
        JLabel rotuloInstituicao = new JLabel("ID Instituição:");
        rotuloInstituicao.setBounds(30, 180, 100, 20);
        janela.add(rotuloInstituicao);
        
        JLabel rotuloAluno = new JLabel("ID Aluno:");
        rotuloAluno.setBounds(30, 220, 80, 20);
        janela.add(rotuloAluno);
        
        JLabel rotuloFiltro = new JLabel("Filtrar por ID:");
        rotuloFiltro.setBounds(30, 250, 80, 20);
        janela.add(rotuloFiltro);
        
        // CAMPOS DE TEXT
        JTextField campoID = new JTextField();
        campoID.setBounds(150, 20, 200, 20);
        janela.add(campoID);
        
        JFormattedTextField campoDataInicio = new JFormattedTextField(mascaraData("##/##/####"));
        campoDataInicio.setBounds(150, 60, 200, 20);
        janela.add(campoDataInicio);        
        
    }
}
