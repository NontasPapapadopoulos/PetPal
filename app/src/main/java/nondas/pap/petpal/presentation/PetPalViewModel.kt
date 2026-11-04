package nondas.pap.petpal.presentation


import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.*
//abstract class PetPalViewModel<S>(private val initialState: S) : ViewModel() {
//    private val _uiState = MutableStateFlow(initialState)
//    val uiState: StateFlow<S> = _uiState.asStateFlow()
//}


abstract class PetPalViewModel<N> : ViewModel() { //in E : Any, out S, N


//    protected abstract val _uiState: StateFlow<S>
//    open val uiState: StateFlow<S> get() = _uiState

    private val _errorFlow = MutableSharedFlow<Throwable>()
    open val errorFlow: SharedFlow<Throwable> = _errorFlow.asSharedFlow()

    private val _navigationFlow = MutableSharedFlow<N>()
    open val navigationFlow: SharedFlow<N> = _navigationFlow.asSharedFlow()

//    private val eventHandlers = HashMap<KClass<*>, suspend (Any) -> Unit>()
//
//    @Suppress("UNCHECKED_CAST")
//    protected fun <T : E> on(clazz: KClass<T>, handler: suspend (event: T) -> Unit) {
//        eventHandlers[clazz] = handler as (suspend (Any) -> Unit)
//    }
//
//    open fun <T : E> add(event: T) = viewModelScope.launch {
//        val handler = eventHandlers.getValue(event::class)
//        handler(event)
//    }

    protected open suspend fun addError(throwable: Throwable) {
        _errorFlow.emit(throwable)
    }

    protected open suspend fun navigateTo(navigationTarget: N) {
        _navigationFlow.emit(navigationTarget)
    }

//    inline fun <reified T> onState(block: (state: T) -> Unit) {
//        val state = uiState.value
//        if (state is T) {
//            block(state)
//        }
//    }
}
