package exemplo.hello;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

public class GreetingWebClient {
    private WebClient client = WebClient.create("http://localhost:8080");



    public String getResult() {
        Mono<ClientResponse> result = client.get()
                .uri("/hello")
                .accept(MediaType.TEXT_PLAIN)
                .exchange();
        return ">> result = " + result.flatMap(res -> res.bodyToMono(String.class)).block();
    }

    public String getResultEmployees() {
        Mono<ClientResponse> result = client.get()
                .uri("/employees")
                .accept(MediaType.APPLICATION_JSON)
                .exchange();
        return ">> result = " + result.flatMap(res -> res.bodyToMono(String.class)).block();
    }
}