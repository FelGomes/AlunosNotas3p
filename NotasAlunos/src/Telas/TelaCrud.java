
package Telas;
import java.io.IOException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Carlos
 */
public class TelaCrud {
    
    public static void montarTelaInicial() throws IOException {
        
        final JFrame jFrameInicial = new JFrame("Sistema de notas");
        
        jFrameInicial.setBounds(200, 170, 650, 450);
        jFrameInicial.setLayout(null);
        
        JLabel labelInserir = new JLabel("   Inserir");
        labelInserir.setBounds(20, 20, 100, 100);
        labelInserir.setHorizontalAlignment(JLabel.CENTER);
        
        JButton buttonInserir = new JButton();
        buttonInserir.setBounds(150,175, 100, 50);
        buttonInserir.add(labelInserir);
        jFrameInicial.add(buttonInserir);
        
        JLabel labelEditar = new JLabel("   Editar");
        labelEditar.setBounds(20, 20, 100, 100);
        labelEditar.setHorizontalAlignment(JLabel.CENTER);
        
        JButton buttonEditar = new JButton();
        buttonEditar.setBounds(275, 175, 100, 50);
        buttonEditar.add(labelEditar);
        jFrameInicial.add(buttonEditar);
        
        JLabel labelListar = new JLabel("   Listar");
        labelListar.setBounds(20, 20, 100, 100);
        labelListar.setHorizontalAlignment(JLabel.CENTER);
        
        JButton buttonListar = new JButton();
        buttonListar.setBounds(400, 175, 100, 50);
        buttonListar.add(labelListar);
        jFrameInicial.add(buttonListar);
        
        
        // ainda falta adicionar as funcionalidades!
        jFrameInicial.setVisible(true);
        
    }
}
