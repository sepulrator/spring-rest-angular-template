package org.spring.template.service.service;

import org.spring.template.core.constants.CacheConstants;
import org.spring.template.core.helper.CacheEvictHelper;
import org.spring.template.datastore.entity.postgre.PersonEntity;
import org.spring.template.datastore.repository.postgre.PersonRepository;
import org.spring.template.service.common.ICrudService;
import org.spring.template.service.dto.converter.PersonConverter;
import org.spring.template.service.dto.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by osman on 8.5.2017.
 */
@Service
public class PersonService implements ICrudService<Person,Long> {

    private final static int PAGE_SIZE = 3;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    PersonConverter personConverter;

    @Autowired
    CacheEvictHelper cacheEvictHelper;

    @Override
    public Person create(Person item) {
        PersonEntity personEntity = personConverter.convert(item);
        personRepository.save(personEntity);
        cacheEvictHelper.evictPersonListCache();
        return personConverter.convertBack(personEntity);
    }

    @Override
    public Person read(Long id) {
        PersonEntity personEntity = personRepository.findOne(id);
        return personConverter.convertBack(personEntity);
    }

    @Override
    public Person update(Person item) {
        PersonEntity personEntity = personConverter.convert(item);
        personRepository.save(personEntity);
        cacheEvictHelper.evictPersonListCache();
        return personConverter.convertBack(personEntity);
    }

    @Override
    public void delete(Long id) {
        cacheEvictHelper.evictPersonListCache();
        personRepository.delete(id);
    }

    @Override
    @Cacheable(cacheNames = CacheConstants.PERSON_LIST)
    public List<Person> list() {
        Iterable<PersonEntity> personEntityList = personRepository.findAll();
        List<Person> personList = StreamSupport.stream(personEntityList.spliterator(), false).map( entity -> personConverter.convertBack(entity)).collect(Collectors.toList());
        return personList;
    }

    @Override
    public Page<Person> listByPage(Pageable pageable) {
        Page<PersonEntity> personEntityList = personRepository.findAll(pageable);
        Page<Person> personList = personEntityList.map( entity -> personConverter.convertBack(entity));
        return personList;
    }
}
