package com.test.liteshop.repository.model

import lombok.*
import java.math.BigDecimal
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "product")

 data class Product (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
     val id: Long? = null,

    @ManyToOne
    @JoinColumn(name = "category_id",)
    var category: ProductCategory? = null,

    @Column(name = "sku")
     val sku: String? = null,

    @Column(name = "name")
     val name: String? = null,

    @Column(name = "description")
     val description: String? = null,

    @Column(name = "unit_price")
     val unitPrice: BigDecimal? = null,

    @Column(name = "image_url")
     val imageUrl: String? = null,

    @Column(name = "active")
     val active:Boolean = false,

    @Column(name = "units_in_stock")
     val unitsInStock:Int = 0,

    @Column(name = "date_created")
    @CreationTimestamp
     val dateCreated: Date? = null,

    @Column(name = "last_updated")
    @UpdateTimestamp
     val lastUpdated: Date? = null
)
