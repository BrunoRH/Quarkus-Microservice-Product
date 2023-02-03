package com.microservice.product.repositories;


import com.microservice.product.entities.Product;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ProductRepository {

    @Inject
    EntityManager entityManager;

    @Transactional
    public void createdProduct(Product p){
        entityManager.persist(p);
    }

    @Transactional
    public void deleteProduct(Product p){
        entityManager.remove(entityManager.contains(p) ? p : entityManager.merge(p));
    }

    @Transactional
    public List<Product> listProduct(){
        List<Product> products = entityManager.createQuery("select p from Product p").getResultList();
        return products;
    }

    @Transactional
    public Product findProduct(Long Id){
        return entityManager.find(Product.class, Id);
    }

    @Transactional
    public void updateProduct(Product p){
        entityManager.merge(p);
    }

}
