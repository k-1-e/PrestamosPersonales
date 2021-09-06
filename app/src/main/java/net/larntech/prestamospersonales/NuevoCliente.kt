package net.larntech.prestamospersonales

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_nuevo_cliente.*
import kotlinx.android.synthetic.main.item_cliente.*
import kotlinx.coroutines.*

class NuevoCliente : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nuevo_cliente)


        var idCliente: Int? = null

        if (intent.hasExtra("cliente")){


            val cliente = intent.extras?.getSerializable("cliente") as Cliente

            nombre_et.setText(cliente.nombre)
            cantidadprestada_et.setText(cliente.cantidadprestada.toString())
            descripcion_et.setText(cliente.direccion)
            telefono_et.setText(cliente.telefono.toString())
            idCliente = cliente.idCliente
        }

        val database = PrestamosDatabase.getDatabase(this)


        guardar_btn.setOnClickListener {

            if (nombre_et.text.isEmpty() || cantidadprestada_et.text.isEmpty() || descripcion_et.text.isEmpty()
                || telefono_et.text.isEmpty()
            )
            {
                Toast.makeText(this, "Por favor rellenar los campos", Toast.LENGTH_SHORT)
                    .show();
            } else {
                val nombre = nombre_et.text.toString()
                val cantidadprestada = cantidadprestada_et.text.toString().toDouble()
                val direccion = descripcion_et.text.toString()
                val telefono = telefono_et.text.toString().toInt()

                val cliente = Cliente(nombre, cantidadprestada, direccion, telefono)
                if (idCliente != null) {

                    CoroutineScope(Dispatchers.IO).launch {
                        cliente.idCliente = idCliente
                        database.clientes().update(cliente)
                        this@NuevoCliente.finish()
                    }
                    Toast.makeText(this, "Cliente Editado Correctamente", Toast.LENGTH_SHORT)
                        .show();
                } else {
                    CoroutineScope(Dispatchers.IO).launch {

                        database.clientes().insertAll(cliente)

                        this@NuevoCliente.finish()
                    }
                    Toast.makeText(this, "Cliente Registrado correctamente", Toast.LENGTH_SHORT)
                        .show();
                }

            }
        }

    }

}
