package nondas.pap.petpal.domain.interactor.medicine

import kotlinx.coroutines.CoroutineDispatcher
import nondas.pap.petpal.domain.executor.IoDispatcher
import nondas.pap.petpal.domain.interactor.SuspendUseCase
import nondas.pap.petpal.domain.model.Medicine
import nondas.pap.petpal.domain.repository.MedicineRepository
import javax.inject.Inject

class AddMedicine @Inject constructor(
    private val medicineRepository: MedicineRepository,
    @IoDispatcher dispatcher: CoroutineDispatcher
): SuspendUseCase<Unit, AddMedicine.Params>(dispatcher) {


    override suspend fun invoke(params: Params) {
        medicineRepository.add(params.medicine)
    }

    data class Params(val medicine: Medicine)

}