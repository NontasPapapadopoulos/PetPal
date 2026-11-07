package nondas.pap.petpal.domain.repository

import kotlinx.coroutines.flow.Flow
import nondas.pap.petpal.domain.model.Pet

interface PetRepository {
    suspend fun get(id: String): Flow<Pet>
    suspend fun getAll(userId: String): Flow<List<Pet>>
    suspend fun add(pet: Pet)
    suspend fun update(pet: Pet)
    suspend fun delete(pet: Pet)
}