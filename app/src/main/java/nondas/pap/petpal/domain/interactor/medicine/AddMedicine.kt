package nondas.pap.petpal.domain.interactor.medicine

import kotlinx.coroutines.CoroutineDispatcher
import nondas.pap.petpal.domain.executor.IoDispatcher
import nondas.pap.petpal.domain.interactor.SuspendUseCase
import nondas.pap.petpal.domain.repository.MedicineRepository
import javax.inject.Inject

class AddMedicine @Inject constructor(
    private val medicineRepository: MedicineRepository,
    @IoDispatcher dispatcher: CoroutineDispatcher
): SuspendUseCase<Unit, Unit>(dispatcher) {


    override suspend fun invoke(params: Unit) {

    }



}