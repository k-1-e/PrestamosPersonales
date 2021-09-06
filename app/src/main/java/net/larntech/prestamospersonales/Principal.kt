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
        comensar();
    }
    fun comensar() {

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
      /* floatingActionButton2.setOnClickListener {
            val intent = Intent(this, NuevoCliente::class.java)

            startActivity(intent)
        }
            <com.google.android.material.floatingactionbutton.FloatingActionButton
        android:id="@+id/floatingActionButton2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginEnd="16dp"
        android:layout_marginBottom="16dp"
        android:clickable="true"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:srcCompat="@android:drawable/ic_input_add" />
       */


    }


}


