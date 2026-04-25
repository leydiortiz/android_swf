package com.example.rutaescolarapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class QuienesSomosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quienes_somos)

        // Botón volver
        val btnVolver = findViewById<Button>(R.id.btnVolver)

        btnVolver.setOnClickListener {
            finish()
        }
    }
}