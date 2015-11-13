/**
 *
 */
package com.br.alldreams.diamantedev.spring.configuration;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * Representação da classe:
 *
 * <url>http://websystique.com/spring/spring4-hibernate4-mysql-maven-integration
 * -example-using-annotations/</url>
 *
 * @author Jorge Demetrio
 * @version 1.0
 * @since 26/06/2015 15:52:04
 */
@Configuration
@EnableTransactionManagement
@ComponentScan({ "com.br.alldreams.diamantecrm" })
@PropertySource(value = { "classpath:application.properties" })
public class HibernateConfiguration {

	private final Logger LOGGER = Logger.getLogger(HibernateConfiguration.class);

	@Autowired
	private Environment environment;

	@Bean
	public DataSource dataSource() {
		LOGGER.debug("Pegando o DataSoruce.");
		DataSource ds = null;
		try {
			final Context initContext = new InitialContext();
			ds = DataSource.class.cast(initContext.lookup("java:comp/env/" + environment.getRequiredProperty("jdbc.jndi")));
			LOGGER.debug("DataSoruce: ".concat(environment.getRequiredProperty("jdbc.jndi")).concat(" ").concat(ds.toString()));
		} catch (final Exception ne) {
			LOGGER.error(ne.getMessage(), ne);
			throw new RuntimeException(ne);
		}
		return ds;

	}

	private Properties hibernateProperties() {
		LOGGER.debug("Chamando o hibernateProperties.");
		final Properties properties = new Properties();
		properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));

		// CONFIGURAÇÃO AMBIENTE DE DESENVOLVIMENTO, DEVEM SER FALSE EM PRODUÇÃO
		properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
		properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
		properties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
		properties.put("hibernate.generate_statistics", environment.getRequiredProperty("hibernate.generate_statistics"));

		// CACHE ESTRUTRA
		properties.put("hibernate.cache.use_structured_entries", environment.getRequiredProperty("hibernate.cache.use_structured_entries"));
		properties.put("hibernate.cache.use_query_cache", environment.getRequiredProperty("hibernate.cache.use_query_cache"));
		properties.put("hibernate.cache.provider_class", environment.getRequiredProperty("hibernate.cache.provider_class"));
		properties.put("hibernate.cache.region.factory_class", environment.getRequiredProperty("hibernate.cache.region.factory_class"));

		return properties;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LOGGER.debug("Chamando o sessionFactory.");
		final LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan(new String[] { "br.com.ebix.cotacaovg" });
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}

	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory s) {
		LOGGER.debug("Chamando o transactionManager.");
		final HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(s);
		return txManager;
	}
}
