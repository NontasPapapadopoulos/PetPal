package nondas.pap.petpal.ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import nondas.pap.petpal.ui.screen.darken
import nondas.pap.petpal.ui.theme.PetPalShapes

@Composable
fun Badge(
    text: String,
    size: Int = 56
) {
    val badgeColors = listOf(
        Color(0xFF4285F4),
        Color(0xFFEA4335),
        Color(0xFFFBBC04),
        Color(0xFF34A853),
    )

    val randomColor = remember { badgeColors.random() }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(size.dp)
            .background(
                color = randomColor.copy(alpha = 0.3f),
                shape = PetPalShapes.medium
            )
    ) {
        Text(
            text = text[0].toString().uppercase(),
            fontWeight = FontWeight.ExtraBold,
            style = MaterialTheme.typography.titleLarge,
            color = randomColor.darken(0.6f)

        )
    }
}