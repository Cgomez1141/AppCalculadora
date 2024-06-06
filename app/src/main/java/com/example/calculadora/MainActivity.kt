package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.example.calculadora.databinding.ActivityMainBinding
import java.lang.Math.pow
import kotlin.math.E
import kotlin.math.PI
import kotlin.math.cbrt
import kotlin.math.cos
import kotlin.math.ln
import kotlin.math.log10
import kotlin.math.pow
import kotlin.math.sin
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {

    lateinit var editText: EditText
    var newOperation=true
    var oldNumero=""
    var operacion="+"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val enlace = ActivityMainBinding.inflate(layoutInflater)
        editText= enlace.editText
        setContentView(enlace.root)
    }
    fun eventonumeros(view: View){
        if (newOperation)
            editText.setText("")
        newOperation=false
        var botonclick = editText.text.toString()
        var botonSelec = view as Button

        when (botonSelec.id){
            R.id.uno -> botonclick += "1"
            R.id.dos -> botonclick += "2"
            R.id.tres -> botonclick += "3"
            R.id.cuatro -> botonclick += "4"
            R.id.cinco -> botonclick += "5"
            R.id.seis -> botonclick += "6"
            R.id.siete -> botonclick += "7"
            R.id.ocho -> botonclick += "8"
            R.id.nueve -> botonclick += "9"
            R.id.cero -> botonclick += "0"
            R.id.punto -> botonclick += "."
            R.id.resta -> botonclick = if (botonclick.startsWith("-")) botonclick.substring(1) else "-$botonclick"
        }
        editText.setText(botonclick)
    }
    fun eventoOperador(view: View){
        newOperation=true
        oldNumero=editText.text.toString()

        var opSelec= view as Button

        when (opSelec.id){
            R.id.resta->operacion="-"
            R.id.suma->operacion="+"
            R.id.multi->operacion="*"
            R.id.divi->operacion="/"
        }

    }
    fun eventoIgualdad (view: View){
        var numero=editText.text.toString()
        var resultado=0.0
        when(operacion){
            "-" -> resultado = oldNumero.toDouble()-numero.toDouble()
            "+" -> resultado = oldNumero.toDouble()+numero.toDouble()
            "*" -> resultado = oldNumero.toDouble() * numero.toDouble()
            "/" -> resultado = oldNumero.toDouble()/numero.toDouble()
        }
        editText.setText(resultado.toString())
    }
    fun eventAC(view: View) {
        editText.setText("0")
        newOperation =true
    }

    fun eventoPorcent(view: View) {
        var num =editText.text.toString().toDouble()/100
        editText.setText(num.toString())
        newOperation =true
    }
    fun eventoRaizCuadrada(view: View) {
        var num = editText.text.toString().toDouble()
        editText.setText(sqrt(num).toString())
        newOperation = true
    }

    fun eventoRaizCubica(view: View) {
        var num = editText.text.toString().toDouble()
        editText.setText(cbrt(num).toString())
        newOperation = true
    }

    fun eventoSeno(view: View) {
        val num = editText.text.toString().toDoubleOrNull()
        if (num != null) {
            val resultado = sin(Math.toRadians(num))
            editText.setText(resultado.toString())
            newOperation = true
        } else {
            editText.setText("ERROR")
        }
    }

    fun eventoCoseno(view: View) {
        val num = editText.text.toString().toDoubleOrNull()
        if (num != null) {
            val resultado = cos(Math.toRadians(num))
            editText.setText(resultado.toString())
            newOperation = true
        } else {
            editText.setText("ERROR")
        }
    }

    fun eventoPi(view: View) {
        editText.setText(PI.toString())
        newOperation = true
    }

    fun eventoLogaritmo(view: View) {
        var num = editText.text.toString().toDouble()
        editText.setText(log10(num).toString())
        newOperation = true
    }

    fun eventoLogaritmoNatural(view: View) {
        val num = editText.text.toString().toDoubleOrNull()
        if (num != null && num > 0) {
            val resultado = ln(num)
            editText.setText(resultado.toString())
            newOperation = true
        } else {
            editText.setText("ERROR")
        }
    }
    fun eventoEuler(view: View) {
        editText.setText(E.toString())
        newOperation = true
    }
    fun borrarDigito(view: View) {
        val textoActual = editText.text.toString()
        if (textoActual.isNotEmpty()) {
            val nuevoTexto = textoActual.substring(0, textoActual.length - 1)
            editText.setText(nuevoTexto)
        }
    }
    fun eventoElevado(view: View) {
        val num = editText.text.toString().toDoubleOrNull()
        if (num != null) {
            val resultado = pow(num, 2.0) // Elevamos el número ingresado al cuadrado (potencia de 2)
            editText.setText(resultado.toString())
            newOperation = true
        } else {
            editText.setText("ERROR")
        }
    }
}
