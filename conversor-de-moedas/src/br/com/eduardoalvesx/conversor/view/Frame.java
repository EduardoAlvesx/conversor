package br.com.eduardoalvesx.conversor.view;

import br.com.eduardoalvesx.conversor.models.*;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.*;


public class Frame extends JFrame {
    private JTextField inputField;
    private JLabel resultLabel;
    private JComboBox<String> comboBoxConversors;
    private JPanel panelConversao;
    private JComboBox<Object> comboBoxBase;
    private JComboBox<Object> comboBoxTarget;

    public Frame() {
        setTitle("Conversor");
        setSize(640, 440);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);

        inputField = new JTextField();
        add(inputField);
        inputField.setFont(new Font("Arial", Font.PLAIN, 16));
        inputField.setBounds(90, 100, 180, 30);

        resultLabel = new JLabel();
        resultLabel.setText("Resultado");
        add(resultLabel);
        resultLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        resultLabel.setBounds(340, 100, 210, 30);

        String[] conversorOptions = {"Moedas", "Temperatura"};
        comboBoxConversors = new JComboBox<>(conversorOptions);
        add(comboBoxConversors);
        comboBoxConversors.setBounds(450, 30, 120, 20);
        comboBoxConversors.setFont(new Font("Arial", Font.PLAIN, 14));
        comboBoxConversors.addActionListener(actionEvent -> {
            comboBoxBase.setModel(new DefaultComboBoxModel<>(getConversor(getSelectedItem()).getCodeItens().keySet().toArray()));
            comboBoxTarget.setModel(new DefaultComboBoxModel<>(getConversor(getSelectedItem()).getCodeItens().keySet().toArray()));
        });

        panelConversao = new JPanel();
        panelConversao.setLayout(new GridLayout());
        panelConversao.setBounds(80, 205, 420, 50);
        add(panelConversao);

        comboBoxBase = new JComboBox<>();
        panelConversao.add(comboBoxBase);
        comboBoxBase.setModel(new DefaultComboBoxModel<>(getConversor(getSelectedItem()).getCodeItens().keySet().toArray()));

        comboBoxTarget = new JComboBox<>();
        panelConversao.add(comboBoxTarget);
        comboBoxTarget.setModel(new DefaultComboBoxModel<>(getConversor(getSelectedItem()).getCodeItens().keySet().toArray()));;

        comboBoxBase.addActionListener(actionEvent -> setResult(getConversor(getSelectedItem())));
        comboBoxTarget.addActionListener(actionEvent -> setResult(getConversor(getSelectedItem())));
    }
    public String getSelectedItem() {
        return (String) Objects.requireNonNull(comboBoxConversors.getSelectedItem());
    }

    public Conversor getConversor(String selectedItem) {
        switch (selectedItem) {
            case "Moedas" -> {return new Moedas();}
            case "Temperatura" -> {return new Temperatura();}
            default -> throw new RuntimeException();
        }
    }

    private void setResult(Conversor conversor) {
        try {
            getResultLabel().setText(getResult(conversor) + getConversorName());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Formato inválido, apenas números");
        }
    }

    public String getResult(Conversor conversor) {
        return resultFormat().format(conversor.convert(getBase(conversor), getTarget(conversor), getInputValue()));
    }

    public DecimalFormat resultFormat() {
        Locale locale = new Locale("eng", "US");
        String padrao = "###,###.##";
        DecimalFormatSymbols formatSymbols = new DecimalFormatSymbols(locale);
        return new DecimalFormat(padrao, formatSymbols);
    }

    public String getConversorName() {
        return " " + getComboBoxTarget().getSelectedItem();
    }
    public String getBase(Conversor conversor) {
        var key = (String) getComboBoxBase().getSelectedItem();
        return conversor.getCodeItens().get(key);
    }
    public String getTarget(Conversor conversor) {
        var key = (String) getComboBoxTarget().getSelectedItem();
        return conversor.getCodeItens().get(key);
    }
    public Integer getInputValue() {
        return Integer.parseInt(getInputField().getText());
    }
    public JTextField getInputField() {
        return inputField;
    }
    public JLabel getResultLabel() {
        return resultLabel;
    }
    public JComboBox getComboBoxBase() {
        return comboBoxBase;
    }
    public JComboBox getComboBoxTarget() {
        return comboBoxTarget;
    }
}
