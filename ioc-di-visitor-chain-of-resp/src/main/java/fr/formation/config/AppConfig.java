package fr.formation.config;

import java.net.http.HttpClient;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

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
        ObjectMapper mapper = new ObjectMapper();

        mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE);
        
        return mapper;
    }

    @Bean
    XmlMapper xmlMapper() {
        XmlMapper mapper = new XmlMapper();

        mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE);
        
        return mapper;
    }
}
