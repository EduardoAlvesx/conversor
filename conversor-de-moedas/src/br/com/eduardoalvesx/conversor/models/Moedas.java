package br.com.eduardoalvesx.conversor.models;

import br.com.eduardoalvesx.conversor.view.MainFrame;

import java.util.LinkedHashMap;

public class Moedas extends Conversor {
    public Moedas(MainFrame mainFrame) {
        super(mainFrame);
    }
    @Override
    public LinkedHashMap<String, String> adicionarNomesResultado() {
        LinkedHashMap<String, String> nomeMoedasMap = new LinkedHashMap<>();
        nomeMoedasMap.put("Real para Dolar", "Dolares");
        nomeMoedasMap.put("Real para Libra", "Libras");
        nomeMoedasMap.put("Real para Euro", "Euros");
        nomeMoedasMap.put("Real para Peso Argentino", "Pesos Argentinos");
        nomeMoedasMap.put("Real para Peso Chileno", "Peso Chileno");

        return nomeMoedasMap;
    }
    @Override
    public LinkedHashMap<String, Double> adicionarItensDesconversao() {
        LinkedHashMap<String, Double> moedasMap = new LinkedHashMap<>();
        moedasMap.put("Real para Dolar", 4.80);
        moedasMap.put("Real para Libra", 6.14);
        moedasMap.put("Real para Euro", 5.31);
        moedasMap.put("Real para Peso Argentino", 0.018);
        moedasMap.put("Real para Peso Chileno", 0.0058);

        return moedasMap;
    }
    @Override
    public LinkedHashMap<String, Double> adicionarItensConversao() {
        LinkedHashMap<String, Double> moedasMap = new LinkedHashMap<>();
        moedasMap.put("Dolar para Real", 4.80);
        moedasMap.put("Libra para Real", 7.17);
        moedasMap.put("Euro para Real", 5.31);
        moedasMap.put("Peso Argentino para Real", 0.018);
        moedasMap.put("Peso Chileno para Real", 0.0058);

        return moedasMap;
    }
}
