package nondas.pap.petpal.ui.screen

import androidx.compose.foundation.layout.Arrangement
import nondas.pap.petpal.R
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nondas.pap.petpal.BackButton
import nondas.pap.petpal.ui.composable.Field
import nondas.pap.petpal.ui.composable.FieldLabel
import nondas.pap.petpal.ui.composable.GoogleIcon
import nondas.pap.petpal.ui.composable.PrimaryButton
import nondas.pap.petpal.ui.composable.SecondaryButton
import nondas.pap.petpal.ui.theme.PetPalShapes
import nondas.pap.petpal.ui.theme.PetPalTheme


@Composable
fun RegisterScreen() {


}



@Composable
private fun RegisterScreenContent() {

    Scaffold {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .padding(24.dp)
        ) {


            BackButton(onClick = {})

            Spacer(modifier = Modifier.height(24.dp))


            Text(
                text = stringResource(R.string.create_your_account),
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(4.dp))



            Text(
                text = stringResource(R.string.create_account_subtitle),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(24.dp))



            FieldLabel(
                text = stringResource(R.string.name),
            )


            Field(
                value = "",
                onValueChange = {},
                placeholder = stringResource(R.string.your_name)
            )

            Spacer(modifier = Modifier.height(16.dp))

            FieldLabel(
                text = stringResource(R.string.email),
            )

            Field(
                value = "",
                onValueChange = {},
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email
                ),
                placeholder = "johnDoe@gmail.com"
            )


            Spacer(modifier = Modifier.height(16.dp))


            FieldLabel(
                text = stringResource(R.string.password),
            )

            Field(
                value = "",
                onValueChange = {},
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password
                ),
                placeholder = stringResource(R.string.at_least_eight)
            )

            Spacer(modifier = Modifier.height(16.dp))


            FieldLabel(
                text = stringResource(R.string.confirm_password),
            )

            Field(
                value = "",
                onValueChange = {},
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password
                ),
                placeholder = stringResource(R.string.repeat_password)
            )

            Spacer(modifier = Modifier.weight(1f))



            PrimaryButton(
                onClick = {},
                text = stringResource(R.string.create_account)
            )

            Spacer(modifier = Modifier.height(16.dp))

            SecondaryButton(
                onClick = {},
                text = stringResource(R.string.google_sign_in),
                icon = {
                    GoogleIcon()
                }
            )


            Spacer(modifier = Modifier.height(24.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {

                Text(
                    text = stringResource(R.string.already_have_account),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Spacer(modifier = Modifier.width(2.dp))

                TextButton(
                    onClick = {}
                ) {
                    Text(
                        text = stringResource(R.string.sign_in),
                        style = MaterialTheme.typography.bodySmall

                    )
                }
            }
        }

    }

}



@Preview
@Composable
private fun RegisterScreenPreview() {
    PetPalTheme {
        RegisterScreenContent()
    }
}