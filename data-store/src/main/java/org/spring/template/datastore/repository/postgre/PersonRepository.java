package org.spring.template.datastore.repository.postgre;

import org.spring.template.datastore.entity.postgre.PersonEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by osman on 8.5.2017.
 */
public interface PersonRepository extends PagingAndSortingRepository<PersonEntity,Long> {

}
