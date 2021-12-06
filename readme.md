# SIEM Project
This project contains Restful APIs to add, show, update and delete a data in Elasticsearch database. <br />
Also, calculate KNN (K-Nearest Neighbor) algorithm for some training data to find classification of a new data. <br />

# APIs Documentation
1) Add a data (purchased products) <br />
URL: /createPurchasedProduct <br />
Method: POST <br />
Body: <br />
```
{
    "id": "...",
    "customerId": "...",
    "age": "...",
    "income": "...",
    "productName": "..."
}
```
<br />

2) Show a data by Id <br />
URL: /getPurchasedProductById/{purchased_product_id} <br />
Method: GET <br />

3) Get all data <br />
URL: /purchasedProducts <br />
Method: GET <br />

4) Find all products in same name <br />
URL: /findByProductName/{product_name} <br />
Method: GET <br />

5) Update a product <br />
URL: /updatePurchasedProduct/{purchased_product_id} <br />
Method: PUT <br />
Body: <br />
```
{
    "id": "...",
    "customerId": "...",
    "age": "...",
    "income": "...",
    "productName": "..."
}
```
<br />

6) Delete a product <br />
URL: /deletePurchasedProduct/{purchased_product_id} <br />
Method: DELETE <br />


