package org.example;

import org.example.models.ConsultaAPI;
import org.example.models.JsonSerializer;

import java.io.IOException;
import java.net.http.HttpResponse;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        ConsultaAPI consulta = new ConsultaAPI();
        JsonSerializer deserializer = new JsonSerializer();

        String connection = consulta.connection("09210-000");
        deserializer.deserialize(connection);
        String cepSerialized = deserializer.toString();
    }
}