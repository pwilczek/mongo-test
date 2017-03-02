package name.wilu.mongo;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PreDestroy;
import java.util.logging.Logger;

@Configuration
public class MongoConfig {

    public static final Logger LOGGER = Logger.getLogger(MongoConfig.class.getName());
    //
    private MongoClient client;

    @Bean
    public Datastore store(Morphia morphia, MongoClient cli) {
        return morphia.createDatastore(cli, "calDB");
    }

    @Bean
    public MongoClient mongoClient() {
        client = new MongoClient();
        return client;
    }

    @Bean
    public Morphia morphia() {
        return new Morphia().mapPackageFromClass(this.getClass());
    }

    @PreDestroy
    public void close() {
        LOGGER.info("Closing connection to " + client.getConnectPoint() + "...");
        client.close();
    }
}
