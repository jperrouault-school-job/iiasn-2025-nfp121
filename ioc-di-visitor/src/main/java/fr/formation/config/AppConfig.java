package fr.formation.config;

import java.net.http.HttpClient;

import com.fasterxml.jackson.databind.ObjectMapper;

import fr.formation.annotation.Bean;
import fr.formation.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    HttpClient httpClient() {
        return HttpClient.newBuilder().build();
    }

    @Bean
    ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}
