package nondas.pap.petpal.ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nondas.pap.petpal.R
import nondas.pap.petpal.domain.model.enums.Sex
import nondas.pap.petpal.ui.theme.PetPalShapes
import nondas.pap.petpal.ui.theme.PetPalTheme

@Composable
fun <T : Enum<T>> SelectionRow(
    firstOption: T,
    secondOption: T,
    selected: T,
    onFirstSelected: () -> Unit,
    onSecondSelected: () -> Unit,
    modifier: Modifier = Modifier
) {

    Row(
        modifier = modifier.fillMaxWidth()
            .height(52.dp)
            .background(
                color = MaterialTheme.colorScheme.surfaceContainerHigh,
                shape = PetPalShapes.medium
            )
            .padding(horizontal = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        SelectionItem(
            selection = firstOption,
            isSelected = selected == firstOption,
            modifier = Modifier.weight(1f)
                .clickable { onFirstSelected() }
        )

        SelectionItem(
            selection = secondOption,
            isSelected = selected == secondOption,
            modifier = Modifier.weight(1f)
                .clickable { onSecondSelected() }
        )

    }
}


@Composable
private fun <T : Enum<T>> SelectionItem(
    selection: T,
    isSelected: Boolean,
    modifier: Modifier = Modifier
) {

    val color = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant
    val backgroundColor = if (isSelected) MaterialTheme.colorScheme.surfaceContainerLowest else MaterialTheme.colorScheme.surfaceVariant


    Text(
        text = selection.name,
        color = color,
        style = MaterialTheme.typography.labelMedium,
        textAlign = TextAlign.Center,
        modifier = modifier
            .background(
                color = backgroundColor,
                shape = PetPalShapes.small
            )
            .padding(vertical = 14.dp)

    )
}

@Preview
@Composable
private fun SelectionRowPreview() {
    PetPalTheme {
        SelectionRow(
            firstOption = Sex.Male,
            secondOption = Sex.Female,
            selected = Sex.Female,
            onSecondSelected = {},
            onFirstSelected = {}
        )
    }
}