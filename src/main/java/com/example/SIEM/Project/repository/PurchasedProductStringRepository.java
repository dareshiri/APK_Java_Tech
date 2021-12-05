package com.example.SIEM.Project.repository;

import com.example.SIEM.Project.model.PurchasedProduct;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface PurchasedProductStringRepository extends ElasticsearchRepository<PurchasedProduct, String> {

    List<PurchasedProduct> findByProductName(String productName);
}
