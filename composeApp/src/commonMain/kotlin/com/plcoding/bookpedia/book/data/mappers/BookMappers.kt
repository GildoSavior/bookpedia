package com.plcoding.bookpedia.book.data.mappers

import com.plcoding.bookpedia.book.data.database.BookEntity
import com.plcoding.bookpedia.book.data.dto.SearchBookDto
import com.plcoding.bookpedia.book.domain.Book

fun SearchBookDto.toBook() : Book {
    return Book(
        id = id.substringAfterLast("/"),
        title = title,

        imageUrl = if (coverKey != null) {
            "https://covers.openlibrary.org/b/olid/${coverKey}-L.jpg"
        } else {
                "https://covers.openlibrary.org/b/id/${coverKey}-L.jpg"
        },
        authors = authorNames?: emptyList(),
        description = "",
        languages = languages?: emptyList(),
        firstPublishYear = firstPublishYear.toString(),
        ratingAverage = ratingAverage?: 0.0,
        ratingsCount = ratingCount?: 0.0,
        numPages = numPages,
        nunEditions = editionCount?: 0
    )
}

fun Book.toBookEntity(): BookEntity {
    return BookEntity(
        id = id,
        title = title,
        description = description,
        imageUrl = imageUrl,
        languages = languages,
        authors = authors,
        firstPublishYear = firstPublishYear,
        ratingAverage = ratingAverage,
        ratingCount = ratingsCount,
        editionCount = nunEditions,
        numberOfPages = numPages
        )
}