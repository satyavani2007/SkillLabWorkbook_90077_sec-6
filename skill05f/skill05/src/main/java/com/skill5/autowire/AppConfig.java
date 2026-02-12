package com.skill5.autowire;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.skill5.autowire")
public class AppConfig {
    // Component scanning will automatically create beans for @Component classes.
}
