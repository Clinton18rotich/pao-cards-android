package com.example.paocards

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.paocards.ui.navigation.CardNavGraph
import com.example.paocards.ui.theme.PAOTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PAOTheme {
                CardNavGraph()
            }
        }
    }
}
