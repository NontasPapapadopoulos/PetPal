package nondas.pap.petpal.data

import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.Flow
import nondas.pap.petpal.domain.model.Medicine
import nondas.pap.petpal.domain.model.Pet
import nondas.pap.petpal.domain.repository.MedicineRepository

class MedicineDataRepository(
    private val firestore: FirebaseFirestore
): MedicineRepository {


    override suspend fun get(id: String): Flow<Medicine> {
        TODO("Not yet implemented")
    }

    override suspend fun getAll(petId: String): Flow<List<Medicine>> {
        TODO("Not yet implemented")
    }

    override suspend fun add(medicine: Medicine) {
        TODO("Not yet implemented")
    }

    override suspend fun update(medicine: Medicine) {
        TODO("Not yet implemented")
    }

    override suspend fun delete(medicine: Medicine) {
        TODO("Not yet implemented")
    }


    companion object {
        private const val COLLECTION_NAME = "Medicine"
    }
}