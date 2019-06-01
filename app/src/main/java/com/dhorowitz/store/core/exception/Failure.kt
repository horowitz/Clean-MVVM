package com.dhorowitz.store.core.exception

sealed class Failure {
    object NetworkConnection : Failure()
    object ServerError : Failure()
}
