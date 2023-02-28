package com.example.lesson31

enum class CounterStates(val buttonValue: String, val attrValue: String) {
    INCREMENT("INCREASE", "++"),
    DECREMENT("DECREASE", "--");

    fun next() = when (this) {
        INCREMENT -> DECREMENT
        DECREMENT -> INCREMENT
    }
}