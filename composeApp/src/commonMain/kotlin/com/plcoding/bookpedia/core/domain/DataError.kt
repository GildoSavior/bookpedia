package com.plcoding.bookpedia.core.domain

sealed interface DataError : Error {
    enum class Remote : DataError {
        REQUEST_TIMEOUT,
        TOO_MANY_REQUESTS,
        SERVER_ERROR,
        UNKNOWN_ERROR,
        NO_INTERNET_CONNECTION,
        SERVER_UNAVAILABLE,
        SERIALIZATION_ERROR,
    }

    enum class Local: DataError {
        DISK_FULL,
        UNKNOWN_ERROR,
    }
}