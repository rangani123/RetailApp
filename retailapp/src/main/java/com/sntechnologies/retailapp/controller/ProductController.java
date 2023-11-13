package com.sntechnologies.retailapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.sntechnologies.retailapp.entity.Product;
import com.sntechnologies.retailapp.service.ProductService; // Import ProductService
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @Operation(summary = "Create a new product", tags = { "products", "post" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = Product.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })

    @PostMapping("/Product")
    public Product insertProduct(@Valid @RequestBody Product product) {
        Product productResult = productService.addProduct(product);
        return productResult;
    }
@Operation(summary = "Retreive product details using product id",tags = {"product","get","filter"})
    @GetMapping("/Product/{productid}")
    public Product getProduct(@PathVariable Long productid) {
        Product productResult = productService.getProduct(productid);
        return productResult;
    }
    @Operation(summary = "Retreive complete list of product details ",tags = {"product","get","filter"})
    @GetMapping("/Product")
    public List<Product> getListOfProduct() {
    List<Product> productListResult = productService.getListofProduct();
        return productListResult;
    }
    @Operation(summary = "Update a product",tags = {"products","put"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = Product.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })

    @PutMapping("/Product")
    public Product updateProduct(@RequestBody Product product) {
        Product productResult = productService.updateProduct(product);
        return productResult;
    }
    @Operation(summary = "Delete  product details using produtid ",tags = {"product","delete","filter"})
    @DeleteMapping("/Product/{productid}")
    public List<Product> deleteProduct(@PathVariable long productid) {
       List <Product> productListResult = productService.deleteProduct(productid);
        return productListResult;
    }
    @Operation(summary = "Delete All product details ",tags = {"product","delete","filter"})
    @DeleteMapping("/Product")
    public List<Product> deleteAllProduct() {
        List<Product> productListResult = productService.deleteAllProduct();
        return productListResult;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String ,String>handleValidation(MethodArgumentNotValidException ex){
    Map<String,String> ListOfError= new HashMap<>();
    ex.getBindingResult().getAllErrors().forEach(error -> {
    String fieldName=((FieldError)error).getField();
    String  errorMessage=error.getDefaultMessage();
    ListOfError.put(fieldName,errorMessage);
    });
    return ListOfError;
    }
}


