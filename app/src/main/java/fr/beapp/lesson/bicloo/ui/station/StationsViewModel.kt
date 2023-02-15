package fr.beapp.lesson.bicloo.ui.station

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.beapp.lesson.bicloo.shared.logic.StationEntity
import fr.beapp.lesson.bicloo.shared.rest.DataSource
import kotlinx.coroutines.launch

class StationsViewModel : ViewModel() {

    private val manager = DataSource

    private val _stations = MutableLiveData<List<StationEntity>>()
    val stations: LiveData<List<StationEntity>>
        get() = _stations

    fun loadAllStations(contractName: String) {
        viewModelScope.launch {
            runCatching {
                manager.getStationsOfCity(contractName)
            }
                .onSuccess { _stations.postValue(it) }
                .onFailure { Log.e(this::class.java.simpleName, "Failed to load stations from $contractName", it) }
        }
    }

}