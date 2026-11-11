package nondas.pap.petpal.domain.model

import com.google.firebase.Timestamp
import nondas.pap.petpal.domain.model.enums.MedicineType
import nondas.pap.petpal.domain.model.enums.Repeat
import java.util.Date

data class Medicine(
    val id: String,
    val ownerId: String,
    val petId: String,
    val name: String,
    val type: MedicineType,
    val date: Timestamp,
    val notes: String,
    val repeat: Repeat

)
