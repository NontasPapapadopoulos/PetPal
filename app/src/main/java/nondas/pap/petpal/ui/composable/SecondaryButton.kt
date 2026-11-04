package nondas.pap.petpal.ui.composable

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp


@Composable
fun SecondaryButton(
    onClick: () -> Unit,
    text: String,
    icon: @Composable () -> Unit
) {
    OutlinedButton(
        onClick = onClick,
        modifier = Modifier
            .height(54.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(14.dp),
        border = BorderStroke(width = 1.dp, color = MaterialTheme.colorScheme.outlineVariant)

    ) {

        icon()

        Text(
            text = text,
            style = MaterialTheme.typography.labelLarge,
            fontWeight = FontWeight.SemiBold
        )
    }
}


@Composable
fun GoogleIcon() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.border(
            border = BorderStroke(
                2.dp,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            ),
            shape = CircleShape
        )
            .size(24.dp)
    ) {
        Text(
            text = "G",
        )
    }

    Spacer(modifier = Modifier.width(8.dp))
}