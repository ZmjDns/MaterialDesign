package com.zmj.materialdesign.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.google.android.material.snackbar.Snackbar
import com.zmj.materialdesign.R
import com.zmj.materialdesign.common.showToast
import com.zmj.materialdesign.entry.Fruit
import com.zmj.materialdesign.ui.adapter.FruitAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.concurrent.thread

class MainActivity : BaseActivity() {

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
        initRecycler()
        initSwipeRefreshLayout()
    }

    private fun initNavigationView(){
        nav_view.setCheckedItem(R.id.call)
        nav_view.setNavigationItemSelectedListener {
            drawer.closeDrawers()
            true
        }
    }

    private fun initFloatingActionBtn(){
        fab.setOnClickListener {
            Snackbar.make(it,"You have delete data",Snackbar.LENGTH_LONG)
                .setAction("undo"
                ) { Toast.makeText(this,"Data restored",Toast.LENGTH_SHORT).show() }
                .show()
        }
    }

    private fun initRecycler(){
        val fruits: ArrayList<Fruit> = ArrayList()
        initFruitData(fruits)
        rv_view.layoutManager = GridLayoutManager(this,2)
        val fruitAdapter = FruitAdapter(this,fruits)
        rv_view.adapter = fruitAdapter

        fruitAdapter.setOnItemClickListener(object :FruitAdapter.OnFruitItemClick{
            override fun onItemClick(fruit: Fruit) {
                FruitActivity.launch(this@MainActivity,fruit)
            }
        })
    }

    private fun initSwipeRefreshLayout(){
        swipeRefresh.setColorSchemeResources(R.color.colorPrimary)
        swipeRefresh.setOnRefreshListener(object :SwipeRefreshLayout.OnRefreshListener{
            override fun onRefresh() {
                refreshFruits()
            }
        })
    }

    private fun refreshFruits() {
        thread {
            Thread.sleep(2000)
            runOnUiThread {
                initRecycler()
                swipeRefresh.isRefreshing = false
            }
        }
    }

    private fun initFruitData(fruits: ArrayList<Fruit>) {
        fruits.add(Fruit("cherry",R.drawable.fruit1))
        fruits.add(Fruit("apple",R.drawable.fruit2))
        fruits.add(Fruit("orange",R.drawable.fruit1))
        fruits.add(Fruit("pineapple",R.drawable.fruit2))
        fruits.add(Fruit("pear",R.drawable.fruit1))
        fruits.add(Fruit("gripe",R.drawable.fruit2))
        fruits.add(Fruit("apple",R.drawable.fruit2))
        fruits.add(Fruit("orange",R.drawable.fruit1))
        fruits.add(Fruit("pineapple",R.drawable.fruit2))
        fruits.add(Fruit("pear",R.drawable.fruit1))
        fruits.add(Fruit("gripe",R.drawable.fruit2))
        fruits.add(Fruit("apple",R.drawable.fruit2))
        fruits.add(Fruit("orange",R.drawable.fruit1))
        fruits.add(Fruit("pineapple",R.drawable.fruit2))
        fruits.add(Fruit("pear",R.drawable.fruit1))
        fruits.add(Fruit("gripe",R.drawable.fruit2))
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
