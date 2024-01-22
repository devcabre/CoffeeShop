package com.example.actividad13

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Button
import android.content.Intent

class DatosConsumidor : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datos_consumidor)

        val intent = intent
        val detalle = intent.getStringExtra("DETALLE")
        val totalFactura = intent.getDoubleExtra("TOTAL_FACTURA", 0.0)

        val txtDetalle: TextView = findViewById(R.id.txtDetalle)
        val txtTotalFactura : TextView = findViewById(R.id.txtTotalFactura)

        txtDetalle.text = detalle
        txtTotalFactura.text = "$totalFactura"

        val btnRegresar : Button
        btnRegresar = findViewById(R.id.btnRegresar)

        btnRegresar.setOnClickListener{
            val intentMainActivity = Intent(this, MainActivity::class.java).apply{
                putExtra("REINICIAR_TODO", true)
            }

            startActivity(intentMainActivity)

            finish()
        }

    }
}