package nondas.pap.petpal.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import nondas.pap.petpal.domain.interactor.pet.AddPet
import nondas.pap.petpal.domain.interactor.pet.GetPet
import nondas.pap.petpal.domain.interactor.pet.UpdatePet
import nondas.pap.petpal.domain.model.Pet
import nondas.pap.petpal.domain.model.enums.Sex
import nondas.pap.petpal.domain.model.enums.Specie


@HiltViewModel(assistedFactory = PetViewModel.Factory::class)
class PetViewModel @AssistedInject constructor(
    private val addPet: AddPet,
    private val updatePet: UpdatePet,
    private val getPet: GetPet,
    @Assisted private val petId: String?
): ViewModel() {

    @AssistedFactory
    interface Factory {
        fun create(id: String): PetViewModel
    }

    val state = getPet.execute(GetPet.Params(petId ?: ""))
        .map { it.getOrThrow()}
        .catch {  }
        .stateIn(
            initialValue = initialState(),
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed()
        )


    fun onAddPet(pet: Pet) {
        viewModelScope.launch {
            addPet.execute(AddPet.Params(pet))
                .fold(
                    onSuccess = {},
                    onFailure = {}
                )
        }
    }

    fun onUpdate(pet: Pet) {
        viewModelScope.launch {
            updatePet.execute(UpdatePet.Params(pet))
                .fold(
                    onSuccess = {},
                    onFailure = {}
                )
        }
    }

    private fun initialState() =
        Pet(
            id = "",
            ownerId = "",
            name = "",
            birthday = "",
            weight = "",
            sex = Sex.Male,
            specie = Specie.Dog,
            breed = "",
            microchipNumber = "",
            photoUrl = ""
        )
}

