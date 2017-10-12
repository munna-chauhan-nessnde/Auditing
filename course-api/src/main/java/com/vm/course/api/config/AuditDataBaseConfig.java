package com.vm.course.api.config;

import java.util.HashMap;

import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
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
@EnableJpaRepositories(basePackages = "com.vm.course.api.audit.repository", 
						entityManagerFactoryRef = "primaryEntityManagerFactory", 
						transactionManagerRef = "primaryTransactionManager")  
public class AuditDataBaseConfig {


	@Autowired
	private Environment env;

	@Autowired
	private DataSource auditDataSource;

	@Bean
	@ConfigurationProperties(prefix = "datasource.db")
	public DataSource auditDataSource() {
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("datasource.audit.db.driver"));
		dataSource.setUrl(env.getProperty("datasource.audit.db.url"));
		dataSource.setUsername(env.getProperty("datasource.audit.db.user"));
		dataSource.setPassword(env.getProperty("datasource.audit.db.pass"));

		return dataSource;
	}

	@PersistenceContext(unitName = "auditPU")
	@Bean
	public LocalContainerEntityManagerFactoryBean auditEntityManagerFactory() {
		
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(auditDataSource);
		em.setPackagesToScan(new String[] { "com.vm.course.api.audit.domain" });

		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		HashMap<String, Object> properties = new HashMap<>();
		properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
		properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
		em.setJpaPropertyMap(properties);

		return em;
	}
	
    @Bean
	public PlatformTransactionManager auditTransactionManager() {

		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(auditEntityManagerFactory().getObject());
		return transactionManager;
	}

}
