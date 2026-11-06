package nondas.pap.petpal.di

import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import nondas.pap.petpal.data.MedicineDataRepository
import nondas.pap.petpal.data.PetDataRepository
import nondas.pap.petpal.data.UserDataRepository
import nondas.pap.petpal.domain.repository.MedicineRepository
import nondas.pap.petpal.domain.repository.PetRepository
import nondas.pap.petpal.domain.repository.UserRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {


    @Provides
    @Singleton
    fun provideUserRepository(
        firestore: FirebaseFirestore
    ): UserRepository {
        return UserDataRepository(firestore)
    }


    @Provides
    @Singleton
    fun providePetRepository(
        firestore: FirebaseFirestore
    ): PetRepository {
        return PetDataRepository(firestore)
    }


    @Provides
    @Singleton
    fun provideMedicineRepository(
        firestore: FirebaseFirestore
    ): MedicineRepository {
        return MedicineDataRepository(firestore)
    }
}