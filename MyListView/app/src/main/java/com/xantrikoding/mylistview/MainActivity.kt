package com.xantrikoding.mylistview

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.*
import com.xantrikoding.mylistview.adapter.HeroAdapter
import com.xantrikoding.mylistview.databinding.ActivityMainBinding
import com.xantrikoding.mylistview.model.Hero

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: HeroAdapter
    private var heroes = arrayListOf<Hero>()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.lvList

        adapter = HeroAdapter(this)

        binding.lvList.adapter = adapter

// fungsi prepare untuk inisialisasi array
        prepare()

// setelah datanya disiapkan pada fungsi prepare(), lanjut membuat fungsi baru


// setelah data disiapkan dan ada fungsi untuk memasukkan data, lanjut membuat metode setOnItem
        binding.lvList.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            Toast.makeText(this@MainActivity, heroes[position].name, Toast.LENGTH_SHORT).show()
        }
    }

    private fun prepare() {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)

        val  heroes = ArrayList<Hero> ()
        for (position in dataName.indices) {
            val hero = Hero(
                dataPhoto.getResourceId(position, -1),
                dataName[position],
                dataDescription[position]
            )
            heroes.add(hero)
        }
        adapter.heroes = heroes
    }
}

/** baris kode menggunakan binding
private lateinit var adapter: HeroAdapter
private var heroes = arrayListOf<Hero>()

private lateinit var binding: ActivityMainBinding

override fun onCreate(savedInstanceState: Bundle?) {
super.onCreate(savedInstanceState)
binding = ActivityMainBinding.inflate(layoutInflater)
setContentView(binding.root)

binding.lvList

// kalau pakai val di adapter maka itu akan membentuk variabel baru, padahal adapter disini memanggil adapter yg di atas
adapter = HeroAdapter(this)
/**
 * baris kode di bawah tidak digunakan lagi karena variabel di atas diganti
ArrayAdapter<String> (this,
// kombinasi simpe_list_item1 dan text 2 membuat app Force Close
android.R.layout.simple_list_item_1, android.R.id.text1, dataName)
*/
binding.lvList.adapter = adapter

// fungsi prepare untuk inisialisasi array
prepare()

// setelah datanya disiapkan pada fungsi prepare(), lanjut membuat fungsi baru


// setelah data disiapkan dan ada fungsi untuk memasukkan data, lanjut membuat metode setOnItem
binding.lvList.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
Toast.makeText(this@MainActivity, heroes[position].name, Toast.LENGTH_SHORT).show()
}
}

private fun prepare() {
val dataName = resources.getStringArray(R.array.data_name)
val dataDescription = resources.getStringArray(R.array.data_description)
val dataPhoto = resources.obtainTypedArray(R.array.data_photo)

val  heroes = ArrayList<Hero> ()
for (position in dataName.indices) {
val hero = Hero(
dataPhoto.getResourceId(position, -1),
dataName[position],
dataDescription[position]
)
heroes.add(hero)
}
adapter.heroes = heroes
}
 */

/*
private lateinit var adapter: HeroAdapter
    private lateinit var dataName: Array<String>
    private lateinit var dataDescription: Array<String>
    private lateinit var dataPhoto: TypedArray
    private var heroes = arrayListOf<Hero>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView: ListView = findViewById(R.id.lv_list)
        // kalau pakai val di adapter maka itu akan membentuk variabel baru, padahal adapter disini memanggil adapter yg di atas
        adapter = HeroAdapter(this)
        listView.adapter = adapter

        // fungsi prepare untuk inisialisasi array
        prepare()

        // setelah datanya disiapkan pada fungsi prepare(), lanjut membuat fungsi baru
        addItem()

        // setelah data disiapkan dan ada fungsi untuk memasukkan data, lanjut membuat metode setOnItem
        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            Toast.makeText(this@MainActivity, heroes[position].name, Toast.LENGTH_SHORT).show()
        }
    }

    private fun addItem() {
        for (position in dataName.indices) {
            val hero = Hero(
                dataPhoto.getResourceId(position, -1),
                dataName[position],
                dataDescription[position]
            )
            heroes.add(hero)
        }
        adapter.heroes = heroes
    }

    private fun prepare() {
        dataName = resources.getStringArray(R.array.data_name)
        dataDescription = resources.getStringArray(R.array.data_description)
        dataPhoto = resources.obtainTypedArray(R.array.data_photo)
    }
 */