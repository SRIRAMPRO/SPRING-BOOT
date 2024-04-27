package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private UserService personService;

    @PostMapping
    public User createPerson(@RequestBody User person) {
        return personService.createPerson(person);
    }

    @GetMapping
    public List<User> getAllPersons() {
        return personService.getAllPersons();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getPersonById(@PathVariable(value = "id") Long id) {
        java.util.Optional<User> person = personService.getPersonById(id);
        if (person.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(person.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updatePerson(@PathVariable(value = "id") Long id,  @RequestBody User personDetails) {
        personService.updatePerson(id, personDetails);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePerson(@PathVariable(value = "id") Long id) {
        personService.deletePerson(id);
        return ResponseEntity.ok().build();
    }
}
