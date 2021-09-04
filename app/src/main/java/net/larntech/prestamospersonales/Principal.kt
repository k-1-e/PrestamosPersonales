package net.larntech.prestamospersonales

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_principal.*

class Principal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)
        val cliente = Cliente("Kevin", 100.0, "kevin es de san carlos",R.drawable.dinero)
        val cliente2 = Cliente("Jose", 500.0,"es de nueva guinea",R.drawable.bienvenidos)

        val listaClientes = listOf(cliente,cliente2)

        val adapter = ClienteAdapter(this, listaClientes)

        lista.adapter = adapter

        lista.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(this, ClienteActivity::class.java)
            intent.putExtra("cliente", listaClientes[position])
            startActivity(intent)
        }
        add_fab.setOnClickListener{

        }
    }
}
