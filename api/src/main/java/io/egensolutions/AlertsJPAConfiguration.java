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
public class AlertsJPAConfiguration {
    @Bean
    public LocalContainerEntityManagerFactoryBean emf()
    {
        //System.out.println("ALERTS");
        LocalContainerEntityManagerFactoryBean emf3 = new LocalContainerEntityManagerFactoryBean();
        emf3.setDataSource(getDataSource());
        emf3.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        emf3.setPackagesToScan("io.egensolutions.entities.alerts");

        Properties properties3 = new Properties();
        properties3.put("hibernate.dialect", "org.hibernate.dialect.MySQL57Dialect");
        properties3.put("hibernate.hbm2ddl.auto", "create");
        properties3.put("hibernate.show_sql", "true");
        emf3.setJpaProperties(properties3);
        return emf3;
    }
    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource ds3 = new DriverManagerDataSource();
        ds3.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds3.setUrl("jdbc:mysql://localhost:3306/alerts_db?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
        ds3.setUsername("root");
        ds3.setPassword("root");
        return ds3;
    }

    @Bean
    public PlatformTransactionManager txManager(EntityManagerFactory emf33) {
        JpaTransactionManager txm3 = new JpaTransactionManager(emf33);
        return txm3;
    }


}
