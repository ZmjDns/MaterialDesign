package com.zmj.materialdesign

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import com.zmj.materialdesign.common.showToast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolBar)
        val actionBar = supportActionBar
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu1)
        }
        initNavigationView()
        initFloatingActionBtn()
    }

    private fun initNavigationView(){
        nav_view.setCheckedItem(R.id.call)
        nav_view.setNavigationItemSelectedListener(object :NavigationView.OnNavigationItemSelectedListener{
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                drawer.closeDrawers()
                return true
            }
        })
    }

    private fun initFloatingActionBtn(){
        fab.setOnClickListener {
            Snackbar.make(it,"You have delete data",Snackbar.LENGTH_LONG)
                .setAction("undo"
                ) { Toast.makeText(this,"Data restored",Toast.LENGTH_SHORT).show() }
                .show()
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> {
                drawer.openDrawer(GravityCompat.START)
            }
            R.id.backUp -> {
                showToast(this,"You Clicked backup")
            }
            R.id.delete -> {
                showToast(this,"You Clicked delete")
            }
            R.id.setting -> {
                showToast(this,"You Clicked setting")
            }
        }
        return true
    }
}
