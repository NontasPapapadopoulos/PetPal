package nondas.pap.petpal

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nondas.pap.petpal.ui.theme.PetPalTheme


@Composable
fun BackButton(
    onClick: () -> Unit
) {

    OutlinedButton(
        onClick = onClick,

        shape = RoundedCornerShape(24.dp)
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBackIosNew,
            contentDescription = null,
            modifier = Modifier.padding(vertical = 16.dp)
        )
    }

}





@Preview
@Composable
private fun BackButtonPreview() {
    PetPalTheme {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            BackButton(
                onClick = {}
            )
        }

    }
}