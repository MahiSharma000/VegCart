package com.example.vegcart.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.vegcart.R
import com.example.vegcart.models.Product

class ProductAdapter(
    val context: Context,
    val layoutRes:Int,
    val products:List<Product>
):RecyclerView.Adapter<ProductAdapter.Holder>() {
    class Holder(val v:View):RecyclerView.ViewHolder(v){
        val name:TextView=v.findViewById(R.id.name)
        val price:TextView=v.findViewById(R.id.price)
        val image:ImageView=v.findViewById(R.id.image)
        fun bind(product: Product){
            name.text=product.name
            price.text=product.price.toString()
            image.setImageResource(product.imageRes)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val v=LayoutInflater.from(context).inflate(layoutRes,parent,false)
        return  Holder(v)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(products[position])
    }

    override fun getItemCount()=products.size


}