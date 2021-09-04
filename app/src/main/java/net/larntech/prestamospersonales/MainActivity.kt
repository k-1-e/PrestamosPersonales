package net.larntech.prestamospersonales

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun startAplication(view: View) {
        var usuario = findViewById<EditText>(R.id.EditUsuario).text.toString();
        var contraseña = findViewById<EditText>(R.id.EditContraseña).text.toString();
        if (usuario == "Kevin" && contraseña == "1351") {
            val intent = Intent(this, Principal::class.java)
            startActivity(intent)
        }
        else {

            Toast.makeText(this,"Falta llenar los campos", Toast.LENGTH_SHORT)
                .show();

        }

    }


}