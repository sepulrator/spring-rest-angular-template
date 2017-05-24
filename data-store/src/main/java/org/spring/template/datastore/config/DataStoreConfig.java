package org.spring.template.datastore.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by osman on 14.5.2017.
 */
@Configuration
@Import({PostgreConfig.class,MongodbConfig.class})
public class DataStoreConfig {
}
