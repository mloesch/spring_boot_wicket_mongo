package de.example.mongodb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.mongodb.repository.support.MongoRepositoryFactory;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

/**
 * This class provides the system with essential MongoDB Spring Beans
 */
@Configuration
@EnableMongoRepositories("de.example.mongodb")
public class MongoDbConfig extends AbstractMongoConfiguration {


    @Bean
    protected MongoClientURI mongoDbUri() {
        return new MongoClientURI("mongodb://localhost/dev?autoconnectretry=true");
    }

    @Override
    protected String getDatabaseName() {
        return mongoDbUri().getDatabase();
    }

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient(mongoDbUri());
    }

    @Bean
    public MongoRepositoryFactory mongoRepositoryFactory() throws Exception {
        MongoTemplate mongo = mongoTemplate();
        return new MongoRepositoryFactory(mongo);
    }

}
