package net.tklearn.mix;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JDK11Tests {

    static class User {
        public Integer userId;
        public Integer id;
        public String title;
        public Boolean completed;

    }

    @Test
    void testReadWriteString() throws IOException {
        Path filePath = Files.writeString(Files.createTempFile(Paths.get("/"), "demo", ".txt"), "Sample text");
        String fileContent = Files.readString(filePath);
        assertEquals(fileContent, "Sample text");
    }

    User readValueJackson(String content) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(content, User.class);
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }
    @Test
    void testHttpClient() throws IOException, InterruptedException, ExecutionException {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://jsonplaceholder.typicode.com/todos/1"))
                .build();
        User user = httpClient
                .sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenApply(this::readValueJackson).get();
        assertEquals(user.title,"delectus aut autem");
    }
}
