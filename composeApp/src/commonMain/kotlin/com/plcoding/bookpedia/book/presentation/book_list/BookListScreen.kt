package com.plcoding.bookpedia.book.presentation.book_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.plcoding.bookpedia.book.domain.Book
import com.plcoding.bookpedia.book.presentation.book_list.components.BookSearchBar
import com.plcoding.bookpedia.core.presentation.DarkBlue
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun BookListScreenRoot(
    viewModel:BookListViewModel = koinViewModel(),
    onBookClick: (Book) -> Unit,
    modifier: Modifier = Modifier
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    BookListScreen(
        state = BookListState(),
        onAction = { action ->
            when(action) {
                is BookListAction.OnClick -> onBookClick(action.book)
                else -> Unit
            }

            viewModel.onEvent(action)
        }
    )
}


@Composable
fun BookListScreen(
    state: BookListState,
    onAction: (BookListAction) -> Unit,
) {
    val keyBoardController = LocalSoftwareKeyboardController.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBlue)
            .statusBarsPadding(),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BookSearchBar(
            searchQuery = state.searchQuery,
            onSearchQueryChange = {
                onAction(BookListAction.OnSearchQueryChange(it))
            },
            onImeSearch = {
                keyBoardController?.hide()
            },

            modifier = Modifier
                .widthIn(max = 400.dp)
                .fillMaxSize()
                .padding(16.dp)

        )
    }
}