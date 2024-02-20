package com.tsdigital.shopoo.repository

import com.tsdigital.shopoo.entity.Review
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface ReviewRepository: JpaRepository<Review, UUID> {
}