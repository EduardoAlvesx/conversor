package br.com.eduardoalvesx.conversor.api;

import java.util.ResourceBundle;

public class ApiKey {
    private static final String key = ResourceBundle.getBundle("currencyApi").getString("key");
    public static String getKey() {
        return key;
    }
}
