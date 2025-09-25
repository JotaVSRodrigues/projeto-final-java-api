package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
        cepAPI.connect("09210-000");
        String mensagem = cepAPI.getCep();

//        cepAPI.serializador(mensagem);
        // nesse ponto, a String cep é transformada em um objeto Cep
        // e isso gera o → cepAPI.getCepSerialized() é uma instância da classe Cep (record original)




//        ------------------------------------------------------------------------------------------
//        Cep cep = cepAPI.getCepSerialized();
//        cepAPI.writer(cep.toString());


        /*
        if (cep.writer(mostradorCEP)) {
            JOptionPane.showMessageDialog(null, "Arquivo .json escrito com sucesso");
        } else {
            throw new Exception("não foi possível escrever o arquivo .json");
        }
        */

    }
}