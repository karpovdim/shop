//package by.karpov.shop.integration;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//
//import java.math.BigDecimal;
//
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//class NbrbControllerTest extends AbstractControllerTest{
//    @MockBean
//    private NbrbClient nbrbClient;
//    @BeforeEach
//    void init(){
//        when(nbrbClient.getRate(431L))
//                .thenReturn(new NbrbResponse("USD", BigDecimal.ONE));
//    }
//
//    @Test
//    void controllerTest() throws Exception {
//        mockMvc
//                .perform(get("/rate/431"))
//                .andExpect(status().is2xxSuccessful())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.curName").value("USD"))
//                .andExpect(jsonPath("$.curOfficialRate").value(BigDecimal.ONE));
//    }
//
//}