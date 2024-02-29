package br.com.eduardoalvesx.conversor.api;

public enum Api {

    CURRENCY_CONVERSOR("https://v6.exchangerate-api.com/v6/%s/pair/%s/%s/%d"),
    WEATHER_CONVERSOR("https://v6.exchangerate-api.com/v6/%s/pair/%s/%s/%d");
    private final String url;
    Api(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
