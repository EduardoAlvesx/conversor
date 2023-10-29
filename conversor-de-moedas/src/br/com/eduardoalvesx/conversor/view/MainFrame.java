package br.com.eduardoalvesx.conversor.view;

import br.com.eduardoalvesx.conversor.models.*;

import javax.swing.*;
import java.awt.*;


public class MainFrame extends JFrame {
    private JTextField inputField;
    private JLabel resultadoLabel;
    private JComboBox<String> comboBoxConversors;
    private JPanel panelConversao;
    private JComboBox<Object> comboBoxConverter;
    private JComboBox<Object> comboBoxDesconverter;
    private Moedas moedas;
    private Distancia distancia;

    MainFrame() {
        setTitle("de moedas");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);

        inputField = new JTextField();
        add(inputField);
        inputField.setFont(new Font("Arial", Font.PLAIN, 16));
        inputField.setBounds(90, 100, 180, 30);

        resultadoLabel = new JLabel();
        resultadoLabel.setText("Resultado");
        add(resultadoLabel);
        resultadoLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        resultadoLabel.setBounds(340, 100, 190, 30);

        String[] opcoesConversao = {"Moedas", "Distância"};
        comboBoxConversors = new JComboBox<>(opcoesConversao);
        add(comboBoxConversors);
        comboBoxConversors.setBounds(450, 30, 120, 20);
        comboBoxConversors.setFont(new Font("Arial", Font.PLAIN, 14));

        comboBoxConversors.addActionListener(actionEvent -> {
            selecionarConversores();
        });

        panelConversao = new JPanel();
        panelConversao.setLayout(new GridLayout());
        panelConversao.setBounds(80, 205, 420, 50);
        add(panelConversao);
        panelConversao.setBackground(Color.ORANGE);

        comboBoxConverter = new JComboBox<>();
        panelConversao.add(comboBoxConverter);
        comboBoxConverter.setModel(new DefaultComboBoxModel<>(new Moedas(this).adicionarItensConversao().keySet()
         .toArray()));

        comboBoxDesconverter = new JComboBox<>();
        panelConversao.add(comboBoxDesconverter);
        comboBoxDesconverter.setModel(new DefaultComboBoxModel<>(new Moedas(this).adicionarItensDesconversao()
         .keySet().toArray
         ()));
    }

    private void selecionarConversores() {
        moedas = new Moedas(this);
        distancia = new Distancia(this);

        switch (comboBoxConversors.getSelectedItem().toString()) {
            case "Moedas" -> {
                comboBoxConverter.setModel(new DefaultComboBoxModel<>(moedas.adicionarItensConversao().keySet().toArray()));
                comboBoxDesconverter.setModel(new DefaultComboBoxModel<>(moedas.adicionarItensDesconversao().keySet().toArray()));
            }
            case "Distância" -> {
                comboBoxDesconverter.setModel(new DefaultComboBoxModel<>(distancia.adicionarItensDesconversao().keySet().toArray()));
                comboBoxConverter.setModel(new DefaultComboBoxModel<>(distancia.adicionarItensConversao().keySet().toArray()));
            }
        }
    }
    public JTextField getInputField() {
        return inputField;
    }
    public JLabel getResultadoLabel() {
        return resultadoLabel;
    }
    public JComboBox getComboBoxConverter() {
        return comboBoxConverter;
    }
    public JComboBox getComboBoxDesconverter() {
        return comboBoxDesconverter;
    }
}
