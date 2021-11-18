package by.karpov.shop.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class JustClass {

    @Value("${db-schema-name}")
    private String msg;

    public String getMsg() {
        return msg;
    }

}
