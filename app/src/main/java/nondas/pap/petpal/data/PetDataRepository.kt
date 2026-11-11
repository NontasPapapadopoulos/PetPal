package nondas.pap.petpal.data

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.dataObjects
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.tasks.await
import nondas.pap.petpal.domain.model.Pet
import nondas.pap.petpal.domain.repository.PetRepository

class PetDataRepository(
    private val firestore: FirebaseFirestore
): PetRepository {

    override fun get(id: String): Flow<Pet> {
        return firestore.collection(COLLECTION_NAME)
            .document(id)
            .dataObjects<Pet>()
            .filterNotNull()

    }

    override fun getAll(): Flow<List<Pet>> {
        val uid = FirebaseAuth.getInstance().currentUser?.uid
            ?: throw IllegalStateException("User not authenticated")

        return firestore.collection(COLLECTION_NAME)
            .whereEqualTo("ownerId", uid)
            .dataObjects<Pet>()
    }

    override suspend fun add(pet: Pet) {
        firestore.collection(COLLECTION_NAME)
            .document(pet.id)
            .set(pet)
            .await()
    }

    override suspend fun update(pet: Pet) {
        firestore.collection(COLLECTION_NAME)
            .document(pet.id)
            .set(pet) // or .update(mapOf(...)) for partial updates
            .await()
    }

    override suspend fun delete(pet: Pet) {
        deletePetMedicines(pet)

        firestore.collection(COLLECTION_NAME)
            .document(pet.id)
            .delete()
            .await()
    }

    private suspend fun deletePetMedicines(pet: Pet) {
        val medicines = firestore
            .collection(COLLECTION_NAME).document(pet.id)
            .collection(MEDICINE_SUBCOLLECTION)
            .get()
            .await()

        medicines.forEach { it.reference.delete().await() }
    }

    companion object {
        private const val COLLECTION_NAME = "Pet"
        private const val MEDICINE_SUBCOLLECTION = "Medicine"

    }

}