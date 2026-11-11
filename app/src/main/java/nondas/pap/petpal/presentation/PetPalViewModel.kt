package nondas.pap.petpal.presentation


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch


abstract class PetPalViewModel<State, inEvent, NavigationTarget>(
    private val initialState: State
) : ViewModel() {


    private val _localState = MutableStateFlow(initialState)
    protected val localState: StateFlow<State> = _localState

    protected fun setState(update: (State) -> State) {
        _localState.update(update)
    }

    open val state: StateFlow<State> = _localState.asStateFlow()

    abstract fun onEvent(event: inEvent)

    protected fun launch(block: suspend CoroutineScope.() -> Unit) {
        viewModelScope.launch { block() }
    }

    private val _errorFlow = MutableSharedFlow<Throwable>()
    open val errorFlow: SharedFlow<Throwable> = _errorFlow.asSharedFlow()

    private val _messageFlow = MutableSharedFlow<String>()
    open val messageFlow: SharedFlow<String> = _messageFlow.asSharedFlow()

    private val _navigationFlow = MutableSharedFlow<NavigationTarget>()
    open val navigationFlow: SharedFlow<NavigationTarget> = _navigationFlow.asSharedFlow()


    protected open suspend fun addError(throwable: Throwable) {
        _errorFlow.emit(throwable)
    }

    protected open suspend fun navigateTo(target: NavigationTarget) {
        _navigationFlow.emit(target)
    }

    protected open suspend fun showMessage(message: String) {
        _messageFlow.emit(message)
    }

}


//private val _eventFlow = MutableSharedFlow<OutEvent>()
//protected val eventFlow: SharedFlow<OutEvent> = _eventFlow.asSharedFlow()
//
//protected fun sendEvent(event: OutEvent) {
//    viewModelScope.launch { _eventFlow.emit(event) }
//}


sealed interface OutEvent {
    data class Navigate(val screen: Any): OutEvent
    data class ShowError(val error: String): OutEvent
    data class ShowSnackBar(val message: String): OutEvent
}
