package com.plcoding.bookpedia.book.presentation

import com.plcoding.bookpedia.book.domain.Book
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SelectedBookViewModel {
    private val _selectedBook = MutableStateFlow<Book?>(null)

    val selected = _selectedBook.asStateFlow()


    fun onSelectedBook(book: Book?) {

    }
}