package com.example.myintentapp

import android.content.Intent
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

        val btnMoveWithData: Button = findViewById(R.id.btn_move_with_data)
        btnMoveWithData.setOnClickListener(this)

        val btnMoveWithObject: Button = findViewById(R.id.btn_move_with_object)
        btnMoveWithObject.setOnClickListener(this)

        val btnDialNumber: Button = findViewById(R.id.btn_dial_number)
        btnDialNumber.setOnClickListener(this)

        val btnMoveWithResult: Button = findViewById(R.id.btn_move_with_result)
        btnMoveWithResult.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            // jika Button in di klik maka akan terjadi ->
            R.id.btn_move_activity -> {
                // baris kode untuk membuat perpindahan dari satu activity ke activity lain
                val moveIntent = Intent(this@MainActivity, MoveActivity::class.java)
                // kode untuk memulai perpindahan
                startActivity(moveIntent)
            }

            R.id.btn_move_with_data -> {
                val moveWithDataIntent = Intent(this@MainActivity, MoveWithDataActivity::class.java)
                // dua baris kode untuk menempatkan data yg akan dipindahkan
                // metode putExtra digunakan untuk berpindah data bersamaan (extra) dengan obyek Intent
                // metode putExtra menampung key-value
                // data yg dikirim menggunakan putExtra, di ambil menggunakan getIntent().getTipeDataExtra(key)
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "DicodingAcademy Boy")
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 5)
                startActivity(moveWithDataIntent)
            }

            R.id.btn_move_with_object -> {
                // karena data yg akan dikirimkan lebih kompleks, kita gunakan data class Person
                val person = Person(
                    "DicodingAcademy", 5, "academy@dicoding.com", "Bandung"
                )

                val moveWithObjectIntent = Intent(this@MainActivity, MoveWithObjectActivity::class.java)
                moveWithObjectIntent.putExtra(MoveWithObjectActivity.EXTRA_PERSON, person)
                startActivity(moveWithObjectIntent)
            }

            R.id.btn_dial_number -> {

            }

            R.id.btn_move_with_result -> {

            }
        }
    }
}