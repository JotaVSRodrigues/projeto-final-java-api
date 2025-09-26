package org.example.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class CepAPI {
    private String cep, cepSerialized, cepInput;
    private Cep cepObj;

    public void connect(String cep) throws IOException, InterruptedException {
        try {
            String url = "https://viacep.com.br/ws/" + cep + "/json/";
            String finalUrl = url.replace("-", "");

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(finalUrl))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            setCep(response.body());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    // a classe que recebe uma String cep e trasnforma isso em uma instância de objeto Cep
    public void serializador(String receivedCep) { // é o Cep que será colocado na Main vindo do getCep()
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        Cep cepObj = new Gson().fromJson(receivedCep, Cep.class);
        setCepSerialized(gson.toJson(cepObj));

        setCepObj(cepObj);
    }

    public boolean writer(String json) {
        try {
            File file = new File("cep.json");
            FileWriter writer = new FileWriter(file);

            writer.write(json);
            writer.close();

            JOptionPane.showMessageDialog(
                    null,
                    "Arquivo .json escrito com sucesso: " + getCepSerialized());
            return true;
        } catch (IOException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(
                    null,
                    "Não foi possível escrever o arquivo .json"
            );
            return false;
        }
    }

    public void scanner() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("---------------------------------");
        System.out.println("---------------***---------------");
        System.out.println("Insira o seu CEP: ");
        String cepInput = scanner.nextLine();
        System.out.println("---------------------------------");
        System.out.println("---------------***---------------");

        setCepInput(cepInput);
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCepSerialized() {
        return cepSerialized;
    }

    public void setCepSerialized(String cepSerialized) {
        this.cepSerialized = cepSerialized;
    }

    public String getCepInput() {
        return cepInput;
    }

    public void setCepInput(String cepInput) {
        this.cepInput = cepInput;
    }

    public Cep getCepObj() {
        return cepObj;
    }

    public void setCepObj(Cep cepObj) {
        this.cepObj = cepObj;
    }
}
