package org.bibalex.eol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

/**
 * Created by maha.mostafa on 4/18/17.
 */
@SpringBootApplication
@EnableMongoAuditing
//@EnableCaching
public class Application extends SpringBootServletInitializer {
//    public class ArchiverApp {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }


    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}