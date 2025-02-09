package com.plcoding.bookpedia.book.domain.repository

import com.plcoding.bookpedia.book.domain.Book
import com.plcoding.bookpedia.core.domain.DataError
import com.plcoding.bookpedia.core.domain.EmptyResult
import com.plcoding.bookpedia.core.domain.Result
import kotlinx.coroutines.flow.Flow

interface BookRepository {
    suspend fun searchBooks(query: String): Result<List<Book>?, DataError.Remote>
    suspend fun getBookDescription(bookId: String): Result<String?, DataError.Remote>

    fun getFavoritesBooks(): Flow<List<Book>>
    fun isBookFavorite(bookId: String): Flow<Boolean>
    suspend fun markAsFavorite(book: Book): EmptyResult<DataError.Local>
    suspend fun deleteFromFavorites(bookId: String)
}