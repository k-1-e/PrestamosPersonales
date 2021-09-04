package net.larntech.prestamospersonales

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_cliente.*

class ClienteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cliente)

        val cliente = intent.getSerializableExtra("cliente") as Cliente
         nombre_cliente.text = cliente.nombre
        cantidadprestada_cliente.text = "$${cliente.cantidadprestada}"
        detalles_cliente.text = cliente.descripcion
      //  imagen_cliente.setImageResource(cliente.imagen)
    }
}