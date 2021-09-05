package net.larntech.prestamospersonales

import android.content.ContentUris
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_nuevo_cliente.*
import kotlinx.coroutines.*

import kotlin.math.round

class NuevoCliente : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nuevo_cliente)


        var idCliente: Int? = null

        if (intent.hasExtra("cliente")){


            val cliente = intent.extras?.getSerializable("cliente") as Cliente

            nombre_et.setText(cliente.nombre)
            cantidadprestada_et.setText(cliente.cantidadprestada.toString())
            descripcion_et.setText(cliente.descripcion)
            idCliente = cliente.idCliente
        }

        val database = PrestamosDatabase.getDatabase(this)


        guardar_btn.setOnClickListener{
            val nombre = nombre_et.text.toString()
            val cantidadprestada = cantidadprestada_et.text.toString().toDouble()
            val descripcion = descripcion_et.text.toString()

            val cliente = Cliente(nombre, cantidadprestada, descripcion)

            if(idCliente != null){

                CoroutineScope(Dispatchers.IO).launch{
                    cliente.idCliente= idCliente
                    database.clientes().update(cliente)
                    this@NuevoCliente.finish()
                }
                Toast.makeText(this, "Cliente Editado Correctamente", Toast.LENGTH_SHORT)
                    .show();
            }else {
                CoroutineScope(Dispatchers.IO).launch {

                    database.clientes().insertAll(cliente)

                    this@NuevoCliente.finish()
                }
                Toast.makeText(this, "Cliente Agregado Correctamente", Toast.LENGTH_SHORT)
                    .show();
            }

        }

    }

}
