package com.tsdigital.shopoo.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.util.Date
import java.util.UUID

@Entity(name = "product")
data class Product (
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        val uuid: UUID,
        var name: String,
        var description: String,
        var price: Double,

        @Column(name = "in_stock")
        var inStock: Int,

        @ManyToOne
        @JoinColumn(name = "merchant_id")
        val merchant: Merchant,

        @CreationTimestamp
        @Column(name = "created_at", updatable = false)
        val createdAt: Date,

        @UpdateTimestamp
        @Column(name = "updated_at")
        var updatedAt: Date,

        @Column(name = "is_delete", columnDefinition = "boolean default false")
        var isDelete: Boolean,
)