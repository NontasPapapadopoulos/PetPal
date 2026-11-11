package nondas.pap.petpal.ui.screen

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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import kotlinx.coroutines.flow.collectLatest
import nondas.pap.petpal.presentation.ForgotPasswordViewmodel
import nondas.pap.petpal.ui.composable.BackButton
import nondas.pap.petpal.ui.composable.Field
import nondas.pap.petpal.ui.composable.FieldLabel
import nondas.pap.petpal.ui.composable.PrimaryButton
import nondas.pap.petpal.ui.theme.PetPalShapes
import nondas.pap.petpal.ui.theme.PetPalTheme


@Composable
fun ForgotPasswordScreen(
    navigateToLoginScreen: () -> Unit,
    navigateToResetPasswordScreen: () -> Unit,
    viewModel: ForgotPasswordViewmodel = hiltViewModel()
) {

    LaunchedEffect(Unit) {
        viewModel.navigationFlow.collectLatest {
            navigateToResetPasswordScreen()
        }
    }

    val snackBarHostState = remember { SnackbarHostState() }


    LaunchedEffect(Unit) {
        viewModel.messageFlow.collect { message ->
            snackBarHostState.showSnackbar(message)
        }
    }


    ForgotPasswordContent(
        onSendLinkButtonClicked = { viewModel.onSendResetLink(it) },
        onBackButtonClicked = navigateToLoginScreen,
        snackBarHost = { SnackbarHost(snackBarHostState) }
    )
}



@Composable
private fun ForgotPasswordContent(
    onSendLinkButtonClicked: (String) -> Unit,
    onBackButtonClicked: () -> Unit,
    snackBarHost: @Composable () -> Unit
) {

    var email by remember { mutableStateOf("") }

    Scaffold(
        snackbarHost = {
            snackBarHost()
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .padding(24.dp)
        ) {

            BackButton(onClick = onBackButtonClicked)

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


            FieldLabel(
                text = stringResource(R.string.email),
            )

            Field(
                value = email,
                onValueChange = { email = it },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email
                ),
                placeholder = "johnDoe@gmail.com"
            )


            Spacer(modifier = Modifier.height(24.dp))

            PrimaryButton(
                onClick = { onSendLinkButtonClicked(email) },
                text = stringResource(R.string.send_reset_link),
                enabled = email.isNotEmpty()
            )

        }

    }

}



@Preview
@Composable
private fun ForgotPasswordScreenPreview() {
    PetPalTheme {
        ForgotPasswordContent(
            onBackButtonClicked = {},
            onSendLinkButtonClicked = {},
            snackBarHost = {}
        )
    }
}