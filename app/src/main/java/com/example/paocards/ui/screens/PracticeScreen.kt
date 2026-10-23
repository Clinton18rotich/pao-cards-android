package com.example.paocards.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.unit.sp
import android.speech.tts.TextToSpeech
import androidx.compose.ui.platform.LocalContext
import java.util.Locale
import coil.compose.AsyncImage
import com.example.paocards.data.CARD_DATA
import com.example.paocards.data.CardEntry
import com.example.paocards.ui.theme.*
import kotlinx.coroutines.delay

@Composable
fun PracticeScreen() {
    var activeTab by remember { mutableStateOf("PAO") }

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
    val context = LocalContext.current
    var tts by remember { mutableStateOf<TextToSpeech?>(null) }
    
    LaunchedEffect(Unit) {
        tts = TextToSpeech(context) { status ->
            if (status == TextToSpeech.SUCCESS) {
                tts?.language = Locale.US
                tts?.setPitch(1.1f)
            }
        }
    }

    var cards by remember { mutableStateOf(List(3) { CARD_DATA.random() }) }
    var fullscreenCardIndex by remember { mutableStateOf(-1) }
    var revealed by remember { mutableStateOf(false) }

    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
        Text("Link the 3 Cards", color = LightGrey, fontSize = 14.sp)
        Spacer(Modifier.height(16.dp))
        
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.fillMaxWidth()) {
            cards.forEachIndexed { index, card ->
                Column(modifier = Modifier.weight(1f), horizontalAlignment = Alignment.CenterHorizontally) {
                    // Real Card Image
                    CardImage(
                        imageName = card.imageName,
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(0.7f)
                            .clip(RoundedCornerShape(8.dp))
                            .clickable { fullscreenCardIndex = index }
                    )
                    Spacer(Modifier.height(8.dp))
                    
                    // PAO Label & Text
                    val label = when(index) { 0 -> "PERSON"; 1 -> "ACTION"; else -> "OBJECT" }
                    Text(label, color = Green, fontSize = 10.sp, fontWeight = FontWeight.Bold)
                    if (revealed) {
                        if (index == 0 && card.personImage != null) {
                            AsyncImage(
                                model = "file:///android_asset/people/${card.personImage}",
                                contentDescription = card.person,
                                modifier = Modifier.fillMaxWidth().height(100.dp).clip(RoundedCornerShape(6.dp)).clickable { fullscreenCardIndex = index },
                                contentScale = ContentScale.Fit
                            )
                            Spacer(Modifier.height(4.dp))
                        }
                        val value = when(index) { 0 -> card.person; 1 -> card.action; else -> card.objectName }
                        Text(value, color = White, fontSize = 12.sp, maxLines = 3, textAlign = TextAlign.Center)
                    } else {
                        Text("???", color = LightGrey, fontSize = 14.sp)
                    }
                }
            }
        }
        
        Spacer(Modifier.height(24.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(onClick = { revealed = !revealed }, modifier = Modifier.weight(1f), colors = ButtonDefaults.buttonColors(containerColor = Orange, contentColor = Color.Black)) {
                Text(if (revealed) "Hide Story" else "Reveal Story")
            }
            Button(onClick = { 
                val rawObj = cards[2].objectName
                val cleanObj = if (rawObj.startsWith("a ", ignoreCase = true) || rawObj.startsWith("an ", ignoreCase = true)) rawObj else "a $rawObj"
                val story = "Imagine ${cards[0].person} is ${cards[1].action} $cleanObj."
                tts?.speak(story, TextToSpeech.QUEUE_FLUSH, null, null)
            }, modifier = Modifier.weight(1f), colors = ButtonDefaults.buttonColors(containerColor = Green, contentColor = Color.Black)) {
                Text("🔊 Speak")
            }
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
        
        // Fullscreen dialog
        if (fullscreenCardIndex >= 0) {
            Dialog(onDismissRequest = { fullscreenCardIndex = -1 }) {
                Box(
                    modifier = Modifier.fillMaxSize().background(Color.Black).clickable { fullscreenCardIndex = -1 },
                    contentAlignment = Alignment.Center
                ) {
                    AsyncImage(
                        model = "file:///android_asset/cards/${cards[fullscreenCardIndex].imageName}.png",
                        contentDescription = cards[fullscreenCardIndex].card,
                        modifier = Modifier.fillMaxSize().padding(16.dp),
                        contentScale = ContentScale.Fit
                    )
                }
            }
        }
    }
}

