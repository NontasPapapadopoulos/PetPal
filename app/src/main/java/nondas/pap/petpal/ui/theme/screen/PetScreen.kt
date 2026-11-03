package nondas.pap.petpal.ui.theme.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.Shield
import androidx.compose.material.icons.outlined.Vaccines
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nondas.pap.petpal.BackButton
import nondas.pap.petpal.R
import nondas.pap.petpal.ui.composable.ChoiceItem
import nondas.pap.petpal.ui.composable.SelectionRow
import nondas.pap.petpal.ui.theme.PetPalShapes
import nondas.pap.petpal.ui.theme.PetPalTheme


@Composable
fun PetScreen() {

}


@Composable
private fun PetContent() {
    Scaffold(
        floatingActionButton = {
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors().copy(
                    containerColor = MaterialTheme.colorScheme.secondary
                ),
                modifier = Modifier.height(height = 56.dp),
                shape = PetPalShapes.medium
            ) {

                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSecondary

                )

                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    text = stringResource(R.string.add_medicine),
                    color = MaterialTheme.colorScheme.onSecondary
                )
            }
        },
    ) {

        Column(
            modifier = Modifier.padding(it)
                .padding(top = 24.dp)

        ) {

            Column(
                modifier = Modifier.padding(
                    horizontal = 24.dp
                )
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    BackButton {  }

                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors().copy(
                            containerColor = MaterialTheme.colorScheme.outlineVariant
                        ),
                        shape = PetPalShapes.medium,
                        modifier = Modifier.height(48.dp)
                    ) {
                        Text(
                            text = stringResource(R.string.edit_pet),
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                }

                PetDetails(
                    name = "Roza",
                    sex = "Female",
                    breed = "Frenchton",
                    age = "6",
                    weight = "10",
                    chipNumber = "1231231"
                )
            }

            SelectionRow(
                firstSelectionText = stringResource(R.string.male),
                secondSelectionText = stringResource(R.string.female),
            )

            Spacer(modifier = Modifier.height(24.dp))

            HorizontalDivider(
                color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.22f),
                thickness = 2.dp
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = MaterialTheme.colorScheme.surfaceVariant)
                    .padding(start = 24.dp, end = 24.dp, top = 24.dp )
            ) {

                FlowRow {
                    ChoiceItem(
                        choice = "All",
                        isSelected = true
                    )

                    ChoiceItem(
                        choice = "Vaccines",
                        isSelected = false
                    )


                    ChoiceItem(
                        choice = "Pills",
                        isSelected = false
                    )

                    ChoiceItem(
                        choice = "Treatments",
                        isSelected = false
                    )


                }

                MedicineItem(
                    icon = {
                        Icon(
                            imageVector = Icons.Outlined.Vaccines,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary,
                        )
                    },
                    description = "Rabies booster",
                    type = "Vaccine",
                    date = "Nov 5",
                    frequency = "yearly",
                    daysLeft = "In 3 days",
                )

                MedicineItem(
                    icon = {
                        Icon(
                            imageVector = Icons.Outlined.Shield,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary,
                        )
                    },
                    description = "Flea & tick spot-on",
                    type = "Treatment",
                    date = "Dec 14",
                    frequency = "monthly",
                    daysLeft = "29 days",
                )


                MedicineItem(
                    icon = {
                        Icon(
                            painter = painterResource(R.drawable.outline_pill_24),
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary,
                        )
                    },
                    description = "Flea & tick spot-on",
                    type = "Treatment",
                    date = "Dec 14",
                    frequency = "monthly",
                    daysLeft = "29 days",
                )
            }

        }
    }
}


@Composable
private fun PetDetails(
    name: String,
    sex: String,
    breed: String,
    age: String,
    weight: String,
    chipNumber: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 24.dp, horizontal = 8.dp)
    ) {

        Text(
            text = name[0].toString().capitalize()
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column {
            Text(
                text = name
            )

            Text(
                text = "$breed · $sex · $age y"
            )

            Text(
                text = "$weight kg · Chip [$chipNumber]"
            )
        }


    }
}



@Composable
private fun MedicineItem(
    icon: @Composable () -> Unit,
    description: String,
    type: String,
    date: String,
    frequency: String,
    daysLeft: String
) {

    Card(
        modifier = Modifier.fillMaxWidth()
            .padding(vertical = 8.dp),
        shape = PetPalShapes.large,
        colors = CardDefaults.cardColors().copy(
            containerColor = MaterialTheme.colorScheme.background
        ),
        border = BorderStroke(
            width = 1.dp,
            color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.2f)
        )
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,

            modifier = Modifier.padding(vertical = 16.dp, horizontal = 8.dp)
        ) {
            Box(
                modifier = Modifier.size(60.dp)
                    .background(
                        color = MaterialTheme.colorScheme.primaryContainer,
                        shape = PetPalShapes.large
                    ),
                contentAlignment = Alignment.Center,
            ) {

                icon()

            }

            Spacer(modifier = Modifier.width(12.dp))


            Column {
                Text(
                    text = description,
                    style = MaterialTheme.typography.bodyMedium,

                    )

                Text(
                    text ="$type · $date · $frequency",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Spacer(modifier = Modifier.weight(1f))


            Text(
                text = daysLeft,
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.labelSmall,
                modifier = Modifier
                    .background(
                        color = MaterialTheme.colorScheme.primaryContainer,
                        shape = PetPalShapes.extraSmall
                    )
                    .padding(vertical = 8.dp, horizontal = 12.dp)


            )
        }

    }
}


@Preview
@Composable
private fun PetContentContent() {
    PetPalTheme {
        PetContent()
    }
}