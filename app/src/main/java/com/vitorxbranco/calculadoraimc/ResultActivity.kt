package com.vitorxbranco.calculadoraimc

import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.DecimalFormat

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val textViewResult2 = findViewById<TextView>(R.id.text_view_result2)
        val textViewClassificacao = findViewById<TextView>(R.id.text_view_classificacao)

        val result = intent.getFloatExtra("EXTRA_RESULT", 0.1f)

        val meuFormatadorDecimal = DecimalFormat("0.00")
        val resultFormatted: String = meuFormatadorDecimal.format(result)

        textViewResult2.text = resultFormatted

        val classificacao = if (result < 18.5f) {
            "Abaixo do peso"
        } else if (result in 18.5f..25.0f) {
            "Normal"
        } else if (result in 25.0f..30.0f) {
            "Sobrepeso"
        } else if (result in 30.0f..35.0f) {
            "Obesidade - Classe I"
        } else if (result in 35.0f..40.0f) {
            "Obesidade - CLasse II"
        } else {
            "Obesidade - Classe III"
        }



        textViewClassificacao.text = getString(R.string.message_classificacao, classificacao)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}