package org.example.controllers

import eu.vendeli.tgbot.TelegramBot
import eu.vendeli.tgbot.annotations.CommandHandler
import eu.vendeli.tgbot.api.message.message
import eu.vendeli.tgbot.types.User
import org.example.common.titleListCommands
import org.example.controllers.Commands.HELP
import org.example.controllers.Commands.commandsList

class HelpController {
    @CommandHandler([HELP])
    suspend fun help(user: User, bot: TelegramBot) {
        val message = createListOfCommandsMessage()
        message(message).send(user, bot)
    }
    private fun createListOfCommandsMessage(): String {
        var message = titleListCommands
        commandsList.forEach { command -> message += "\n$command" }
        return message
    }
}
