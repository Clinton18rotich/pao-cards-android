package com.example.paocards.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.paocards.data.CARD_DATA
import com.example.paocards.ui.theme.*

@Composable
fun FlashcardsScreen() {
    var current by remember { mutableStateOf(CARD_DATA.random()) }
    var revealed by remember { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxSize().background(DarkBg).padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Card(modifier = Modifier.fillMaxWidth().height(350.dp), colors = CardDefaults.cardColors(containerColor = DarkSurface)) {
            Column(modifier = Modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                Text(current.emoji, fontSize = 80.sp)
                Text("${current.rank} of ${current.suit}", color = Orange, fontSize = 32.sp, fontWeight = FontWeight.Bold)
                Spacer(Modifier.height(16.dp))
                if (!revealed) { Button(onClick = { revealed = true }, colors = ButtonDefaults.buttonColors(containerColor = Orange, contentColor = Color.Black)) { Text("Reveal PAO") } } else {
                    Text(current.person, color = White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    Text(current.action, color = LightGrey, fontSize = 16.sp)
                    Text(current.objectName, color = LightGrey, fontSize = 16.sp)
                }
            }
        }
        Spacer(Modifier.height(16.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(onClick = { current = CARD_DATA.random(); revealed = false }, modifier = Modifier.weight(1f), colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF555555))) { Text("🎲 Random") }
            Button(onClick = { val idx = (CARD_DATA.indexOf(current) + 1) % CARD_DATA.size; current = CARD_DATA[idx]; revealed = false }, modifier = Modifier.weight(1f), colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF555555))) { Text("➡️ Next") }
        }
    }
}
