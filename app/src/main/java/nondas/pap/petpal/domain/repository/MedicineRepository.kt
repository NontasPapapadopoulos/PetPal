package nondas.pap.petpal.domain.repository

import kotlinx.coroutines.flow.Flow
import nondas.pap.petpal.domain.model.Medicine
import nondas.pap.petpal.domain.model.Pet

interface MedicineRepository {
    fun get(petId: String, id: String): Flow<Medicine>
    fun getAll(petId: String): Flow<List<Medicine>>
    suspend fun add(medicine: Medicine)
    suspend fun update(medicine: Medicine)
    suspend fun delete(medicine: Medicine)
}