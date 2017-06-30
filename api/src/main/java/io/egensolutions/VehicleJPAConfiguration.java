package io.egensolutions;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
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
public class VehicleJPAConfiguration {

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean emf()
    {
        LocalContainerEntityManagerFactoryBean emf1 = new LocalContainerEntityManagerFactoryBean();
        emf1.setDataSource(getDataSource());
        emf1.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        emf1.setPackagesToScan("io.egensolutions.entities.vehicle");

        Properties properties1 = new Properties();
        properties1.put("hibernate.dialect", "org.hibernate.dialect.MySQL57Dialect");
        properties1.put("hibernate.hbm2ddl.auto", "create");
        properties1.put("hibernate.show_sql", "true");
        emf1.setJpaProperties(properties1);
        return emf1;
    }
    @Primary
    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/vehicles_db?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
        ds.setUsername("root");
        ds.setPassword("root");
        return ds;
    }
    @Primary
    @Bean
    public PlatformTransactionManager txManager(EntityManagerFactory emf11) {
        JpaTransactionManager txm1 = new JpaTransactionManager(emf11);
        return txm1;
    }
}
