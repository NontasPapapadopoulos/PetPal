package nondas.pap.petpal.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import nondas.pap.petpal.domain.interactor.execute
import nondas.pap.petpal.domain.interactor.pet.AddPet
import nondas.pap.petpal.domain.interactor.pet.GetPet
import nondas.pap.petpal.domain.interactor.pet.UpdatePet
import nondas.pap.petpal.domain.model.Pet
import javax.inject.Inject


@HiltViewModel
class AddPetViewModel @Inject constructor(
    private val addPet: AddPet,
    private val getPet: GetPet,
    private val updatePet: UpdatePet
): ViewModel() {

    val petFlow = getPet.execute(GetPet.Params(""))
        .map { it.getOrThrow() }
        .catch {  }


    fun onAddPet(pet: Pet) {
        viewModelScope.launch {
            addPet.execute().fold(
                onSuccess = {},
                onFailure = {}
            )
        }
    }





}