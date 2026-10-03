package com.example.healthchatbot

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.healthchatbot.ui.ChatScreen
import com.example.healthchatbot.ui.ChatViewModel

class MainActivity : ComponentActivity() {

    private val viewModel: ChatViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            val messages = viewModel.messages

            ChatScreen(
                messages = messages.collectAsState().value,
                onSendMessage = {
                    viewModel.sendMessage(it)
                }
            )
        }
    }
}
