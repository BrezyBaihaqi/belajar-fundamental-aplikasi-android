package com.example.myintentapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MoveWithObjectActivity : AppCompatActivity() {

    // function untuk menyimpan value
    companion object {
        const val EXTRA_PERSON = "extra_person"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_object)

        // untuk menentukan tv Object akan di tampilkan di tv_object_received
        val tvObject: TextView = findViewById(R.id.tv_object_received)

        // memanggil function EXTRA_PERSON untuk menerima data dari activity lain
        val person = intent.getParcelableExtra<Person>(EXTRA_PERSON) as Person
        val text = "Name : ${person.name.toString()},\nEmail : ${person.email.toString()}," +
                "\nAge : ${person.age.toString()},\nLocation : ${person.city.toString()},\n"

        // yg akan di tampilkan di tv Object adalah expression text di atas
        tvObject.text = text
    }
}