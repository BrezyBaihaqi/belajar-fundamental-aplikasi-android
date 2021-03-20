package com.xantrikoding.githubapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xantrikoding.githubapp.adapter.ListCoderAdapter
import com.xantrikoding.githubapp.data.Coder
import com.xantrikoding.githubapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private val list = ArrayList<Coder>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvCoders.setHasFixedSize(true)

        list.addAll(getListCoders())
        showRecyclerList()

        binding.rvCoders.setOnClickListener(this)
    }

    fun getListCoders(): ArrayList<Coder> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataUserName = resources.getStringArray(R.array.data_user_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.getStringArray(R.array.data_photo)

        val listCoder = ArrayList<Coder>()
        for (position in dataName.indices) {
            val coder = Coder(
                dataName[position],
                dataUserName[position],
                dataDescription[position],
                dataPhoto[position]
            )
            listCoder.add(coder)
        }
        return listCoder
    }

    private fun showRecyclerList() {
        binding.rvCoders.layoutManager = LinearLayoutManager(this)
        val listCoderAdapter = ListCoderAdapter(list)
        binding.rvCoders.adapter = listCoderAdapter
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.rv_coders -> {

            }
        }
    }
}