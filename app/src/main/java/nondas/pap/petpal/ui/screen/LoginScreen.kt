package nondas.pap.petpal.ui.screen

import android.app.Activity
import android.content.Context
import android.credentials.GetCredentialException
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.credentials.Credential
import androidx.credentials.CredentialManager
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.google.android.libraries.identity.googleid.GetSignInWithGoogleOption
import kotlinx.coroutines.flow.collectLatest
import nondas.pap.petpal.R
import nondas.pap.petpal.presentation.LoginState
import nondas.pap.petpal.presentation.LoginViewModel
import nondas.pap.petpal.ui.composable.Field
import nondas.pap.petpal.ui.composable.FieldLabel
import nondas.pap.petpal.ui.composable.GoogleIcon
import nondas.pap.petpal.ui.composable.LoadingBox
import nondas.pap.petpal.ui.composable.PrimaryButton
import nondas.pap.petpal.ui.composable.SecondaryButton
import nondas.pap.petpal.ui.theme.PetPalTheme
import androidx.credentials.GetCredentialRequest
import androidx.credentials.exceptions.NoCredentialException
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import kotlinx.coroutines.launch


@Composable
fun LoginScreen(
    navigateToHome: () -> Unit,
    navigateToForgotPassword: () -> Unit,
    navigateToCreateAccount: () -> Unit,
    viewModel: LoginViewModel = hiltViewModel()
) {

    LaunchedEffect(Unit) {
        viewModel.navigationFlow.collectLatest {
            navigateToHome()
        }
    }

    val snackBarHostState = remember { SnackbarHostState() }


    val state by viewModel.uiState.collectAsStateWithLifecycle()

    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()

    LoginContent(
        state = state,
        onLogin = { email, password -> viewModel.onLogin(email, password) },
        onContinueWithGoogleClicked = {
            coroutineScope.launch {
                launchCredential(
                    context = context,
                    onRequestResult = { viewModel.onLoginWithGoogle(it) }

                )
            }


        },
        onForgotPasswordClicked = navigateToForgotPassword,
        onCreateAccountClicked = navigateToCreateAccount,
        snackBarHost = { SnackbarHost(snackBarHostState) }
    )
}


@Composable
private fun LoginContent(
    state: LoginState,
    onLogin: (email: String, password: String) -> Unit,
    onForgotPasswordClicked: () -> Unit,
    onCreateAccountClicked: () -> Unit,
    onContinueWithGoogleClicked: () -> Unit,
    snackBarHost: @Composable () -> Unit
) {
    Scaffold(
        snackbarHost = {
            snackBarHost()
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
                .padding(it)
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            var email by remember { mutableStateOf("") }
            var password by remember { mutableStateOf("") }

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
                visualTransformation = PasswordVisualTransformation(),
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
                onClick = onContinueWithGoogleClicked,
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

        if (state.isLoading)
            LoadingBox()

    }
}

private suspend fun launchCredential(
    context: Context,
    onRequestResult: (String) -> Unit
) {
    try {
        val signInWithGoogleOption = GetSignInWithGoogleOption
            .Builder(serverClientId = context.getString(R.string.default_web_client_id))
            .build()

        // TODO: find and place the web_client_id on the values.xml file.

        val request = GetCredentialRequest.Builder()
            .addCredentialOption(signInWithGoogleOption)
            .build()

        val result = CredentialManager.create(context).getCredential(
            request = request,
            context = context
        )

        val googleIdToken = GoogleIdTokenCredential
            .createFrom(result.credential.data).idToken

        onRequestResult(googleIdToken)

    } catch (e: NoCredentialException) {
        Log.d("ERROR", e.message.orEmpty())
    } catch (e: androidx.credentials.exceptions.GetCredentialException) {

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
            state = LoginState(isLoading = true),
            onLogin = { _, _ -> },
            onCreateAccountClicked = {},
            onForgotPasswordClicked = {},
            onContinueWithGoogleClicked = {},
            snackBarHost = {}
        )
    }
}