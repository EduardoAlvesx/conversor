package br.com.eduardoalvesx.conversor.modelo;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.LinkedHashMap;
import java.util.Locale;

public class SelecaoDeMoedas1 extends JPanel{
    SelecaoDeMoedas1(Estrutura estrutura) {

        // adicionando as moedas para o map
        LinkedHashMap<String, Double> moedasMap = new LinkedHashMap<>();
        moedasMap.put("Real para Dolar", 4.80);
        moedasMap.put("Real para Libra", 6.17);
        moedasMap.put("Real para Euro", 5.31);
        moedasMap.put("Real para Peso Argentino", 0.018);
        moedasMap.put("Real para Peso Chileno", 0.0058);

        // nome das moedas
        LinkedHashMap<String, String> nomeMoedasMap = new LinkedHashMap<>();
        nomeMoedasMap.put("Real para Dolar", "Dolares");
        nomeMoedasMap.put("Real para Libra", "Libras");
        nomeMoedasMap.put("Real para Euro", "Euros");
        nomeMoedasMap.put("Real para Peso Argentino", "Pesos Argentinos");
        nomeMoedasMap.put("Real para Peso Chileno", "Peso Chileno");

        setBounds(80, 205, 200, 30);
        JComboBox<String> comboBoxMoedas1 = new JComboBox<>(moedasMap.keySet().toArray(new String[0]));
        add(comboBoxMoedas1);
        comboBoxMoedas1.setFont(new Font("Arial", Font.PLAIN, 14));

        // Deixando o resultado com duas casas decimais
        Locale locale = new Locale("eng", "US");
        String padrao = "###,###.##";
        DecimalFormatSymbols formatSymbols = new DecimalFormatSymbols(locale);
        DecimalFormat decimalFormat = new DecimalFormat(padrao, formatSymbols);

        // Convertendo as moedas
        comboBoxMoedas1.addActionListener(actionEvent -> {
            try {
                double doubleValorField = Double.parseDouble(estrutura.getTextField().getText());
                String chave = (String) comboBoxMoedas1.getSelectedItem();
                double valoresMoedasMap = moedasMap.get(chave);

                String nomesMoedas = nomeMoedasMap.get(chave);
                estrutura.getConversaoLabel().setText(decimalFormat.format(doubleValorField / valoresMoedasMap) + " " + nomesMoedas);

            } catch (NumberFormatException exception) {
                JOptionPane.showMessageDialog(null, "Formato inválido, apenas números! ");
            }
        });

    }
}
