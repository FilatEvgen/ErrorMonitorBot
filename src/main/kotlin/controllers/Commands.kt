package org.example.controllers

object Commands {
    const val START = "/start"
    const val HELP = "/help"
    const val TOP_EVENTS = "/top_events"
    val commandsList = listOf(
        "$HELP - список доступных команд",
        "$START - запустить бота",
        "$TOP_EVENTS - получить топ 10 поисковых запросов"
    )
}