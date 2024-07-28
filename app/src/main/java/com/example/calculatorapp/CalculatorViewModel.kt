package com.example.calculatorapp

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.calculatorapp.data.Events
import com.example.calculatorapp.data.OperationStates
import com.example.calculatorapp.data.Operations

class CalculatorViewModel: ViewModel() {
    var state = mutableStateOf(OperationStates())
    private set

    fun onEvent(event: Events){
        when(event){
            is Events.Number -> enterNumber(event.number)
            is Events.Decimal -> enterDecimal()
            is Events.Clear -> clearData()
            is Events.Delete-> enterDelete()
            is Events.Operation -> enterOperator(event.operation)
            is Events.Calculate -> calculate()

        }
    }

    private fun enterNumber(number: Int) {
        if (state.value.operation == null) {
            if (state.value.firstNumber.length >= MAX_LEN) return
            state.value = state.value.copy(
                firstNumber = state.value.firstNumber + number
            )
        } else {
            if (state.value.secondNumber.length >= MAX_LEN) return
            state.value = state.value.copy(
                secondNumber = state.value.secondNumber + number
            )
        }

    }
    private fun enterOperator(operator: Operations) {
        if (state.value.firstNumber.isNotBlank() && state.value.operation == null) {
            state.value = state.value.copy(operation = operator)
        }
    }

    private fun enterDecimal() {
        if(state.value.operation == null && !state.value.firstNumber.contains(".")
            && state.value.firstNumber.isNotBlank()
        ){
            state.value=state.value.copy(
                firstNumber=state.value.firstNumber + "."
            )
            return
        }
        if(!state.value.secondNumber.contains(".")&& state.value.secondNumber.isNotBlank()
        ){
            state.value=state.value.copy(
                secondNumber=state.value.secondNumber + "."
            )
        }

    }
    private fun calculate() {
        val firstNumber = state.value.firstNumber.toDoubleOrNull()
        val secondNumber = state.value.secondNumber.toDoubleOrNull()
        if(firstNumber != null && secondNumber != null){
            val result = when(state.value.operation) {
                is Operations.Add -> firstNumber + secondNumber
                is Operations.Subtract -> firstNumber - secondNumber
                is Operations.Multiply -> firstNumber * secondNumber
                is Operations.Divide -> firstNumber / secondNumber
                null -> return
            }
            state.value = state.value.copy(
                firstNumber = result.toString().take(15),
                secondNumber = "",
                operation = null
            )
        }

    }
    private fun enterDelete() {
        when {
            state.value.firstNumber.isNotBlank() -> state.value = state.value.copy(
                firstNumber = state.value.firstNumber.dropLast(1)
            )
            state.value.operation != null -> state.value = state.value.copy(
                operation = null
            )
            state.value.secondNumber.isNotBlank() -> state.value = state.value.copy(
                secondNumber = state.value.secondNumber.dropLast(1)
            )

        }

    }
    private fun clearData() {
        state.value = OperationStates()

    }
companion object {
    private const val MAX_LEN =8
}
}
