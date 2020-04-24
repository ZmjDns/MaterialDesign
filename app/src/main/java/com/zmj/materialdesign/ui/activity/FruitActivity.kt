package com.zmj.materialdesign.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.zmj.materialdesign.R
import com.zmj.materialdesign.entry.Fruit
import kotlinx.android.synthetic.main.activity_fruit.*

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/4/24
 * Description :
 */
class FruitActivity:AppCompatActivity() {

    private var fruit: Fruit? = null

    companion object{
        fun launch(context: Context,fruit: Fruit){
            val intent = Intent(context,FruitActivity::class.java)
            intent.putExtra("fruit",fruit)

            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_fruit)

        fruit = intent.getSerializableExtra("fruit") as Fruit

        setSupportActionBar(toolBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        collapsing_toolbar.title = fruit?.name
        if (fruit?.imageId != null){
            fruit_image.setImageDrawable(getDrawable(fruit!!.imageId))
        }
        fruit_content_text.text = initFruit(fruit!!.name)
    }

    private fun initFruit(name: String): CharSequence? {
        val str = StringBuilder()
        for (i in 0 until 500){
            str.append(name)
        }
        return str.toString()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> {
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}