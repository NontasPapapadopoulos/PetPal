package nondas.pap.petpal.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CameraAlt
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nondas.pap.petpal.ui.composable.BackButton
import nondas.pap.petpal.R
import nondas.pap.petpal.domain.model.enums.Sex
import nondas.pap.petpal.domain.model.enums.Specie
import nondas.pap.petpal.ui.composable.Field
import nondas.pap.petpal.ui.composable.FieldLabel
import nondas.pap.petpal.ui.composable.PrimaryButton
import nondas.pap.petpal.ui.composable.SelectionRow
import nondas.pap.petpal.presentation.Mode
import nondas.pap.petpal.ui.theme.PetPalShapes
import nondas.pap.petpal.ui.theme.PetPalTheme

@Composable
fun AddPetScreen(
    navigateBack: () -> Unit,
    mode: Mode
) {




}


@Composable
private fun AddPetContent(
    onBackClicked: () -> Unit,
    onSavePetClicked: () -> Unit
) {

    var name by remember { mutableStateOf("") }
    var breed by remember { mutableStateOf("") }
    var weight by remember { mutableStateOf("") }
    var birthday by remember { mutableStateOf("") }
    var microChip by remember { mutableStateOf("") }
    var sex by remember { mutableStateOf(Sex.Male) }
    var specie by remember { mutableStateOf(Specie.Dog) }


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
                BackButton(onClick = onBackClicked)

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
//                AsyncImage(
//                    model = pet.photoUrl,
//                    contentDescription = pet.name
//                )
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
                value = name,
                onValueChange = { name = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = "Roza"
            )

            Spacer(modifier = Modifier.height(12.dp))


            FieldLabel(
                text = stringResource(R.string.species),
            )

            Row {
                SpecieItem(
                    specie = Specie.Dog,
                    selectedSpecie = specie,
                    modifier = Modifier.weight(1f),
                    onClick = { specie = it }
                )

                SpecieItem(
                    specie = Specie.Cat,
                    selectedSpecie = specie,
                    modifier = Modifier.weight(1f),
                    onClick = { specie = it }
                )

                SpecieItem(
                    specie = Specie.Bird,
                    selectedSpecie = specie,
                    modifier = Modifier.weight(1f),
                    onClick = { specie = it }
                )

                SpecieItem(
                    specie = Specie.Other,
                    selectedSpecie = specie,
                    modifier = Modifier.weight(1f),
                    onClick = { specie = it }
                )


            }

            Spacer(modifier = Modifier.height(12.dp))


            FieldLabel(
                text = stringResource(R.string.breed),
            )


            Field(
                value = breed,
                onValueChange = { breed = it },
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
                        value = birthday,
                        onValueChange = {
                            if (it.length <= 8 && it.all { c -> c.isDigit() })
                                birthday = it
                        },
                        placeholder = "DD / MM / YYYY",
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number
                        ),
                        visualTransformation = DateVisualTransformation,
                        )
                }

                Spacer(modifier = Modifier.width(8.dp))

                Column(modifier = Modifier.weight(1f)) {
                    FieldLabel(
                        text = stringResource(R.string.weight),
                    )


                    Field(
                        value = weight,
                        onValueChange = { weight = it },
                        placeholder = "10 kg",
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number
                        ),
                    )
                }

            }

            Spacer(modifier = Modifier.height(12.dp))


            FieldLabel(
                text = "Sex"
            )


            SelectionRow(
                firstSelectionText = "Male",
                secondSelectionText = "Female",
                onFirstSelectionClicked = { sex = Sex.Male },
                onSecondSelectionClicked = { sex = Sex.Female }
            )


            Spacer(modifier = Modifier.height(12.dp))


            FieldLabel(
                text = stringResource(R.string.microchip),
            )


            Field(
                value = microChip,
                onValueChange = { microChip = it },
                placeholder = "15 Digits",
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
            )

            Spacer(modifier = Modifier.height(12.dp))


            Spacer(modifier = Modifier.weight(1f))


            PrimaryButton(
                onClick = onSavePetClicked,
                text = stringResource(R.string.save_pet)
            )

        }
    }

}


@Composable
private fun SpecieItem(
    specie: Specie,
    selectedSpecie: Specie,
    modifier: Modifier = Modifier,
    onClick: (Specie) -> Unit
) {

    val isSelected = specie == selectedSpecie

    val textColor = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onBackground
    val borderColor = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.2f)
    val backgroundColor = if (isSelected) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.surfaceContainerLowest
    Text(
        text = specie.name,
        color = textColor,
        textAlign = TextAlign.Center,
        modifier = modifier
            .clickable { onClick(specie) }
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
        AddPetContent(
            onSavePetClicked = {},
            onBackClicked = {}
        )
    }
}


object DateVisualTransformation : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        val trimmed = text.text.take(8)
        var output = ""
        for (i in trimmed.indices) {
            output += trimmed[i]
            if (i == 1 || i == 3) output += " / "
        }
        return TransformedText(
            AnnotatedString(output),
            object : OffsetMapping {
                override fun originalToTransformed(offset: Int): Int =
                    when {
                        offset <= 2 -> offset
                        offset <= 4 -> offset + 3
                        else -> offset + 6
                    }
                override fun transformedToOriginal(offset: Int): Int =
                    when {
                        offset <= 2 -> offset
                        offset <= 5 -> offset - 3
                        else -> offset - 6
                    }
            }
        )
    }
}