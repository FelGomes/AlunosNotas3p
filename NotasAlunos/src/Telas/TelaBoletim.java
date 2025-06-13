package Telas;

import java.awt.Font;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


/**
 *
 * @author Dheniel 
 */
public class TelaBoletim {
    private static JTable tabelaBoletim;
    private static DefaultTableModel modelBoletim;
    
    public static void montarTelaVisualizacao(){
        final JFrame oJFrame = new JFrame("Boletim");
        oJFrame.setBounds(450, 170, 580, 500);
        oJFrame.setLayout(null);
        JButton oJButtonBoletim = new JButton("Filtrar");
        oJButtonBoletim.setBounds(420, 230, 100, 25);

   
        String[] colunasBoletim = {
            "Nome", "Sexo", "Sala", "Turma", "Média", "Faltas", "Total Aulas"
        };
        
        modelBoletim = new DefaultTableModel(colunasBoletim, 0); 
        tabelaBoletim = new JTable(modelBoletim);
        JScrollPane scrollBoletim = new JScrollPane(tabelaBoletim);
        scrollBoletim.setBounds(20, 30, 530, 200); 
        oJFrame.add(scrollBoletim);
    }
    
}
