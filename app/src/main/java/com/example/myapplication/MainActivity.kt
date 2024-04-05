package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

 class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btnCalculate: Button = findViewById(R.id.btnCalculator)
        val edtWeight : EditText = findViewById(R.id.edttext_Weight)
        val edtHeight : EditText = findViewById(R.id.edtttext_Height)


        btnCalculate.setOnClickListener {

            val heightStr = edtHeight.text.toString()
            val weightStr = edtWeight.text.toString()

            if(heightStr.isNotEmpty() && weightStr.isNotEmpty()){

            val height : Float = edtHeight.text.toString().toFloat()
            val finalHeight : Float = height * height
            val weight: Float = edtWeight.text.toString().toFloat()
            val result : Float = weight / finalHeight

            val intent = Intent(this, ResultActivity::class.java)
                .apply {
                    putExtra("EXTRA_RESULT", result)

                }
            startActivity(intent)
        } else
            Toast.makeText(this, "Fill the empty spaces", Toast.LENGTH_LONG).show()


    }

   }

 }
