package com.sntechnologies.retailapp.controller;


import com.sntechnologies.retailapp.entity.Supplier;
import com.sntechnologies.retailapp.service.SupplierService; // Import SupplierService
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SupplierController {
    @Autowired
    private SupplierService supplierService; // Autowire SupplierService
    @Operation(summary = "Create a new supplier",tags = {"suppliers","post"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = Supplier.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @PostMapping("/supplier") // Use lowercase for endpoint
   public Supplier insertSupplier ( @Valid  @RequestBody Supplier supplier) {
        Supplier supplierResult = supplierService.addSupplier(supplier);

        return supplierResult;
    }

}
