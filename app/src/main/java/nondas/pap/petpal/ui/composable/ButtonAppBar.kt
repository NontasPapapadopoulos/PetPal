package nondas.pap.petpal.ui.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import nondas.pap.petpal.R
import nondas.pap.petpal.ui.Screen


@Composable
fun BottomAppBar(
    screen: Screen,
    onHomeClicked: () -> Unit = {},
    onSettingsClicked: () -> Unit = {},
) {
    Column {
        HorizontalDivider(
            thickness = 3.dp
        )

        BottomAppBar(
            containerColor = MaterialTheme.colorScheme.surfaceContainerLowest,
            contentPadding = PaddingValues(0.dp)
        ) {

            val homeColors = if (screen == Screen.Home) MaterialTheme.colorScheme.primary
            else MaterialTheme.colorScheme.onSurfaceVariant

            val settingsColors = if (screen == Screen.Settings) MaterialTheme.colorScheme.primary
            else MaterialTheme.colorScheme.onSurfaceVariant


            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .weight(1f)
                    .clickable {
                        if (screen == Screen.Home)
                            onSettingsClicked()
                    }
            ) {

                Icon(
                    imageVector = Icons.Outlined.Home,
                    tint = homeColors,
                    contentDescription = null
                )

                Text(
                    text = stringResource(R.string.home),
                    color = homeColors,
                    style = MaterialTheme.typography.labelSmall
                )
            }


            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .weight(1f)
                    .clickable {
                        if (screen == Screen.Settings)
                            onHomeClicked()
                    }
            ) {
                Icon(
                    imageVector = Icons.Outlined.Settings,
                    tint = settingsColors,
                    contentDescription = null
                )

                Text(
                    text = stringResource(R.string.settings),
                    color = settingsColors,
                    style = MaterialTheme.typography.labelSmall
                )
            }
        }
    }
}