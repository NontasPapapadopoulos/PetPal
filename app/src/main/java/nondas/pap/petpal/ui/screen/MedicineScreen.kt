package nondas.pap.petpal.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.google.firebase.Timestamp
import kotlinx.coroutines.flow.collectLatest
import nondas.pap.petpal.ui.composable.BackButton
import nondas.pap.petpal.R
import nondas.pap.petpal.domain.model.Medicine
import nondas.pap.petpal.domain.model.enums.MedicineType
import nondas.pap.petpal.domain.model.enums.Repeat
import nondas.pap.petpal.presentation.MedicineState
import nondas.pap.petpal.presentation.MedicineViewModel
import nondas.pap.petpal.ui.composable.Badge
import nondas.pap.petpal.ui.composable.ChoiceItem
import nondas.pap.petpal.ui.composable.Field
import nondas.pap.petpal.ui.composable.FieldLabel
import nondas.pap.petpal.ui.composable.PrimaryButton
import nondas.pap.petpal.ui.theme.PetPalShapes
import nondas.pap.petpal.ui.theme.PetPalTheme
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


@Composable
fun MedicineScreen(
    navigateBack: () -> Unit,
    medicineId: String,
    petId: String,
    viewModel: MedicineViewModel = hiltViewModel<MedicineViewModel, MedicineViewModel.Factory>(
        key = medicineId,
        creationCallback = { factory -> factory.create(petId = petId, medicineId = medicineId) }
    )
) {

    LaunchedEffect(Unit) {
        viewModel.navigationFlow.collectLatest {
            navigateBack()
        }
    }

    val state by viewModel.state.collectAsStateWithLifecycle()

    MedicineContent(
        content = state,
        onBackClicked = navigateBack,
        onSaveMedicine = { viewModel.onAddMedicine(it) },
        onUpdateMedicine = { viewModel.onUpdateMedicine(it) }
    )

}


