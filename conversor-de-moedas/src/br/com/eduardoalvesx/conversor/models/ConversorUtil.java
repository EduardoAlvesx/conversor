package br.com.eduardoalvesx.conversor.models;

import br.com.eduardoalvesx.conversor.view.MainFrame;

import java.util.LinkedHashMap;

public interface ConversorUtil {
    LinkedHashMap<String, Double> adicionarItensDesconversao();
    LinkedHashMap<String, Double> adicionarItensConversao();
    LinkedHashMap<String, String> adicionarNomesResultado();
    void converter(MainFrame mainFrame);
    void desconverter(MainFrame mainFrame);
}
