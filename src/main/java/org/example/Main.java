package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.example.models.Cep;
import org.example.models.CepAPI;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public class Main {
    public static void main(String[] args) throws Exception {

        CepAPI cepAPI = new CepAPI();
        cepAPI.scanner();
        cepAPI.connect(cepAPI.getCepInput());
        String mensagem = cepAPI.getCep();

        // -----------------------------------------------------------------------------------------
        // cria um objeto do tipo Cep (direto no Record)

        cepAPI.serializador(mensagem);
        cepAPI.writer(cepAPI.getCepSerialized());

        // -----------------------------------------------------------------------------------------
    }
}