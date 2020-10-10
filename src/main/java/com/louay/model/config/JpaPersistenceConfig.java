package com.louay.model.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableAutoConfiguration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.louay.model")
public class JpaPersistenceConfig {

    @Bean("pool")
    @Primary
    protected DataSource dataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setUsername("root");
        dataSource.setPassword("1729384#General");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/graphql?useSSL=false");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");

        return dataSource;
    }

    @Bean
    protected PlatformTransactionManager transactionManager(@Autowired @Qualifier("pool") DataSource dataSource) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory(dataSource).getObject());

        return transactionManager;
    }

    @Bean
    protected LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        JpaVendorAdapter vendorAdapter = getHibernateJpaVendorAdapter();
        LocalContainerEntityManagerFactoryBean entityManagerBean = new LocalContainerEntityManagerFactoryBean();

        entityManagerBean.setDataSource(dataSource);
        entityManagerBean.setPackagesToScan("com.louay.model");
        entityManagerBean.setJpaVendorAdapter(vendorAdapter);
        entityManagerBean.setJpaProperties(additionalProperties());

        return entityManagerBean;
    }

    @Bean
    protected HibernateJpaVendorAdapter getHibernateJpaVendorAdapter() {
        return new HibernateJpaVendorAdapter();
    }


    @Bean
    protected PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    private Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "update"); //for developer none | validate | update | create-only |create | create-drop with every SessionFactory close
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        properties.setProperty("hibernate.naming-strategy", "org.hibernate.cfg.ImprovedNamingStrategy");

        //for batch
        properties.setProperty("hibernate.jdbc.batch_size", "4");
        properties.setProperty("hibernate.order_inserts", "true");
        properties.setProperty("hibernate.order_updates", "true");
        properties.setProperty("hibernate.batch_versioned_data", "true");

        return properties;
    }
}
