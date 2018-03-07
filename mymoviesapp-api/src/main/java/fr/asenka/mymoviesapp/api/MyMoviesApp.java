package fr.asenka.mymoviesapp.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication // @Configuration + @EnableAutoConfiguration + @ComponentScan
@EnableTransactionManagement // Activate the transactional mode for Database queries
@EnableSpringDataWebSupport // Make the pagination available
@EntityScan(basePackages = { "fr.asenka.mymoviesapp.model" }) // Package where the entities are seek
@ComponentScan(basePackages = { "fr.asenka.mymoviesapp" }) // Override the @ComponentScan of @SpringBootApplication to
															// make sure that the configuration classes are looked-up
															// everywhere
public class MyMoviesApp {

	public static void main(String[] args) {
		
		SpringApplication.run(MyMoviesApp.class, args);
	}
}
