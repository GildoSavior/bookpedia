package com.plcoding.bookpedia

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.plcoding.bookpedia.book.data.network.KtorRemoteBookDataSource
import com.plcoding.bookpedia.book.data.repository.DefaultBookRepository
import com.plcoding.bookpedia.book.domain.repository.BookRepository
import com.plcoding.bookpedia.book.presentation.book_list.BookListScreenRoot
import com.plcoding.bookpedia.book.presentation.book_list.BookListViewModel
import com.plcoding.bookpedia.core.data.HttpClientFactory
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App(engine: HttpClientEngine) {
   Box() {
       BookListScreenRoot(
           viewModel =
           remember { BookListViewModel(
               bookRepository = DefaultBookRepository(
                   remoteBookDataSource = KtorRemoteBookDataSource(
                        httpClient = HttpClientFactory.create(
                            engine = HttpClient().engine
                        )
                   )
               )
           ) },
           onBookClick = {}
       )
   }
}