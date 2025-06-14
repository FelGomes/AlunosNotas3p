package Telas;

import javax.swing.*;
import java.io.IOException;

public class TFrequencias {

    public static void MontarTelaFrequencia() throws IOException {
        JFrame janela = new JFrame("FREQUÊNCIA");
        janela.setSize(600, 600);
        janela.setLayout(null);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Rótulos
        JLabel rotuloFrequenciasId = new JLabel("ID FREQUÊNCIA:");
        rotuloFrequenciasId.setBounds(30, 20, 120, 20);
        janela.add(rotuloFrequenciasId);

        JLabel rotuloTotalAulas = new JLabel("TOTAL DE AULAS:");
        rotuloTotalAulas.setBounds(30, 50, 120, 20);
        janela.add(rotuloTotalAulas);

        JLabel rotuloAulasMinistradas = new JLabel("AULAS MINISTRADAS:");
        rotuloAulasMinistradas.setBounds(30, 80, 150, 20);
        janela.add(rotuloAulasMinistradas);

        JLabel rotuloFrequenciasFaltas = new JLabel("FALTAS:");
        rotuloFrequenciasFaltas.setBounds(30, 110, 120, 20);
        janela.add(rotuloFrequenciasFaltas);

        JLabel rotuloFrequenciasDisciplinas = new JLabel("DISCIPLINA:");
        rotuloFrequenciasDisciplinas.setBounds(30, 140, 120, 20);
        janela.add(rotuloFrequenciasDisciplinas);

        // Campos
        JTextField campoFrequenciasId = new JTextField();
        campoFrequenciasId.setBounds(180, 20, 200, 20);
        janela.add(campoFrequenciasId);

        JTextField campoTotalAulas = new JTextField();
        campoTotalAulas.setBounds(180, 50, 200, 20);
        janela.add(campoTotalAulas);

        JTextField campoAulasMinistradas = new JTextField();
        campoAulasMinistradas.setBounds(180, 80, 200, 20);
        janela.add(campoAulasMinistradas);

        JTextField campoFrequenciasFaltas = new JTextField();
        campoFrequenciasFaltas.setBounds(180, 110, 200, 20);
        janela.add(campoFrequenciasFaltas);

        JTextField campoFrequenciasDisciplinas = new JTextField();
        campoFrequenciasDisciplinas.setBounds(180, 140, 200, 20);
        janela.add(campoFrequenciasDisciplinas);

        // Botões
        JButton botaoSalvar = new JButton("SALVAR");
        botaoSalvar.setBounds(400, 20, 120, 30);
        janela.add(botaoSalvar);

        JButton botaoAlterar = new JButton("ALTERAR");
        botaoAlterar.setBounds(400, 60, 120, 30);
        janela.add(botaoAlterar);

        JButton botaoExcluir = new JButton("EXCLUIR");
        botaoExcluir.setBounds(400, 100, 120, 30);
        janela.add(botaoExcluir);

        JButton botaoListar = new JButton("LISTAR");
        botaoListar.setBounds(400, 140, 120, 30);
        janela.add(botaoListar);

        JButton botaoCancelar = new JButton("CANCELAR");
        botaoCancelar.setBounds(400, 180, 120, 30);
        janela.add(botaoCancelar);

        // Tabela
        String[] colunas = {"ID", "Total Aulas", "Ministradas", "Faltas", "Disciplina"};
        String[][] dados = new String[0][5]; // Inicialmente vazio
        JTable tabela = new JTable(dados, colunas);
        JScrollPane scroll = new JScrollPane(tabela);
        scroll.setBounds(30, 250, 520, 250);
        janela.add(scroll);

        // Instância da entidade
        EFrequencias frequencias = new EFrequencias();

        // Evento SALVAR
        botaoSalvar.addActionListener(e -> {
            try {
                frequencias.setFrequencias_id(Integer.parseInt(campoFrequenciasId.getText()));
                frequencias.setTotal_aulas(Integer.parseInt(campoTotalAulas.getText()));
                frequencias.setAulas_ministradas(Integer.parseInt(campoAulasMinistradas.getText()));
                frequencias.setFrequencias_faltas(Integer.parseInt(campoFrequenciasFaltas.getText()));
                frequencias.setFrequencias_disciplinas(campoFrequenciasDisciplinas.getText());

                float presenca = ((float) (frequencias.getAulas_ministradas() - frequencias.getFrequencias_faltas()) / frequencias.getAulas_ministradas()) * 100;
                frequencias.setPrctg_presenca(presenca);

                JOptionPane.showMessageDialog(null, "Frequência salva com sucesso!\nPresença: " + presenca + "%");

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Erro: Verifique os campos numéricos.");
            } catch (ArithmeticException ex) {
                JOptionPane.showMessageDialog(null, "Erro de cálculo: Divisão por zero.");
            }
        });

        // Mostrar a janela
        janela.setVisible(true);
    }
}
