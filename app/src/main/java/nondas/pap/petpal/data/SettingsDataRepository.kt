package nondas.pap.petpal.data

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import com.google.firebase.firestore.snapshots
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.tasks.await
import nondas.pap.petpal.domain.model.Settings
import nondas.pap.petpal.domain.repository.SettingsRepository
import javax.inject.Inject

class SettingsDataRepository @Inject constructor(
    private val firestore: FirebaseFirestore,
): SettingsRepository {

    override fun get(): Flow<Settings> {
        val uid = getUserId()

        return firestore.collection(COLLECTION_NAME)
            .document(uid)
            .snapshots()
            .map { it.toObject(Settings::class.java) ?: Settings.DEFAULT }
            .catch {
                emit(Settings.DEFAULT)
            }
    }

    override suspend fun update(settings: Settings) {
        val uid = getUserId()

        firestore
            .collection(COLLECTION_NAME)
            .document(uid)
            .set(settings, SetOptions.merge())
            .await()
    }

    private fun getUserId(): String {
        return FirebaseAuth.getInstance().currentUser?.uid
            ?: throw IllegalStateException("User not authenticated")
    }

    companion object {
        private const val COLLECTION_NAME = "settings"
    }
}