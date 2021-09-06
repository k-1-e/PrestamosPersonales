package net.larntech.prestamospersonales

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Bienvenida : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bienvenida)
    }
    fun agregarClientes(view: android.view.View) {
        val intent = Intent(this, NuevoCliente::class.java)

        startActivity(intent)
    }

    fun verClientes(view: android.view.View) {
        val intent = Intent(this, Principal::class.java)

        startActivity(intent)
    }
    fun capital(view: android.view.View) {
        val intent = Intent(this, TotalFondos::class.java)

        startActivity(intent)
    }

}