package com.test.liteshop.repository.model

import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter
import javax.persistence.*

@Entity
@Table(name = "product_category")
data class ProductCategory (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
     val id: Long? = null,

    @Column(name = "category_name")
     val categoryName: String? = null,

    @OneToMany(cascade = [CascadeType.ALL], mappedBy = "category")
     val products: Set<Product>? = null
)
