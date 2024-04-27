package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository personRepository;

    public User createPerson(User person) {
        return personRepository.save(person);
    }

    public List<User> getAllPersons() {
        return personRepository.findAll();
    }

    public Optional<User> getPersonById(Long id) {
        return personRepository.findById(id);
    }

    public void updatePerson(Long id, User personDetails) {
        User person = new User();
        person.setId(id);
        person.setUsername(personDetails.getUsername());
        person.setFirstname(personDetails.getFirstname());
        person.setLastname(personDetails.getLastname());
        person.setPassword(personDetails.getPassword());
        person.setPhone(personDetails.getPhone());
        person.setEmail(personDetails.getEmail());    
        personRepository.save(person);
    }
    

    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }
}
