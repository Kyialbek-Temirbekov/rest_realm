package com.example.FirstRestApp.services;

import com.example.FirstRestApp.util.PersonNotFoundException;
import jakarta.transaction.Transactional;
import com.example.FirstRestApp.models.Person;
import com.example.FirstRestApp.repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PeopleService {
    private final PeopleRepository peopleRepository;
    @Autowired
    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }
    public List<Person> findAll() {
        return peopleRepository.findAll();
    }
    public Person findOne(int id) {
        Optional<Person> foundPerson = peopleRepository.findById(id);
        return foundPerson.orElseThrow(PersonNotFoundException::new);
    }
    public void save(Person person) {
        enrichPerson(person);
        peopleRepository.save(person);
    }
    private void enrichPerson(Person person) {
        person.setCreatedAt(LocalDateTime.now());
        person.setUpdatedAt(LocalDateTime.now());
        person.setCreatedWho("ADMIN");
    }
    public void update(int id, Person person) {
        person.setId(id);
        peopleRepository.save(person);
    }
    public void delete(int id) {
        peopleRepository.deleteById(id);
    }
}
