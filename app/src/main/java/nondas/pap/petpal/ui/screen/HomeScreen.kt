package nondas.pap.petpal.ui.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.google.apps.card.v1.OnClick
import nondas.pap.petpal.R
import nondas.pap.petpal.domain.model.Pet
import nondas.pap.petpal.domain.model.enums.Sex
import nondas.pap.petpal.domain.model.enums.Specie
import nondas.pap.petpal.presentation.HomeViewModel
import nondas.pap.petpal.ui.Screen
import nondas.pap.petpal.ui.composable.Badge
import nondas.pap.petpal.ui.composable.BottomAppBar
import nondas.pap.petpal.ui.composable.ForwardArrowIcon
import nondas.pap.petpal.ui.theme.PetPalShapes
import nondas.pap.petpal.ui.theme.PetPalTheme
import kotlin.random.Random


@Composable
fun HomeScreen(
    navigateToSettings: () -> Unit,
    navigateToAddPet: () -> Unit,
    navigateToPet: (String) -> Unit,
    navigateToNotifications: () -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {


    val state = viewModel.state.collectAsStateWithLifecycle()

    HomeContent(
        content = state.value ,
        onSettingsClicked = navigateToSettings,
        onAddPetClicked = navigateToAddPet,
        onPetClicked = navigateToPet,
        onNotificationsClicked = navigateToNotifications
    ) 

}


@Composable
private fun HomeContent(
    content: List<Pet>,
    onSettingsClicked: () -> Unit,
    onAddPetClicked: () -> Unit,
    onPetClicked: (String) -> Unit,
    onNotificationsClicked: () -> Unit
) {

    Scaffold(
        bottomBar = {
            BottomAppBar(
                screen = Screen.Home,
                onSettingsClicked = onSettingsClicked
            )
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
                .padding(it)
                .padding(24.dp)
//                .verticalScroll(rememberScrollState())
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Column {
                    Text(
                        text = "Monday, 2 November",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Text(
                        text = "Hi, Nondas",
                        style = MaterialTheme.typography.headlineSmall
                    )
                }

                OutlinedButton(
                    onClick = onNotificationsClicked,
                    shape = RoundedCornerShape(16.dp),
                    contentPadding = PaddingValues(16.dp),
                    border = BorderStroke(
                        width = 1.dp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.2f)
                    ),
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = MaterialTheme.colorScheme.surfaceContainerLowest,
                    )

                ) {
                    Icon(
                        imageVector = Icons.Outlined.Notifications,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))


            LazyColumn {
                items(content) { pet ->
                    PetItem(
                        name = pet.name,
                        specie = pet.specie,
                        breed = pet.breed,
                        age = pet.age,
                        onClick = { onPetClicked("") }
                    ) 
                }
            }


            Spacer(modifier = Modifier.height(16.dp))


            OutlinedButton(
                onClick = onAddPetClicked,
                modifier = Modifier.fillMaxWidth()
                    .height(56.dp),
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
    specie: Specie,
    breed: String,
    age: String,
    onClick: () -> Unit
) {

    Card(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth()
            .padding(vertical = 8.dp),
        border = BorderStroke(
            width = 1.dp,
            color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.2f)
        ),
        colors = CardDefaults.cardColors().copy(
            containerColor = MaterialTheme.colorScheme.surfaceContainerLowest
        )
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(vertical = 24.dp, horizontal = 16.dp)
        ) {

            Badge(name)

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(
                    text = name,
                    style = MaterialTheme.typography.titleMedium
                )

                Text(
                    text = "$specie · $breed · $age y",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            ForwardArrowIcon()
        }

    }
}

fun Color.darken(factor: Float = 0.6f): Color = copy(
    red = red * factor,
    green = green * factor,
    blue = blue * factor
)


@Preview
@Composable
private fun HomeContentPreview() {
    PetPalTheme {
        HomeContent(
            content = generatePets(),
            onSettingsClicked = {},
            onPetClicked = {},
            onAddPetClicked = {},
            onNotificationsClicked = {},
        )
    }
}


private fun generatePets(): List<Pet> {
    return (1..3).map {
        Pet(
            id = it.toString(),
            ownerId = ((1..100).random()).toString(),
            name = "Happy Pet $it",
            age = ((1..12).random()).toString(),
            sex = Sex.Male,
            specie = Specie.Dog,
            breed = "whatever",
            microchipNumber = ((1..10000).random()).toString()
        )
    }
}