package com.cybage.project.configuration;
 
import java.util.Properties;
 
import javax.sql.DataSource;
 
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
 
/*
 * Indicates that a class declares one or more @Bean methods and may be processed by the Spring 
 * container to generate bean definitions and service requests for those beans at runtime.
 * Enables Spring's annotation-driven transaction management capability, similar to the support found in Spring's <tx:*> XML namespace.
 * Configures component scanning directives for use with @Configuration classes.
 * Annotation providing a convenient and declarative mechanism for adding a PropertySource to Spring's Environment.
 * @see         org.springframework.context.annotation.Configuration
 * @see         org.springframework.context.annotation.EnableTransactionManagement
 * @see         org.springframework.context.annotation.ComponentScan
 * @see			org.springframework.context.annotation.PropertySource
 * @version     %1%
 */
@Configuration
@EnableTransactionManagement
@ComponentScan({ "com.cybage.project" })
@PropertySource(value = { "classpath:application.properties" })
public class WebMvcHibernateConfiguration {
 
    @Autowired
    private Environment environment;
 
    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(new String[] { "com.cybage.project.model" });
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
     }
     
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
        dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
        dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
        dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
        return dataSource;
    }
     
    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
        properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
        properties.put("hibernate.hbm2ddl.auto",environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
        return properties;        
    }
     
    /*
     * Indicates that a method produces a bean to be managed by the Spring container.
     * Marks a constructor, field, setter method or config method as to be autowired by Spring's dependency injection facilities.
     * @see      org.springframework.context.annotation.Bean
     * @see      org.springframework.beans.factory.annotation.Autowired  
     */
    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory s) {
       HibernateTransactionManager txManager = new HibernateTransactionManager();
       txManager.setSessionFactory(s);
       return txManager;
    }
}