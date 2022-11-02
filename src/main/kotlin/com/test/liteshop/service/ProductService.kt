package com.test.liteshop.service

import com.test.liteshop.exception.ProductNotFoundException
import com.test.liteshop.repository.ProductCategoryRepository
import com.test.liteshop.repository.ProductRepository
import com.test.liteshop.repository.model.Product
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service

@Service
class ProductService( private val productRepository: ProductRepository,private val catRepository: ProductCategoryRepository) {
    fun addProduct(productDTO: Product){

    }

    fun getProducts(): List<Product> = productRepository.findAll()


    fun getProductsById(employeeId: Long): Product = productRepository.findById(employeeId)
        .orElseThrow { ProductNotFoundException(HttpStatus.NOT_FOUND, "No matching product was found") }
    
    fun createProduct(product: Product): Product {
         val cat =catRepository.findById(product.category?.id!!).get()
         product.category=cat
    return productRepository.save(product)
    }

    fun updateProductById(employeeId: Long, product: Product): Product {
        return if (productRepository.existsById(employeeId)) {
            productRepository.save(
                Product(
                    id = product.id,
                    active = product.active,
                    name = product.name,
                    unitPrice = product.unitPrice,
                    description = product.description,
                    dateCreated = product.dateCreated
                )
            )
        } else throw ProductNotFoundException(HttpStatus.NOT_FOUND, "No matching product was found")
    }


    fun deleteProductsById(employeeId: Long) {
        return if (productRepository.existsById(employeeId)) {
            productRepository.deleteById(employeeId)
        } else throw ProductNotFoundException(HttpStatus.NOT_FOUND, "No matching product was found")
    }


}
