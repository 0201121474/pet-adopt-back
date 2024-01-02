package com.pet;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.pet.dao")
@SpringBootApplication
public class PetcenterBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetcenterBackApplication.class, args);
    }

}
