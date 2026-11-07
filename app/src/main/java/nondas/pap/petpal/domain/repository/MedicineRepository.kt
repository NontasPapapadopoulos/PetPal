package nondas.pap.petpal.domain.repository

import kotlinx.coroutines.flow.Flow
import nondas.pap.petpal.domain.model.Medicine
import nondas.pap.petpal.domain.model.Pet

interface MedicineRepository {
    suspend fun get(id: String): Flow<Medicine>
    suspend fun getAll(petId: String): Flow<List<Medicine>>
    suspend fun add(medicine: Medicine)
    suspend fun update(medicine: Medicine)
    suspend fun delete(medicine: Medicine)
}