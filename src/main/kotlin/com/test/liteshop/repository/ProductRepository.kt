package com.test.liteshop.repository



import com.test.liteshop.repository.model.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface ProductRepository : JpaRepository<Product, Long?> {
    //fun findByCategoryId(@RequestParam("id") id: Long?, pageable: Pageable?): Page<Product?>?
   // fun findByNameContaining(@RequestParam("name") name: String?, pageable: Pageable?): Page<Product?>?

    //fun findByNameContaining(courseName : String) : List<Product>

   // @Query(value = "SELECT * FROM COURSES where name like %?1%", nativeQuery = true)
    //fun findProductsByName(courseName : String) : List<Product>
}
