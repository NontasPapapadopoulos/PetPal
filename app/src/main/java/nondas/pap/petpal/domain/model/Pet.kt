package nondas.pap.petpal.domain.model

import nondas.pap.petpal.domain.model.enums.Sex
import nondas.pap.petpal.domain.model.enums.Specie

data class Pet(
    val id: String = "",
    val ownerId: String = "",
    val name: String = "",
    val birthday: String = "",
    val weight: String = "",
    val sex: Sex = Sex.Male,
    val specie: Specie = Specie.Dog,
    val breed: String = "",
    val microchipNumber: String = "",
    val photoUrl: String? = null
) {
    fun getAge() = "222" // TODO
}
