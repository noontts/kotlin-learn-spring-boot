package com.tsdigital.shopoo.entity

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import org.apache.logging.log4j.util.StringMap
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.util.*

@Entity(name = "merchant")
data class Merchant(
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        var uuid: UUID,

        @Column(name = "store_name")
        var storeName: String,

        @Column(name = "first_name")
        var firstName: String,

        @Column(name = "last_name")
        var lastName: String,

        @OneToMany(mappedBy = "merchant", cascade = [CascadeType.ALL], orphanRemoval = true)
        var product: MutableList<Product> = mutableListOf(),

        @CreationTimestamp
        @Column(name = "created_at", updatable = false)
        var createdAt: Date,

        @UpdateTimestamp
        @Column(name = "updated_at")
        var updatedAt: Date,

        @Column(name = "is_delete", columnDefinition = "boolean default false")
        var isDelete: Boolean,
)