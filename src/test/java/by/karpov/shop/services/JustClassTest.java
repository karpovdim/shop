package by.karpov.shop.services;

import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JustClassTest {

    private final JustClass testObject = new JustClass();

    @Test
    void getMsg() {
        ReflectionTestUtils.setField(testObject, "msg", "message");

//        final var msg = testObject.getClass().getDeclaredField("msg");
//        msg.setAccessible(true);
//        msg.set(testObject, "message");
//        msg.setAccessible(false);

        assertEquals("message", testObject.getMsg());
    }
}