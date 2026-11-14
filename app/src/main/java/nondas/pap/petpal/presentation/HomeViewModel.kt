package nondas.pap.petpal.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.fold
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import nondas.pap.petpal.domain.execute
import nondas.pap.petpal.domain.interactor.pet.GetPets
import nondas.pap.petpal.domain.interactor.user.GetUser
import nondas.pap.petpal.domain.model.Pet
import nondas.pap.petpal.domain.model.User
import nondas.pap.petpal.ui.navigation.Home
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPets: GetPets,
    private val getUser: GetUser
): ViewModel() {

    private val petsFlow = getPets.execute(Unit)
        .map { it.getOrThrow() }
        .catch {}

    private val userFlow = getUser.execute()
        .map { it.getOrThrow() }
        .catch {  }


    val state: StateFlow<HomeState> = combine(
        petsFlow,
        userFlow
    ) { pets, user ->
        HomeState(user, pets)
    }.stateIn(
        scope = viewModelScope,
        initialValue = HomeState(),
        started = SharingStarted.WhileSubscribed()
    )


}


data class HomeState(
    val user: User = User(
        fullName = "",
        email = "",
    ),
    val pets: List<Pet> = listOf()
)