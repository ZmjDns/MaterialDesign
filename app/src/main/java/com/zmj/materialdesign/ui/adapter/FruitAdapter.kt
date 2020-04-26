package com.zmj.materialdesign.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.zmj.materialdesign.R
import com.zmj.materialdesign.entry.Fruit
import kotlinx.android.synthetic.main.fruit_item.view.*

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/4/24
 * Description :
 */
class FruitAdapter(var context: Context,var fruits: List<Fruit>): RecyclerView.Adapter<FruitAdapter.FruitHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.fruit_item,null)
        return FruitHolder(view)
    }

    override fun getItemCount(): Int {
        return fruits.size
    }

    override fun onBindViewHolder(holder: FruitHolder, position: Int) {
        val fruit = fruits[position]
        //holder.fruitImg.setImageDrawable(context.getDrawable(fruit.imageId))
        holder.fruitImg.setImageDrawable(context.resources.getDrawable(fruit.imageId))
        holder.fruitName.text = fruit.name

        holder.cardView.setOnClickListener {
            listener?.onItemClick(fruit)
        }
    }



    class FruitHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var cardView = itemView as CardView
        var fruitImg: ImageView = itemView.findViewById(R.id.fruitImg)
        var fruitName: TextView = itemView.findViewById(R.id.fruitName)
    }

    private var listener: OnFruitItemClick? = null

    interface OnFruitItemClick{
        fun onItemClick (fruit: Fruit)
    }

    fun setOnItemClickListener(listener: OnFruitItemClick){
        this.listener = listener
    }
}