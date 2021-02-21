package com.dio.diocontatosui

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dio.diocontatosui.ContactDetail.Companion.EXTRA_CONTACT

class MainActivity : AppCompatActivity(), ClickContact {
    private val rvlist: RecyclerView by lazy {
        findViewById<RecyclerView>(R.id.rv_list)
    }

    private val adapter = ContactAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.drawer_menu)

        initDrawer()
        bindView()
        updateList()
    }

    private fun initDrawer() {
        val drawerLayout = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val toogle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.openDrawer, R.string.closeDrawer)
        drawerLayout.addDrawerListener(toogle)
        toogle.syncState()
    }

    private fun bindView(){
        rvlist.adapter = adapter
        rvlist.layoutManager = LinearLayoutManager(this)
    }

    private fun updateList(){
        adapter.updateList(
            arrayListOf(
                Contact(
                    "Ana Carolina Cortez",
                    "(11)9911-9911",
                    R.drawable.ana
                ),
                Contact(
                    "Santa Rosa Madalena",
                    "(11)8822-8822",
                    R.drawable.rosa
                ),
                Contact(
                    "Billie Jean",
                    "(11)7733-7733",
                    R.drawable.billie
                ),
                Contact(
                    "Kátia Flávia",
                    "(11)6644-6644",
                    R.drawable.katia
                )
            )
        )
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean{
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    private fun showToast(msg: String){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.menu1 -> {
                showToast("Clicou no menu 1")
                return true
            }
            R.id.menu2 -> {
                showToast("Clicou no menu 2")
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun clickContactCard(contato: Contact){
        var intent = Intent(this, ContactDetail::class.java)
        intent.putExtra(EXTRA_CONTACT, contato)
        startActivity(intent)
    }
}