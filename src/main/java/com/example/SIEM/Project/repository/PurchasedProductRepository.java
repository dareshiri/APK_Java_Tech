package com.example.SIEM.Project.repository;

import com.example.SIEM.Project.model.PurchasedProduct;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface PurchasedProductRepository extends ElasticsearchRepository<PurchasedProduct, Long> {

    // all crud database methods
}
