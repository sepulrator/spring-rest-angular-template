package org.spring.template.datastore.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by osman on 14.5.2017.
 */
@Configuration
@EnableMongoRepositories("org.spring.template.datastore.repository.mongodb")
@PropertySource(value={"classpath:mongodb.config"})
public class MongodbConfig extends AbstractMongoConfiguration {

    @Value("${mongodb.host}")
    private String mongoHost;

    @Value("${mongodb.port}")
    private String mongoPort;

    @Value("${mongodb.database}")
    private String mongoDB;

    @Override
    public MongoMappingContext mongoMappingContext()
            throws ClassNotFoundException {
        return super.mongoMappingContext();
    }

    @Override
    @Bean
    public Mongo mongo() throws Exception {
        return new MongoClient(mongoHost + ":" + mongoPort);
    }
    @Override
    protected String getDatabaseName() {
        return mongoDB;
    }


}
