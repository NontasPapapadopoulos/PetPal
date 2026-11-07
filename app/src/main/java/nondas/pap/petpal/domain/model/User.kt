package nondas.pap.petpal.domain.model

data class User(
    val id: String,
    val name: String,
    val email: String,
    val pets: List<Pet>,

)
