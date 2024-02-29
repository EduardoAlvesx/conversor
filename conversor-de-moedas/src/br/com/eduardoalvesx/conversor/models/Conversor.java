package br.com.eduardoalvesx.conversor.models;

import java.util.Map;

public interface Conversor {
    Map<String, String> getCodeItens();
    Double convert(String base, String target, Integer value);
}
