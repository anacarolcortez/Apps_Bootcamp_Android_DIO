package com.dio.busyme

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CalendarContract
import android.provider.CalendarContract.EXTRA_EVENT_BEGIN_TIME
import android.provider.CalendarContract.EXTRA_EVENT_END_TIME
import android.provider.CalendarContract.Events.*
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main.*
import java.time.DayOfWeek
import java.time.Instant
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnAdd = findViewById<Button>(R.id.btnAdicionar)

        btnAdd.setOnClickListener {

            val titulo = inputTitulo.text.toString()
            val local = inputLocal.text.toString()

            val intent = Intent(Intent.ACTION_INSERT)
                    .setData(CONTENT_URI)
                    .putExtra(TITLE, titulo)
                    .putExtra(EVENT_LOCATION, local)
                    .putExtra(EXTRA_EVENT_BEGIN_TIME, Calendar.getInstance().timeInMillis)
                    .putExtra(EXTRA_EVENT_END_TIME, Calendar.getInstance().timeInMillis + (60*60*1000))

            startActivity(intent)
        }
    }
}