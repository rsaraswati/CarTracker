package io.egensolutions;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class ReadingsJPAConfiguration {
    @Bean
    public LocalContainerEntityManagerFactoryBean emf()
    {

        LocalContainerEntityManagerFactoryBean emf2 = new LocalContainerEntityManagerFactoryBean();
        emf2.setDataSource(getDataSource());
        emf2.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        emf2.setPackagesToScan("io.egensolutions.entities.readings");

        Properties properties2 = new Properties();
        properties2.put("hibernate.dialect", "org.hibernate.dialect.MySQL57Dialect");
        try {
            properties2.put("hibernate.hbm2ddl.auto", "create");
            properties2.put("hibernate.show_sql", "true");
            emf2.setJpaProperties(properties2);
            }catch (Exception e){
            System.out.println("Error in config");
        }
        return emf2;
    }
    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource ds2 = new DriverManagerDataSource();
        ds2.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds2.setUrl("jdbc:mysql://localhost:3306/readings_db?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
        ds2.setUsername("root");
        ds2.setPassword("root");
        return ds2;
    }

    @Bean
    public PlatformTransactionManager txManager(EntityManagerFactory emf22) {
        JpaTransactionManager txm2 = new JpaTransactionManager(emf22);
        return txm2;
    }
}
