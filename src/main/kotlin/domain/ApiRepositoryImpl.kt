package org.example.domain

import eu.vendeli.tgbot.types.internal.ImplicitFile
import io.ktor.client.*

class ApiRepositoryImpl(private val client: HttpClient): ApiRepository {
    override suspend fun handleErrorStreamSubscription(
        sendMessage: suspend (String) -> Unit,
        sendFile: suspend (ImplicitFile) -> Unit
    ) {