@Composable
private fun MedicineContent(
    content: MedicineState,
    onBackClicked: () -> Unit,
    onSaveMedicine: (Medicine) -> Unit,
    onUpdateMedicine: (Medicine) -> Unit,
) {

    Scaffold {
        Column(
            modifier = Modifier.padding(it)
                .fillMaxSize()
                .padding(24.dp)
                .verticalScroll(rememberScrollState())

        ) {
            var selectedPetId by remember() { mutableStateOf(content.medicine.petId) }
            var selectedRepeat by remember(content.medicine.repeat) { mutableStateOf(content.medicine.repeat) }
//            var selectedTab by remember { mutableStateOf(Tab.ScheduleReminder) }
            var medicineType by remember(content.medicine.type) { mutableStateOf(content.medicine.type) }
            var name by remember(content.medicine.name) { mutableStateOf(content.medicine.name) }
            var dose by remember(content.medicine.dose) { mutableStateOf(content.medicine.dose) }
            var date: String by remember((content.medicine.date)) { mutableStateOf(content.medicine.date.toString()) }
            var notes by remember(content.medicine.notes) { mutableStateOf(content.medicine.notes) }

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                BackButton { onBackClicked() }

                Spacer(modifier = Modifier.width(16.dp))


                Text(
                    text = stringResource(R.string.add_medicine),
                    style = MaterialTheme.typography.titleLarge
                )

            }

//            Spacer(modifier = Modifier.height(24.dp))

//            SelectionRow(
//                firstOption = Tab.ScheduleReminder,
//                secondOption = Tab.LogPastDose,
//                selected = selectedTab,
//                onFirstSelected = { selectedTab = Tab.ScheduleReminder },
//                onSecondSelected = { selectedTab = Tab.LogPastDose }
//            )



            // medicine exists, and we don't want to change pet.
//            if (content.medicine.id.isEmpty()) {
//                Spacer(modifier = Modifier.height(16.dp))
//
//                FieldLabel(text = stringResource(R.string.forr))
//
//                FlowRow(
//                    modifier = Modifier.fillMaxWidth(),
//                    horizontalArrangement = Arrangement.SpaceBetween
//                ) {
//                    content.pets.forEach {
//                        PetItem(
//                            name = it.name,
//                            isSelected = it.id == selectedPetId,
//                            onClick = { selectedPetId = it.id }
//                        )
//                    }
//                }
//            }

            Spacer(modifier = Modifier.height(16.dp))


            FieldLabel(text = stringResource(R.string.type))

            FlowRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                MedicineType.entries.forEach {
                    MedicineItem(
                        name = it.name,
                        isSelected = it == medicineType
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))


            FieldLabel(text = stringResource(R.string.medicine_name))

            Field(
                value = name,
                onValueChange = { name = it },
                placeholder = "e.g. Rabies booster"
            )

            Spacer(modifier = Modifier.height(16.dp))


            Row {
                Column(modifier = Modifier.weight(1f)) {
                    FieldLabel(
                        text = stringResource(R.string.dose)
                    )

                    Field(
                        value = dose,
                        onValueChange = { dose = it },
                        placeholder = "e.g. 1 tablet"
                    )
                }

                Spacer(modifier = Modifier.width(8.dp))

                Column(modifier = Modifier.weight(1f)) {
                    FieldLabel(
                        text = stringResource(R.string.start_due_date)
                    )


                    Field(
                        value = date,
                        onValueChange = { date = it },
                        placeholder = "DD / MM / YYYY",
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))


            FieldLabel(
                text = stringResource(R.string.repeats)
            )

            FlowRow {
                Repeat.entries.forEach {
                    ChoiceItem(
                        choice = it,
                        selectedChoice = selectedRepeat,
                        onClick = { selectedRepeat = it }
                    )
                }
            }


            Spacer(modifier = Modifier.height(16.dp))

            NotificationSettingsContainer()


            Spacer(modifier = Modifier.height(16.dp))


            FieldLabel(
                text = stringResource(R.string.notes)
            )

            Field(
                value = notes,
                onValueChange = { notes = it },
                modifier = Modifier.fillMaxWidth()
                    .height(88.dp),
                placeholder =  stringResource(R.string.notes_placeholder)
            )


            Spacer(modifier = Modifier.weight(1f))

            PrimaryButton(
                onClick = {
//                    val formatter = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
//                    val date = formatter.parse(date)

                    val medicine = Medicine(
                        id = "",
                        ownerId = "",
                        petId = selectedPetId,
                        name = name,
                        type = medicineType,
                        date = Timestamp(Date()),
                        notes = notes,
                        repeat = selectedRepeat,
                        dose = dose
                    )
                    if (content.medicine.id.isEmpty())
                        onSaveMedicine(medicine)
                    else
                        onUpdateMedicine(medicine.copy(id = content.medicine.id))
                },
                text = stringResource(R.string.save_reminder),
                modifier = Modifier.padding(top = 24.dp)
            )

        }
    }
}





@Composable
private fun PetItem(
    name: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val borderWidth = if (isSelected) 2.dp else 1.dp
    val borderColor = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.2f)
    val backgroundColor = if (isSelected) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.surfaceContainerLowest
    val textColor = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onBackground


    Row(
        modifier = Modifier
            .clickable { onClick() }
            .border(width = borderWidth, color = borderColor, shape = PetPalShapes.medium)
            .background(color = backgroundColor, shape = PetPalShapes.medium)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Badge(
            text = name,
            size = 44
        )



        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = name,
            color = textColor,
            style = MaterialTheme.typography.titleMedium
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
    val backgroundColor = if (isSelected) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.surfaceContainerLowest
    val textColor = if (isSelected) MaterialTheme.colorScheme.onPrimaryContainer else MaterialTheme.colorScheme.onBackground


    Row(
        modifier = Modifier
            .border(width = borderWidth, color = borderColor, shape = PetPalShapes.medium)
            .background(color = backgroundColor, shape = PetPalShapes.medium)
            .padding(horizontal = 12.dp, vertical = 16.dp)
    ) {

        Text(
            text = name,
            color = textColor,
            style = MaterialTheme.typography.titleSmall
        )


    }

}




@Composable
private fun NotificationSettingsContainer() {
    Column(
        modifier = Modifier
            .background(
                color = MaterialTheme.colorScheme.surfaceContainerLowest,
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
        MedicineContent(
            onSaveMedicine = {},
            onBackClicked = {},
            onUpdateMedicine = {},
            content = MedicineState()
        )
    }
}


enum class Tab {
    ScheduleReminder,
    LogPastDose
}