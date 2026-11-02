package nondas.pap.petpal.ui.theme

import androidx.compose.ui.graphics.Color

// ---------------------------------------------------------------------------
// Brand palette (raw values from the Pawmark design board)
// ---------------------------------------------------------------------------
val Teal700 = Color(0xFF0E5E58)      // Primary
val Teal800 = Color(0xFF0A4743)
val Teal900 = Color(0xFF00201C)
val Teal100 = Color(0xFFCDE9E3)      // Primary tint
val Teal200 = Color(0xFF7FD3C8)      // Primary (dark theme)

val Apricot500 = Color(0xFFE8833A)   // Accent – FAB, "due today"
val Apricot300 = Color(0xFFFFB68A)
val Apricot100 = Color(0xFFFCE7D6)
val Apricot800 = Color(0xFF8A4512)
val Apricot900 = Color(0xFF522300)

val Sage600 = Color(0xFF2F7D57)      // Given / success
val Sage800 = Color(0xFF1E5B3F)
val Sage100 = Color(0xFFDCEFE6)
val Sage300 = Color(0xFF8FD6AF)

val Brick600 = Color(0xFFB3261E)     // Overdue / error
val Brick800 = Color(0xFF8C1D18)
val Brick100 = Color(0xFFF9DEDC)
val Brick300 = Color(0xFFFFB4AB)

val Ink = Color(0xFF15201E)
val InkMuted = Color(0xFF55625F)
val MintWhite = Color(0xFFF5F7F4)    // Ground
val White = Color(0xFFFFFFFF)
val Line = Color(0xFFDCE3E0)
val LineStrong = Color(0xFFC9D3D0)
val Mist = Color(0xFFE6ECE9)
val Mist2 = Color(0xFFEEF2F0)

// Dark neutrals
val Night = Color(0xFF0F1514)
val Night1 = Color(0xFF141B1A)
val Night2 = Color(0xFF1A2120)
val Night3 = Color(0xFF242B2A)
val Night4 = Color(0xFF2F3634)
val NightText = Color(0xFFDEE4E1)
val NightTextMuted = Color(0xFFBEC9C5)
val NightOutline = Color(0xFF889390)
val NightOutlineVariant = Color(0xFF3F4946)

// ---------------------------------------------------------------------------
// Light scheme roles
// ---------------------------------------------------------------------------
val primaryLight = Teal700
val onPrimaryLight = White
val primaryContainerLight = Teal100
val onPrimaryContainerLight = Teal800

val secondaryLight = Apricot500
val onSecondaryLight = Ink
val secondaryContainerLight = Apricot100
val onSecondaryContainerLight = Apricot800

val tertiaryLight = Sage600
val onTertiaryLight = White
val tertiaryContainerLight = Sage100
val onTertiaryContainerLight = Sage800

val errorLight = Brick600
val onErrorLight = White
val errorContainerLight = Brick100
val onErrorContainerLight = Brick800

val backgroundLight = MintWhite
val onBackgroundLight = Ink
val surfaceLight = MintWhite
val onSurfaceLight = Ink
val surfaceVariantLight = Mist
val onSurfaceVariantLight = InkMuted
val outlineLight = LineStrong
val outlineVariantLight = Line
val inverseSurfaceLight = Color(0xFF2A3331)
val inverseOnSurfaceLight = Color(0xFFECF2EF)
val inversePrimaryLight = Teal200
val scrimLight = Color(0xFF000000)

val surfaceContainerLowestLight = White     // cards
val surfaceContainerLowLight = White
val surfaceContainerLight = Mist2
val surfaceContainerHighLight = Mist        // segmented control track
val surfaceContainerHighestLight = Line
val surfaceDimLight = Color(0xFFD7DDDA)
val surfaceBrightLight = MintWhite

// ---------------------------------------------------------------------------
// Dark scheme roles
// ---------------------------------------------------------------------------
val primaryDark = Teal200
val onPrimaryDark = Color(0xFF00382F)
val primaryContainerDark = Teal700
val onPrimaryContainerDark = Teal100

val secondaryDark = Apricot300
val onSecondaryDark = Apricot900
val secondaryContainerDark = Apricot800
val onSecondaryContainerDark = Apricot100

val tertiaryDark = Sage300
val onTertiaryDark = Color(0xFF00391F)
val tertiaryContainerDark = Sage800
val onTertiaryContainerDark = Sage100

val errorDark = Brick300
val onErrorDark = Color(0xFF690005)
val errorContainerDark = Brick800
val onErrorContainerDark = Brick100

val backgroundDark = Night
val onBackgroundDark = NightText
val surfaceDark = Night
val onSurfaceDark = NightText
val surfaceVariantDark = NightOutlineVariant
val onSurfaceVariantDark = NightTextMuted
val outlineDark = NightOutline
val outlineVariantDark = NightOutlineVariant
val inverseSurfaceDark = NightText
val inverseOnSurfaceDark = Color(0xFF2A3331)
val inversePrimaryDark = Teal700
val scrimDark = Color(0xFF000000)

val surfaceContainerLowestDark = Color(0xFF0A0F0E)
val surfaceContainerLowDark = Night1
val surfaceContainerDark = Night2
val surfaceContainerHighDark = Night3
val surfaceContainerHighestDark = Night4
val surfaceDimDark = Night
val surfaceBrightDark = Color(0xFF353B3A)
