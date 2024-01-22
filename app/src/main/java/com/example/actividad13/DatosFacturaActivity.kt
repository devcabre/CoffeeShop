package com.example.actividad13

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText
import android.content.Intent
import android.widget.CheckBox

class DatosFacturaActivity : AppCompatActivity() {

    lateinit var btnGenerar : Button

    lateinit var itxtNombre: TextInputEditText
    lateinit var itxtApellido : TextInputEditText
    lateinit var itxtDocumentoIdentidad : TextInputEditText
    lateinit var itxtCorreo : TextInputEditText
    lateinit var itxtDireccion : TextInputEditText
    lateinit var itxtTelefono : TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datos_factura)

        btnGenerar = findViewById(R.id.btnGenerar)

        itxtNombre = findViewById(R.id.itxtNombre)
        itxtApellido = findViewById(R.id.itxtApellido)
        itxtDocumentoIdentidad = findViewById(R.id.itxtDocumentoIdentidad)
        itxtCorreo = findViewById(R.id.itxtCorreo)
        itxtDireccion = findViewById(R.id.itxtDireccion)
        itxtTelefono = findViewById(R.id.itxtTelefono)



        btnGenerar.setOnClickListener{

            val itxtNombre = itxtNombre.text.toString()
            val itxtApellido = itxtApellido.text.toString()
            val itxtDocumentoIdentidad = itxtDocumentoIdentidad.text.toString()
            val itxtCorreo = itxtCorreo.text.toString()
            val itxtDireccion = itxtDireccion.text.toString()
            val itxtTelefono = itxtTelefono.text.toString()



            val totalFactura = intent.getDoubleExtra("TOTAL_FACTURA", 0.0)
            val detalleFactura = intent.getStringExtra("DETALLE_FACTURA")

            val intent = Intent(this, FacturaImpresa::class.java).apply{

                putExtra("NOMBRE", itxtNombre)
                putExtra("APELLIDO", itxtApellido)
                putExtra("DOCUMENTO", itxtDocumentoIdentidad)
                putExtra("CORREO", itxtCorreo)
                putExtra("DIRECCION", itxtDireccion)
                putExtra("TELEFONO", itxtTelefono)
                putExtra("DETALLE", detalleFactura)
                putExtra("TOTAL_FACTURA", totalFactura)
            }

            startActivity(intent)

        }
    }
}