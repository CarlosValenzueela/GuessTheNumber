package mx.edu.potros.guessthenumber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    //Variables
    var minValue = 0
    var maxValue = 100
    var num = 0
    var won = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Instancias
        val guessings: TextView = findViewById(R.id.guessings)
        val down: Button = findViewById(R.id.down)
        val up: Button = findViewById(R.id.up)
        val generate: Button = findViewById(R.id.generate)
        val guessed: Button = findViewById(R.id.guessed)


        generate.setOnClickListener {
            num = Random.nextInt(minValue, maxValue)
            guessings.setText(num.toString())
            generate.visibility = View.INVISIBLE
            guessed.visibility = View.VISIBLE
        }

        down.setOnClickListener {
            maxValue = num
            if (checkingLimits()) {
                num = Random.nextInt(minValue, maxValue)
                guessings.setText(num.toString())

            } else {
                guessings.setText(num.toString())
            }
        }

        up.setOnClickListener {
            minValue = num
            if (checkingLimits()) {
                num = Random.nextInt(minValue, maxValue)
                guessings.setText(num.toString())

            } else {
                guessings.setText("No puede ser, me ganaste.")
            }

        }

        guessed.setOnClickListener {
            if (!won) {
                guessings.setText("Adivine, tu numero es el " + num)
                guessed.setText("Volver a jugar")
                won = true
            } else {
                generate.visibility = View.VISIBLE
                generate.setText("Tap on generate to start")
                guessed.visibility = View.INVISIBLE
                resetValues()
            }
        }
    }

    //Funciones
    fun checkingLimits(): Boolean {
        return minValue != maxValue
    }

    fun resetValues() {
        var minValue = 0
        var maxValue = 100
        var num = 0
        var won = false
    }


}