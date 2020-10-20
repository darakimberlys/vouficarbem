package com.vouficarbem.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;

@EnableTransactionManagement
public class JPAConfiguration {

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        factoryBean.setJpaVendorAdapter(vendorAdapter);

//        Preparação para o banco de dados

//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setUsername("root");
//        dataSource.setPassword("");
//        dataSource.setUrl("jdbc:mysql://localhost:3307/vouficarbem?useSSL=false&serverTimezone=UTC");
//        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        factoryBean.setDataSource(dataSource);
//
//        Properties properties = new Properties();
//
//        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
//        properties.setProperty("hibernate.show_sql", "true");
//        properties.setProperty("hibernate.hbm2ddl.auto", "update");
//
//        factoryBean.setJpaProperties(properties);
//        factoryBean.setPackagesToScan("br.com.vouficarbem.loja.models");
//
        return factoryBean;
    }

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }
}
