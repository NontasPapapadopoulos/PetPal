package nondas.pap.petpal.ui.theme.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.ArrowForwardIos
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nondas.pap.petpal.R
import nondas.pap.petpal.ui.theme.PetPalShapes
import nondas.pap.petpal.ui.theme.PetPalTheme


@Composable
private fun HomeScreen() {

}


@Composable
private fun HomeContent() {

    Scaffold {
        Column(
            modifier = Modifier.fillMaxSize()
                .padding(it)
                .padding(24.dp)
                .verticalScroll(rememberScrollState())
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Column {
                    Text(
                        text = "Monday, 2 November",
                    )

                    Text(
                        text = "Hi, Nondas",
                        style = MaterialTheme.typography.headlineMedium
                    )
                }

                OutlinedButton(
                    onClick = {},

                    shape = RoundedCornerShape(24.dp)
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Notifications,
                        contentDescription = null,
                        modifier = Modifier.padding(vertical = 16.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))


            PetItem(
                name = "Roza",
                specie = "Dog",
                breed = "Frenchton",
                age = "6"
            )


            PetItem(
                name = "Pepe",
                specie = "Dog",
                breed = "Yorkshire",
                age = "6"
            )


            PetItem(
                name = "Luna",
                specie = "Dog",
                breed = "Golden",
                age = "6"
            )

            Spacer(modifier = Modifier.height(16.dp))


            OutlinedButton(
                onClick = {},
                modifier = Modifier.fillMaxWidth()
                    .height(64.dp),
                shape = PetPalShapes.large,
            ) {

                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary
                )

                Text(
                    text = stringResource(R.string.add_pet),
                    color = MaterialTheme.colorScheme.primary
                )
            }

        }

    }




}


@Composable
private fun PetItem(
    name: String,
    specie: String,
    breed: String,
    age: String
) {

    Card(
        onClick = {},
        modifier = Modifier.fillMaxWidth()
            .padding(vertical = 8.dp),
        border = BorderStroke(
            width = 1.dp,
            color = MaterialTheme.colorScheme.surfaceVariant
        )
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
                    text = "$specie · $breed · $age y"
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            Icon(
                imageVector = Icons.Outlined.ArrowForwardIos,
                contentDescription = null
            )
        }

    }
}




@Preview
@Composable
private fun HomeContentPreview() {
    PetPalTheme {
        HomeContent()
    }
}