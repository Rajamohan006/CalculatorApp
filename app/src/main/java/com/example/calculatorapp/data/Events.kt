package com.example.calculatorapp.data

sealed class Events {
    object Clear: Events()
    object Delete: Events()
    object Decimal: Events()
    object Calculate: Events()
    data class Number(val number: Int): Events()
    data class Operation(val operation: Operations): Events()

}