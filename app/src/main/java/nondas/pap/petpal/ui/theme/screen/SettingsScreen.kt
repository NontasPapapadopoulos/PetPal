package nondas.pap.petpal.ui.theme.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.automirrored.filled.Logout
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nondas.pap.petpal.R
import nondas.pap.petpal.ui.theme.PetPalShapes
import nondas.pap.petpal.ui.theme.PetPalTheme
import java.nio.file.WatchEvent


@Composable
fun SettingsScreen() {

}


@Composable
private fun SettingsContent() {

    Scaffold(
        bottomBar = {
            BottomAppBar() {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Home,
                        tint = MaterialTheme.colorScheme.primary,
                        contentDescription = null
                    )

                    Text(
                        text = stringResource(R.string.home),
                        color = MaterialTheme.colorScheme.primary,

                    )
                }


                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Settings,
                        tint = MaterialTheme.colorScheme.primary,
                        contentDescription = null
                    )

                    Text(
                        text = stringResource(R.string.settings),
                        color = MaterialTheme.colorScheme.primary,

                        )
                }
            }
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
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(24.dp))

            Row(
                modifier = Modifier.fillMaxWidth()
                    .background(
                        color = MaterialTheme.colorScheme.background,
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
                    Text(text = "Nondas Papadopoulos")

                    Text(
                        text = "papadopoulose92@protonmail.com",
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
                    onClick = {},
                    primaryText = stringResource(R.string.push_notifications),
                    composable = {
                        Switch(
                            checked = true,
                            onCheckedChange = {}
                        )
                    }
                )

                SettingDivider()

                SettingItem(
                    onClick = {},
                    primaryText = stringResource(R.string.default_reminder),
                    secondaryText = "1 day before",
                    composable = {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                            contentDescription = null
                        )
                    }
                )

                SettingDivider()


                SettingItem(
                    onClick = {},
                    primaryText = stringResource(R.string.reminder_time),
                    secondaryText = "09:00",
                    composable = {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                            contentDescription = null
                        )
                    }
                )

            }

            SettingCategory(
                text = stringResource(R.string.app)
            )


            SettingsContainer {

                SettingItem(
                    onClick = {},
                    primaryText = stringResource(R.string.theme),
                    secondaryText = stringResource(R.string.system_default),
                    composable = {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                            contentDescription = null
                        )
                    }
                )

                SettingDivider()


                SettingItem(
                    onClick = {},
                    primaryText = stringResource(R.string.export),
                    secondaryText = stringResource(R.string.pdf),
                    composable = {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                            contentDescription = null
                        )
                    }
                )

            }


            SettingCategory(
                text = stringResource(R.string.account)
            )


            SettingsContainer {

                SettingItem(
                    onClick = {},
                    primaryText = stringResource(R.string.change_password),
                    composable = {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                            contentDescription = null
                        )
                    }
                )

                SettingDivider()


                SettingItem(
                    onClick = {},
                    primaryText = stringResource(R.string.sign_out),
                    composable = {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.Logout,
                            contentDescription = null
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
        modifier = Modifier.padding(vertical = 12.dp)
    )
}

@Composable
private fun SettingsContainer(
    content: @Composable () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth()
            .background(
                color = MaterialTheme.colorScheme.background,
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

@Preview
@Composable
private fun SettingsContentPreview() {
    PetPalTheme {
        SettingsContent()
    }
}