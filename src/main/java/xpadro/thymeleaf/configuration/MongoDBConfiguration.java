package xpadro.thymeleaf.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

@Configuration
@EnableMongoRepositories("xpadro.thymeleaf.repository")
public class MongoDBConfiguration extends AbstractMongoConfiguration {

	private String database;

	@Override
	public Mongo mongo() throws Exception {
		
		MongoClientURI mongoUri = new MongoClientURI(System.getenv("MONGODB_URI"));
		database = mongoUri.getDatabase();
		
		return new MongoClient(mongoUri);
	}

	@Override
	protected String getDatabaseName() {
		return database;
	}
}
