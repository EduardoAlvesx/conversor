package br.com.eduardoalvesx.conversor.modelo;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.LinkedHashMap;
import java.util.Locale;

public class SelecaoDeMoedas2 extends JPanel{
    SelecaoDeMoedas2(Estrutura estrutura) {

        // adicionando as moedas para o map
        LinkedHashMap<String, Double> moedasMap2 = new LinkedHashMap<>();
        moedasMap2.put("Dolar para Real", 4.80);
        moedasMap2.put("Libra para Real", 7.17);
        moedasMap2.put("Euro para Real", 5.31);
        moedasMap2.put("Peso Argentino para Real", 0.018);
        moedasMap2.put("Peso Chileno para Real", 0.0058);

        setBounds(320, 205, 200, 30);
        JComboBox<String> comboBoxMoedas2 = new JComboBox<>(moedasMap2.keySet().toArray(new String[0]));
        add(comboBoxMoedas2);
        comboBoxMoedas2.setFont(new Font("Arial", Font.PLAIN, 14));

        //deixando o resultado com duas casas decimais
        Locale locale = new Locale("eng", "US");
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(locale);
        String padrao = "###,###.##";
        DecimalFormat decimalFormat = new DecimalFormat(padrao, symbols);

        //convertendo as moedas
        comboBoxMoedas2.addActionListener(actionEvent -> {
            try {
                double doubleValorField = Double.parseDouble(estrutura.getTextField().getText());
                String chave = (String) comboBoxMoedas2.getSelectedItem();
                double valoresMoedasMap = moedasMap2.get(chave);
                estrutura.getConversaoLabel().setText(decimalFormat.format(doubleValorField * valoresMoedasMap) + " Reais");

            } catch (NumberFormatException exception) {
                JOptionPane.showMessageDialog(null,  "Formato inválido, apenas números! ");

            }
        });
    }
}
