package nondas.pap.petpal.domain.model

data class User(
    val fullName: String,
    val email: String,
    val password: String?
)
