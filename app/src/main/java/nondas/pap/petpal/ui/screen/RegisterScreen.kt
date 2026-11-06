package nondas.pap.petpal.ui.screen

import nondas.pap.petpal.R
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.coroutines.flow.collectLatest
import nondas.pap.petpal.presentation.RegisterNavigationTarget
import nondas.pap.petpal.presentation.RegisterState
import nondas.pap.petpal.presentation.RegisterViewModel
import nondas.pap.petpal.ui.composable.BackButton
import nondas.pap.petpal.ui.composable.Field
import nondas.pap.petpal.ui.composable.FieldLabel
import nondas.pap.petpal.ui.composable.GoogleIcon
import nondas.pap.petpal.ui.composable.LoadingBox
import nondas.pap.petpal.ui.composable.PrimaryButton
import nondas.pap.petpal.ui.composable.SecondaryButton
import nondas.pap.petpal.ui.theme.PetPalTheme


@Composable
fun RegisterScreen(
    navigateToLoginScreen: () -> Unit,
    navigateToHomeScreen: () -> Unit,
    viewModel: RegisterViewModel = hiltViewModel()
) {


    LaunchedEffect(Unit) {
        viewModel.navigationFlow.collectLatest { target ->
            when (target) {
                RegisterNavigationTarget.Home -> navigateToHomeScreen()
                RegisterNavigationTarget.Login -> navigateToLoginScreen()
            }
        }
    }

    val snackBarHostState = remember { SnackbarHostState() }


    LaunchedEffect(Unit) {
        viewModel.errorFlow.collect { throwable ->
            snackBarHostState.showSnackbar(throwable.message ?: "Something went wrong")
        }
    }

    LaunchedEffect(Unit) {
        viewModel.messageFlow.collect { message ->
            snackBarHostState.showSnackbar(message)
        }
    }


    val state by viewModel.uiState.collectAsStateWithLifecycle()

    RegisterScreenContent(
        state = state,
        onCreateAccountClicked = { name, email, password, confirmPassword ->
            viewModel.onCreateAccount(name, email, password, confirmPassword)
        },
        onContinueWithGoogleClicked = { viewModel.onCreateWithGoogle() },
        onBackButtonClicked = navigateToLoginScreen,
        snackBarHost = { SnackbarHost(snackBarHostState) }
    )




}

@Composable
private fun RegisterScreenContent(
    state: RegisterState,
    onCreateAccountClicked: (name: String, email: String, password: String, confirmPassword: String ) -> Unit,
    onContinueWithGoogleClicked: () -> Unit,
    onBackButtonClicked: () -> Unit,
    snackBarHost: @Composable () -> Unit
) {

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

            var name by remember { mutableStateOf("") }
            var email by remember { mutableStateOf("") }
            var password by remember { mutableStateOf("") }
            var confirmPassword by remember { mutableStateOf("") }

            BackButton(onClick = onBackButtonClicked)

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
                value = name,
                onValueChange = { name = it },
                placeholder = stringResource(R.string.your_name)
            )

            Spacer(modifier = Modifier.height(16.dp))

            FieldLabel(
                text = stringResource(R.string.email),
            )

            Field(
                value = email,
                onValueChange = { email = it },
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
                value = password,
                onValueChange = { password = it },
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
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password
                ),
                placeholder = stringResource(R.string.repeat_password)
            )

            Spacer(modifier = Modifier.weight(1f))



            PrimaryButton(
                onClick = { onCreateAccountClicked(name, email, password, confirmPassword) },
                text = stringResource(R.string.create_account),
                enabled = name.isNotEmpty() &&
                        email.isNotEmpty() &&
                        password.isNotEmpty() &&
                        confirmPassword.isNotEmpty()
            )

            Spacer(modifier = Modifier.height(16.dp))

            SecondaryButton(
                onClick = onContinueWithGoogleClicked,
                text = stringResource(R.string.google_sign_in),
                icon = {
                    GoogleIcon()
                }
            )

        }

        if (state.isLoading)
            LoadingBox()

    }

}



@Preview
@Composable
private fun RegisterScreenPreview() {
    PetPalTheme {
        RegisterScreenContent(
            state = RegisterState(),
            onBackButtonClicked = {},
            onContinueWithGoogleClicked = {},
            onCreateAccountClicked = { _, _, _, _ -> },
            snackBarHost = {}
        )
    }
}