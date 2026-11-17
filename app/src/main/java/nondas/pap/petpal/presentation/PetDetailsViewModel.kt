package nondas.pap.petpal.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import nondas.pap.petpal.domain.interactor.medicine.GetMedicines
import nondas.pap.petpal.domain.interactor.pet.GetPet
import nondas.pap.petpal.domain.model.Medicine
import nondas.pap.petpal.domain.model.Pet
import nondas.pap.petpal.domain.model.enums.Sex
import nondas.pap.petpal.domain.model.enums.Specie
import javax.inject.Inject

@HiltViewModel
class PetDetailsViewModel @Inject constructor(
    private val getMedicines: GetMedicines,
    private val getPet: GetPet,
) : ViewModel() {

    private val petFlow = getPet.execute(GetPet.Params(""))
        .map { it.getOrThrow() }
        .catch {  }

    private val medicinesFlow = getMedicines.execute(GetMedicines.Params(""))
        .map { it.getOrThrow() }
        .catch {  }


    val state: StateFlow<PetState> = combine(
        petFlow,
        medicinesFlow
    ) { pet, medicines ->
        PetState(
            pet,
            medicines
        )
    }.stateIn(
        scope = viewModelScope,
        initialValue = PetState(),
        started = SharingStarted.WhileSubscribed()
    )


}


data class PetState(
    val pet: Pet = Pet(name = "", breed = "", birthday = "", sex = Sex.Male, specie = Specie.Dog, weight = "10"),
    val medicines: List<Medicine> = listOf()
)