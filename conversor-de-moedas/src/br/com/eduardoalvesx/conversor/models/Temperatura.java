package br.com.eduardoalvesx.conversor.models;

import br.com.eduardoalvesx.conversor.api.Api;
import br.com.eduardoalvesx.conversor.api.ApiKey;
import br.com.eduardoalvesx.conversor.api.ClientHttp;
import br.com.eduardoalvesx.conversor.api.CurrencyResponseDTO;
import com.google.gson.Gson;

import java.util.LinkedHashMap;
import java.util.Map;

public class Temperatura implements Conversor {
    @Override
    public Map<String, String> getCodeItens() {
        Map<String, String> map = new LinkedHashMap<>();
        return map;
    }

    @Override
    public Double convert(String base, String target, Integer value) {
        var url = new ClientHttp().getResponse(Api.WEATHER_CONVERSOR.getUrl().formatted());
        Gson gson = new Gson();
        var currency = gson.fromJson(url, CurrencyResponseDTO.class);
        return currency.conversionResult();
    }
}
