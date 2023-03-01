package com.example.lesson31

enum class CounterStates(val buttonValue: String, val attrValue: String) {
    INCREMENT("INCREASE", "increase"),
    DECREMENT("DECREASE", "decrease");

    fun switch() = when (this) {
        INCREMENT -> DECREMENT
        DECREMENT -> INCREMENT
    }
}