package fr.beapp.lesson.bicloo.ui.search

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.beapp.lesson.bicloo.core.rest.RestManager
import fr.beapp.lesson.bicloo.logic.ContractEntity
import kotlinx.coroutines.launch

class CitySelectionViewModel : ViewModel() {

    private val manager = RestManager

    private val _contracts = MutableLiveData<List<ContractEntity>>()
    private var _originalContracts: List<ContractEntity> = emptyList()

    val contracts: LiveData<List<ContractEntity>>
        get() = _contracts

    fun loadContracts() {
        viewModelScope.launch {
            runCatching {
                manager.getContracts()
            }
                .onSuccess {
                    _originalContracts = it
                    _contracts.postValue(it)
                }
                .onFailure { Log.e(this::class.java.simpleName, "Failed to load contracts, cause: ", it) }
        }
    }

    fun searchForContract(search: String) {
        viewModelScope.launch {
            if (search.isEmpty()) {
                _contracts.postValue(_originalContracts)
                return@launch
            }
            val tmp = _originalContracts.filter {
                it.name.lowercase().contains(search.lowercase())
            }
            _contracts.postValue(tmp)
        }

    }

    class NoContractFoundException(city: String) : Exception("No contract found for city: $city")
}