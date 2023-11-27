package com.bytebankers.swing.http;

import com.bytebankers.contabancaria.model.ContaBanco;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class ClienteHttp {
    private static final String BASE_URL = "http://localhost:8080";
    private static final ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args){
//        ContaBanco conta = entrarNaConta(3, "Borlink");
//        conta.setDono("Kagami");
//        ContaBanco contaAlterada = salvarAlteracoes(conta);
//        System.out.println(contaAlterada);
    }

    public static ContaBanco criarConta(String nome, String tipo) {
        String resposta = fazerRequisicaoHttp("POST", "/conta/" + nome + "/" + tipo);
        try {
            return mapper.readValue(resposta, ContaBanco.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ContaBanco entrarNaConta(int id, String nome) {
        String resposta = fazerRequisicaoHttp("GET", "/conta/" + id + "/" + nome);
        try {
            return mapper.readValue(resposta, ContaBanco.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ContaBanco salvarAlteracoes(ContaBanco conta) {
        String resposta = fazerRequisicaoHttp("PUT", "/conta", conta);
        try {
            return mapper.readValue(resposta, ContaBanco.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String fazerRequisicaoHttp(String metodo, String endpoint) {
        try {
            URL url = new URL(BASE_URL + endpoint);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod(metodo);

            int responseCode = connection.getResponseCode();
            System.out.println(responseCode);
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Lê a resposta da requisição
                try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = in.readLine()) != null) {
                        response.append(line);
                    }
                    return response.toString();
                }
            } else {
                System.out.println("Erro na requisição: " + responseCode);
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String fazerRequisicaoHttp(String metodo, String endpoint, Object corpo) {
        try {
            URL url = new URL(BASE_URL + endpoint);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod(metodo);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            // Envia o corpo da requisição (JSON)
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = mapper.writeValueAsBytes(corpo);
                os.write(input, 0, input.length);
            }

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Lê a resposta da requisição
                try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = in.readLine()) != null) {
                        response.append(line);
                    }
                    return response.toString();
                }
            } else {
                System.out.println("Erro na requisição: " + responseCode);
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
