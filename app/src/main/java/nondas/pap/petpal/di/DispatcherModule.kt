package nondas.pap.petpal.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import nondas.pap.petpal.domain.executor.IoDispatcher


@Module
@InstallIn(SingletonComponent::class)
object DispatcherModule {

    @ExperimentalCoroutinesApi
    @IoDispatcher
    @Provides
    fun provideIoDispatcher(): CoroutineDispatcher = Dispatchers.IO.limitedParallelism(4)

}