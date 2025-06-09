/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Telas;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author felipe
 */
public class Usuario {
 
    public static void montarTelaUsuario() throws IOException {

        JFrame janela = new JFrame("INSERIR USUARIO");
        janela.setBounds(200, 150, 600, 550);
        janela.setLayout(null);

        JLabel nomeUsuario = new JLabel("NOME:");
        nomeUsuario.setBounds(5, 20, 60, 25);
        nomeUsuario.setHorizontalAlignment(JLabel.RIGHT);
        janela.add(nomeUsuario);

        JTextField campoUsuario = new JTextField();
        campoUsuario.setBounds(20, 45, 250, 25);
        campoUsuario.setLayout(null);
        janela.add(campoUsuario);

        JLabel nomeEndereco = new JLabel("ENDERECO:");
        nomeEndereco.setBounds(5, 80, 80, 25);
        nomeEndereco.setHorizontalAlignment(JLabel.RIGHT);
        janela.add(nomeEndereco);

        JTextField campoEndereco = new JTextField();
        campoEndereco.setBounds(20, 108, 250, 25);
        campoEndereco.setLayout(null);
        janela.add(campoEndereco);

        JLabel nomeCPF = new JLabel("CPF:");
        nomeCPF.setBounds(310, 20, 60, 25);
        nomeCPF.setHorizontalAlignment(JLabel.RIGHT);
        janela.add(nomeCPF);

        JTextField campoCPF = new JFormattedTextField(mascaraCPF("###.###.###-##"));
        campoCPF.setBounds(340, 45, 250, 25);
        campoCPF.setLayout(null);
        janela.add(campoCPF);

        JLabel campoSexo = new JLabel("SEXO:");
        campoSexo.setBounds(315, 80, 60, 25);
        campoSexo.setHorizontalAlignment(JLabel.RIGHT);
        janela.add(campoSexo);

        JComboBox<String> ojComboBox = new JComboBox<>();
        ojComboBox.setBounds(338, 108, 120, 25);
        ojComboBox.addItem("-SELECIONE-");
        ojComboBox.addItem("M");
        ojComboBox.addItem("F");
        janela.add(ojComboBox);

        JLabel nomeData = new JLabel("DAT.NASC");
        nomeData.setBounds(20, 140, 60, 25);
        nomeData.setHorizontalAlignment(JLabel.RIGHT);
        janela.add(nomeData);

        JTextField campoData = new JFormattedTextField(mascaraData("##/##/####"));
        campoData.setBounds(20, 170, 100, 25);
        campoData.setLayout(null);
        janela.add(campoData);

        // botoes // 
        JButton botaoSalvar = new JButton("SAVE");
        botaoSalvar.setBounds(350, 170, 80, 25);
        janela.add(botaoSalvar);

        JButton botaoCancelar = new JButton("CANCEL");
        botaoCancelar.setBounds(450, 170, 100, 25);
        janela.add(botaoCancelar);

        JButton botaoAlterar = new JButton("ALTER");
        botaoAlterar.setBounds(350, 205, 80, 25);
        botaoAlterar.setEnabled(false);
        janela.add(botaoAlterar);

        JButton botaoDeletar = new JButton("DEL");
        botaoDeletar.setBounds(450, 205, 100, 25);
        botaoDeletar.setEnabled(false);
        janela.add(botaoDeletar);

        JButton botaoFiltrar = new JButton("Filtrar");
        botaoFiltrar.setBounds(350, 240, 80, 25);
        janela.add(botaoFiltrar);

        JButton botaoArquivo = new JButton("GER.ARQ");
        botaoArquivo.setBounds(450, 240, 100, 25);
        janela.add(botaoArquivo);

        String[] colunas = new String[]{"Nome", "Sexo", "CPF", "Endereco", "Nascimento"};
        ArrayList<EUsuario> oListaUsuario = new ArrayList<>();
        PUsuario ppUsuarios = new PUsuario();

        try {
            oListaUsuario = ppUsuarios.consultarUsuario();
        } catch (SQLException e1) {
            System.out.println(e1.getMessage());
        }

        String linhas[][] = new String[oListaUsuario.size()][5];

        int i = 0;

        for (EUsuario usu : oListaUsuario) {

            linhas[i][0] = usu.getNome();
            linhas[i][1] = usu.getSexo();
            linhas[i][2] = usu.getCpf();
            linhas[i][3] = usu.getEndereco();
            linhas[i][4] = usu.getDataNasc();

            i++;

        }

        JLabel nomeFiltro = new JLabel("FILTRO:");
        nomeFiltro.setBounds(10, 205, 60, 25);
        nomeFiltro.setHorizontalAlignment(JLabel.RIGHT);
        janela.add(nomeFiltro);

        JTextField campoFiltro = new JTextField();
        campoFiltro.setBounds(20, 230, 250, 25);
        campoFiltro.setLayout(null);
        janela.add(campoFiltro);

        /// tabela
        JTable tabela = new JTable(linhas, colunas);
        JScrollPane scroll = new JScrollPane();
        scroll.setBounds(30, 270, 515, 220);
        scroll.setViewportView(tabela);
        janela.add(scroll);

        botaoSalvar.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                if (campoUsuario.getText().trim().equalsIgnoreCase("")
                        || ojComboBox.getSelectedIndex() == 0
                        || campoCPF.getText().trim().equalsIgnoreCase("")
                        || campoEndereco.getText().trim().equalsIgnoreCase("")
                        || campoData.getText().trim().equalsIgnoreCase("")) {

                    JOptionPane.showMessageDialog(null, "Preencha todos os dados!");

                    return;

                }

                PUsuario usu = new PUsuario();
                String inclusao = usu.incluirUsuario(campoUsuario.getText(), ojComboBox.getSelectedItem().toString(), campoCPF.getText(), campoEndereco.getText(), campoData.getText());

                JOptionPane.showMessageDialog(null, inclusao);

                janela.dispose();
                try {
                    Usuario.montarTelaUsuario();
                } catch (IOException e1) {
                    System.out.println(e1.getMessage());
                }

            }
        });

        // arrumar essa sintaxe para aparecer na tela
        tabela.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                campoUsuario.setText(tabela.getValueAt(tabela.getSelectedRow(), 0).toString()); // Nome
                ojComboBox.setSelectedItem(tabela.getValueAt(tabela.getSelectedRow(), 1).toString()); // Sexo
                campoCPF.setText(tabela.getValueAt(tabela.getSelectedRow(), 2).toString()); // CPF
                campoEndereco.setText(tabela.getValueAt(tabela.getSelectedRow(), 3).toString()); // Endereço
                campoData.setText(tabela.getValueAt(tabela.getSelectedRow(), 4).toString()); // Nascimento

                botaoAlterar.setEnabled(true);
                botaoDeletar.setEnabled(true);

                botaoDeletar.addMouseListener(new MouseAdapter() {

                    @Override
                    public void mouseClicked(MouseEvent e) {

                        PUsuario usuario = new PUsuario();

                        try {
                            if (!campoCPF.getText().equalsIgnoreCase("") && campoCPF.getText() != null) {
                                String exclusao = usuario.excluirUsuario(campoCPF.getText());
                                JOptionPane.showMessageDialog(null, exclusao);
                                janela.dispose();
                                Usuario.montarTelaUsuario();

                            } else {
                                JOptionPane.showMessageDialog(null, "Selecione uma pessoa!");

                            }

                        } catch (IOException e1) {
                            System.out.println(e1.getMessage());
                        } catch (java.sql.SQLException ex) {
                            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }
                });

            }
        });
        
        
        botaoAlterar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                PUsuario usuario = new PUsuario();
                
                try {
                    if(campoUsuario.getText().trim().equalsIgnoreCase("") || ojComboBox.getSelectedIndex() == 0 || campoCPF.getText().trim().equalsIgnoreCase("")|| campoEndereco.getText().trim().equalsIgnoreCase("")
                    ||campoData.getText().trim().equals("")){
                        JOptionPane.showMessageDialog(null, "Preencha todos os dados!");

                        return;
                    }
                    
                    if(!campoCPF.getText().equalsIgnoreCase("") && campoCPF.getText() != null){
                        String alteracao = usuario.alterarUsuario(campoUsuario.getText(),ojComboBox.getSelectedItem().toString(), campoCPF.getText(), campoEndereco.getText(),campoData.getText());
                        JOptionPane.showMessageDialog(null, alteracao);
                        janela.dispose();
                        Usuario.montarTelaUsuario();
                    } else {
                        JOptionPane.showMessageDialog(null, "Selecione uma pessoa!");
                        
                    }
                } catch (IOException e1){
                    System.out.println(e1.getMessage());
                }
                
            }
        });
       

        botaoFiltrar.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                ArrayList<EUsuario> oListaPessoa = new ArrayList<>();
                PUsuario usuario = new PUsuario();

                oListaPessoa = usuario.consultarUsuarioNome(campoFiltro.getText().trim());

                String linhas[][] = new String[oListaPessoa.size()][5];

                int i = 0;
                for (EUsuario usurio : oListaPessoa) {

                    linhas[i][0] = usurio.getNome();
                    linhas[i][1] = usurio.getSexo();
                    linhas[i][2] = usurio.getCpf();
                    linhas[i][3] = usurio.getEndereco();
                    linhas[i][4] = usurio.getDataNasc();
                    i++;
                }

                janela.remove(scroll);

                JTable tabela = new JTable(linhas, colunas);
                JScrollPane scroll = new JScrollPane();
                scroll.setBounds(30, 270, 515, 220);
                scroll.setViewportView(tabela);
                janela.add(scroll);

            }
        });

        botaoArquivo.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                ArrayList<EUsuario> listaUsu = new ArrayList<>();
                PUsuario usuario = new PUsuario();

                listaUsu = usuario.consultarUsuarioNome(campoUsuario.getText().trim());

                try {
                    Arquivo.gerarArquivoTabela("/home/felipe/Documentos/Usuario.txt", listaUsu);
                    JOptionPane.showMessageDialog(null, "Arquivo gerado com sucesso!");
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    System.out.println(e1.getMessage());
                }

            }
        });
        
        botaoCancelar.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                try {
                    janela.dispose();
                    montarTelaUsuario();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    System.out.println(e1.getMessage());
                }

            }
        });
        
        

        janela.setVisible(true);

    }

    public static MaskFormatter mascaraCPF(String mascara) {

        MaskFormatter F_Mascara = new MaskFormatter();

        try {
            F_Mascara.setMask(mascara); // atribui a mascaraa
            F_Mascara.setPlaceholder("000.000.000-00"); // caracter para preenchimento e os numeros

        } catch (ParseException excecao) {
            System.out.println(excecao.getMessage());

        }

        return F_Mascara;

    }

    public static MaskFormatter mascaraData(String mascara) {

        MaskFormatter F_Mascara = new MaskFormatter();

        try {
            F_Mascara.setMask(mascara); // atribui a mascaraa
            F_Mascara.setPlaceholderCharacter(' '); // caracter para preenchimento e os numeros

        } catch (ParseException excecao) {
            System.out.println(excecao.getMessage());

        }

        return F_Mascara;

    }

}

    

