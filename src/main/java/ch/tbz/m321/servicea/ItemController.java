package ch.tbz.m321.servicea;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

/** Gibt die Daten aus, die Service A bei Service B abgeholt hat. */
@RestController
public class ItemController {

    private final ServiceBClient serviceBClient;

    public ItemController(ServiceBClient serviceBClient) {
        this.serviceBClient = serviceBClient;
    }

    @GetMapping("/items")
    public ResponseEntity<?> items() {
        try {
            List<Item> items = serviceBClient.fetchItems();
            return ResponseEntity.ok(Map.of("source", "service-b", "items", items));
        } catch (RestClientException e) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                    .body(Map.of("error", "Service B nicht erreichbar", "detail", e.getMessage()));
        }
    }
}
