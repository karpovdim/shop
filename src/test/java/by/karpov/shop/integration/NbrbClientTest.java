package by.karpov.shop.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.test.web.client.MockRestServiceServer;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

@AutoConfigureWebClient(registerRestTemplate = true)
@RestClientTest(NbrbClient.class)
class NbrbClientTest {
    @Autowired
    private MockRestServiceServer server;
    @Autowired
    private NbrbClient nbrbClient;
    private final ObjectMapper mapper = new ObjectMapper();


//    @Test
//    void getRateTest() throws JsonProcessingException {
//        NbrbResponse response = new NbrbResponse("USD", BigDecimal.ONE);
//        String usd = mapper.writeValueAsString(response);
//        server.expect(requestTo("https://www.nbrb.by/api/exrates/rates/431"))
//                .andRespond(withSuccess(usd, MediaType.APPLICATION_JSON));
//        NbrbResponse rate = nbrbClient.getRate(431L);
//        assertEquals(response,rate);
//    }
}