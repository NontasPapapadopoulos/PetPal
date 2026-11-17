package nondas.pap.petpal.domain.interactor.medicine

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import nondas.pap.petpal.domain.FlowUseCase
import nondas.pap.petpal.domain.executor.IoDispatcher
import nondas.pap.petpal.domain.model.Medicine
import nondas.pap.petpal.domain.repository.MedicineRepository
import javax.inject.Inject

class GetMedicine @Inject constructor(
    private val medicineRepository: MedicineRepository,
    @IoDispatcher dispatcher: CoroutineDispatcher
): FlowUseCase<Medicine, GetMedicine.Params>(dispatcher) {


    override  fun invoke(params: Params): Flow<Medicine> {
        return medicineRepository.get(params.petId, params.medicineId)
    }

    data class Params(
        val petId: String,
        val medicineId: String
    )

}