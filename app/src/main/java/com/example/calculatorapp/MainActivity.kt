package com.example.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.calculatorapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAdd.setOnClickListener {
            calculateSum()
        }

        binding.btnSub.setOnClickListener {
            calculateDifference()
        }

        binding.btnMul.setOnClickListener {
            calculateProduct()
        }

        binding.btnDiv.setOnClickListener {
            calculateDivision()
        }
    }

    private fun calculateSum() {
        val no1 = binding.edtNo1.text.toString()
        val no2 = binding.edtNo2.text.toString()

        if (no1.isNotEmpty() && no2.isNotEmpty()) {
            val sum = no1.toInt() + no2.toInt()
            showToast("The Sum is $sum")
        } else {
            showToast("Please Fill all the Required Blanks.")
        }
    }

    private fun calculateDifference() {
        val no1 = binding.edtNo1.text.toString()
        val no2 = binding.edtNo2.text.toString()

        if (no1.isNotEmpty() && no2.isNotEmpty()) {
            val sub = if (no1.toInt() > no2.toInt()) {
                no1.toInt() - no2.toInt()
            } else {
                no2.toInt() - no1.toInt()
            }
            showToast("The Difference is $sub")
        } else {
            showToast("Please Fill all the Required Blanks.")
        }
    }

    private fun calculateProduct() {
        val no1 = binding.edtNo1.text.toString()
        val no2 = binding.edtNo2.text.toString()

        if (no1.isNotEmpty() && no2.isNotEmpty()) {
            val mul = no1.toInt() * no2.toInt()
            showToast("The Product is $mul")
        } else {
            showToast("Please Fill all the Required Blanks.")
        }
    }

    private fun calculateDivision() {
        val no1 = binding.edtNo1.text.toString()
        val no2 = binding.edtNo2.text.toString()

        if (no1.isNotEmpty() && no2.isNotEmpty()) {
            val divisor = no2.toInt()
            if (divisor == 0) {
                showToast("A number can't be divided by zero as it produces infinite.")
            } else {
                val div = no1.toInt() / divisor
                showToast("The Division is $div")
            }
        } else {
            showToast("Please Fill all the Required Blanks.")
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}
