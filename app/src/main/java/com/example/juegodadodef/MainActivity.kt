package com.example.juegodadodef


import android.content.Context
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textoDado = findViewById<EditText>(R.id.textoDado)
        val textoCara = findViewById<EditText>(R.id.textoCara)
        val btnTirar = findViewById<Button>(R.id.btnTirar)
        val textoNum = findViewById<TextView>(R.id.textView)
        val textoNum2 = findViewById<TextView>(R.id.textView2)



        btnTirar.setOnClickListener {

            val text1 = textoDado.text.toString()
            val text2 = textoCara.text.toString()
            var sumaNumeros = 0
            if (textoDado.text.toString().isEmpty() || textoCara.text.toString().isEmpty()) {
                //txtError.text = "Error al rellenar campos"
                if(textoDado.text.toString().isEmpty()){
                    textoDado.error = "Campo obligatorio"
                }
                if(textoCara.text.toString().isEmpty()){
                    textoCara.error = "Campo obligatorio"
                }
            } else {
                val arrayNumeros = arrayOfNulls<String>(text1.toInt())
                for (i in 0..arrayNumeros.size - 1) {
                    val randomNumber = (1..text2.toInt()).random()
                    arrayNumeros[i] = randomNumber.toString()
                    sumaNumeros += randomNumber
                }
                textoNum.text = "La suma de los dados es: " + sumaNumeros.toString()
                textoNum2.text = "Resultado de los dados es: " + arrayNumeros.joinToString(", ")

            }

            this.currentFocus?.let { view ->
                val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
                imm?.hideSoftInputFromWindow(view.windowToken, 0)
            }
           }

}
}