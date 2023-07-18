package chl.ancud.m5_individual14

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import chl.ancud.m5_individual14.databinding.ActivityMainBinding
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var saldo = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //var mensaje = ""

        binding.btnOk.setOnClickListener {
            when(binding.radioGroup.checkedRadioButtonId) {
                binding.rbSaldo.id -> saldo()
                binding.rbIngresar.id -> ingresar()
                binding.rbRetirar.id -> retirar()
                binding.rbSalir.id -> salir()
            }
            //Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
        }
    }

    private fun saldo() {
        mostrarTostada(saldo.toString())
        limpiaMonto()
    }

    private fun ingresar() {
        saldo += binding.etxMonto.text.toString().toInt()
        mostrarTostada("Ingreso exitoso. Nuevo saldo: " + saldo.toString())
        limpiaMonto()
    }

    private fun retirar() {
        val retiro = binding.etxMonto.text.toString().toInt()
        if(retiro > saldo) {
            mostrarTostada("No se puede retirar. Saldo insuficiente: " + saldo.toString())
        } else {
            saldo -= retiro
            mostrarTostada("Retiro exitoso. Nuevo Saldo: "+saldo.toString())
        }
        limpiaMonto()
    }

    private fun salir() {
        exitProcess(0)
    }

    private fun limpiaMonto() {
        binding.etxMonto.text.clear()
    }

    private fun mostrarTostada(mensaje: String) {
        Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()
    }
}