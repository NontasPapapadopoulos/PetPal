package nondas.pap.petpal.domain.interactor.pet

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import nondas.pap.petpal.domain.FlowUseCase
import nondas.pap.petpal.domain.executor.IoDispatcher
import nondas.pap.petpal.domain.model.Pet
import nondas.pap.petpal.domain.repository.PetRepository
import javax.inject.Inject

class GetPets @Inject constructor(
    private val petRepository: PetRepository,
    @IoDispatcher dispatcher: CoroutineDispatcher
): FlowUseCase<List<Pet>, Unit>(dispatcher) {


    override fun invoke(params: Unit): Flow<List<Pet>> {
        return petRepository.getAll()
    }


}