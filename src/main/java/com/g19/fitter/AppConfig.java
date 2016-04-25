package com.g19.fitter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
/**
 * Created by davidsudia on 4/15/16.
 */
public class AppConfig {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(AppConfig.class);
        app.run(args);
    }
}
