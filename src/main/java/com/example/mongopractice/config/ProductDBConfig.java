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
//        entityManagerFactoryRef = "productEntityManagerFactory",
//        transactionManagerRef = "productTransactionManager",
//        basePackages = { "com.example.mongopractice.repository.product" })
//public class ProductDBConfig {
//    @Primary
//    @Bean(name="productProperties")
//    @ConfigurationProperties("spring.datasource.product")
//    public DataSourceProperties productDataSourceProperties() {
//        return new DataSourceProperties();
//    }
//
//    @Primary
//    @Bean(name="productDatasource")
//    @ConfigurationProperties(prefix = "spring.datasource.product")
//    public DataSource productDatasource(@Qualifier("productProperties") DataSourceProperties properties){
//        return properties.initializeDataSourceBuilder().build();
//    }
//
//    @Primary
//    @Bean(name="productEntityManagerFactory")
//    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean
//            (EntityManagerFactoryBuilder builder, @Qualifier("productDatasource") DataSource dataSource){
//
//        return builder.dataSource(dataSource)
//                .packages("com.example.mongopractice.entity")
//                .persistenceUnit("ProductEntity").build();
//    }
//
//    @Primary
//    @Bean(name = "productTransactionManager")
//    @ConfigurationProperties("spring.jpa")
//    public PlatformTransactionManager transactionManager(
//            @Qualifier("productEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
//
//        return new JpaTransactionManager(entityManagerFactory);
//    }
//}
