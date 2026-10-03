package com.example.healthchatbot.ui

import androidx.lifecycle.ViewModel
import com.example.healthchatbot.data.model.ChatMessage
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ChatViewModel : ViewModel() {

    private val _messages = MutableStateFlow(
        listOf(
            ChatMessage(
                "Hello! I am your AI Health Assistant. How can I help you?",
                false
            )
        )
    )

    val messages = _messages.asStateFlow()

    fun sendMessage(message: String) {

        val updatedMessages =
            _messages.value.toMutableList()

        updatedMessages.add(
            ChatMessage(message, true)
        )

        updatedMessages.add(
            ChatMessage(
                generateResponse(message),
                false
            )
        )

        _messages.value = updatedMessages
    }

    private fun generateResponse(message: String): String {

        val text = message.lowercase()

        return when {
            "headache" in text ->
                "Headaches can have many causes such as dehydration, stress, lack of sleep, or other conditions. If your headache is severe, sudden, or persistent, consider consulting a healthcare professional."

            "fever" in text ->
                "Fever can occur for many reasons, including infections. Monitor your temperature and stay hydrated. Seek medical attention if the fever is severe or persistent."

            "water" in text ->
                "Staying hydrated is important for general health. Your fluid needs depend on factors such as activity, climate, and health conditions."

            "exercise" in text ->
                "Regular physical activity can support overall health. Choose activities appropriate for your fitness level and health condition."

            else ->
                "I can provide general health information, but I cannot diagnose medical conditions. Could you provide more details?"
        }
    }
}
