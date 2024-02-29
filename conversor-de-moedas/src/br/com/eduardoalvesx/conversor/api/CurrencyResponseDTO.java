package br.com.eduardoalvesx.conversor.api;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public record CurrencyResponseDTO(
        @SerializedName(value = "conversion_result")
        Double conversionResult,
        @SerializedName(value = "conversion_rates")
        Map<String, Double> conversioRates) {

}
