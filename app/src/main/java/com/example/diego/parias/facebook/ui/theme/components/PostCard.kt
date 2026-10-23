package com.example.diego.parias.facebook.ui.theme.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun PostCard() {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        PostHeader(
            username = "Diego Parias",
            timeAgo = "Hace 2 h · 🌎"
        )
        Text(
            text = "Por fin terminé la pantalla de login de compose!",
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))
        AsyncImage(
            model = "https://images.unsplash.com/photo-1618005182384-a83a8bd57fbe?q=80&w=1000&auto=format&fit=crop",
            contentDescription = "Imagen de la publicación",
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(4.dp))
        PostStates(
            likesCount = 124,
            commentsCount = 15,
            sharesCount = 3
        )
        Spacer(modifier = Modifier.height(4.dp))
        PostActions()
    }
}

@Preview(showBackground = true)
@Composable
fun PostCardPreview() {
    PostCard()
}
