package br.com.eduardoalvesx.conversor;


import br.com.eduardoalvesx.conversor.api.ApiKey;
import br.com.eduardoalvesx.conversor.view.Frame;

import java.awt.*;
import java.lang.module.ModuleFinder;
import java.util.Locale;
import java.util.ResourceBundle;

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Frame frame = new Frame();
            frame.setVisible(true);
        });
    }
}