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

//	@Bean
//	public DataSource dataSource() {
//
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		
//		dataSource.setDriverClassName(environment.getRequiredProperty(PROPERTY_NAME_DATABASE_DRIVER_CLASS));
//
//		// Uncomment to read db url, username and password from properties file.		
////		String url = environment.getRequiredProperty(PROPERTY_NAME_DATABASE_URL);		
////		ds.setJdbcUrl(url);		
////		ds.setUser(environment
////				.getRequiredProperty(PROPERTY_NAME_DATABASE_USERNAME));
////		ds.setPassword(environment
////				.getRequiredProperty(PROPERTY_NAME_DATABASE_PASSWORD));
//
//		// Read db url, username and password from environment.		
//		dataSource.setUrl(dbUrl);		
//		dataSource.setUsername(dbUserName);
//		dataSource.setPassword(dbPassword);
//	
//		return dataSource;
//	}

//	@Bean
//	public LocalContainerEntityManagerFactoryBean entityManagerFactory(
//			DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {
//		LocalContainerEntityManagerFactoryBean lef = new LocalContainerEntityManagerFactoryBean();
//		lef.setDataSource(dataSource);
//		lef.setJpaVendorAdapter(jpaVendorAdapter);
//		lef.setPackagesToScan(environment
//				.getRequiredProperty(PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN));
//
//		Properties jpaProperties = new Properties();
//		jpaProperties.put(PROPERTY_NAME_HIBERNATE_DIALECT, environment
//				.getRequiredProperty(PROPERTY_NAME_HIBERNATE_DIALECT));
//		jpaProperties.put(PROPERTY_NAME_HIBERNATE_FORMAT_SQL, environment
//				.getRequiredProperty(PROPERTY_NAME_HIBERNATE_FORMAT_SQL));
//		jpaProperties.put(PROPERTY_NAME_HIBERNATE_NAMING_STRATEGY, environment
//				.getRequiredProperty(PROPERTY_NAME_HIBERNATE_NAMING_STRATEGY));
//		jpaProperties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, environment
//				.getRequiredProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL));
//		lef.setJpaProperties(jpaProperties);
//
//		return lef;
//	}

//	@Bean
//	public JpaVendorAdapter jpaVendorAdapter() {
//		HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
//		hibernateJpaVendorAdapter.setShowSql(true);
//		hibernateJpaVendorAdapter.setGenerateDdl(false);
//		hibernateJpaVendorAdapter.setDatabase(Database.MYSQL);
//		return hibernateJpaVendorAdapter;
//	}
//
//	@Bean
//	public PlatformTransactionManager transactionManager(
//			EntityManagerFactory entityManagerFactory) {
//		return new JpaTransactionManager(entityManagerFactory);
//	}
	
	@Bean
	public ProductService productService() {
		return new ProductServiceImpl();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(MyMarkProductApplication.class, args);
	}
}
