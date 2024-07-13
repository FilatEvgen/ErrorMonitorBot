package org.example.controllers

import eu.vendeli.tgbot.TelegramBot
import eu.vendeli.tgbot.annotations.CommandHandler
import eu.vendeli.tgbot.api.message.message
import eu.vendeli.tgbot.types.User
import org.example.common.titleListEvents
import org.example.controllers.Commands.TOP_EVENTS
import org.example.controllers.Commands.commandsList

class EventController {
    @CommandHandler([TOP_EVENTS])
    suspend fun topSearchQuery(user: User, bot: TelegramBot) {
        val message = createListOfEvent()
        message(message).send(user, bot)
    }

    private fun createListOfEvent(): String {
        var message = titleListEvents
        commandsList.forEach { command -> message += "\n$command" }
        return message
    }
}