package com.vitorxbranco.calculadoraimc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextAltura: EditText = findViewById(R.id.edit_text_altura)
        val editTextPeso: EditText = findViewById(R.id.edit_text_peso)
        val buttonCalcular: Button = findViewById(R.id.button_calcular)

        buttonCalcular.setOnClickListener {
            val alturaString = editTextAltura.text.toString()
            val pesoString = editTextPeso.text.toString()

            if (alturaString.isNotEmpty() && pesoString.isNotEmpty()) {
                val altura: Float = alturaString.toFloat()
                val peso: Float = pesoString.toFloat()
                val alturaFinal: Float = altura * altura
                val result = peso / alturaFinal


                val intent = Intent(this, ResultActivity::class.java)
                    .apply {
                        putExtra("EXTRA_RESULT", result)
                    }
                startActivity(intent)
            } else {
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_LONG).show()
            }


        }
    }
}