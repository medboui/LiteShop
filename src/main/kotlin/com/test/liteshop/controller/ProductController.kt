package com.test.liteshop.controller

import com.test.liteshop.repository.model.Product
import com.test.liteshop.service.ProductService
import org.springframework.web.bind.annotation.*

@RestController
class ProductController(private val productService: ProductService) {

    @GetMapping("/products")
    fun getAllProducts(): List<Product> = productService.getProducts()

    @GetMapping("/products/{id}")
    fun getProductsById(@PathVariable("id") employeeId: Long): Product =
        productService.getProductsById(employeeId)

    @PostMapping("/products")
    fun createProduct(@RequestBody payload: Product): Product = productService.createProduct(payload)

    @PutMapping("/products/{id}")
    fun updateProductById(@PathVariable("id") employeeId: Long, @RequestBody payload: Product): Product =
        productService.updateProductById(employeeId, payload)

    @DeleteMapping("/products/{id}")
    fun deleteProductsById(@PathVariable("id") employeeId: Long): Unit =
        productService.deleteProductsById(employeeId)

}
