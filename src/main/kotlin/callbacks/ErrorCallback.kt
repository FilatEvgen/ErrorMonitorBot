package org.example.callbacks

import eu.vendeli.tgbot.TelegramBot
import eu.vendeli.tgbot.annotations.CommandHandler
import eu.vendeli.tgbot.api.media.sendDocument
import eu.vendeli.tgbot.api.message.message
import eu.vendeli.tgbot.types.User
import io.ktor.client.*
import org.example.CallbackRoutes.BUG_REPORT_ROUTE
import org.example.domain.ApiRepository
import org.example.domain.ApiRepositoryImpl

class ErrorCallback {
    private val _repository: ApiRepository = ApiRepositoryImpl(HttpClient())

    @CommandHandler.CallbackQuery([BUG_REPORT_ROUTE])
    suspend fun subscribeToBugReports(user: User, bot: TelegramBot) {
        _repository.handleErrorStreamSubscription(
            sendMessage = { msg -> message(msg).send(user, bot) },
            sendFile = { file -> sendDocument(file).send(user, bot) }
        )
    }
}