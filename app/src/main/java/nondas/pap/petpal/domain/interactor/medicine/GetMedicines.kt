package nondas.pap.petpal.domain.interactor.medicine

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import nondas.pap.petpal.domain.FlowUseCase
import nondas.pap.petpal.domain.executor.IoDispatcher
import nondas.pap.petpal.domain.interactor.SuspendUseCase
import nondas.pap.petpal.domain.model.Medicine
import nondas.pap.petpal.domain.repository.MedicineRepository
import javax.inject.Inject

class GetMedicines @Inject constructor(
    private val medicineRepository: MedicineRepository,
    @IoDispatcher dispatcher: CoroutineDispatcher
): FlowUseCase<List<Medicine>, GetMedicines.Params>(dispatcher) {


    override fun invoke(params: Params): Flow<List<Medicine>> {
        return medicineRepository.getAll(params.petId)
    }


    data class Params(val petId: String)
}