package com.example.kotlincum

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private lateinit var cumViewModel: CumViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cumViewModel = ViewModelProvider(this).get(CumViewModel::class.java)

        val camponota: EditText = findViewById(R.id.campo_nota)
        val campouv: EditText = findViewById(R.id.campo_uv)
        val btnagregar: Button = findViewById(R.id.btn_agregar)
        val btncalcular: Button = findViewById(R.id.btn_calcular)
        val textresultado: TextView = findViewById(R.id.text_resultado)

        btnagregar.setOnClickListener {
            val nota = camponota.text.toString().toDoubleOrNull()
            val uv = campouv.text.toString().toIntOrNull()

            if (nota != null && uv != null) {
                cumViewModel.addnota(nota)
                cumViewModel.adduv(uv)
                camponota.text.clear()
                campouv.text.clear()
            }
        }

        btncalcular.setOnClickListener {
            val cum = cumViewModel.calcularCum()
            textresultado.text = "Tu CUM es: %.2f".format(cum)
        }
    }
}
