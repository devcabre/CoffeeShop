package com.example.actividad13

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.content.Intent

class FacturaImpresa : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_factura_impresa)

        val intent = intent
        val nombre = intent.getStringExtra("NOMBRE")
        val apellido = intent.getStringExtra("APELLIDO")
        val documento = intent.getStringExtra("DOCUMENTO")
        val correo = intent.getStringExtra("CORREO")
        val direccion = intent.getStringExtra("DIRECCION")
        val telefono = intent.getStringExtra("TELEFONO")
        val detalle = intent.getStringExtra("DETALLE")
        //val totalFactura = intent.getStringExtra("TOTAL_FACTURA")

        val txtNombre : TextView = findViewById(R.id.txtNombre)
        val txtApellido : TextView = findViewById(R.id.txtApellido)
        val txtDocumentoIdentidad : TextView = findViewById(R.id.txtDocumentoIdentidad)
        val txtCorreo : TextView = findViewById(R.id.txtCorreo)
        val txtDireccion : TextView = findViewById(R.id.txtDireccion)
        val txtTelefono : TextView = findViewById(R.id.txtTelefono)
        val txtDetalle: TextView = findViewById(R.id.txtDetalle)
        val txtTotalFactura : TextView = findViewById(R.id.txtTotalFactura)

        val totalFactura = intent.getDoubleExtra("TOTAL_FACTURA", 0.0)

        txtNombre.text = "$nombre"
        txtApellido.text = "$apellido"
        txtDocumentoIdentidad.text = "$documento"
        txtCorreo.text = "$correo"
        txtDireccion.text = "$direccion"
        txtTelefono.text = "$telefono"
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