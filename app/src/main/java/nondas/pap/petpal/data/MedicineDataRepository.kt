package nondas.pap.petpal.data

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.dataObjects
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.tasks.await
import nondas.pap.petpal.domain.model.Medicine
import nondas.pap.petpal.domain.model.Pet
import nondas.pap.petpal.domain.repository.MedicineRepository

class MedicineDataRepository(
    private val firestore: FirebaseFirestore
): MedicineRepository {


    override fun get(petId: String, id: String): Flow<Medicine> {
        return firestore
            .collection(PET_COLLECTION).document(petId)
            .collection(MEDICINE_SUBCOLLECTION).document(id)
            .dataObjects<Medicine>()
            .filterNotNull()
    }

    override fun getAll(petId: String): Flow<List<Medicine>> {
        return firestore
            .collection(PET_COLLECTION).document(petId)
            .collection(MEDICINE_SUBCOLLECTION)
            .dataObjects<Medicine>()
    }

    override suspend fun add(medicine: Medicine) {
        firestore
            .collection(PET_COLLECTION).document(medicine.petId)
            .collection(MEDICINE_SUBCOLLECTION).document(medicine.id)
            .set(medicine)
            .await()
    }

    override suspend fun update(medicine: Medicine) {
        firestore
            .collection(PET_COLLECTION).document(medicine.petId)
            .collection(MEDICINE_SUBCOLLECTION).document(medicine.id)
            .set(medicine)
            .await()
    }

    override suspend fun delete(medicine: Medicine) {
        firestore
            .collection(PET_COLLECTION).document(medicine.petId)
            .collection(MEDICINE_SUBCOLLECTION).document(medicine.id)
            .delete()
            .await()
    }


    companion object {
        private const val PET_COLLECTION = "Pet"
        private const val MEDICINE_SUBCOLLECTION = "Medicine"
    }
}