
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
import Telas.EMatricula;
import Telas.PMatricula;

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
        
        JFormattedTextField campoDataFim = new JFormattedTextField(mascaraData("##/##/####"));
        campoDataFim.setBounds(150, 100, 200, 20);
        janela.add(campoDataFim);

        JTextField campoQtdTempo = new JTextField();
        campoQtdTempo.setBounds(150, 140, 200, 20);
        janela.add(campoQtdTempo);

        JTextField campoInstituicao = new JTextField();
        campoInstituicao.setBounds(150, 180, 200, 20);
        janela.add(campoInstituicao);

        JTextField campoAluno = new JTextField();
        campoAluno.setBounds(150, 220, 200, 20);
        janela.add(campoAluno);

        JTextField campoFiltro = new JTextField();
        campoFiltro.setBounds(150, 250, 200, 20);
        janela.add(campoFiltro);
        
         // Botões
        JButton botaoSalvar = new JButton("Salvar");
        botaoSalvar.setBounds(400, 20, 100, 30);
        janela.add(botaoSalvar);

        JButton botaoAlterar = new JButton("Alterar");
        botaoAlterar.setBounds(400, 60, 100, 30);
        janela.add(botaoAlterar);

        JButton botaoExcluir = new JButton("Excluir");
        botaoExcluir.setBounds(400, 100, 100, 30);
        janela.add(botaoExcluir);

        JButton botaoFiltrar = new JButton("Filtrar");
        botaoFiltrar.setBounds(400, 250, 100, 30);
        janela.add(botaoFiltrar);

        JButton botaoArquivo = new JButton("Gerar Arquivo");
        botaoArquivo.setBounds(400, 140, 150, 30);
        janela.add(botaoArquivo);

        JButton botaoCancelar = new JButton("Cancelar");
        botaoCancelar.setBounds(400, 180, 100, 30);
        janela.add(botaoCancelar);
        
          // Tabela
        String[] colunas = {"ID", "Data Início", "Data Fim", "Qtd Tempo", "Instituição", "Aluno"};
        String[][] dados = new String[0][6];
        JTable tabela = new JTable(dados, colunas);
        JScrollPane scroll = new JScrollPane(tabela);
        scroll.setBounds(30, 300, 520, 200);
        janela.add(scroll);
        
         // Ações dos botões
        PMatricula matricula = new PMatricula();

        botaoSalvar.addActionListener(e -> {
            try {
                if(campoID.getText().isEmpty() || campoDataInicio.getText().trim().equals("") || campoDataFim.getText().trim().equals("") ||
                        campoQtdTempo.getText().isEmpty() || campoInstituicao.getText().isEmpty() || campoAluno.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Preencha todos os dados!");
                } else {
                    String resultado = matricula.inserirMatricula(
                            Integer.parseInt(campoID.getText()),
                            campoDataInicio.getText(),
                            campoDataFim.getText(),
                            Integer.parseInt(campoQtdTempo.getText()),
                            Integer.parseInt(campoInstituicao.getText()),
                            Integer.parseInt(campoAluno.getText())
                    );
                    JOptionPane.showMessageDialog(null, resultado);
                    janela.dispose();
                    MontarTelaMatricula();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        
        botaoAlterar.addActionListener(e -> {
            try {
                if(campoID.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Informe o ID para alterar!");
                } else {
                    String resultado = matricula.alterarMatricula(
                            Integer.parseInt(campoID.getText()),
                            campoDataInicio.getText(),
                            campoDataFim.getText(),
                            Integer.parseInt(campoQtdTempo.getText()),
                            Integer.parseInt(campoInstituicao.getText()),
                            Integer.parseInt(campoAluno.getText())
                    );
                    JOptionPane.showMessageDialog(null, resultado);
                    janela.dispose();
                    MontarTelaMatricula();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        
        botaoAlterar.addActionListener(e -> {
             try {
                if(campoID.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Informe o ID para alterar!");
                } else {
                    String resultado = matricula.alterarMatricula(
                            Integer.parseInt(campoID.getText()),
                            campoDataInicio.getText(),
                            campoDataFim.getText(),
                            Integer.parseInt(campoQtdTempo.getText()),
                            Integer.parseInt(campoInstituicao.getText()),
                            Integer.parseInt(campoAluno.getText())
                    );
                    JOptionPane.showMessageDialog(null, resultado);
                    janela.dispose();
                    MontarTelaMatricula();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        botaoExcluir.addActionListener(e -> {
            try {
                if(campoID.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Informe o ID para excluir!");
                } else {
                    String resultado = matricula.excluirMatricula(Integer.parseInt(campoID.getText()));
                    JOptionPane.showMessageDialog(null, resultado);
                    janela.dispose();
                    MontarTelaMatricula();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        botaoFiltrar.addActionListener(e -> {
            ArrayList<EMatricula> lista = matricula.consultarMatriculaID(Integer.parseInt(campoFiltro.getText()));
            String[][] linhas = new String[lista.size()][6];
            int i = 0;
            for(EMatricula mat : lista){
                linhas[i][0] = String.valueOf(mat.getMatriculas_id());
                linhas[i][1] = mat.getData_inicio();
                linhas[i][2] = mat.getData_fim();
                linhas[i][3] = String.valueOf(mat.getQtd_tempo());
                linhas[i][4] = String.valueOf(mat.getFk_instituicao_id());
                linhas[i][5] = String.valueOf(mat.getFk_aluno_id());
                i++;
            }
            janela.remove(scroll);
            JTable novaTabela = new JTable(linhas, colunas);
            JScrollPane novoScroll = new JScrollPane(novaTabela);
            novoScroll.setBounds(30, 300, 520, 200);
            janela.add(novoScroll);
            janela.revalidate();
            janela.repaint();
        });
        botaoArquivo.addActionListener(e -> {
            try {
                ArrayList<EMatricula> lista = matricula.consultarMatriculaID(Integer.parseInt(campoID.getText()));
                Arquivo.gerarArquivoTabela("/home/felipe/Documentos/Matricula.txt", lista);
                JOptionPane.showMessageDialog(null, "Arquivo gerado com sucesso!");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        
        botaoCancelar.addActionListener(e -> {
            janela.dispose();
            try {
                montarTelaMatricula();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        janela.setVisible(true);
        
    }
  
     // Máscaras 
    public static MaskFormatter mascaraData(String mascara){
        MaskFormatter F_Mascara = new MaskFormatter();
        try{
            F_Mascara.setMask(mascara);
            F_Mascara.setPlaceholderCharacter(' ');
        } catch(ParseExeception exececao){
            System.out.println(exececao.getMessage());
        }
        return F_Mascara;
    }
}
