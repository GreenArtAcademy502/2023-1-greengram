package com.green.greengram;

import com.green.greengram.common.config.properties.AppProperties;
import com.green.greengram.common.config.properties.CorsProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({AppProperties.class, CorsProperties.class })
public class GreengramApplication {
    public static void main(String[] args) {
        SpringApplication.run(GreengramApplication.class, args);
    }
}
