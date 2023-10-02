package com.perguntados.concessionriaapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.perguntados.concessionriaapp.Car
import com.perguntados.concessionriaapp.CarAdapter
import com.perguntados.concessionriaapp.R

class CarListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_car_list)
        val decorView = window.decorView
        val uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN
        decorView.systemUiVisibility = uiOptions





        val carRecyclerView = findViewById<RecyclerView>(R.id.carRecyclerView)
        val layoutManager = LinearLayoutManager(this)
        carRecyclerView.layoutManager = layoutManager

        val carList = generateCarList() // Substitua por seus próprios dados
        val adapter = CarAdapter(this, carList)
        carRecyclerView.adapter = adapter


        adapter.setOnItemClickListener { car ->
            val intent = Intent(this, CarDetailActivity::class.java)
            intent.putExtra("carName", car.name)
            intent.putExtra("carDescription", car.description)
            intent.putExtra("carImageResource", car.imageResource)
            intent.putExtra("detailDesc", car.detailDesc)
            startActivity(intent)
        }


    }

    private fun generateCarList(): List<Car> {
        val carList = listOf(
            car1,
            car2,
            car3,
            car4,
            car5,
            car6,
            car7,
            car8,
            car9,
            car10,
            car11,
            car12,
            car13,
            car14,
            car15,
            car16,
            car17,
            car18,
            car19,
            car20
        )
        return carList
    }}

