package ch.tbz.m321.servicea;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

/** HTTP-Client, der die Daten von Service B abholt. */
@Component
public class ServiceBClient {

    private final RestClient restClient;

    public ServiceBClient(@Value("${service-b.url}") String baseUrl) {
        this.restClient = RestClient.create(baseUrl);
    }

    public List<Item> fetchItems() {
        return restClient.get()
                .uri("/api/items")
                .retrieve()
                .body(new ParameterizedTypeReference<List<Item>>() {});
    }
}
