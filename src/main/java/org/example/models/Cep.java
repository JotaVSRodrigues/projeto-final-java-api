package org.example.models;

import com.google.gson.annotations.SerializedName;

public record Cep(
        @SerializedName("cep")
        String cepNumber, // "00000-000"
        @SerializedName("logradouro")
        String rua,
        String estado, // "São Paulo"
        String localidade, // "São Paulo - cidade"
        String bairro, // "Sé"
        String regiao, // "sudeste"
        String ddd, // "11"
        String ibge // "3550308"
) {
}
