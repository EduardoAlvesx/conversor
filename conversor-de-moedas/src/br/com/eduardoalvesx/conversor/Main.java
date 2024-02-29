package br.com.eduardoalvesx.conversor;


import br.com.eduardoalvesx.conversor.view.Frame;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Frame frame = new Frame();
            frame.setVisible(true);
        });
    }
}