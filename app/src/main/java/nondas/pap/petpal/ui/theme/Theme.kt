package nondas.pap.petpal.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

private val LightColors = lightColorScheme(
    primary = primaryLight,
    onPrimary = onPrimaryLight,
    primaryContainer = primaryContainerLight,
    onPrimaryContainer = onPrimaryContainerLight,
    secondary = secondaryLight,
    onSecondary = onSecondaryLight,
    secondaryContainer = secondaryContainerLight,
    onSecondaryContainer = onSecondaryContainerLight,
    tertiary = tertiaryLight,
    onTertiary = onTertiaryLight,
    tertiaryContainer = tertiaryContainerLight,
    onTertiaryContainer = onTertiaryContainerLight,
    error = errorLight,
    onError = onErrorLight,
    errorContainer = errorContainerLight,
    onErrorContainer = onErrorContainerLight,
    background = backgroundLight,
    onBackground = onBackgroundLight,
    surface = surfaceLight,
    onSurface = onSurfaceLight,
    surfaceVariant = surfaceVariantLight,
    onSurfaceVariant = onSurfaceVariantLight,
    outline = outlineLight,
    outlineVariant = outlineVariantLight,
    inverseSurface = inverseSurfaceLight,
    inverseOnSurface = inverseOnSurfaceLight,
    inversePrimary = inversePrimaryLight,
    scrim = scrimLight,
    surfaceTint = primaryLight,
    surfaceContainerLowest = surfaceContainerLowestLight,
    surfaceContainerLow = surfaceContainerLowLight,
    surfaceContainer = surfaceContainerLight,
    surfaceContainerHigh = surfaceContainerHighLight,
    surfaceContainerHighest = surfaceContainerHighestLight,
    surfaceDim = surfaceDimLight,
    surfaceBright = surfaceBrightLight,
)

private val DarkColors = darkColorScheme(
    primary = primaryDark,
    onPrimary = onPrimaryDark,
    primaryContainer = primaryContainerDark,
    onPrimaryContainer = onPrimaryContainerDark,
    secondary = secondaryDark,
    onSecondary = onSecondaryDark,
    secondaryContainer = secondaryContainerDark,
    onSecondaryContainer = onSecondaryContainerDark,
    tertiary = tertiaryDark,
    onTertiary = onTertiaryDark,
    tertiaryContainer = tertiaryContainerDark,
    onTertiaryContainer = onTertiaryContainerDark,
    error = errorDark,
    onError = onErrorDark,
    errorContainer = errorContainerDark,
    onErrorContainer = onErrorContainerDark,
    background = backgroundDark,
    onBackground = onBackgroundDark,
    surface = surfaceDark,
    onSurface = onSurfaceDark,
    surfaceVariant = surfaceVariantDark,
    onSurfaceVariant = onSurfaceVariantDark,
    outline = outlineDark,
    outlineVariant = outlineVariantDark,
    inverseSurface = inverseSurfaceDark,
    inverseOnSurface = inverseOnSurfaceDark,
    inversePrimary = inversePrimaryDark,
    scrim = scrimDark,
    surfaceTint = primaryDark,
    surfaceContainerLowest = surfaceContainerLowestDark,
    surfaceContainerLow = surfaceContainerLowDark,
    surfaceContainer = surfaceContainerDark,
    surfaceContainerHigh = surfaceContainerHighDark,
    surfaceContainerHighest = surfaceContainerHighestDark,
    surfaceDim = surfaceDimDark,
    surfaceBright = surfaceBrightDark,
)

// ---------------------------------------------------------------------------
// Dose status colors – not part of the M3 scheme, so they live in their own
// CompositionLocal. Use: PawmarkTheme.status.overdue / onOverdue, etc.
// ---------------------------------------------------------------------------
@Immutable
data class StatusColors(
    val upcoming: Color,
    val onUpcoming: Color,
    val dueToday: Color,
    val onDueToday: Color,
    val overdue: Color,
    val onOverdue: Color,
    val given: Color,
    val onGiven: Color,
)

private val LightStatus = StatusColors(
    upcoming = Teal100, onUpcoming = Teal700,
    dueToday = Apricot100, onDueToday = Apricot800,
    overdue = Brick100, onOverdue = Brick800,
    given = Sage100, onGiven = Sage800,
)

private val DarkStatus = StatusColors(
    upcoming = Teal700, onUpcoming = Teal100,
    dueToday = Apricot800, onDueToday = Apricot100,
    overdue = Brick800, onOverdue = Brick100,
    given = Sage800, onGiven = Sage100,
)

private val LocalStatusColors = staticCompositionLocalOf { LightStatus }

// Rounded, friendly shapes matching the mockups (chips 8, inputs 14, cards 20)
val PetPalShapes = Shapes(
    extraSmall = RoundedCornerShape(8.dp),
    small = RoundedCornerShape(12.dp),
    medium = RoundedCornerShape(16.dp),
    large = RoundedCornerShape(20.dp),
    extraLarge = RoundedCornerShape(28.dp),
)

@Composable
fun PetPalTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Off by default so the brand teal stays consistent; flip on if you want Material You.
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit,
) {
    val colorScheme: ColorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColors
        else -> LightColors
    }

    CompositionLocalProvider(
        LocalStatusColors provides if (darkTheme) DarkStatus else LightStatus
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = PawmarkTypography,
            shapes = PetPalShapes,
            content = content,
        )
    }
}

object PetPalTheme {
    val status: StatusColors
        @Composable
        @ReadOnlyComposable
        get() = LocalStatusColors.current
}
