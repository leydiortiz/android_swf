package com.example.rutaescolarapp

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class HorariosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_horarios)

        // 🔙 Flecha arriba
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val btnVolver = findViewById<Button>(R.id.btnVolver)

        btnVolver.setOnClickListener {
            finish()
        }
    }

    // 🔙 Acción de la flecha
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}