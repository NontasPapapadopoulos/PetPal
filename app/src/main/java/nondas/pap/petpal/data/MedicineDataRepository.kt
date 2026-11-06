package nondas.pap.petpal.data

import com.google.firebase.firestore.FirebaseFirestore
import nondas.pap.petpal.domain.repository.MedicineRepository

class MedicineDataRepository(
    private val firestore: FirebaseFirestore
): MedicineRepository {


    companion object {
        private const val COLLECTION_NAME = "Medicine"
    }
}