package com.mvatanasov.danodastane;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DanoDaStaneApplication {

    public static void main(String[] args) {

        SpringApplication.run(DanoDaStaneApplication.class, args);
        System.out.println("http://127.0.0.1:8080/");
    }

}
