package com.plcoding.bookpedia.book.presentation.book_list

import com.plcoding.bookpedia.book.domain.Book
import com.plcoding.bookpedia.core.presentation.UiText

data class BookListState(

    val searchQuery: String = "kotlin",
    val searchResults: List<Book> = emptyList(),
    val favoriteBooks: List<Book> = emptyList(),
    val isLoading: Boolean = false,
    val selectedTabIndex: Int = 0,
    val errorMessage:UiText? = null,
)
//{
//    companion object {
//        val defaultState = BookListState()
//    }
//}


val books = (1  ..  100).map {
    Book(
        id = it.toString(),
        title = "Book $it",
        imageUrl = "http://test.com",
        authors = listOf("Author $it"),
        description = "Description $it",
        languages = emptyList(),
        firstPublishYear = null,
        averageRating = 4.343,
        ratingsCount = 5.5,
        numPages = 100,
        nunEditions = 3
    )
}