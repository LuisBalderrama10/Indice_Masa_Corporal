package mxedu.itesca.examen_19130166

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.time.measureTime

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val altura: EditText = findViewById(R.id.edEstatura)
        val peso: EditText = findViewById(R.id.etKilos)
        val calcular: Button = findViewById(R.id.btnCalcular)
        val setid: TextView = findViewById(R.id.tvIndice)
        val setTipo: TextView = findViewById(R.id.tvTipo)

        calcular.setOnClickListener {
            var c = Convertir((altura.text.toString().toDouble()), (peso.text.toString().toDouble()))
            setid.text = "$c"
            if (c < 18.5) {
                setTipo.text = "Tiene bajo peso"
                setTipo.setTextColor(resources.getColor(android.R.color.holo_green_light))
            } else if (c >= 18.5 && c <= 24.9) {
                setTipo.text = "Tiene Peso normal"
                setTipo.setTextColor(resources.getColor(android.R.color.holo_green_dark))
            } else if (c >= 25.0 && c <= 29.9) {
                setTipo.text = "Tiene Sobrepeso"
                setTipo.setTextColor(resources.getColor(android.R.color.holo_orange_light))
            } else if (c >= 30.0) {
                setTipo.text = "tiene Obesidad"
                setTipo.setTextColor(resources.getColor(android.R.color.holo_red_dark))
            }
        }
    }
}

    fun Convertir(altura: Double, peso:Double):Double{
        var imc=peso/(altura * altura)
        return imc
    }
