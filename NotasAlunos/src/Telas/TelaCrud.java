
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
        
        jFrameInicial.setBounds(200, 170, 500, 200);
        jFrameInicial.setLayout(null);
        
        jFrameInicial.setVisible(true);
        
    }
}
