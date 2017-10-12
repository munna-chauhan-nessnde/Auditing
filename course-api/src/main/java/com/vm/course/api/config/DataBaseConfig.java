package com.vm.course.api.config;

import java.util.HashMap;

import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Component
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.vm.course.api.repository", 
						entityManagerFactoryRef = "primaryEntityManagerFactory", 
						transactionManagerRef = "primaryTransactionManager")  
public class DataBaseConfig {

	@Autowired
	private Environment env;

	@Autowired
	private DataSource primaryDataSource;

	@Bean
	@Primary
	@ConfigurationProperties(prefix = "datasource.db")
	public DataSource primaryDataSource() {
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("datasource.db.driver"));
		dataSource.setUrl(env.getProperty("datasource.db.url"));
		dataSource.setUsername(env.getProperty("datasource.db.user"));
		dataSource.setPassword(env.getProperty("datasource.db.pass"));

		return dataSource;
	}

	@PersistenceContext(unitName = "primaryPU")
	@Primary
	@Bean
	public LocalContainerEntityManagerFactoryBean primaryEntityManagerFactory() {
		
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(primaryDataSource);
		em.setPackagesToScan(new String[] { "com.vm.course.api.domain" });

		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		HashMap<String, Object> properties = new HashMap<>();
		properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
		properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
		em.setJpaPropertyMap(properties);

		return em;
	}
	
    @Primary
    @Bean
	public PlatformTransactionManager primaryTransactionManager() {

		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(primaryEntityManagerFactory().getObject());
		return transactionManager;
	}

}
