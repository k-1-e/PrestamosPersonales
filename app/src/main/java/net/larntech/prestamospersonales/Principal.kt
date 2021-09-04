package net.larntech.prestamospersonales

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_principal.*

class Principal : AppCompatActivity() {
    private var listaClientes = emptyList<Cliente>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)

        val db = PrestamosDatabase.getDatabase(this)

        db.clientesDao().getAll().observe(this, Observer {
         listaClientes = it
            val adapter = ClienteAdapter(this, listaClientes)
            lista.adapter = adapter
        })

        lista.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(this, ClienteActivity::class.java)
            intent.putExtra("cliente", listaClientes[position])
            startActivity(intent)
        }
        add_fab.setOnClickListener{
            val intent = Intent(this,  NuevoCliente::class.java)
           // intent.putExtra("cliente", listaClientes[position])
            startActivity(intent)
        }
    }
    fun agregar(view: View) {
        val intent = Intent(this, NuevoCliente::class.java)
        startActivity(intent)

    }
}
