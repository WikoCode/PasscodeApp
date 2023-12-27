package com.example.shemajamebeli_6

import androidx.lifecycle.ViewModel

class PasscodeViewModel : ViewModel() {
    private val correctPasscode = "0934"
    var enteredPasscode = ""

    fun addDigit(digit: String) {
        if (enteredPasscode.length < 4) {
            enteredPasscode += digit
        }
    }

    fun removeLastDigit() {
        if (enteredPasscode.isNotEmpty()) {
            enteredPasscode = enteredPasscode.dropLast(1)
        }
    }

    fun isPasscodeCorrect(): Boolean {
        return enteredPasscode == correctPasscode
    }

    fun resetPasscode() {
        enteredPasscode = ""
    }
}
