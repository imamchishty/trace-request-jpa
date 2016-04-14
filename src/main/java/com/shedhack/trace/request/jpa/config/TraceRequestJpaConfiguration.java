package com.shedhack.trace.request.jpa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;

/**
 * <pre>
 *     Most applications usually access databases and define their own
 *     datasources. This library also requires a db and in the
 *     case of trace-request-jpa it assumes that the db it will be writing
 *     to will be a central one, and probably not the applications db.
 *     As a result you'll see a separate TX manager, EMF and of course
 *     the database. Please note that you may need to use {@link org.springframework.beans.factory.annotation.Qualifier}
 *     to your existing database to prevent any conflicts.
 * </pre>
 *
 * @author imamchishty
 */
@Configuration
@EnableJpaRepositories(
        basePackages = "com.shedhack.trace.request.jpa.repository",
        entityManagerFactoryRef = "traceRequestEntityManager",
        transactionManagerRef = "traceRequestTxManager"
)
@ComponentScan(basePackages = "com.shedhack.trace.request.jpa.service")
public class TraceRequestJpaConfiguration {

    @Autowired
    private Environment env;

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean traceRequestEntityManager() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(traceRequestDataSource());
        em.setPackagesToScan(new String[] { "com.shedhack.trace.request.jpa.domain" });

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", env.getProperty("trace-request.hibernate.hbm2ddl.auto"));
        properties.put("hibernate.dialect", env.getProperty("trace-request.hibernate.dialect"));
        em.setJpaPropertyMap(properties);

        return em;
    }

    @Bean
    public DataSource traceRequestDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("trace-request.jdbc.driverClassName"));
        dataSource.setUrl(env.getProperty("trace-request.jdbc.url"));
        dataSource.setUsername(env.getProperty("trace-request.jdbc.user"));
        dataSource.setPassword(env.getProperty("trace-request.jdbc.pass"));
        return dataSource;
    }

    @Bean
    public PlatformTransactionManager traceRequestTxManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(traceRequestEntityManager().getObject());
        return transactionManager;
    }
}
