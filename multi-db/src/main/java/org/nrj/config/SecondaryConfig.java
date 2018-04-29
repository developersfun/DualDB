package org.nrj.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		entityManagerFactoryRef="secondaryEntityManagerFactory",
		basePackages= {"org.nrj.secondary.repo"}
		)
public class SecondaryConfig {
	

	@Bean(name="secondaryDatasource")
	@ConfigurationProperties(prefix = "secondary.datasource")
	public DataSource mysqlDataSource() {
		return DataSourceBuilder
					.create()
					.build();
	}

	@Bean(name = "secondaryEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean secondaryEntityManagerFactory(EntityManagerFactoryBuilder builder
			, @Qualifier("secondaryDatasource") DataSource dataSource) {
		return builder
					.dataSource(dataSource)
					.packages("org.nrj.secondary.entities")
					.persistenceUnit("DB_Two")
					.build();
	}

	@Bean(name = "secondaryTransactionManager")
	public PlatformTransactionManager mysqlTransactionManager(@Qualifier("secondaryEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}
}
