package com.example.myapplication

import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val tvResult = findViewById<TextView>(R.id.textview_result)
        val tvCategory = findViewById<TextView>(R.id.textview_category)

        val result = intent.getFloatExtra("EXTRA_RESULT", 0.1f)

        tvResult.text = result.toString()

        /* BMI Categories

        MENOR QUE 18,5      UNDERWEIGHT
        ENTRE 18,5 E 24,9   NORMAL WEIGHT
        ENTRE 25,0 E 29,9   OVERWEIGHT
        ENTRE 30,0 E 39,9   OBESITY
        MAIOR QUE 40,0      SERIOUS OBESITY
       */


        var Category = if (result < 18.5f) {
            "UNDERWEIGHT"
        } else if (result in 18.5f..24.9f) {
            "NORMAL WEIGHT"
        } else if (result in 25f..29.9f) {
            "Overweight"
        } else if (result in 30f..39.9f) {
            "OBESITY"
        } else {
            "SERIOUS OBESITY"
        }

        tvCategory.text = getString(R.string.message_category, Category)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }

}










