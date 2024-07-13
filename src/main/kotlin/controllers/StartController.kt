package org.example.controllers

import eu.vendeli.tgbot.TelegramBot
import eu.vendeli.tgbot.annotations.CommandHandler
import eu.vendeli.tgbot.api.message.message
import eu.vendeli.tgbot.types.User
import org.example.CallbackRoutes.BUG_REPORT_ROUTE
import org.example.common.gettingErrorButton
import org.example.common.welcomeMessage
import org.example.controllers.Commands.START

class StartController {
    @CommandHandler([START])
    suspend fun start(user: User, bot: TelegramBot) {
        message(welcomeMessage).inlineKeyboardMarkup { gettingErrorButton callback BUG_REPORT_ROUTE }.send(user,bot)
    }
}