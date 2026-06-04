package br.com.ifba.bookboxd; 

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookboxdApplicationTests {

    static {
        System.setProperty("java.awt.headless", "false");
    }

    @Test
    void contextLoads() {
    }

}