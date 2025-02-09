package com.plcoding.bookpedia.di

import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.plcoding.bookpedia.book.data.database.DatabaseFactory
import com.plcoding.bookpedia.book.data.database.FavoriteBookDatabase
import com.plcoding.bookpedia.book.data.network.KtorRemoteBookDataSource
import com.plcoding.bookpedia.book.data.network.RemoteBookDataSource
import com.plcoding.bookpedia.book.domain.repository.BookRepository
import com.plcoding.bookpedia.core.data.HttpClientFactory
import com.plcoding.bookpedia.book.data.repository.DefaultBookRepository
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import com.plcoding.bookpedia.book.presentation.book_list.BookListViewModel
import org.koin.core.module.Module
import org.koin.dsl.bind
import org.koin.dsl.module
import com.plcoding.bookpedia.book.presentation.SelectedBookViewModel
import com.plcoding.bookpedia.book.presentation.book_detail.BookDetailViewModel

expect val platformModule: Module

var sharedModule = module {
    single { HttpClientFactory.create(get()) }
    singleOf(::KtorRemoteBookDataSource).bind<RemoteBookDataSource>()
    singleOf(::DefaultBookRepository).bind<BookRepository>()

    single {
        get<DatabaseFactory>().create()
            .setDriver(BundledSQLiteDriver())
            .build()

    }

    single { get<FavoriteBookDatabase>().favoriteBookDao }

    viewModelOf(::BookListViewModel)
    viewModelOf(::SelectedBookViewModel)
    viewModelOf(::BookDetailViewModel)

}