package nondas.pap.petpal.ui.composable

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import nondas.pap.petpal.R
import nondas.pap.petpal.ui.theme.PetPalShapes


@Composable
fun PrimaryButton(
    onClick: () -> Unit,
    text: String,
) {
    Button(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth()
            .height(height = 54.dp),
        shape = PetPalShapes.medium
    ) {
        Text(
            text = text
        )
    }
}