@Composable
fun CardChampionship() {
    var gameState by remember { mutableStateOf("setup") }
    var targetDeck by remember { mutableStateOf(listOf<CardEntry>()) }
    var userSequence by remember { mutableStateOf(listOf<CardEntry>()) }
    var timeLeft by remember { mutableStateOf(300) }
    var resultMessage by remember { mutableStateOf("") }
    var finalTime by remember { mutableStateOf(0) }

    LaunchedEffect(gameState) {
        if (gameState == "memorizing") {
            timeLeft = 300
            while (timeLeft > 0 && gameState == "memorizing") {
                delay(1000L)
                timeLeft--
            }
            if (gameState == "memorizing") gameState = "recall"
        }
    }

    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
        if (gameState == "setup") {
            Text("Speed Cards Championship", color = Orange, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Spacer(Modifier.height(8.dp))
            Text("Memorize a full deck of 52 cards. Then recall them by tapping.", color = LightGrey, fontSize = 12.sp, textAlign = TextAlign.Center)
            Spacer(Modifier.height(24.dp))
            Button(onClick = {
                targetDeck = CARD_DATA.shuffled()
                userSequence = emptyList()
                resultMessage = ""
                timeLeft = 300
                gameState = "memorizing"
            }, colors = ButtonDefaults.buttonColors(containerColor = Green), modifier = Modifier.fillMaxWidth()) {
                Text("Start Memorizing")
            }
        } else if (gameState == "memorizing") {
            Text(String.format("⏱️ %02d:%02d left", timeLeft / 60, timeLeft % 60), color = Red, fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Spacer(Modifier.height(8.dp))
            
            // Show all 52 cards as small thumbnails
            LazyVerticalGrid(columns = GridCells.Fixed(5), modifier = Modifier.weight(1f), horizontalArrangement = Arrangement.spacedBy(4.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                items(targetDeck) { card ->
                    CardImage(imageName = card.imageName, modifier = Modifier.fillMaxWidth().aspectRatio(0.7f))
                }
            }
            
            Spacer(Modifier.height(16.dp))
            Button(onClick = { finalTime = 300 - timeLeft; gameState = "recall" }, colors = ButtonDefaults.buttonColors(containerColor = Orange, contentColor = Color.Black), modifier = Modifier.fillMaxWidth()) {
                Text("I'm Ready")
            }
        } else if (gameState == "recall") {
            Text("Tap cards in the order you saw them", color = Orange, fontSize = 16.sp, fontWeight = FontWeight.Bold)
            Text("Tapped: ${userSequence.size} / 52", color = White, fontSize = 14.sp)
            
            // Show what the user has tapped so far
            Row(modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp), horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                userSequence.takeLast(5).forEach { 
                    Text(it.card, color = Green, fontSize = 14.sp, fontWeight = FontWeight.Bold)
                }
            }
            
            // The tap grid (52 cards shuffled so they don't memorize positions)
            val shuffledGrid = remember { CARD_DATA.shuffled() }
            LazyVerticalGrid(columns = GridCells.Fixed(5), modifier = Modifier.weight(1f), horizontalArrangement = Arrangement.spacedBy(4.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                items(shuffledGrid) { card ->
                    Box(modifier = Modifier.clickable {
                        if (userSequence.size < 52) {
                            userSequence = userSequence + card
                            if (userSequence.size == 52) gameState = "results"
                        }
                    }) {
                        CardImage(imageName = card.imageName, modifier = Modifier.fillMaxWidth().aspectRatio(0.7f))
                    }
                }
            }
            
            Spacer(Modifier.height(8.dp))
            Button(onClick = { userSequence = userSequence.dropLast(1) }, modifier = Modifier.fillMaxWidth(), colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF555555))) {
                Text("Undo Last Tap")
            }
        } else if (gameState == "results") {
            var correctCount = 0
            targetDeck.forEachIndexed { index, card ->
                if (index < userSequence.size && card.card == userSequence[index].card) correctCount++
            }
            
            Text("Results", color = Orange, fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Spacer(Modifier.height(16.dp))
            Text("Correct: $correctCount / 52", color = if (correctCount > 40) Green else Red, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Text("Time used: ${finalTime / 60}m ${finalTime % 60}s", color = White, fontSize = 16.sp)
            
            Spacer(Modifier.height(16.dp))
            Text("Your Sequence:", color = LightGrey, fontSize = 14.sp)
            
            // Scrollable detailed view
            androidx.compose.foundation.lazy.LazyColumn(modifier = Modifier.weight(1f).fillMaxWidth()) {
                itemsIndexed(targetDeck) { index, correctCard ->
                    val userCard = if (index < userSequence.size) userSequence[index] else null
                    val isCorrect = userCard?.card == correctCard.card
                    
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp).background(
                            if (isCorrect) Color(0xFF1E3A1E) else Color(0xFF3A1E1E),
                            androidx.compose.foundation.shape.RoundedCornerShape(4.dp)
                        ).padding(8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("#${index + 1}", color = LightGrey, fontSize = 14.sp)
                        Text(correctCard.card, color = Green, fontSize = 14.sp, fontWeight = FontWeight.Bold)
                        Text(userCard?.card ?: "?", color = if (isCorrect) Green else Red, fontSize = 14.sp)
                    }
                }
            }
            
            Spacer(Modifier.height(16.dp))
            Button(onClick = { gameState = "setup" }, colors = ButtonDefaults.buttonColors(containerColor = Orange, contentColor = Color.Black), modifier = Modifier.fillMaxWidth()) {
                Text("Try Again")
            }
        }
    }
}
