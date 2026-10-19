package com.example.paocards.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.paocards.data.CARD_DATA
import com.example.paocards.ui.theme.*
import kotlinx.coroutines.delay

@Composable
fun PracticeScreen() {
    var activeTab by remember { mutableStateOf("PAO") } // PAO or Championship

    Column(modifier = Modifier.fillMaxSize().background(DarkBg).padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(onClick = { activeTab = "PAO" }, modifier = Modifier.weight(1f), colors = ButtonDefaults.buttonColors(containerColor = if (activeTab == "PAO") Orange else DarkSurface)) {
                Text("3-Card PAO", color = if (activeTab == "PAO") Color.Black else White)
            }
            Button(onClick = { activeTab = "Champ" }, modifier = Modifier.weight(1f), colors = ButtonDefaults.buttonColors(containerColor = if (activeTab == "Champ") Orange else DarkSurface)) {
                Text("Championship", color = if (activeTab == "Champ") Color.Black else White)
            }
        }
        Spacer(Modifier.height(16.dp))

        if (activeTab == "PAO") {
            CardPAOPractice()
        } else {
            CardChampionship()
        }
    }
}

@Composable
fun CardPAOPractice() {
    var cards by remember { mutableStateOf(List(3) { CARD_DATA.random() }) }
    var revealed by remember { mutableStateOf(false) }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Link the 3 Cards (P-A-O)", color = LightGrey, fontSize = 14.sp)
        Spacer(Modifier.height(16.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            cards.forEachIndexed { index, card ->
                Card(modifier = Modifier.weight(1f).height(180.dp), colors = CardDefaults.cardColors(containerColor = DarkSurface)) {
                    Column(modifier = Modifier.fillMaxSize().padding(8.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                        Text(card.card, color = Orange, fontSize = 24.sp, fontWeight = FontWeight.Bold)
                        Spacer(Modifier.height(4.dp))
                        val label = when(index) { 0 -> "PERSON"; 1 -> "ACTION"; else -> "OBJECT" }
                        Text(label, color = Green, fontSize = 10.sp, fontWeight = FontWeight.Bold)
                        if (revealed) {
                            val value = when(index) { 0 -> card.person; 1 -> card.action; else -> card.objectName }
                            Text(value, color = White, fontSize = 12.sp, maxLines = 2, textAlign = TextAlign.Center)
                        } else {
                            Text("???", color = LightGrey, fontSize = 14.sp)
                        }
                    }
                }
            }
        }
        Spacer(Modifier.height(16.dp))
        Button(onClick = { revealed = !revealed }, modifier = Modifier.fillMaxWidth(), colors = ButtonDefaults.buttonColors(containerColor = Orange, contentColor = Color.Black)) {
            Text(if (revealed) "Hide Story" else "Reveal Story")
        }
        if (revealed) {
            Spacer(Modifier.height(16.dp))
            Column(modifier = Modifier.fillMaxWidth().background(DarkSurface, RoundedCornerShape(10.dp)).padding(16.dp)) {
                Text("Imagine ${cards[0].person} is ${cards[1].action} a ${cards[2].objectName}.", color = White, fontSize = 16.sp, fontWeight = FontWeight.Medium)
            }
        }
        Spacer(Modifier.height(16.dp))
        Button(onClick = { cards = List(3) { CARD_DATA.random() }; revealed = false }, modifier = Modifier.fillMaxWidth(), colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF555555))) {
            Text("🎲 Shuffle")
        }
    }
}

@Composable
fun CardChampionship() {
    var gameState by remember { mutableStateOf("setup") }
    var targetDeck by remember { mutableStateOf(listOf<String>()) }
    var userInput by remember { mutableStateOf("") }
    var timeLeft by remember { mutableStateOf(300) } // 5 minutes
    var resultMessage by remember { mutableStateOf("") }

    LaunchedEffect(gameState) {
        if (gameState == "memorizing") {
            timeLeft = 300
            while (timeLeft > 0 && gameState == "memorizing") {
                delay(1000L)
                timeLeft--
            }
            if (gameState == "memorizing") {
                gameState = "recall"
            }
        }
    }

    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth().verticalScroll(rememberScrollState())) {
        if (gameState == "setup") {
            Text("Speed Cards Championship", color = Orange, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Spacer(Modifier.height(8.dp))
            Text("Memorize a full deck of 52 cards in 5 minutes. Then recall them.", color = LightGrey, fontSize = 12.sp, textAlign = TextAlign.Center)
            Spacer(Modifier.height(24.dp))
            Button(onClick = {
                targetDeck = CARD_DATA.shuffled().map { it.card }
                userInput = ""
                resultMessage = ""
                timeLeft = 300
                gameState = "memorizing"
            }, colors = ButtonDefaults.buttonColors(containerColor = Green), modifier = Modifier.fillMaxWidth()) {
                Text("Start Memorizing")
            }
        } else if (gameState == "memorizing") {
            Text(String.format("⏱️ %02d:%02d left", timeLeft / 60, timeLeft % 60), color = Red, fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Spacer(Modifier.height(16.dp))
            Box(modifier = Modifier.fillMaxWidth().height(300.dp).background(DarkSurface, RoundedCornerShape(10.dp)).padding(16.dp)) {
                Text(targetDeck.joinToString(" → "), color = Orange, fontSize = 14.sp, fontWeight = FontWeight.Bold, modifier = Modifier.verticalScroll(rememberScrollState()))
            }
            Spacer(Modifier.height(16.dp))
            Button(onClick = { gameState = "recall" }, colors = ButtonDefaults.buttonColors(containerColor = Orange, contentColor = Color.Black), modifier = Modifier.fillMaxWidth()) {
                Text("I'm Ready (Skip Timer)")
            }
        } else if (gameState == "recall") {
            Text("Recall the deck (e.g., A♥, 2♦, K♣)", color = Orange, fontSize = 16.sp, fontWeight = FontWeight.Bold)
            Spacer(Modifier.height(16.dp))
            OutlinedTextField(
                value = userInput,
                onValueChange = { userInput = it },
                label = { Text("Type the cards in order") },
                modifier = Modifier.fillMaxWidth().height(150.dp),
                colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = Orange, focusedTextColor = White)
            )
            Spacer(Modifier.height(16.dp))
            Button(onClick = {
                resultMessage = if (userInput.trim().equals(targetDeck.joinToString(", "), ignoreCase = true)) {
                    "✅ Perfect!"
                } else {
                    "❌ Incorrect. Correct: ${targetDeck.joinToString(", ")}"
                }
                gameState = "results"
            }, colors = ButtonDefaults.buttonColors(containerColor = Green), modifier = Modifier.fillMaxWidth()) {
                Text("Check Answer")
            }
        } else if (gameState == "results") {
            Text(resultMessage, color = if (resultMessage.startsWith("✅")) Green else Red, fontSize = 16.sp, textAlign = TextAlign.Center)
            Spacer(Modifier.height(16.dp))
            Button(onClick = { gameState = "setup" }, colors = ButtonDefaults.buttonColors(containerColor = Orange, contentColor = Color.Black), modifier = Modifier.fillMaxWidth()) {
                Text("Try Again")
            }
        }
    }
}
