package nondas.pap.petpal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import dagger.hilt.android.AndroidEntryPoint
import nondas.pap.petpal.presentation.MainViewModel
import nondas.pap.petpal.ui.navigation.Navigation

import nondas.pap.petpal.ui.theme.PetPalTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val settings by viewModel.state.collectAsStateWithLifecycle()

            PetPalTheme(darkTheme = settings.darkThemeEnabled) {
                Navigation()
            }
        }
    }
}



