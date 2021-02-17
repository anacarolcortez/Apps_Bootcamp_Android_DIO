package com.dio.aulaciclosdevidaandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.w("Lifecycle", "On Create: estou criando a tela")
    }

    override fun onStart() {
        super.onStart()
        Log.w("Lifecycle", "On Start: deixei a tela visível para você")
    }

    override fun onResume() {
        super.onResume()
        Log.w("Lifecycle", "On Resume: agora você pode interagir com a tela")
    }

    override fun onPause() {
        super.onPause()
        Log.w("Lifecycle", "On Pause: a tela perdeu o foco, você não pode mais interagir com ela")
    }

    override fun onStop() {
        Log.w("Lifecycle", "On Stop: a tela não está mais visível, mas ainda existe")
        super.onStop()
    }

    override fun onRestart() {
        super.onRestart()
        Log.w("Lifecycle", "On Restart: a tela está retomando o foco")
    }

    override fun onDestroy() {
        Log.w("Lifecycle", "On Destroy: a tela foi destruída :(")
        super.onDestroy()
    }

}
