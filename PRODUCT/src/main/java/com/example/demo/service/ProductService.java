package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository personRepository;

    public Product createPerson(Product person) {
        return personRepository.save(person);
    }

    public List<Product> getAllPersons() {
        return personRepository.findAll();
    }

    public Optional<Product> getPersonById(Long id) {
        return personRepository.findById(id);
    }

    public void updatePerson(Long id, Product productDetails) {
        Product product = new Product();
    product.setProductId(id);
    product.setProductName(productDetails.getProductName());
    product.setDescription(productDetails.getDescription());
    product.setCategory(productDetails.getCategory());
    product.setPrice(productDetails.getPrice());
    product.setQuantityAvailable(productDetails.getQuantityAvailable());
    product.setHeight(productDetails.getHeight());
    product.setSpread(productDetails.getSpread());
    product.setSunlightRequirement(productDetails.getSunlightRequirement());
    product.setWateringFrequency(productDetails.getWateringFrequency());
    product.setSoilType(productDetails.getSoilType());
    product.setHardinessZone(productDetails.getHardinessZone());
    product.setGrowthRate(productDetails.getGrowthRate());
    product.setPlantingSeason(productDetails.getPlantingSeason());
    product.setFeatures(productDetails.getFeatures());
    product.setAvailability(productDetails.isAvailability());
    personRepository.save(product);
    }
    

    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }
}
