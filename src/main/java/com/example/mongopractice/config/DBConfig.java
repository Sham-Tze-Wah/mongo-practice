//package com.example.mongopractice.config;
//
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.persistence.EntityManagerFactory;
//import javax.sql.DataSource;
//
//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(
//        entityManagerFactoryRef = "itemEntityManagerFactory",
//        transactionManagerRef = "itemTransactionManager",
//        basePackages = { "com.example.mongopractice.repository.item" })
//public class DBConfig {
//    @Primary
//    @Bean(name="itemProperties")
//    @ConfigurationProperties("spring.data")
//    public DataSourceProperties dataSourceProperties() {
//        return new DataSourceProperties();
//    }
//
//    @Primary
//    @Bean(name="itemDatasource")
//    @ConfigurationProperties(prefix = "spring.datasource")
//    public DataSource datasource(@Qualifier("itemProperties") DataSourceProperties properties){
//
//        return properties.initializeDataSourceBuilder().build();
//    }
//
//    @Primary
//    @Bean(name="itemEntityManagerFactory")
//    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean
//            (EntityManagerFactoryBuilder builder, @Qualifier("itemDatasource") DataSource dataSource){
//
//        return builder.dataSource(dataSource)
//                .packages("com.example.mongopractice.entity")
//                .persistenceUnit("GroceryItem").build();
//    }
//
//    @Primary
//    @Bean(name = "itemTransactionManager")
//    @ConfigurationProperties("spring.jpa")
//    public PlatformTransactionManager transactionManager(
//            @Qualifier("itemEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
//
//        return new JpaTransactionManager(entityManagerFactory);
//    }
//
//    //***********************************************************
//
//
//
//}
