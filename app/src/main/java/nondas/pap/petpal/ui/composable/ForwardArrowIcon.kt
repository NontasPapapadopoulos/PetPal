package nondas.pap.petpal.ui.composable

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ForwardArrowIcon() {
    Icon(
        imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
        tint = MaterialTheme.colorScheme.onSurfaceVariant,
        contentDescription = null,
        modifier = Modifier.size(20.dp)
    )
}
