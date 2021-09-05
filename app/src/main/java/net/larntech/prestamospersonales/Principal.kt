package net.larntech.prestamospersonales

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_principal.*

class Principal : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)

         var listaClientes = emptyList<Cliente>()
        val database = PrestamosDatabase.getDatabase(this)

       database.clientes().getAll().observe(this, Observer {
         listaClientes = it
            val adapter = ClienteAdapter(this, listaClientes)
            lista.adapter = adapter
        })



        lista.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(this, ClienteActivity::class.java)
            intent.putExtra("id", listaClientes[position].idCliente)
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
       menuInflater.inflate(R.menu.cliente_menu,menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.editar_item ->{
            }
            R.id.eliminar_item ->{

            }

        }

        return super.onOptionsItemSelected(item)
    }


}
