package nondas.pap.petpal.data

import com.google.firebase.firestore.FirebaseFirestore
import nondas.pap.petpal.domain.repository.PetRepository

class PetDataRepository(
    private val firestore: FirebaseFirestore
): PetRepository {


    companion object {
        private const val COLLECTION_NAME = "Pet"
    }

}