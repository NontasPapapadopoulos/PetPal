package nondas.pap.petpal.ui.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nondas.pap.petpal.ui.theme.PetPalTheme


@Composable
fun Field(
    value: String,
    onValueChange: () -> Unit,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    placeholder: String = "",
    modifier: Modifier = Modifier
) {

    OutlinedTextField(
        value = value,
        onValueChange = { onValueChange() },
        keyboardOptions = keyboardOptions,
        shape = RoundedCornerShape(14.dp),
        textStyle = MaterialTheme.typography.bodyMedium,
        placeholder = {
            if (placeholder.isNotEmpty())
                Text(
                    text = placeholder,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.6f),
                    fontWeight = FontWeight.W100
                )
        },
        colors = OutlinedTextFieldDefaults.colors().copy(
            focusedContainerColor = MaterialTheme.colorScheme.surfaceContainerLowest,
            unfocusedContainerColor = MaterialTheme.colorScheme.surfaceContainerLowest,
        ),
        modifier = modifier.fillMaxWidth()
            .height(52.dp),
    )

}

//colors = OutlinedTextFieldDefaults.colors().copy(
//focusedTextColor = MaterialTheme.colorScheme.primary,
//unf
//),


@Preview
@Composable
private fun FieldPreview() {
    PetPalTheme {
        Scaffold {
            Column(
                modifier = Modifier.padding(it)
                    .padding(24.dp)
            ) {
                Field(
                    value = "Hello World!",
                    onValueChange = {},
                )

                Spacer(modifier = Modifier.height(16.dp))

                Field(
                    value = "",
                    placeholder = "Hello World!",
                    onValueChange = {},
                )

            }

        }

    }
}