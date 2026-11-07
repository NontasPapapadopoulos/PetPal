package nondas.pap.petpal.domain.model

import nondas.pap.petpal.domain.model.enums.MedicineType
import nondas.pap.petpal.domain.model.enums.Repeat
import java.util.Date

data class Medicine(
    val id: String,
    val name: String,
    val type: MedicineType,
    val date: Date,
    val notes: String,
    val repeat: Repeat

)
