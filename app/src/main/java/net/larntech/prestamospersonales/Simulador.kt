package net.larntech.prestamospersonales

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_nuevo_cliente.GenerarCalculo
import kotlinx.android.synthetic.main.activity_simulador.*

class Simulador : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simulador)
        multiplicar()
    }

    fun multiplicar() {
        GenerarCalculo.setOnClickListener() {
                var neto: Int= (ingresarPrestamo.text.toString()).toInt()
                var interes: Int= (ingresarInteres.text.toString()).toInt()
                var total: String =  (((neto*interes)/100)+neto).toString()
            resultadoApagar.setText(total)

        }
    }
}


