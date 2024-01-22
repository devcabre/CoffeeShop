package com.example.actividad13

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.TextView
import android.view.View
import android.widget.Spinner
import android.content.Intent
import java.lang.StringBuilder


class MainActivity : AppCompatActivity() {

    lateinit var rbtn_recoger: RadioButton
    lateinit var rbtn_domicilio: RadioButton

    lateinit var chkMacciato: CheckBox
    lateinit var chkExpresso: CheckBox
    lateinit var chkAmericano: CheckBox
    lateinit var chkCapuccino: CheckBox

    lateinit var chkBrownie: CheckBox
    lateinit var chkDonut: CheckBox
    lateinit var chkChocolate: CheckBox
    lateinit var chkDulceLeche: CheckBox

    lateinit var btnCalcular: Button
    lateinit var btnCancelar: Button
    lateinit var btnPagarcuenta: Button

    lateinit var txtTotal: TextView

    lateinit var sptipodoc : Spinner

    var reiniciarTodo : Boolean = false





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rbtn_recoger = findViewById(R.id.rbtn_recoger)
        rbtn_domicilio = findViewById(R.id.rbtn_domicilio)

        chkMacciato = findViewById(R.id.chkMacciato)
        chkExpresso = findViewById(R.id.chkExpresso)
        chkAmericano = findViewById(R.id.chkAmericano)
        chkCapuccino = findViewById(R.id.chkCapuccino)

        chkBrownie = findViewById(R.id.chkBrownie)
        chkDonut = findViewById(R.id.chkDonut)
        chkChocolate = findViewById(R.id.chkChocolate)
        chkDulceLeche = findViewById(R.id.chkDulceLeche)

        btnCalcular = findViewById(R.id.btnCalcular)
        btnCancelar = findViewById(R.id.btnCancelar)

        txtTotal = findViewById(R.id.txtTotal)

        sptipodoc = findViewById(R.id.sptipodoc)
        btnPagarcuenta = findViewById(R.id.btnPagarcuenta)

        btnPagarcuenta.setOnClickListener{
            val tipoDocumento = sptipodoc.selectedItem.toString()

            if(tipoDocumento == "Factura con datos"){
                //val intent = Intent(this, DatosFacturaActivity::class.java)
                //startActivity(intent)
                val total = calcular()
                val detalle = generarDetalle()
                val intent = Intent(this, DatosFacturaActivity::class.java).apply{
                    putExtra("TOTAL_FACTURA", total)
                    putExtra("DETALLE_FACTURA", detalle)
                }
                startActivity(intent)
            }else if(tipoDocumento == "Consumidor final"){
                val total = calcular()
                val detalle = generarDetalle()
                val intent = Intent(this, DatosConsumidor::class.java).apply{
                    putExtra("TOTAL_FACTURA", total)
                    putExtra("DETALLE", detalle)
                }
                startActivity(intent)
            }





        }

        reiniciarTodo()


    }

        private fun agregarDetalle(checkBox: CheckBox, nombre : String, detalle :StringBuilder){
            if(checkBox.isChecked){
                if(detalle.isNotEmpty()){
                    detalle.append("\n ")
                }
                detalle.append(nombre)
            }
        }

        private fun generarDetalle():String{
            val detalle = StringBuilder()

            agregarDetalle(chkMacciato, "Macciato", detalle)
            agregarDetalle(chkExpresso, "Expresso", detalle)
            agregarDetalle(chkAmericano, "Americano", detalle)
            agregarDetalle(chkCapuccino, "Capuccino", detalle)
            agregarDetalle(chkBrownie, "Brownie", detalle)
            agregarDetalle(chkDonut, "Donut", detalle)
            agregarDetalle(chkChocolate, "Chocolate", detalle)
            agregarDetalle(chkDulceLeche, "Dulce de leche", detalle)

            return detalle.toString()
        }

        private fun reiniciarTodo(){
            var total = 0.0
            rbtn_domicilio.isChecked = false
            chkMacciato.isChecked = false
            chkAmericano.isChecked = false
            chkExpresso.isChecked = false
            chkCapuccino.isChecked = false
            chkBrownie.isChecked = false
            chkDonut.isChecked = false
            chkDulceLeche.isChecked = false
            chkChocolate.isChecked = false

            txtTotal.text = "Total a pagar: $total"
        }


        fun calcular(): Double{

            var total = 0.0

            if(rbtn_domicilio.isChecked)
                total += 4

            if(chkMacciato.isChecked)
                total += 3

            if(chkExpresso.isChecked)
                total += 2.5

            if(chkAmericano.isChecked)
                total += 1.5

            if(chkCapuccino.isChecked)
                total += 5

            if(chkBrownie.isChecked)
                total += 2.5

            if(chkDonut.isChecked)
                total += 4

            if(chkDulceLeche.isChecked)
                total += 1

            if(chkChocolate.isChecked)
                total += 3

            txtTotal.text = "Total a pagar: $total"

            return total
    }

    fun calcularDesdeOtroContexto(){
        calcular()
    }

    fun calcular(v: View){
        calcular()
    }

    fun cancelar(v : View){
        reiniciarTodo()
    }


}