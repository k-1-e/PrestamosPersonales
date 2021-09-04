package net.larntech.prestamospersonales

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_nuevo_cliente.*

class NuevoCliente : AppCompatActivity() {

    private val db = PrestamosDatabase.getDatabase(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nuevo_cliente)

        guardar_btn.setOnClickListener{
            val nombre = nombre_et.text.toString()
            val cantidadprestada = cantidadprestada_et.toString().toDouble()
            val descripcion = descripcion_et.text.toString()

            val cliente = Cliente(nombre, cantidadprestada, descripcion)

           doAsync{
               db.clientesDao().InsertAll(cliente)
               runOnUiThread{
                   this@NuevoCliente.finish()
               }
           }



        }
    }
}