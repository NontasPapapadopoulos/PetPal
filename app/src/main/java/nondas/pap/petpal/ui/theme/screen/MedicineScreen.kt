package nondas.pap.petpal.ui.theme.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.outlined.AccessTime
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layout
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nondas.pap.petpal.BackButton
import nondas.pap.petpal.R
import nondas.pap.petpal.ui.composable.ChoiceItem
import nondas.pap.petpal.ui.composable.FieldTitle
import nondas.pap.petpal.ui.composable.PrimaryButton
import nondas.pap.petpal.ui.composable.SelectionRow
import nondas.pap.petpal.ui.theme.PetPalShapes
import nondas.pap.petpal.ui.theme.PetPalTheme


@Composable
fun MedicineScreen() {

}


@Composable
private fun MedicineContent() {

    Scaffold {
        Column(
            modifier = Modifier.padding(it)
                .fillMaxSize()
                .padding(24.dp)
                .verticalScroll(rememberScrollState())

        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                BackButton {  }

                Spacer(modifier = Modifier.width(16.dp))


                Text(
                    text = stringResource(R.string.add_medicine),
                    style = MaterialTheme.typography.headlineMedium
                )

            }

            Spacer(modifier = Modifier.height(24.dp))

            SelectionRow(
                firstSelectionText = stringResource(R.string.schedule_reminder),
                secondSelectionText = stringResource(R.string.log_past_dose),
            )

            Spacer(modifier = Modifier.height(16.dp))


            FieldTitle(text = stringResource(R.string.forr))

            FlowRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                PetItem("Roza", true)
                PetItem("Pepe", false)
                PetItem("Luna", false)
            }

            Spacer(modifier = Modifier.height(16.dp))


            FieldTitle(text = stringResource(R.string.type))

            FlowRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                MedicineItem(
                    name = stringResource(R.string.vaccine),
                    isSelected = true
                )

                MedicineItem(
                    name = stringResource(R.string.pill),
                    isSelected = false
                )

                MedicineItem(
                    name = stringResource(R.string.treatment),
                    isSelected = false
                )

                MedicineItem(
                    name = stringResource(R.string.other),
                    isSelected = false
                )
            }

            Spacer(modifier = Modifier.height(16.dp))


            FieldTitle(text = stringResource(R.string.medicine_name))

            OutlinedTextField(
                value = "",
                onValueChange = {},
                modifier = Modifier.fillMaxWidth()
                    .height(56.dp),
                shape = PetPalShapes.medium,
                placeholder = {
                    Text(
                        text = "e.g. Rabies booster",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.5f),
                        fontWeight = FontWeight.W100
                    )
                }
            )

            Spacer(modifier = Modifier.height(16.dp))


            Row {
                Column(modifier = Modifier.weight(1f)) {
                    FieldTitle(
                        text = stringResource(R.string.dose)
                    )

                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        modifier = Modifier.fillMaxWidth(),
                        placeholder = {
                            Text(
                                text = "e.g. 1 tablet",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.5f),
                                fontWeight = FontWeight.W100
                            )
                        }
                    )
                }

                Spacer(modifier = Modifier.width(8.dp))

                Column(modifier = Modifier.weight(1f)) {
                    FieldTitle(
                        text = stringResource(R.string.start_due_date)
                    )


                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        modifier = Modifier.fillMaxWidth(),
                        placeholder = {
                            Text(
                                text = "DD / MM / YYYY",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.5f),
                                fontWeight = FontWeight.W100
                            )
                        }
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))


            FieldTitle(
                text = stringResource(R.string.repeats)
            )

            FlowRow() {
                ChoiceItem(
                    choice = stringResource(R.string.once),
                    isSelected = false
                )

                ChoiceItem(
                    choice = stringResource(R.string.daily),
                    isSelected = false
                )

                ChoiceItem(
                    choice = stringResource(R.string.weekly),
                    isSelected = false
                )

                ChoiceItem(
                    choice = stringResource(R.string.monthly),
                    isSelected = false
                )

                ChoiceItem(
                    choice = stringResource(R.string.yearly),
                    isSelected = true
                )

            }

            Spacer(modifier = Modifier.height(16.dp))

            NotificationSettingsContainer()


            Spacer(modifier = Modifier.height(16.dp))


            FieldTitle(
                text = stringResource(R.string.notes)
            )

            OutlinedTextField(
                value = "",
                onValueChange = {},
                modifier = Modifier.fillMaxWidth()
                    .height(88.dp),
                placeholder = {
                    Text(
                        text = stringResource(R.string.notes_placeholder),
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.5f),
                        fontWeight = FontWeight.W100
                    )
                }
            )


            Spacer(modifier = Modifier.weight(1f))

            PrimaryButton(
                onClick = {},
                text = stringResource(R.string.save_reminder)
            )

        }




    }
}





