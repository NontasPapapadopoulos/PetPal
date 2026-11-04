package nondas.pap.petpal.ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import nondas.pap.petpal.ui.theme.PetPalShapes

@Composable
fun ChoiceItem(
    choice: String,
    isSelected: Boolean,
    modifier: Modifier = Modifier
) {
    val color = if (isSelected) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onBackground
    val backgroundColor = if (!isSelected) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onBackground
    val borderColor = if (isSelected) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.2f)
    Text(
        text = choice,
        color = color,
        style = MaterialTheme.typography.bodySmall,
        modifier = modifier
            .padding(horizontal = 2.dp, vertical = 4.dp)
            .background(color = backgroundColor, shape = PetPalShapes.large)
            .border(width = if (isSelected) 0.dp else 1.dp, color = borderColor, shape = PetPalShapes.large)
            .padding(vertical = 8.dp, horizontal = 12.dp)
    )
}