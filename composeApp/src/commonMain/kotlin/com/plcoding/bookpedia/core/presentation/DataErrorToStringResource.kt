package com.plcoding.bookpedia.core.presentation

import cmp_bookpedia.composeapp.generated.resources.Res
import cmp_bookpedia.composeapp.generated.resources.dis_full
import cmp_bookpedia.composeapp.generated.resources.generic_error
import cmp_bookpedia.composeapp.generated.resources.no_internet_connection
import cmp_bookpedia.composeapp.generated.resources.request_timeout
import cmp_bookpedia.composeapp.generated.resources.serialization_error
import cmp_bookpedia.composeapp.generated.resources.server_unavailable
import cmp_bookpedia.composeapp.generated.resources.too_many_requests
import cmp_bookpedia.composeapp.generated.resources.unknown_error
import com.plcoding.bookpedia.core.domain.DataError

fun DataError.toUiText(): UiText {

    val stringRes = when(this) {
        DataError.Local.DISK_FULL -> Res.string.dis_full
        DataError.Local.UNKNOWN_ERROR -> Res.string.unknown_error
        DataError.Remote.UNKNOWN_ERROR -> Res.string.unknown_error
        DataError.Remote.SERIALIZATION_ERROR -> Res.string.serialization_error
        DataError.Remote.REQUEST_TIMEOUT -> Res.string.request_timeout
        DataError.Remote.TOO_MANY_REQUESTS -> Res.string.too_many_requests
        DataError.Remote.NO_INTERNET_CONNECTION -> Res.string.no_internet_connection
        DataError.Remote.SERVER_UNAVAILABLE -> Res.string.server_unavailable
        else -> Res.string.generic_error
    }

    return UiText.StringResourceId(stringRes)
}