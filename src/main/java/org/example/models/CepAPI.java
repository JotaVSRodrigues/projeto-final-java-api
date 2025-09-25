package org.example.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CepAPI {
    private String cep;
    private Cep cepSerialized;

    public void connect(String cep) throws IOException, InterruptedException {
        String url = "https://viacep.com.br/ws/" + cep + "/json/";
        String finalUrl = url.replace("-", "");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(finalUrl))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        setCep(response.body());
    }

    // a classe que recebe uma String cep e trasnforma isso em uma instância de objeto cep
    public void serializador(String receivedCep) { // é o Cep que será colocado na Main vindo do getCep()
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        Cep cep = gson.fromJson(receivedCep, Cep.class);
        setCepSerialized(cep);
    }

    public boolean writer(String jsonMessage) {
        try {
            File file = new File("cep.json");
            FileWriter writer = new FileWriter(file);
            writer.write(jsonMessage);
            return true;
        } catch (IOException e){
            e.printStackTrace();
            return false;
        }
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Cep getCepSerialized() {
        return cepSerialized;
    }

    public void setCepSerialized(Cep cepSerialized) {
        this.cepSerialized = cepSerialized;
    }
}
