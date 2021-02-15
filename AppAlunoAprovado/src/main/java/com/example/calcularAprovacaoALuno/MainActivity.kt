package com.example.calcularAprovacaoALuno

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalcular.setOnClickListener{
            val resultado = texto

            val nota1 = Integer.parseInt(nota1.text.toString())
            val nota2 = Integer.parseInt(nota2.text.toString())
            val faltas = Integer.parseInt(totalFaltas.text.toString())
            val media = (nota1+nota2)/2

            if(media >= 6 && faltas <= 10){
                resultado.text = "Aluno(a) aprovado(a) \n" + "Nota final: $media \n" + "Faltas: $faltas"
                resultado.setTextColor(Color.BLUE)
            } else {
                resultado.text = "Aluno(a) reprovado(a) \n" + "Nota final: $media \n" + "Faltas: $faltas"
                resultado.setTextColor(Color.RED)
            }
        }

    }
}