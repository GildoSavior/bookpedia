package com.plcoding.bookpedia.book.presentation.book_list

import com.plcoding.bookpedia.book.domain.Book

sealed interface BookListaAction {
    data class OnSearchQueryChange(val query: String) : BookListaAction
    data class OnClick(val book: Book) : BookListaAction
    data class OnTabSelected(val index: Int) : BookListaAction

}