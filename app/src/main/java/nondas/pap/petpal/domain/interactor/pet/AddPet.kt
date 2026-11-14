package nondas.pap.petpal.domain.interactor.pet

import kotlinx.coroutines.CoroutineDispatcher
import nondas.pap.petpal.domain.executor.IoDispatcher
import nondas.pap.petpal.domain.interactor.SuspendUseCase
import nondas.pap.petpal.domain.model.Pet
import nondas.pap.petpal.domain.repository.PetRepository
import javax.inject.Inject

class AddPet @Inject constructor(
    private val petRepository: PetRepository,
    @IoDispatcher dispatcher: CoroutineDispatcher
): SuspendUseCase<Unit, AddPet.Params>(dispatcher) {

    override suspend fun invoke(params: Params) {
        petRepository.add(params.pet)
    }

    data class Params(val pet: Pet)

}