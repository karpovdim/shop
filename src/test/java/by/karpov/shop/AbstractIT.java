package by.karpov.shop;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class AbstractIT {

    @Container
    private static final MySQLContainer<?> CONTAINER = new MySQLContainer<>("mysql:8.0.27")
            .withDatabaseName("shop_db")
            .withUsername("root")
            .withPassword("pass");

    @DynamicPropertySource
    private static void postgresqlProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", CONTAINER::getJdbcUrl);
        registry.add("spring.datasource.password", CONTAINER::getPassword);
        registry.add("spring.datasource.username", CONTAINER::getUsername);
    }

}
