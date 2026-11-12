package nondas.pap.petpal.domain.interactor.pet

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import nondas.pap.petpal.domain.FlowUseCase
import nondas.pap.petpal.domain.executor.IoDispatcher
import nondas.pap.petpal.domain.model.Pet
import nondas.pap.petpal.domain.repository.PetRepository
import javax.inject.Inject

class GetPet @Inject constructor(
    private val petRepository: PetRepository,
    @IoDispatcher dispatcher: CoroutineDispatcher
): FlowUseCase<Pet, GetPet.Params>(dispatcher) {

    override fun invoke(params: Params): Flow<Pet> {
        return petRepository.get(params.id)
    }


    data class Params(val id: String)
}