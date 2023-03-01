package com.example.lesson31

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lesson31.databinding.ActivityMainCounterBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainCounterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainCounterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var counterStates = CounterStates.INCREMENT
        val button = binding.buttonToChangeCounter
        button.text = counterStates.switch().buttonValue

        button.setOnClickListener {
            counterStates = counterStates.switch()
            button.text = counterStates.switch().buttonValue
            binding.counter.counterState = counterStates.attrValue
        }
    }
}