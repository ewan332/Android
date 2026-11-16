package com.example.demo1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DataForBindingViewModel : ViewModel() {
    private val _dataForBing = MutableLiveData<DataForBinding>()
    val dataForBing : LiveData<DataForBinding> = _dataForBing

    init {
        _dataForBing.value = DataForBinding("Euro","Dollar")
    }

    fun updateDataForBing(newData: DataForBinding) {

        _dataForBing.value?.let {
            val data = it.copy(
                labelHaut = newData.labelHaut?:it.labelHaut,
                labelBas = newData.labelBas?:it.labelBas,
                resultatHaut = newData.resultatHaut?:it.resultatHaut,
                resultatBas = newData.resultatBas?:it.resultatBas)
            _dataForBing.value = data
        }

    }
}