package com.example.demo1

import androidx.lifecycle.ViewModel

class ConversionViewModel : ViewModel() {
    var taux :Double?=null
        private set

    fun modifierTaux(nouveauTaux:Double){
        taux = nouveauTaux
    }
}