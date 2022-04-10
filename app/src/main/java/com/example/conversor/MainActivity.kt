package com.example.conversor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val visualize:Button=btnConvertir
        visualize.setOnClickListener{
            val dollar:Double=etxValor.text.toString().toDouble()
            val cosign:CheckBox=checkBoxDivisa
            val result:TextView=txtResultado

            if(cosign.isChecked){
                val sharedPref = getSharedPreferences("MySharedPreferences", MODE_PRIVATE)
                val change = sharedPref.getFloat("KEYEUR", 0.0F)
                val eur:Double = change.toDouble()
                val finish:Double = dollar * eur
                result.text = "$finish €"

            }
            else{
                var EUR:Double = 0.90
                val finish:Double = dollar * EUR
                result.text = "$finish €"
            }
        }

    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.others, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {
            R.id.setting -> {
                val intent = Intent(this, CambiarDivisa::class.java).apply {

                }
                startActivity(intent)
                true
            }
            R.id.member -> {
                val intent = Intent(this, members::class.java).apply {

                }
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}