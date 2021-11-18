package by.karpov.shop.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@RequiredArgsConstructor
public class RestConfig {

    private final RestTemplateBuilder restTemplateBuilder;
    @Bean
    public RestTemplate createTemplate(){
        return restTemplateBuilder.build();
    }

}
