package modelos;

import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BuscadorCEP{

    public Endereco buscarCep(String cep){
        URI endereco = URI.create("https://viacep.com.br/ws/" + cep + "/json/");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request,HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            Gson gson = new Gson();

            return gson.fromJson(json, Endereco.class);
        } catch (Exception e) {
            throw new RuntimeException("Não foi possível indentificar esse cep");
        }


    }
}
