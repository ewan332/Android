package com.example.demo1

data class DataForBinding(
    var resultatHaut : Double? = null,
    var resultatBas : Double? = null

){
    val resultatBasformatted: String
        get()= String.format("%2f",resultatBas ?:0.0)

    val resultatHautFormatted: String
    get()= String.format("%2f",resultatHaut)
}
