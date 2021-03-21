package com.xantrikoding.githubapp

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.xantrikoding.githubapp.adapter.ListCoderAdapter
import com.xantrikoding.githubapp.data.Coder
import com.xantrikoding.githubapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val list = ArrayList<Coder>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvCoders.setHasFixedSize(true)

        list.addAll(getListCoders())
        showRecyclerList()
    }

    fun getListCoders(): ArrayList<Coder> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataUserName = resources.getStringArray(R.array.data_user_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.getStringArray(R.array.data_photo)
        val dataCity = resources.getStringArray(R.array.data_city)
        val dataLocation = resources.getStringArray(R.array.data_location)
        val dataLink = resources.getStringArray(R.array.data_link)
        val dataFollower = resources.getStringArray(R.array.data_follower)
        val dataFollowing = resources.getStringArray(R.array.data_following)

        val listCoder = ArrayList<Coder>()
        for (position in dataName.indices) {
            val coder = Coder(
                dataName[position],
                dataUserName[position],
                dataDescription[position],
                dataPhoto[position],
                dataCity[position],
                dataLocation[position],
                dataLink[position],
                dataFollower[position],
                dataFollowing[position],
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

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_change_setting) {
            val mIntent = Intent(Settings.ACTION_LOCALE_SETTINGS)
            startActivity(mIntent)
        }
        return super.onOptionsItemSelected(item)
    }
}