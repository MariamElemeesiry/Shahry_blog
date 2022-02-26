package com.example.shahry_blog.domain.entities

import com.example.shahry_blog.presentation.models.Address


data class AddressDomain(val latitude: Double, val longitude: Double)

fun AddressDomain.mapToPresentation() = Address(latitude, longitude)
