package com.example.SIEM.Project.controller;

import com.example.SIEM.Project.exception.ResourceNotFoundException;
import com.example.SIEM.Project.model.PurchasedProduct;
import com.example.SIEM.Project.repository.PurchasedProductRepository;
import com.example.SIEM.Project.repository.PurchasedProductStringRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PurchasedProductController {

    @Autowired
    private PurchasedProductRepository purchasedProductRepository;

    @Autowired
    private PurchasedProductStringRepository purchasedProductStringRepository;

    @GetMapping("/purchasedProducts")
    public Iterable<PurchasedProduct> getAllPurchasedProducts() {

        return purchasedProductRepository.findAll();
    }

    // build create employee REST API
    @PostMapping("/createPurchasedProduct")
    public PurchasedProduct createPurchasedProduct(@RequestBody PurchasedProduct product) {
        return purchasedProductRepository.save(product);
    }

    // build get employee by id REST API
    @GetMapping("/getPurchasedProductById/{id}")
    public ResponseEntity<PurchasedProduct> getPurchasedProductById(@PathVariable long id) {
        PurchasedProduct product = purchasedProductRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Purchased Product not exist with id:" + id));
        return ResponseEntity.ok(product);
    }

    @GetMapping("/findByProductName/{productName}")
    public List<PurchasedProduct> findByProductName(@PathVariable String productName) {
        return purchasedProductStringRepository.findByProductName(productName);
    }

    // build update employee REST API
    @PutMapping("/updatePurchasedProduct/{id}")
    public ResponseEntity<PurchasedProduct> updatePurchasedProduct(@PathVariable long id, @RequestBody PurchasedProduct productDetails) {
        PurchasedProduct updatePurchasedProduct = purchasedProductRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Purchased Product not exist with id: " + id));

        updatePurchasedProduct.setCustomerId(productDetails.getCustomerId());
        updatePurchasedProduct.setAge(productDetails.getAge());
        updatePurchasedProduct.setIncome(productDetails.getIncome());
        updatePurchasedProduct.setProductName(productDetails.getProductName());

        purchasedProductRepository.save(updatePurchasedProduct);

        return ResponseEntity.ok(updatePurchasedProduct);
    }

    // build delete employee Rest API
    @DeleteMapping("/deletePurchasedProduct/{id}")
    public ResponseEntity<HttpStatus> deletePurchasedProduct(@PathVariable long id) {
        PurchasedProduct product = purchasedProductRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Purchased Product not exist with id: " + id));

        purchasedProductRepository.delete(product);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        return (ResponseEntity<HttpStatus>) purchasedProductRepository.findAll();
    }
}
