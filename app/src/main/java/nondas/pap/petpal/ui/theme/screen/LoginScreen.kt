package nondas.pap.petpal.ui.theme.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Pets
import androidx.compose.material.icons.outlined.Pets
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nondas.pap.petpal.BackButton
import nondas.pap.petpal.R
import nondas.pap.petpal.ui.theme.PetPalShapes
import nondas.pap.petpal.ui.theme.PetPalTheme


@Composable
fun LoginScreen() {

}


@Composable
private fun LoginContent() {
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(56.dp))

        Icon(
            imageVector = Icons.Outlined.Pets,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.background,
            modifier = Modifier
                .background(
                    color = MaterialTheme.colorScheme.primary,
                    shape = RoundedCornerShape(topStart = 22.dp, topEnd = 22.dp, bottomEnd = 22.dp, bottomStart = 8.dp)
                )
                .padding(24.dp)
                .size(72.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = stringResource(R.string.welcome_back),
            style = MaterialTheme.typography.headlineMedium,

        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = stringResource(R.string.sign_in_subtitle),
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

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = stringResource(R.string.password),
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start
        )

        Spacer(modifier = Modifier.height(4.dp))

        OutlinedTextField(
            value = "",
            onValueChange = {},
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            TextButton(
                onClick = {},
                modifier = Modifier.padding(4.dp)
            ) {
                Text(
                    text = stringResource(R.string.forgot_password),
                    style = MaterialTheme.typography.labelLarge
                )
            }
        }


        Spacer(modifier = Modifier.height(24.dp))


        Button(
            onClick = {},
            modifier = Modifier.fillMaxWidth()
                .height(height = 54.dp),
            shape = PetPalShapes.medium
        ) {
            Text(
                text = stringResource(R.string.sign_in)
            )
        }


        Spacer(modifier = Modifier.height(16.dp))


        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            HorizontalDivider(modifier = Modifier.weight(1f))

            Spacer(modifier = Modifier.width(12.dp))

            Text(
                text = stringResource(R.string.or),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.outlineVariant
            )

            Spacer(modifier = Modifier.width(12.dp))


            HorizontalDivider(
                modifier = Modifier.weight(1f),
                color = MaterialTheme.colorScheme.outlineVariant
            )

        }

        Spacer(modifier = Modifier.height(16.dp))


        OutlinedButton(
            onClick = {},
            modifier = Modifier
                .height(56.dp)
                .fillMaxWidth(),
            shape = PetPalShapes.medium

        ) {

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

            Text(
                text = stringResource(R.string.google_sign_in),

            )
        }


        Spacer(modifier = Modifier.weight(1f))


        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {

            Text(
                text = stringResource(R.string.new_to_petpal),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.width(2.dp))

            TextButton(
                onClick = {}
            ) {
                Text(
                    text = stringResource(R.string.create_account),
                    style = MaterialTheme.typography.bodySmall

                )
            }
        }

        

    }
}



@Composable
@Preview
private fun LoginContentPreview() {
    PetPalTheme(
        darkTheme = false,
        dynamicColor = false
    ) {
        LoginContent()
    }
}