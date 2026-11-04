package nondas.pap.petpal.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Pets
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.flow.collectLatest
import nondas.pap.petpal.R
import nondas.pap.petpal.presentation.LoginViewModel
import nondas.pap.petpal.ui.composable.Field
import nondas.pap.petpal.ui.composable.FieldLabel
import nondas.pap.petpal.ui.composable.GoogleIcon
import nondas.pap.petpal.ui.composable.PrimaryButton
import nondas.pap.petpal.ui.composable.SecondaryButton
import nondas.pap.petpal.ui.theme.PetPalTheme


@Composable
fun LoginScreen(
    navigateToHome: () -> Unit,
    navigateToForgotPassword: () -> Unit,
    navigateToCreateAccount: () -> Unit,
    viewModel: LoginViewModel
) {

    LaunchedEffect(Unit) {
        viewModel.navigationFlow.collectLatest {
            navigateToHome()
        }
    }


    LoginContent(
        onLogin = { email, password -> viewModel.onLogin(email, password) },
        onForgotPasswordClicked = navigateToForgotPassword,
        onCreateAccountClicked = navigateToCreateAccount
    )
}


@Composable
private fun LoginContent(
    onLogin: (email: String, password: String) -> Unit,
    onForgotPasswordClicked: () -> Unit,
    onCreateAccountClicked: () -> Unit,
) {
    Scaffold {
        Column(
            modifier = Modifier.fillMaxSize()
                .padding(it)
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            var email by rememberSaveable { mutableStateOf("") }
            var password by rememberSaveable { mutableStateOf("") }

            Spacer(modifier = Modifier.height(56.dp))

            Icon(
                imageVector = Icons.Outlined.Pets,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.background,
                modifier = Modifier
                    .background(
                        color = MaterialTheme.colorScheme.primary,
                        shape = RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp, bottomEnd = 28.dp, bottomStart = 8.dp)
                    )
                    .padding(24.dp)
                    .size(48.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = stringResource(R.string.app_name),
                style = MaterialTheme.typography.headlineMedium,

            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = stringResource(R.string.sign_in_subtitle),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )


            Spacer(modifier = Modifier.height(24.dp))


            FieldLabel(
                text = stringResource(R.string.email)
            )

            Field(
                value = email,
                onValueChange = { email = it },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email
                ),
            )

            Spacer(modifier = Modifier.height(12.dp))

            FieldLabel(
                text = stringResource(R.string.password),
            )

            Field(
                value = password,
                onValueChange = { password = it },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password
                ),
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                TextButton(
                    onClick = onForgotPasswordClicked,
                    modifier = Modifier.padding(4.dp)
                ) {
                    Text(
                        text = stringResource(R.string.forgot_password),
                        style = MaterialTheme.typography.labelLarge
                    )
                }
            }


            Spacer(modifier = Modifier.height(24.dp))


            PrimaryButton(
                onClick = { onLogin(email, password) },
                text = stringResource(R.string.sign_in)
            )


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
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Spacer(modifier = Modifier.width(12.dp))


                HorizontalDivider(
                    modifier = Modifier.weight(1f),
                )

            }

            Spacer(modifier = Modifier.height(16.dp))


            SecondaryButton(
                onClick = {},
                text = stringResource(R.string.google_sign_in),
                icon = {
                    GoogleIcon()
                }
            )


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
                    onClick = onCreateAccountClicked
                ) {
                    Text(
                        text = stringResource(R.string.create_account),
                        style = MaterialTheme.typography.bodySmall

                    )
                }
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
        LoginContent(
            onLogin = { _, _ -> },
            onCreateAccountClicked = {},
            onForgotPasswordClicked = {}
        )
    }
}