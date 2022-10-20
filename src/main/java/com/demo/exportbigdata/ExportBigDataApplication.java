package com.demo.exportbigdata;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class ExportBigDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExportBigDataApplication.class, args);
        log.info("-------------启动成功-------------");
    }

}
