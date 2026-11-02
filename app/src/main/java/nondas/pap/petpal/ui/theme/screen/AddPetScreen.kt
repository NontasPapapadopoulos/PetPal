package nondas.pap.petpal.ui.theme.screen

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CameraAlt
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nondas.pap.petpal.BackButton
import nondas.pap.petpal.R
import nondas.pap.petpal.ui.theme.PetPalShapes
import nondas.pap.petpal.ui.theme.PetPalTheme

@Composable
fun AddPetScreen() {

}


@Composable
private fun AddPetContent() {

    Column(
        modifier = Modifier
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
                style = MaterialTheme.typography.headlineMedium
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

        Text(
            text = stringResource(R.string.name),
            modifier = Modifier.fillMaxWidth()
                .padding(bottom = 4.dp),
            textAlign = TextAlign.Start
        )



        OutlinedTextField(
            value = "",
            onValueChange = {},
            modifier = Modifier.fillMaxWidth(),
        )


        Spacer(modifier = Modifier.height(12.dp))


        Text(
            text = stringResource(R.string.species),
            modifier = Modifier.fillMaxWidth()
                .padding(bottom = 4.dp),
            textAlign = TextAlign.Start
        )

        Row {
            SpecieItem(
                specie = stringResource(R.string.dog),
                isSelected = true,
                modifier = Modifier.weight(1f)
            )

            SpecieItem(
                specie = stringResource(R.string.cat),
                isSelected = true,
                modifier = Modifier.weight(1f)
            )

            SpecieItem(
                specie = stringResource(R.string.bird),
                isSelected = true,
                modifier = Modifier.weight(1f)
            )

            SpecieItem(
                specie = stringResource(R.string.other),
                isSelected = true,
                modifier = Modifier.weight(1f)
            )


        }

        Spacer(modifier = Modifier.height(12.dp))


        Text(
            text = stringResource(R.string.breed),
            modifier = Modifier.fillMaxWidth()
                .padding(bottom = 4.dp),
            textAlign = TextAlign.Start
        )



        OutlinedTextField(
            value = "",
            onValueChange = {},
            modifier = Modifier.fillMaxWidth(),
        )

        Spacer(modifier = Modifier.height(12.dp))

        Row {

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = stringResource(R.string.birth_date),
                    modifier = Modifier.fillMaxWidth()
                        .padding(bottom = 4.dp),
                    textAlign = TextAlign.Start
                )

                Spacer(modifier = Modifier.height(4.dp))


                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier.fillMaxWidth(),
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = stringResource(R.string.weight),
                    modifier = Modifier.fillMaxWidth()
                        .padding(bottom = 4.dp),
                    textAlign = TextAlign.Start
                )

                Spacer(modifier = Modifier.height(4.dp))


                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier.fillMaxWidth(),
                )
            }

        }

        Spacer(modifier = Modifier.height(12.dp))


//        Text(
//            text = stringResource(R.string.sex),
//            modifier = Modifier.fillMaxWidth()
//                .padding(bottom = 4.dp),
//            textAlign = TextAlign.Start
//        )


        Row(
            modifier = Modifier.fillMaxWidth()
                .height(56.dp)
                .background(
                    color = MaterialTheme.colorScheme.surfaceContainerHigh,
                    shape = PetPalShapes.medium
                )
                .padding(horizontal = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            SexItem(
                sex = stringResource(R.string.male),
                isSelected = true,
                modifier = Modifier.weight(1f)
            )

            SexItem(
                sex = stringResource(R.string.female),
                isSelected = false,
                modifier = Modifier.weight(1f)

            )

        }

        Spacer(modifier = Modifier.height(12.dp))


        Text(
            text = stringResource(R.string.microchip),
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start
        )

        Spacer(modifier = Modifier.height(4.dp))


        OutlinedTextField(
            value = "",
            onValueChange = {},
            modifier = Modifier.fillMaxWidth(),
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = stringResource(R.string.vet_clinic),
            modifier = Modifier.fillMaxWidth()
                .padding(bottom = 4.dp),
            textAlign = TextAlign.Start
        )


        OutlinedTextField(
            value = "",
            onValueChange = {},
            modifier = Modifier.fillMaxWidth(),
        )

        Spacer(modifier = Modifier.weight(1f))


        Button(
            onClick = {},
            modifier = Modifier.fillMaxWidth()
                .height(height = 54.dp),
            shape = PetPalShapes.medium
        ) {
            Text(
                text = stringResource(R.string.save_pet)
            )
        }

    }

}

@Composable
private fun SexItem(
    sex: String,
    isSelected: Boolean,
    modifier: Modifier = Modifier
) {
    val color = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant
    val backgroundColor = if (isSelected) MaterialTheme.colorScheme.background else MaterialTheme.colorScheme.surfaceVariant

    Text(
        text = sex,
        color = color,
        style = MaterialTheme.typography.labelMedium,
        textAlign = TextAlign.Center,
        modifier = modifier
            .background(
                color = backgroundColor,
                shape = PetPalShapes.small
            )
            .padding( vertical = 12.dp)

    )
}

@Composable
private fun SpecieItem(
    specie: String,
    isSelected: Boolean,
    modifier: Modifier = Modifier
) {

    val color = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surfaceVariant
    val backgroundColor = if (isSelected) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.background
    Text(
        text = specie,
        color = color,
        textAlign = TextAlign.Center,
        modifier = modifier
            .padding(horizontal = 4.dp)
            .background(
                color = backgroundColor,
                shape = PetPalShapes.medium
            )
            .border(
                width = 1.dp,
                color = color,
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