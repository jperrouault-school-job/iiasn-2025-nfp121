package fr.formation.config;

import java.net.http.HttpClient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
@ComponentScan("fr.formation")
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
