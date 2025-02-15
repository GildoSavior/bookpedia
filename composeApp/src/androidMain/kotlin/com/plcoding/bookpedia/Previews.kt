package com.plcoding.bookpedia;


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.plcoding.bookpedia.book.domain.Book
import com.plcoding.bookpedia.book.presentation.book_list.BookListScreen
import com.plcoding.bookpedia.book.presentation.book_list.BookListState

import com.plcoding.bookpedia.book.presentation.book_list.components.BookSearchBar

@Preview
@Composable
private fun BookSearchBarPreview() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {
        BookSearchBar(
            searchQuery = "Kotlin",
            onSearchQueryChange = {},
            onImeSearch = {},
            modifier = Modifier.fillMaxWidth()
        )
    }
}




@Preview
@Composable
private fun BookListScreenPreview() {
    BookListScreen(
        state = BookListState(searchResults = books),
        onAction = {}
    )
}



val books = (1  ..  100).map {
    Book(
        id = it.toString(),
        title = "Book $it",
        imageUrl = "http://test.com",
        authors = listOf("Author $it"),
        description = "Description $it",
        languages = emptyList(),
        firstPublishYear = null,
        ratingAverage = 4.343,
        ratingCount = 5.5,
        numberOfPages = 100,
        editionCount = 3
    )
}