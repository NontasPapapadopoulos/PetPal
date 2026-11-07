package nondas.pap.petpal.domain.model

import nondas.pap.petpal.domain.model.enums.Theme

data class Settings(
    val pushNotificationsEnabled: Boolean,
    val theme: Theme,
)
