package com.bin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.bin.dao")
public class HutoolApplication {

    public static void main(String[] args) {
        SpringApplication.run(HutoolApplication.class, args);
    }

}
