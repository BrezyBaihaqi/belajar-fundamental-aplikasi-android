package com.example.myintentapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // memperkenalkan button yg ada di activity_main.xml
        val btnMoveActivity: Button = findViewById(R.id.btn_move_activity)
        // tambahkan onClick untuk setiap Button agar bisa di klik
        btnMoveActivity.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            // jika Button in di klik maka akan terjadi ->
            R.id.btn_move_activity -> {

            }
        }
    }
}