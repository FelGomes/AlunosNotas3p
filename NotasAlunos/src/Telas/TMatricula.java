
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
    }
}
