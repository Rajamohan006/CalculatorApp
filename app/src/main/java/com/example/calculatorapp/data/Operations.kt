package com.example.calculatorapp.data

sealed class Operations(val symbol: String) {
    object Add: Operations("+")
    object Subtract: Operations("-")
    object Multiply: Operations("*")
    object Divide: Operations("/")

}