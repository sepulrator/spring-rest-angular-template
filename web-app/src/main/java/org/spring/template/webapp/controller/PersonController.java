package org.spring.template.webapp.controller;

import org.spring.template.service.dto.domain.Person;
import org.spring.template.service.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by osman on 8.5.2017.
 */
@RestController
@RequestMapping("person")
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping
    //@RequestMapping(value = "/pageable")
    public Page<Person> getPersonList(Pageable pageable) {
        return personService.listByPage(pageable);
    }

    @GetMapping
    @RequestMapping(value = "/{id}")
    public Person readPerson(@PathVariable("id") long id) {
        return personService.read(id);
    }

    @PostMapping
    public Person createPerson(@Valid @RequestBody Person person) {
        return personService.create(person);
    }

    @PutMapping
    public Person updatePerson(@Valid @RequestBody Person person) {
        return personService.update(person);
    }

    //@DeleteMapping
    @RequestMapping(value = "/{id}" ,method = RequestMethod.DELETE)
    public void deletePerson(@PathVariable("id") long id) {
        personService.delete(id);
    }

}
