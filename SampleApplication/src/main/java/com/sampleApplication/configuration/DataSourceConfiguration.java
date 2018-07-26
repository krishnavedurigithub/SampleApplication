
package com.sampleApplication.configuration;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DataSourceConfiguration {
	public static final Logger LOG = LoggerFactory.getLogger(DataSourceConfiguration.class);
	
	@Value("${spring.datasource.url}")
	public String dataSourceUrl;
	@Value("${spring.datasource.username}")
	public String dataSourceUsername;
	@Value("${spring.datasource.password}")
	public String dataSourcePassword;
	@Value("${spring.datasource.driver-class-name}")
	public String dataSourceDriverClassName;
	@Value("${hikari.datasource.poolName}")
	public String dataSourcePoolName;
	@Value("${hikari.datasource.autoCommit}")
	public Boolean dataSourceIsAutoCommit;
	@Value("${hikari.datasource.maximumPoolSize}")
	public int dataSourceMaxPoolSize;
	@Value("${hikari.datasource.minimumIdle}")
	public int dataSourceMinimumIdle;
	@Value("${hikari.datasource.maxLifetime}")
	public Long dataSourceMaxLifetime;
	
	@Bean					
	public DataSource dataSourceContextSource(){
		HikariDataSource dataSource = new HikariDataSource();
		dataSource.setJdbcUrl(dataSourceUrl);
		dataSource.setDriverClassName(dataSourceDriverClassName);
		dataSource.setUsername(dataSourceUsername);
		dataSource.setPassword(dataSourcePassword);
		dataSource.setPoolName(dataSourcePoolName);
		dataSource.setAutoCommit(dataSourceIsAutoCommit);
		dataSource.setMaximumPoolSize(dataSourceMaxPoolSize);
		dataSource.setMinimumIdle(dataSourceMinimumIdle);
		dataSource.setMaxLifetime(dataSourceMaxLifetime);
		return dataSource;
	}
	
	@Bean(name="clJdbcTemplate")
	public JdbcTemplate clJdbcTemplate(){
		return new JdbcTemplate(dataSourceContextSource());
	}
	
	@Bean(name="clNamedParameterJdbcTemplate")
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate(){
		return new NamedParameterJdbcTemplate(dataSourceContextSource());
	}
}
