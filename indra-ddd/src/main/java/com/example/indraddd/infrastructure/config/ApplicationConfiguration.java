package com.example.indraddd.infrastructure.config;

import com.example.indraddd.application.services.PriceService;
import com.example.indraddd.application.usecases.RetrievePriceUseCaseImpl;
import com.example.indraddd.domain.ports.out.PriceRepositoryPort;
import com.example.indraddd.infrastructure.repositories.R2dbcPriceRepositoryAdapter;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.r2dbc.connectionfactory.init.CompositeDatabasePopulator;
import org.springframework.data.r2dbc.connectionfactory.init.ConnectionFactoryInitializer;
import org.springframework.data.r2dbc.connectionfactory.init.ResourceDatabasePopulator;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public ConnectionFactoryInitializer databaseInitializer(ConnectionFactory connectionFactory) {

        ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
        initializer.setConnectionFactory(connectionFactory);

        CompositeDatabasePopulator populator = new CompositeDatabasePopulator();
        populator.addPopulators(new ResourceDatabasePopulator(new ClassPathResource("schema.sql")));
        populator.addPopulators(new ResourceDatabasePopulator(new ClassPathResource("data.sql")));
        initializer.setDatabasePopulator(populator);

        return initializer;
    }

    @Bean
    public PriceService priceService(PriceRepositoryPort priceRepositoryPort) {
        return new PriceService(
               new RetrievePriceUseCaseImpl(priceRepositoryPort)
        );
    }

    @Bean
    public PriceRepositoryPort priceRepositoryPort(R2dbcPriceRepositoryAdapter r2dbcPriceRepositoryAdapter) {
        return r2dbcPriceRepositoryAdapter;
    }

}