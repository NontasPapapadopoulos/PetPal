package nondas.pap.petpal.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Logout
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.coroutines.flow.collectLatest
import nondas.pap.petpal.R
import nondas.pap.petpal.domain.model.Settings
import nondas.pap.petpal.domain.model.User
import nondas.pap.petpal.domain.model.enums.Theme
import nondas.pap.petpal.presentation.SettingsState
import nondas.pap.petpal.presentation.SettingsViewModel
import nondas.pap.petpal.ui.Screen
import nondas.pap.petpal.ui.composable.BottomAppBar
import nondas.pap.petpal.ui.composable.Field
import nondas.pap.petpal.ui.composable.ForwardArrowIcon
import nondas.pap.petpal.ui.theme.PetPalShapes
import nondas.pap.petpal.ui.theme.PetPalTheme


@Composable
fun SettingsScreen(
    navigateToHome: () -> Unit,
    navigateToLogin: () -> Unit,
    navigateToChangePassword: () -> Unit,
    viewModel: SettingsViewModel = hiltViewModel()
) {


    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.navigationFlow.collectLatest {
            navigateToLogin()
        }
    }

    SettingsContent(
        content = state,
        onHomeClicked = navigateToHome,
        onChangePasswordClicked = { navigateToChangePassword() },
        onDeleteAccount = { viewModel.onDeleteAccount(it) },
        onSignOut = { viewModel.onSignOut() },
        onUpdateTheme = { viewModel.onUpdateTheme(it) },
        onTogglePushNotifications = { viewModel.onTogglePushNotifications(it) }

    )

}


@Composable
private fun SettingsContent(
    content: SettingsState,
    onHomeClicked: () -> Unit,
    onChangePasswordClicked: () -> Unit,
    onDeleteAccount: (String) -> Unit,
    onSignOut: () -> Unit,
    onTogglePushNotifications: (Boolean) -> Unit,
    onUpdateTheme: (Theme) -> Unit
) {

    var showPasswordDialog by remember { mutableStateOf(false) }
    var showThemeDialog by remember { mutableStateOf(false) }
    var password by remember { mutableStateOf("") }

    Scaffold(
        bottomBar = {
            BottomAppBar(
                screen = Screen.Settings,
                onHomeClicked = onHomeClicked
            )
        }
    ) {

        Column(
            modifier = Modifier
                .padding(it)
                .padding(24.dp)
                .verticalScroll(rememberScrollState())
        ) {

            Text(
                text = stringResource(R.string.settings),
                style = MaterialTheme.typography.headlineSmall
            )

            Spacer(modifier = Modifier.height(24.dp))

            Row(
                modifier = Modifier.fillMaxWidth()
                    .background(
                        color = MaterialTheme.colorScheme.surfaceContainerLowest,
                        shape = PetPalShapes.large,
                    )
                    .border(
                        width = 1.dp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.22f),
                        shape = PetPalShapes.large
                    )
                    .padding(vertical = 24.dp)
            ) {

                Spacer(modifier = Modifier.width(16.dp))

                Column {
                    Text(text = content.user.fullName)

                    Text(
                        text = content.user.email,
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }


            }

            SettingCategory(
                text = stringResource(R.string.reminders)
            )


            SettingsContainer {

                SettingItem(
                    onClick = {  },
                    primaryText = stringResource(R.string.push_notifications),
                    composable = {
                        Switch(
                            checked = content.settings.pushNotificationsEnabled,
                            onCheckedChange = { onTogglePushNotifications(it) }
                        )
                    }
                )

                SettingDivider()

                SettingItem(
                    onClick = {},
                    primaryText = stringResource(R.string.default_reminder),
                    secondaryText = "1 day before",
                    composable = {
                        ForwardArrowIcon()
                    }
                )

                SettingDivider()


                SettingItem(
                    onClick = {},
                    primaryText = stringResource(R.string.reminder_time),
                    secondaryText = "09:00",
                    composable = {
                        ForwardArrowIcon()
                    }
                )

            }

            SettingCategory(
                text = stringResource(R.string.app)
            )


            SettingsContainer {

                SettingItem(
                    onClick = { },
                    primaryText = stringResource(R.string.theme),
                    secondaryText = stringResource(R.string.system_default),
                    composable = {
                        ForwardArrowIcon()
                    }
                )

                SettingDivider()


                SettingItem(
                    onClick = {},
                    primaryText = stringResource(R.string.export),
                    secondaryText = stringResource(R.string.pdf),
                    composable = {
                        ForwardArrowIcon()
                    }
                )

            }


            SettingCategory(
                text = stringResource(R.string.account)
            )


            SettingsContainer {

                SettingItem(
                    onClick = onChangePasswordClicked,
                    primaryText = stringResource(R.string.change_password),
                    composable = {
                        ForwardArrowIcon()
                    }
                )

                SettingDivider()


                SettingItem(
                    onClick = onSignOut,
                    primaryText = stringResource(R.string.sign_out),
                    composable = {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.Logout,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                )

                SettingDivider()


                TextButton(
                    onClick = {},
                    modifier = Modifier.padding(start = 4.dp)
                ) {
                    Text(
                        text = stringResource(R.string.delete_account),
                        color = MaterialTheme.colorScheme.error
                    )
                }

            }

        }

        if (showPasswordDialog) {
            PasswordDialog(
                onDismiss = {
                      showPasswordDialog = false
                  },
                onConfirm = {
                    onDeleteAccount(it)
                    showPasswordDialog = false
                }
            )
        }
    }

}

@Composable
private fun SettingDivider() {
    HorizontalDivider(
        modifier = Modifier.padding(horizontal = 16.dp),
        color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.2f)
    )
}

