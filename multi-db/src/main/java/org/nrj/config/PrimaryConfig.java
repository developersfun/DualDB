package org.nrj.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		entityManagerFactoryRef="primaryEntityManagerFactory",
		basePackages= {"org.nrj.primary.repo"}
		)
public class PrimaryConfig {
	

	@Primary
	@Bean(name="primaryDatasource")
	@ConfigurationProperties(prefix = "primary.datasource")
	public DataSource mysqlDataSource() {
		return DataSourceBuilder
					.create()
					.build();
	}

	@Primary
	@Bean(name = "primaryEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean primaryEntityManagerFactory(EntityManagerFactoryBuilder builder
			, @Qualifier("primaryDatasource") DataSource dataSource) {
		return builder
					.dataSource(dataSource)
					.packages("org.nrj.primary.entities")
					.persistenceUnit("DB_One")
					.build();
	}

	@Primary
	@Bean(name = "primaryTransactionManager")
	public PlatformTransactionManager mysqlTransactionManager(@Qualifier("primaryEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}
}
