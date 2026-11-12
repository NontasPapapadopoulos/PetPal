package nondas.pap.petpal.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.fold
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import nondas.pap.petpal.domain.execute
import nondas.pap.petpal.domain.interactor.pet.GetPets
import nondas.pap.petpal.domain.model.Pet
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPets: GetPets
): ViewModel() {


    val state: StateFlow<List<Pet>> = getPets.execute(Unit)
        .map { it.getOrThrow() }

        .stateIn(
            scope = viewModelScope,
            initialValue = listOf(),
            started = SharingStarted.WhileSubscribed()
        )


}