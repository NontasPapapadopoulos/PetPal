package nondas.pap.petpal.data

import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.Flow
import nondas.pap.petpal.domain.model.Pet
import nondas.pap.petpal.domain.repository.PetRepository

class PetDataRepository(
    private val firestore: FirebaseFirestore
): PetRepository {
    override suspend fun get(id: String): Flow<Pet> {
        TODO("Not yet implemented")
    }

    override suspend fun getAll(userId: String): Flow<List<Pet>> {
        TODO("Not yet implemented")
    }

    override suspend fun add(pet: Pet) {
        TODO("Not yet implemented")
    }

    override suspend fun update(pet: Pet) {
        TODO("Not yet implemented")
    }

    override suspend fun delete(pet: Pet) {
        TODO("Not yet implemented")
    }


    companion object {
        private const val COLLECTION_NAME = "Pet"
    }

}