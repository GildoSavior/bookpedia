package com.plcoding.bookpedia.app

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.plcoding.bookpedia.book.presentation.book_list.BookListScreenRoot
import com.plcoding.bookpedia.book.presentation.book_list.BookListViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
@Preview
//fun App(engine: HttpClientEngine) {
fun App() {
   MaterialTheme {
       var navController = rememberNavController()

       NavHost(
           navController=navController,
           startDestination = Route.BookGraph,
       ) {
           navigation<Route.BookGraph>(
                startDestination = Route.BookList
           ) {
               composable<Route.BookList> {
                   val viewModel = koinViewModel<BookListViewModel>()

                   BookListScreenRoot(
                       viewModel = viewModel,
                       onBookClick = { book ->
                           navController.navigate(
                               Route.BookDetail(book.id)
                           )
                       }
                   )
               }

               composable<Route.BookDetail> { entry ->
                   run {
                       val args = entry.toRoute<Route.BookDetail>()

                       Box(
                           modifier = Modifier.fillMaxSize(),
                           contentAlignment = Alignment.Center
                       ) {
                           Text("Text Rout Id" + args.bookId)
                       }
                   }

               }
           }
       }
   }
}