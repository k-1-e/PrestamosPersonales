package net.larntech.prestamospersonales

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_cliente.*

class ClienteActivity : AppCompatActivity() {

    private lateinit var database: PrestamosDatabase
    private lateinit var cliente : Cliente
    private lateinit var  clienteLiveData: LiveData<Cliente>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cliente)

        database = PrestamosDatabase.getDatabase(this)

        val idCliente = intent.getIntExtra("id",0)

        clienteLiveData = database.clientes().get(idCliente)

        clienteLiveData.observe(this, Observer{
            cliente = it

            nombre_cliente.text = cliente.nombre
            cantidadprestada_cliente.text = "$${cliente.cantidadprestada}"
            detalles_cliente.text = cliente.descripcion
            //  imagen_cliente.setImageResource(cliente.imagen)
        })



    }
}