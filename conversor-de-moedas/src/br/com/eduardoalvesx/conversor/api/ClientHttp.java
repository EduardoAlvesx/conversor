package br.com.eduardoalvesx.conversor.api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ClientHttp {
    private HttpClient client;
    private HttpRequest request;
    public String getResponse(String url) {
        var uri = URI.create(url);
        this.client = HttpClient.newHttpClient();
        this.request = HttpRequest.newBuilder(uri).build();

        try {
            HttpResponse<String> response = this.client.send(this.request, HttpResponse.BodyHandlers.ofString());
            return response.body();

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
