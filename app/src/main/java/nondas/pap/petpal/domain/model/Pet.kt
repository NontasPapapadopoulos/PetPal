package nondas.pap.petpal.domain.model

import nondas.pap.petpal.domain.model.enums.Sex
import nondas.pap.petpal.domain.model.enums.Specie

data class Pet(
    val id: String,
    val ownerId: String,
    val name: String,
    val age: String,
    val sex: Sex,
    val specie: Specie,
    val breed: String,
    val microchipNumber: String,
)
