package org.spring.template.datastore.repository.mongodb;

import org.spring.template.datastore.entity.mongodb.ServiceLog;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by osman on 14.5.2017.
 */
public interface ServiceLogRepository extends MongoRepository<ServiceLog,Long> {
}
