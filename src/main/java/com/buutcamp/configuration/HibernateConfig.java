package com.buutcamp.configuration;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:webconfig.properties")
public class HibernateConfig {

    @Autowired
    private Environment env;

    @Bean
    public DataSource getDataSource(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(env.getProperty("db.driver"));
        dataSource.setUrl(env.getProperty("db.url"));
        //dataSource.setDatabaseName("hibernate_simple_demo");
        dataSource.setUsername(env.getProperty("db.username"));
        dataSource.setPassword(env.getProperty("db.password"));
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean getSessionFactory() throws SQLException {
        LocalSessionFactoryBean localFactBean = new LocalSessionFactoryBean();
        localFactBean.setDataSource(getDataSource());
        localFactBean.setPackagesToScan("com.buutcamp.emitents");
        localFactBean.setHibernateProperties(hibernateProperties());
        return localFactBean;
    }

    Properties hibernateProperties() {
        return new Properties() {
            {
                setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
                setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
                setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
            }
        };
    }

    @Bean
    public HibernateTransactionManager getTransactionManager(SessionFactory localFactBean){
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(localFactBean);
        return transactionManager;
    }

}
