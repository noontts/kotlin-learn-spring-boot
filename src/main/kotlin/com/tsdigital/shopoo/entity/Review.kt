package com.tsdigital.shopoo.entity

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.util.*

@Entity(name = "review")
data class Review(
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        var uuid: UUID,

        @CreationTimestamp
        @Column(name = "created_at", updatable = false)
        var createdAt: Date,

        @UpdateTimestamp
        @Column(name = "updated_at")
        var updatedAt: Date,

        @Column(name = "is_delete", columnDefinition = "boolean default false")
        var isDelete: Boolean,
)