package com.cardozo.infra.configuration;

import com.cardozo.DddHexagonalApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = DddHexagonalApplication.class)
public class BeanConfiguration {
}
