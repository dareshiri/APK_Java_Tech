package com.example.SIEM.Project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchasedProduct {

    @Id
    private long id;
    private long customerId;
    private String age;
    private String income;
    private String productName;
}