package com.perguntados.concessionriaapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CarAdapter(private val context: Context, private val carList: List<Car>) :
    RecyclerView.Adapter<CarAdapter.ViewHolder>() {

    private var onItemClick: ((Car) -> Unit)? = null

    fun setOnItemClickListener(listener: (Car) -> Unit) {
        onItemClick = listener
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val carImageView = itemView.findViewById<ImageView>(R.id.carImageView)
        val carNameTextView = itemView.findViewById<TextView>(R.id.carNameTextView)
        val carPrecco = itemView.findViewById<TextView>(R.id.carPreco)
        val carDescriptionTextView = itemView.findViewById<TextView>(R.id.carDescriptionTextView)
        val descdetail = itemView.findViewById<TextView>(R.id.cardesc)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.car_item, parent, false)
        return ViewHolder(view)

    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val car = carList[position]
        holder.carNameTextView.text = car.name
        holder.carPrecco.text = car.preco
        holder.carDescriptionTextView.text = car.description

        holder.carImageView.setImageResource(car.imageResource)


        holder.itemView.setOnClickListener {
            onItemClick?.invoke(car)
        }


    }

    override fun getItemCount(): Int {
        return carList.size
    }

}