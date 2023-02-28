package com.example.lesson31

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lesson31.databinding.ActivityMainCounterBinding

class MainActivity : AppCompatActivity() {

    private var counterStates = CounterStates.INCREMENT
    private lateinit var binding: ActivityMainCounterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainCounterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val button = binding.buttonToChangeCounter
        button.text = counterStates.next().buttonValue

        button.setOnClickListener {
            counterStates = counterStates.next()
            button.text = counterStates.next().buttonValue
            binding.counter.counterState = counterStates.attrValue
        }
    }
}