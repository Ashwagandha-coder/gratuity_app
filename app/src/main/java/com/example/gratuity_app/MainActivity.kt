package com.example.gratuity_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gratuity_app.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // set binding

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)


        binding.mainBtn.setOnClickListener { logical() }
    }


    fun logical() {

        val textFromEditText = binding.etGratuity.text.toString()
        val resultNumber = textFromEditText.toDouble()


        val checkedButton = binding.typeGratuity.checkedRadioButtonId

        chooseTypeGratuity(checkedButton)

        var result = chooseTypeGratuity(checkedButton) * resultNumber

        val flag = binding.switchRound.isChecked

        if (flag)
            result = kotlin.math.ceil(result)


        val formatedResult = NumberFormat.getCurrencyInstance().format(result)

        binding.tvResult.text = getString(R.string.gratuity_result,formatedResult)




    }


    fun chooseTypeGratuity(id: Int): Double {

        val param: Double

        when (id) {

            R.id.amazing_Rbtn -> param = 0.20
            R.id.good_Rbtn -> param = 0.18
            else -> param = 0.15

        }

        return param

    }
}