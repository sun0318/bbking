package com.family.bbkingweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication(scanBasePackages = {"com.family.bbkingweb","com.family.bbkingservice","com.family.bbkingdao"})
@MapperScan("com.family.bbkingdao.mapper")
@EnableCaching
public class BbkingWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(BbkingWebApplication.class, args);
    }

}
