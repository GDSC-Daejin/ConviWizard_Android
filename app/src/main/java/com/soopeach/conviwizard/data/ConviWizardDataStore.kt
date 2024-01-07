package com.soopeach.conviwizard.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "convi")

class ConviWizardDataStore(private val context: Context) {
    private val uIdKey = stringPreferencesKey("uId")
    val uId: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[uIdKey]
        }

    suspend fun updateUId(uid: String) {
        context.dataStore.edit { preferences ->
            preferences[uIdKey] = uid
        }
    }
}