package com.appgate.calc.infra.init;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.appgate.calc.infra.repository"},
scanBasePackageClasses = {
		com.appgate.calc.infra.adapters.CalcRepositoryAdapter.class,
})
@PropertySource(ignoreResourceNotFound = false, value = "classpath:application_test.properties")
@EnableJpaRepositories("com.appgate.calc.infra")
@EntityScan("com.appgate.calc.infra.entity")
public class AppInfraTest {

	@Bean
	public DataSource dataSource() {
		@SuppressWarnings("unchecked")
		DataSourceBuilder<DataSource> dataSourceBuilder = (DataSourceBuilder<DataSource>) DataSourceBuilder.create();
		dataSourceBuilder.url("jdbc:sqlite:calculator_db_test.db");
		return dataSourceBuilder.build();
	}

}
