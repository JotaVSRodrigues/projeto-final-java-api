package org.example.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import org.example.models.ConsultaAPI;

import java.io.IOException;

public class Cep {
    private String cep;
    private String complemento;
    private String bairro;
    private String estado;
    private String uf;
    @SerializedName("localidade")
    private String cidade; // está como "localidade" no viacep (dar um jeito)
    private String regiao;
    private String ibge;

    @Override
    public String toString() {
        return "Cep {" +
                "cep='" + cep + '\'' +
                ", complemento = '" + complemento + '\'' +
                ", bairro = '" + bairro + '\'' +
                ", estado = '" + estado + '\'' +
                ", uf = '" + uf + '\'' +
                ", cidade = '" + cidade + '\'' +
                ", regiao = '" + regiao + '\'' +
                ", ibge = '" + ibge + '\'' +
                '}';
    }

    public String getCep() {
        return cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getEstado() {
        return estado;
    }

    public String getUf() {
        return uf;
    }

    public String getCidade() {
        return cidade;
    }

    public String getRegiao() {
        return regiao;
    }

    public String getIbge() {
        return ibge;
    }
}
