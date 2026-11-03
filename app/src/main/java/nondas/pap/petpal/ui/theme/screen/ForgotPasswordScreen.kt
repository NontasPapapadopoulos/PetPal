package nondas.pap.petpal.ui.theme.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import nondas.pap.petpal.R
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nondas.pap.petpal.BackButton
import nondas.pap.petpal.ui.theme.PetPalShapes
import nondas.pap.petpal.ui.theme.PetPalTheme


@Composable
fun ForgotPasswordScreen() {


}



@Composable
private fun ForgotPasswordContent() {

    Scaffold {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .padding(24.dp)
        ) {

            BackButton(onClick = {})

            Spacer(modifier = Modifier.height(24.dp))


            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.size(88.dp)
                    .background(
                        color = MaterialTheme.colorScheme.primaryContainer,
                        shape = PetPalShapes.large
                    )
            ) {
                Icon(
                    imageVector = Icons.Outlined.Lock,
                    tint = MaterialTheme.colorScheme.onPrimaryContainer,
                    contentDescription = null,
                    modifier = Modifier.size(40.dp)

                )
            }


            Spacer(modifier = Modifier.height(24.dp))


            Text(
                text = stringResource(R.string.forgot_your_password),
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(4.dp))


            Text(
                text = stringResource(R.string.forgot_your_password_subtitle),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(24.dp))


            Text(
                text = stringResource(R.string.email),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Start
            )

            Spacer(modifier = Modifier.height(4.dp))


            OutlinedTextField(
                value = "",
                onValueChange = {},
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email
                )
            )


            Spacer(modifier = Modifier.height(24.dp))


            Button(
                onClick = {},
                modifier = Modifier.fillMaxWidth()
                    .height(height = 54.dp),
                shape = PetPalShapes.medium
            ) {
                Text(
                    text = stringResource(R.string.send_reset_link)
                )
            }


        }

    }

}



@Preview
@Composable
private fun ForgotPasswordScreenPreview() {
    PetPalTheme {
        ForgotPasswordContent()
    }
}