@Composable
private fun SettingCategory(
    text: String
) {
    Text(
        text = text.uppercase(),
        color = MaterialTheme.colorScheme.onSurfaceVariant,
        modifier = Modifier.padding(vertical = 12.dp),
        style = MaterialTheme.typography.labelSmall
    )
}

@Composable
private fun SettingsContainer(
    content: @Composable () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth()
            .background(
                color = MaterialTheme.colorScheme.surfaceContainerLowest,
                shape = PetPalShapes.large,
            )
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.22f),
                shape = PetPalShapes.large
            )
            .padding(vertical = 12.dp)
    ) {
        content()
    }
}

@Composable
private fun SettingItem(
    onClick: () -> Unit,
    primaryText: String,
    secondaryText: String = "",
    composable: @Composable () -> Unit
) {

    Row(
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Column {
            Text(
                text = primaryText
            )

            if (secondaryText.isNotEmpty())
                Text(
                    text = secondaryText,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant

                )
        }

        Spacer(modifier = Modifier.weight(1f))

        composable()
    }

}



@Composable
fun PasswordDialog(
    onDismiss: () -> Unit,
    onConfirm: (String) -> Unit
) {
    var password by remember { mutableStateOf("") }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(stringResource(R.string.delete_account))
        },
        text = {
            Field(
                value = password,
                onValueChange = { password = it },
            )
        },
        confirmButton = {
            Button(
                onClick = { onConfirm(password) },
                colors = ButtonDefaults.buttonColors().copy(
                    containerColor = MaterialTheme.colorScheme.error
                )
            ) {
                Text(stringResource(R.string.delete))
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text(stringResource(R.string.cancel))
            }
        }
    )
}

@Preview
@Composable
private fun SettingsContentPreview() {
    PetPalTheme {
        SettingsContent(
            content = SettingsState(
                user = User(
                    fullName = "Nondas Pa",
                    email = "nondas.papadopoulos@gmail.com"
                ),
                settings = Settings(true, Theme.Light)
            ),
            onHomeClicked = {},
            onChangePasswordClicked = {},
            onDeleteAccount = {},
            onSignOut = {},
            onTogglePushNotifications = {},
            onUpdateTheme = {},
        )
    }
}