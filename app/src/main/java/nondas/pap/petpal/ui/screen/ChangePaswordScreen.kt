package nondas.pap.petpal.ui.screen

import androidx.compose.foundation.border
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.outlined.Circle
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
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
import nondas.pap.petpal.ui.composable.Field
import nondas.pap.petpal.ui.composable.FieldLabel
import nondas.pap.petpal.ui.composable.PrimaryButton
import nondas.pap.petpal.ui.theme.PetPalShapes
import nondas.pap.petpal.ui.theme.PetPalTheme


@Composable
fun ChangePasswordScreen() {


}



@Composable
private fun ChangePasswordScreenContent() {

    Scaffold {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .padding(24.dp)
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                BackButton(onClick = {})

                Spacer(modifier = Modifier.width(16.dp))

                Text(
                    text = stringResource(R.string.change_password),
                    style = MaterialTheme.typography.headlineMedium
                )

            }

            Spacer(modifier = Modifier.height(24.dp))


            Text(
                text = stringResource(R.string.change_password_subtitle),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(24.dp))


            FieldLabel(
                text = stringResource(R.string.current_password),
            )


            Field(
                value = "",
                onValueChange = {},
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password
                ),
                placeholder = stringResource(R.string.current_password)
            )

            HorizontalDivider(
                modifier = Modifier.padding(vertical = 16.dp)
            )


            FieldLabel(
                text = stringResource(R.string.new_password),
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
                text = stringResource(R.string.confirm_new_password),
            )

            Spacer(modifier = Modifier.height(4.dp))



            Field(
                value = "",
                onValueChange = {},
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password
                ),
                placeholder = stringResource(R.string.repeat_password)
            )


            Spacer(modifier = Modifier.height(24.dp))


            Column (
                modifier = Modifier.fillMaxWidth()
                    .border(
                        width = 1.dp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant.copy(0.2f),
                        shape = PetPalShapes.large

                    )
            ) {
                Text(
                    text = stringResource(R.string.password_needs),
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                )

                PasswordRule(
                    text = stringResource(R.string.at_least_eight),
                    isSatisfied = true
                )

                PasswordRule(
                    text = stringResource(R.string.one_number),
                    isSatisfied = false
                )

                PasswordRule(
                    text = stringResource(R.string.different_from_current),
                    isSatisfied = false
                )

            }


            Spacer(modifier = Modifier.weight(1f))


            PrimaryButton(
                onClick = {},
                text = stringResource(R.string.update_password)
            )

        }

    }

}

@Composable
private fun PasswordRule(
    text: String,
    isSatisfied: Boolean
) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        val color = if (isSatisfied) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant

        Icon(
            imageVector = if (isSatisfied) Icons.Default.Check else Icons.Outlined.Circle,
            tint = color,
            contentDescription = null
        )

        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = text,
            color = color,
            style = MaterialTheme.typography.bodyMedium
        )
    }




}



@Preview
@Composable
private fun ChangePasswordScreenContentPreview() {
    PetPalTheme() {
        ChangePasswordScreenContent()
    }
}