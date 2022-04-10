package com.example.conversor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Button
import kotlinx.android.synthetic.main.activity_cambiar_divisa.*
import kotlinx.android.synthetic.main.activity_main.*

class CambiarDivisa : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cambiar_divisa)

        val actualizar:Button = btnActualizar
        actualizar.setOnClickListener{
            val euros:Float = etxValorActual.text.toString().toFloat()
            val sharedPref = getSharedPreferences("MySharedPreferences", MODE_PRIVATE)
            val myEdit = sharedPref.edit()
            myEdit.putFloat("KEYEUR", euros)
            myEdit.commit()

            val intent = Intent(this, MainActivity::class.java).apply {

            }
            startActivity(intent)
        }
    }

}