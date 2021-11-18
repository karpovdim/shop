package by.karpov.shop.integration;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
class NbrbClient {
    private static final String URL = "https://www.nbrb.by/api/exrates/rates/%s";
    private final RestTemplate restTemplate;
NbrbResponse getRate(Long id){
    return restTemplate.exchange(String.format(URL, id), HttpMethod.GET, null, NbrbResponse.class).getBody();
}
}
