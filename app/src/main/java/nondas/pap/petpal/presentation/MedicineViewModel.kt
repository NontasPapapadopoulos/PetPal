package nondas.pap.petpal.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import nondas.pap.petpal.domain.execute
import nondas.pap.petpal.domain.interactor.medicine.AddMedicine
import nondas.pap.petpal.domain.interactor.medicine.GetMedicine
import nondas.pap.petpal.domain.interactor.medicine.UpdateMedicine
import nondas.pap.petpal.domain.interactor.pet.GetPets
import nondas.pap.petpal.domain.model.Medicine
import nondas.pap.petpal.domain.model.Pet
import nondas.pap.petpal.domain.model.enums.MedicineType
import nondas.pap.petpal.domain.model.enums.Repeat

@HiltViewModel(assistedFactory = MedicineViewModel.Factory::class)
class MedicineViewModel @AssistedInject constructor(
    private val getMedicine: GetMedicine,
    private val addMedicine: AddMedicine,
    private val updateMedicine: UpdateMedicine,
    private val getPets: GetPets,
    @Assisted("petId") private val petId: String,
    @Assisted("medicineId") private val medicineId: String
): ViewModel() {


    @AssistedFactory
    interface Factory {
        fun create(
            @Assisted("petId") petId: String,
            @Assisted("medicineId") medicineId: String
        ): MedicineViewModel
    }

    private val petsFlow = getPets.execute()
        .map { it.getOrThrow() }
        .catch {  }

    private val medicineFlow = getMedicine.execute(GetMedicine.Params(petId, medicineId))
        .map { it.getOrThrow() }
        .catch {}

    fun onAddMedicine(medicine: Medicine) {
        viewModelScope.launch {
            addMedicine.execute(AddMedicine.Params(medicine))
                .fold(
                    onSuccess = {},
                    onFailure = {}
                )
        }
    }

    val state: StateFlow<MedicineState> = combine(
            petsFlow,
            medicineFlow
        ) { pets, medicine ->
            MedicineState(
                pets,
                medicine
            )
        }.stateIn(
            scope = viewModelScope,
            initialValue = MedicineState(),
            started = SharingStarted.WhileSubscribed()
        )

    fun onUpdateMedicine(medicine: Medicine) {
        viewModelScope.launch {
            updateMedicine.execute(UpdateMedicine.Params(medicine))
                .fold(
                    onSuccess = {},
                    onFailure = {}
                )
        }
    }



}

data class MedicineState(
    val pets: List<Pet> = listOf(),
    val medicine: Medicine = Medicine(
        id = "",
        ownerId = "",
        petId = "",
        name = "",
        type = MedicineType.Vaccine,
        date = null,
        notes = "",
        repeat = Repeat.Once
    )
)