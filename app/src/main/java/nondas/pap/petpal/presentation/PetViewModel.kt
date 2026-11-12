package nondas.pap.petpal.presentation

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import nondas.pap.petpal.domain.interactor.medicine.GetMedicines
import nondas.pap.petpal.domain.interactor.pet.GetPet
import nondas.pap.petpal.domain.model.Medicine
import javax.inject.Inject

@HiltViewModel
class PetViewModel @Inject constructor(
    private val getMedicines: GetMedicines,
    private val getPet: GetPet,
) : ViewModel() {

    private val petFlow = getPet.execute(GetPet.Params(""))
        .map { it.getOrThrow() }
        .catch {  }

    private val medicinesFlow = getMedicines.execute(GetMedicines.Params(""))
        .map { it.getOrThrow() }
        .catch {  }



}