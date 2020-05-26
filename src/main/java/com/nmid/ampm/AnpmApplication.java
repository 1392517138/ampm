package com.nmid.ampm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Aaron
 * @description
 * @date 2020/5/24 11:35 PM
 */
@EnableTransactionManagement(proxyTargetClass = true)
@MapperScan("com.nmid.ampm.mapper")
@SpringBootApplication
@EnableScheduling
public class AnpmApplication {
    public static void main(String[] args) {
        SpringApplication.run(AnpmApplication.class,args);
    }
}
