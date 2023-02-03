package com.microservice.product;


import com.microservice.product.entities.Product;
import com.microservice.product.repositories.ProductRepository;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/product")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResource {

    @Inject
    ProductRepository productRepository;

    @GET
    public List<Product> list() {
        return productRepository.listProduct();
    }

    @POST
    public Response add(Product p) {
        productRepository.createdProduct(p);
        return Response.ok().build();
    }

    @DELETE
    public Response delete(Product p) {
        productRepository.deleteProduct(p);
        return Response.ok().build();
    }


}
