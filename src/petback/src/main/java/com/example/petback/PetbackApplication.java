package com.example.petback;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class PetbackApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetbackApplication.class, args);
    }

}
