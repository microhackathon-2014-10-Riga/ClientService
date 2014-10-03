package com.ofg.client.config
import com.github.fakemongo.Fongo
import com.mongodb.Mongo
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.config.AbstractMongoConfiguration
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@Configuration
@EnableMongoRepositories
class DbConfiguration extends AbstractMongoConfiguration {

    @Override
    protected String getDatabaseName() {
        'client-db'
    }

    @Override
    Mongo mongo() throws Exception {
        def fongo = new Fongo('mongo server 1')
        fongo.getMongo()
    }
}
