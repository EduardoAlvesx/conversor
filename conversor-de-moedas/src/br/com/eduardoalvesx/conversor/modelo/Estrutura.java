package br.com.eduardoalvesx.conversor.modelo;

import javax.swing.*;
import java.awt.*;


public class Estrutura extends JFrame {
    private final JTextField textField;
    private final JLabel conversaoLabel;

    Estrutura() {
        // Atribuindo propriedades a tela principal
        setTitle("Conversor de moedas");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);

        // Adicionando classeS na Estrutura
        add(new SelecaoDeMoedas1(this));
        add(new SelecaoDeMoedas2(this));

        // Area para inserir os numeros
        JTextField inputField = new JTextField();
        this.textField = inputField;
        add(inputField);
        inputField.setFont(new Font("Arial", Font.PLAIN, 16));
        inputField.setBounds(90, 100, 180, 30);

        // Label do resultado de conversao
        JLabel conversaoLabel = new JLabel();
        this.conversaoLabel = conversaoLabel;
        conversaoLabel.setText("Resultado");
        add(conversaoLabel);
        conversaoLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        conversaoLabel.setBounds(340, 100, 190, 30);
    }

    public JTextField getTextField() {
        return textField;
    }

    public JLabel getConversaoLabel() {
        return conversaoLabel;
    }

}
