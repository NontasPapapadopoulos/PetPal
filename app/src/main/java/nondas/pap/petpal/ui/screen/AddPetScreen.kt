package nondas.pap.petpal.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CameraAlt
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nondas.pap.petpal.ui.composable.BackButton
import nondas.pap.petpal.R
import nondas.pap.petpal.ui.composable.Field
import nondas.pap.petpal.ui.composable.FieldLabel
import nondas.pap.petpal.ui.composable.PrimaryButton
import nondas.pap.petpal.ui.composable.SelectionRow
import nondas.pap.petpal.ui.theme.PetPalShapes
import nondas.pap.petpal.ui.theme.PetPalTheme

@Composable
fun AddPetScreen() {

}


@Composable
private fun AddPetContent() {

    Scaffold {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                BackButton({})

                Spacer(modifier = Modifier.width(16.dp))

                Text(
                    text = stringResource(R.string.add_pet),
                    style = MaterialTheme.typography.titleLarge
                )
            }

            Spacer(modifier = Modifier.height(12.dp))


            IconButton(
                onClick = {},
                modifier = Modifier.size(120.dp)
                    .border(
                        width = 1.dp,
                        color = MaterialTheme.colorScheme.surfaceVariant,
                        shape = PetPalShapes.extraLarge
                    )
                    .background(
                        color = MaterialTheme.colorScheme.surfaceContainerLowest,
                        shape = PetPalShapes.extraLarge
                    ),
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageVector = Icons.Outlined.CameraAlt,
                        tint = MaterialTheme.colorScheme.onPrimaryContainer,
                        contentDescription = null
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = stringResource(R.string.add_photo),
                        color = MaterialTheme.colorScheme.primary,
                    )

                }
            }

            Spacer(modifier = Modifier.height(24.dp))


            FieldLabel(
                text = stringResource(R.string.name)
            )


            Field(
                value = "",
                onValueChange = {},
                modifier = Modifier.fillMaxWidth(),
                placeholder = "Roza"
            )

            Spacer(modifier = Modifier.height(12.dp))


            FieldLabel(
                text = stringResource(R.string.species),
            )


            Row {
                SpecieItem(
                    specie = stringResource(R.string.dog),
                    isSelected = true,
                    modifier = Modifier.weight(1f)
                )

                SpecieItem(
                    specie = stringResource(R.string.cat),
                    isSelected = false,
                    modifier = Modifier.weight(1f)
                )

                SpecieItem(
                    specie = stringResource(R.string.bird),
                    isSelected = false,
                    modifier = Modifier.weight(1f)
                )

                SpecieItem(
                    specie = stringResource(R.string.other),
                    isSelected = false,
                    modifier = Modifier.weight(1f)
                )


            }

            Spacer(modifier = Modifier.height(12.dp))


            FieldLabel(
                text = stringResource(R.string.breed),
            )


            Field(
                value = "",
                onValueChange = {},
                modifier = Modifier.fillMaxWidth(),
                placeholder = "Frenchton"
            )

            Spacer(modifier = Modifier.height(12.dp))

            Row {

                Column(modifier = Modifier.weight(1f)) {

                    FieldLabel(
                        text = stringResource(R.string.birth_date)
                    )

                    Field(
                        value = "",
                        onValueChange = {},
                        placeholder = "DD / MM / YYYY"
                    )
                }

                Spacer(modifier = Modifier.width(8.dp))

                Column(modifier = Modifier.weight(1f)) {
                    FieldLabel(
                        text = stringResource(R.string.weight),
                    )


                    Field(
                        value = "",
                        onValueChange = {},
                        placeholder = "10 kg"
                    )
                }

            }

            Spacer(modifier = Modifier.height(12.dp))


            FieldLabel(
                text = "Sex"
            )


            SelectionRow(
                firstSelectionText = "Male",
                secondSelectionText = "Female"
            )


            Spacer(modifier = Modifier.height(12.dp))


            FieldLabel(
                text = stringResource(R.string.microchip),
            )

            Spacer(modifier = Modifier.height(4.dp))


            Field(
                value = "",
                onValueChange = {},
                placeholder = "15 Digits"
            )

            Spacer(modifier = Modifier.height(12.dp))


            Spacer(modifier = Modifier.weight(1f))


            PrimaryButton(
                onClick = {},
                text = stringResource(R.string.save_pet)
            )

        }
    }

}


@Composable
private fun SpecieItem(
    specie: String,
    isSelected: Boolean,
    modifier: Modifier = Modifier
) {

    val textColor = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onBackground
    val borderColor = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.2f)
    val backgroundColor = if (isSelected) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.surfaceContainerLowest
    Text(
        text = specie,
        color = textColor,
        textAlign = TextAlign.Center,
        modifier = modifier
            .padding(horizontal = 4.dp)
            .background(
                color = backgroundColor,
                shape = PetPalShapes.medium
            )
            .border(
                width = 1.dp,
                color = borderColor,
                shape = PetPalShapes.medium
            )
            .padding(horizontal = 16.dp, vertical = 12.dp)

    )

}

@Composable
@Preview
private fun AddPetContentPreview() {
    PetPalTheme(darkTheme = false) {
        AddPetContent()
    }
}