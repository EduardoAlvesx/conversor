package br.com.eduardoalvesx.conversor.models;

import br.com.eduardoalvesx.conversor.view.MainFrame;

import java.util.LinkedHashMap;


public class Distancia extends Conversor{
    public Distancia(MainFrame mainFrame) {
        super(mainFrame);
    }

    @Override
    public LinkedHashMap<String, Double> adicionarItensDesconversao() {
        LinkedHashMap<String, Double> distanciaMap = new LinkedHashMap<>();
        distanciaMap.put("Quilometro para Milha", 1.609);
        distanciaMap.put("Centimetro para Jarda", 91.44);
        distanciaMap.put("Centimetro para Pé", 30.48);
        distanciaMap.put("Centimetro para Polegada", 2.54);
        distanciaMap.put("Polegada para Centimetro", 25.4);

        return distanciaMap;
    }
    @Override
    public LinkedHashMap<String, Double> adicionarItensConversao() {
        LinkedHashMap<String, Double> distanciaMap = new LinkedHashMap<>();
        distanciaMap.put("Milha para Quilômetro", 1.609);
        distanciaMap.put("Jarda para Centimetro", 91.44);
        distanciaMap.put("Pé para Centimetro", 30.48);
        distanciaMap.put("Polegada para Centimetro", 2.54);
        distanciaMap.put("Polegada para Milimetro", 25.4);

        return distanciaMap;
    }
}
