package com.plcoding.bookpedia.book.domain

data class Book(
    val id: String,
    val title: String,
    val imageUrl: String?,
    val authors: List<String>,
    val description: String?,
    val languages: List<String>,
    val firstPublishYear: String?,
    val ratingAverage: Double?,
    val ratingCount: Double?,
    val numberOfPages: Int?,
    val editionCount: Int?
)
