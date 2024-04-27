package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    @Autowired
    private ProductService personService;

    @PostMapping
    public Product createPerson(@RequestBody Product person) {
        return personService.createPerson(person);
    }

    @GetMapping
    public List<Product> getAllPersons() {
        return personService.getAllPersons();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getPersonById(@PathVariable(value = "id") Long id) {
        java.util.Optional<Product> person = personService.getPersonById(id);
        if (person.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(person.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updatePerson(@PathVariable(value = "id") Long id,  @RequestBody Product personDetails) {
        personService.updatePerson(id, personDetails);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePerson(@PathVariable(value = "id") Long id) {
        personService.deletePerson(id);
        return ResponseEntity.ok().build();
    }
}
