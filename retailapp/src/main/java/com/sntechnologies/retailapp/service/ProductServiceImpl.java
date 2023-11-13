package com.sntechnologies.retailapp.service;
import java.util.List;
import java.util.Optional;
import com.sntechnologies.retailapp.entity.Product;
import com.sntechnologies.retailapp.exception.ProductNotFoundException;
import com.sntechnologies.retailapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    @CacheEvict(value = "retailapp",allEntries = true)
    public Product addProduct(Product product) {
        // TODO Auto-generated method stub
        return productRepository.save(product);

    }

    @Override
    public Product getProduct(Long productid) {
        Optional<Product> productresult = productRepository.findById(productid);
        if (productresult.isEmpty()) {
            throw new ProductNotFoundException("Product is not found exception for the given productid:" + productid);
        }
        return productresult.get();

    }
    @Override
    @Cacheable("retailapp")
    public List<Product> getListofProduct() {
        return productRepository.findAll(); // Corrected from ProductRepository.findAll()
    }

    @Override
   // @CachePut(value = "retailapp")
    @CacheEvict(value = "retailapp",allEntries = true)
    public Product updateProduct(Product product) {
        return productRepository.save(product);

    }

    @Override
    public List<Product> deleteProduct(long productid) {
        productRepository.deleteById(productid);
        List<Product> productListResult=productRepository.findAll();
        return productListResult;
    }

    @Override
    public List<Product> deleteAllProduct() {
        productRepository.deleteAll();
        List<Product> productList = productRepository.findAll();
        return productList;
    }


}


