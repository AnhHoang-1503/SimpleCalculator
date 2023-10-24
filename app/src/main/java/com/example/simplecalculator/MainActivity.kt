package com.example.simplecalculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.simplecalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCe.setOnClickListener {
            binding.result.text = "0"
            previous = 0
        }
        binding.buttonC.setOnClickListener {
            binding.result.text = "0"
        }
        binding.buttonBs.setOnClickListener {
            if (binding.result.text.length >= 2) {
                binding.result.text = binding.result.text.dropLast(1)
            } else {
                binding.result.text = "0"
            }
        }
        binding.buttonDivide.setOnClickListener {
            if(previous != 0) {
                calculate()
                binding.result.text = "0"
                mathOperation = 4
            }
        }
        binding.button7.setOnClickListener {
            binding.result.text = addToInput("7")
        }
        binding.button8.setOnClickListener {
            binding.result.text = addToInput("8")
        }
        binding.button9.setOnClickListener {
            binding.result.text = addToInput("9")
        }
        binding.buttonMultiply.setOnClickListener {
            calculate()
            binding.result.text = "0"
            mathOperation = 3
        }
        binding.button4.setOnClickListener {
            binding.result.text = addToInput("4")
        }
        binding.button5.setOnClickListener {
            binding.result.text = addToInput("5")
        }
        binding.button6.setOnClickListener {
            binding.result.text = addToInput("6")
        }
        binding.buttonMinus.setOnClickListener {
            calculate()
            binding.result.text = "0"
            mathOperation = 2
        }
        binding.button3.setOnClickListener {
            binding.result.text = addToInput("3")
        }
        binding.button2.setOnClickListener {
            binding.result.text = addToInput("2")
        }
        binding.button1.setOnClickListener {
            binding.result.text = addToInput("1")
        }
        binding.buttonPlus.setOnClickListener {
            calculate()
            binding.result.text = "0"
            mathOperation = 1
        }
        binding.button0.setOnClickListener {
            binding.result.text = addToInput("0")
        }
        binding.buttonEqual.setOnClickListener {
            calculate()
            binding.result.text = "$previous"
            mathOperation = 0
        }
    }

    private var previous = 0
    private var mathOperation = 0

    private fun addToInput(buttonValue: String): String {
        if(binding.result.text == "0") binding.result.text = ""
        return "${binding.result.text}$buttonValue"
    }

    private fun calculate() {
        println(previous)
        println(mathOperation)

        val currentNumber = Integer.parseInt(binding.result.text.toString())
        when(mathOperation) {
            0 -> previous = currentNumber
            1 -> previous += currentNumber
            2 -> previous -= currentNumber
            3 -> previous *= currentNumber
            4 -> previous /= currentNumber
        }

        println(previous)
        println(mathOperation)
    }

}
