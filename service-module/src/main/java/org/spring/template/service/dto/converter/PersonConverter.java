package org.spring.template.service.dto.converter;

import org.spring.template.datastore.entity.postgre.PersonEntity;
import org.spring.template.service.dto.domain.Person;
import org.springframework.stereotype.Component;

/**
 * Created by osman on 9.5.2017.
 */
@Component
public class PersonConverter extends AbstractTwoWayConverter<Person, PersonEntity> {

    @Override
    public PersonEntity convert(Person person) {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setFirstName(person.getFirstName());
        personEntity.setGender(person.getGender());
        personEntity.setId(person.getId());
        personEntity.setLastName(person.getLastName());
        personEntity.setNationality(person.getNationality());
        return personEntity;
    }

    @Override
    public Person convertBack(PersonEntity personEntity) {
        Person person = new Person();
        person.setFirstName(personEntity.getFirstName());
        person.setGender(personEntity.getGender());
        person.setId(personEntity.getId());
        person.setLastName(personEntity.getLastName());
        person.setNationality(personEntity.getNationality());
        return person;
    }
}
