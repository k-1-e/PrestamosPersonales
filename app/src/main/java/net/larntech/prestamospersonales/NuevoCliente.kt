package net.larntech.prestamospersonales

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_nuevo_cliente.*
import org.jetbrains.anko.doAsync
import kotlin.math.round

class NuevoCliente : AppCompatActivity() {
    private val db = PrestamosDatabase.getDatabase(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nuevo_cliente)

            guardar_btn.setOnClickListener{
            val nombre = nombre_et.text.toString()
            val cantidadprestada = cantidadprestada_et.text.toString().toDouble()
            val descripcion = descripcion_et.text.toString()
            val cliente = Cliente(nombre, cantidadprestada, descripcion)

            doAsync{
                db.clientesDao().insertAll(cliente)

                runOnUiThread {
                    this@NuevoCliente.finish()
                }
            }

        }

    }
}