@Composable
private fun PetItem(
    name: String,
    isSelected: Boolean
) {
    val borderWidth = if (isSelected) 2.dp else 1.dp
    val borderColor = if (isSelected) MaterialTheme.colorScheme.onPrimaryContainer else MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.2f)
    val backgroundColor = if (isSelected) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.background
    val textColor = if (isSelected) MaterialTheme.colorScheme.onPrimaryContainer else MaterialTheme.colorScheme.onSurfaceVariant


    Row(
        modifier = Modifier
            .border(width = borderWidth, color = borderColor, shape = PetPalShapes.medium)
            .background(color = backgroundColor, shape = PetPalShapes.medium)
            .padding(horizontal = 16.dp, vertical = 16.dp)
    ) {
        Text(
            text = name[0].toString().capitalize()
        )

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = name,
            color = textColor
        )


    }

}


@Composable
private fun MedicineItem(
    name: String,
    isSelected: Boolean
) {
    val borderWidth = if (isSelected) 2.dp else 1.dp
    val borderColor = if (isSelected) MaterialTheme.colorScheme.onPrimaryContainer else MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.2f)
    val backgroundColor = if (isSelected) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.background
    val textColor = if (isSelected) MaterialTheme.colorScheme.onPrimaryContainer else MaterialTheme.colorScheme.onSurfaceVariant


    Row(
        modifier = Modifier
            .border(width = borderWidth, color = borderColor, shape = PetPalShapes.medium)
            .background(color = backgroundColor, shape = PetPalShapes.medium)
            .padding(horizontal = 12.dp, vertical = 16.dp)
    ) {

        Text(
            text = name,
            color = textColor
        )


    }

}




@Composable
private fun NotificationSettingsContainer() {
    Column(
        modifier = Modifier
            .background(
                color = MaterialTheme.colorScheme.background,
                shape = PetPalShapes.large,
            )
            .border(
                width = 1.dp,
                shape = PetPalShapes.large,
                color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.2f)
            )
            .padding(16.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                imageVector = Icons.Outlined.Notifications,
                tint = MaterialTheme.colorScheme.primary,
                contentDescription = null
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column {
                Text(
                    text = stringResource(R.string.remind_me)
                )

                Text(
                    text = "1 day before · 09:00",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Spacer(modifier = Modifier.weight(1f))


            Icon(
                imageVector = Icons.Default.ArrowForwardIos,
                contentDescription = null
            )

        }

        HorizontalDivider(
            modifier = Modifier.padding(vertical = 8.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                imageVector = Icons.Outlined.AccessTime,
                tint = MaterialTheme.colorScheme.primary,
                contentDescription = null
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column {
                Text(
                    text = stringResource(R.string.on_the_day)
                )

                Text(
                    text = stringResource(R.string.also_notify),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Spacer(modifier = Modifier.weight(1f))


            Switch(
                checked = true,
                onCheckedChange = {}
            )
        }

    }
}


@Composable
@Preview
private fun NotificationSettingsContainerPreview() {
    PetPalTheme {
        NotificationSettingsContainer()
    }
}

@Composable
@Preview
private fun MedicineContentPreview() {
    PetPalTheme {
        MedicineContent()
    }
}
