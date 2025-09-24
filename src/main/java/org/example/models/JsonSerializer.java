package org.example.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.http.HttpResponse;

public class JsonSerializer {
    private Cep cepModel;

    public void deserialize(String json) {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        Cep cepModel = gson.fromJson(json, Cep.class);
        setCepModel(cepModel);
    }

    public Cep getCepModel() {
        return cepModel;
    }

    public void setCepModel(Cep cepModel) {
        this.cepModel = cepModel;
    }
}
