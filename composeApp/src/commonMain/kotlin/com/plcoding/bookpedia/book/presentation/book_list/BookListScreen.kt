package com.plcoding.bookpedia.book.presentation.book_list

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.plcoding.bookpedia.book.domain.Book
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun BookListScreenRoot(
    viewModel:BookListViewModel = koinViewModel(),
    onBookClick: (Book) -> Unit,
    modifier: Modifier = Modifier
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    BookListScreen(
        state = BookListState,
        onAction = { action ->
            when(action) {
                is BookListaAction.OnClick -> onBookClick(action.book)
                else -> Unit
            }

            viewModel.onEvent(action)
        }
    )
}


@Composable
fun BookListScreen(
    state: BookListState.Companion,
    onAction: (BookListaAction) -> Unit,
) {

}