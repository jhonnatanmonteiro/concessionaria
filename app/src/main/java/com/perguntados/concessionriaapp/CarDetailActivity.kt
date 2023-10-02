package com.perguntados.concessionriaapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.service.controls.actions.FloatAction
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton


class CarDetailActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_car_detail)
        val btn = findViewById<FloatingActionButton>(R.id.floatingActionButton2)





        val decorView = window.decorView
        val uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN
        decorView.systemUiVisibility = uiOptions


        val carNameTextView = findViewById<TextView>(R.id.carDetailNameTextView)
        val carDescriptionTextView = findViewById<TextView>(R.id.carDetailDescriptionTextView)
        val carImageView = findViewById<ImageView>(R.id.carDetailImageView)
        val desdetail=findViewById<TextView>(R.id.cardesc)

        val carName = intent.getStringExtra("carName")
      //  val carDescription = intent.getStringExtra("carDescription")
        val carImageResource = intent.getIntExtra("carImageResource", 0)
        val detailDesc = intent.getStringExtra("detailDesc")
        // Defina os dados nos componentes de exibição
        carNameTextView.text = carName
       // carDescriptionTextView.text = carDescription
        carImageView.setImageResource(carImageResource)
        desdetail.text=detailDesc


    }

}