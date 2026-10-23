package com.example.paocards.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import coil.compose.SubcomposeAsyncImage
import com.example.paocards.data.CardEntry

@Composable
fun CardImage(imageName: String, modifier: Modifier = Modifier) {
    SubcomposeAsyncImage(
        model = "file:///android_asset/cards/$imageName.png",
        contentDescription = imageName,
        modifier = modifier,
        loading = {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }
    )
}

@Composable
fun PersonImage(card: CardEntry, modifier: Modifier = Modifier) {
    if (card.personImage != null) {
        SubcomposeAsyncImage(
            model = "file:///android_asset/people/${card.personImage}",
            contentDescription = card.person,
            modifier = modifier,
            loading = {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            }
        )
    }
}
