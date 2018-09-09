package com.mymark.mymarkproduct;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.mymark.mymarkproduct.service.ProductService;
import com.mymark.mymarkproduct.service.impl.ProductServiceImpl;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@PropertySource({"classpath:application.properties"})
public class MyMarkProductApplication {

	@Resource
	private Environment environment;

	@Bean
	public ProductService productService() {
		return new ProductServiceImpl();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(MyMarkProductApplication.class, args);
	}
}
