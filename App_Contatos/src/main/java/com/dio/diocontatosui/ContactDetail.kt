package com.dio.diocontatosui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout

class ContactDetail : AppCompatActivity() {
    private var contato: Contact? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_detail)

        initToolBar()
        getExtras()
        bindView()
    }

    private fun initToolBar(){
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun getExtras() {
        contato = intent.getParcelableExtra(EXTRA_CONTACT)
    }

    private fun bindView(){
        findViewById<TextView>(R.id.nameDetail).text = contato?.name
        findViewById<TextView>(R.id.phoneDetail).text = contato?.phone
        contato?.photo?.let { findViewById<ImageView>(R.id.photoDetail).setImageResource(it) }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    companion object{
        const val EXTRA_CONTACT: String = "EXTRA_CONTACT"
    }
}