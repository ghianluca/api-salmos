package br.com.ghianluca.SalmoApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SalmoAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(SalmoAppApplication.class, args);
    }
}