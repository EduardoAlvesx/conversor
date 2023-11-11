package br.com.eduardoalvesx.conversor.models;

import br.com.eduardoalvesx.conversor.view.MainFrame;

import javax.swing.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.LinkedHashMap;
import java.util.Locale;

public abstract class Conversor implements ConversorUtil {
    public Conversor(MainFrame mainFrame) {
        if (mainFrame.getComboBoxConverter() != null) {
            setConverterListener(mainFrame);
        }

        if (mainFrame.getComboBoxDesconverter() != null) {
            setDesconverterListener(mainFrame);
        }
    }
    private void setDesconverterListener(MainFrame mainFrame) {
        mainFrame.getComboBoxDesconverter().addActionListener(actionEvent -> {
            desconverter(mainFrame);
        });
    }
    private void setConverterListener(MainFrame mainFrame) {
        mainFrame.getComboBoxConverter().addActionListener(actionEvent -> {
            converter(mainFrame);
        });
    }
    @Override
    public void desconverter(MainFrame mainFrame) {
        try {
            var keyDesconverter = (String) mainFrame.getComboBoxDesconverter().getSelectedItem();
            var valoresDesconverter = adicionarItensDesconversao().get(keyDesconverter);

            if (valoresDesconverter != null) {
                //var nomesMoedas = adicionarNomesResultado().get(keyDesconverter);
                mainFrame.getResultadoLabel().setText(valorFormat().format(getValorInput(mainFrame) / valoresDesconverter)
                        );
            }

        } catch (NumberFormatException exception) {
            JOptionPane.showMessageDialog(null, "Formato inválido, apenas números");
        }

    }
    @Override
    public void converter(MainFrame mainFrame) {
        try {
            var keyConverter = (String) mainFrame.getComboBoxConverter().getSelectedItem();
            var valoresConverter = adicionarItensConversao().get(keyConverter);
            if (valoresConverter != null) {
                mainFrame.getResultadoLabel().setText(valorFormat().format(getValorInput(mainFrame) * valoresConverter));
            }

        } catch (NumberFormatException exception) {
            JOptionPane.showMessageDialog(null, "Formato inválido, apenas números");
        }
    }
    public Double getValorInput(MainFrame mainFrame) {
        return Double.parseDouble(mainFrame.getInputField().getText());
    }
    public DecimalFormat valorFormat() {
        // Deixando o resultado com duas casas decimais
        Locale locale = new Locale("eng", "US");
        String padrao = "###,###.##";
        DecimalFormatSymbols formatSymbols = new DecimalFormatSymbols(locale);
        DecimalFormat decimalFormat = new DecimalFormat(padrao, formatSymbols);
        return decimalFormat;
    }
    @Override
    public LinkedHashMap<String, Double> adicionarItensConversao() {
        return null;
    }
    @Override
    public LinkedHashMap<String, Double> adicionarItensDesconversao() {
        return null;
    }
    @Override
    public LinkedHashMap<String, String> adicionarNomesResultado() {
        return null;
    }
}
