package com.xantrikoding.githubapp.data

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.xantrikoding.githubapp.R
import com.xantrikoding.githubapp.databinding.ActivityDetailBinding
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    companion object {
        const val EXTRA_DETAIL = "extra_detail"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val coder = intent.getParcelableExtra<Coder>(EXTRA_DETAIL)

        Glide.with(this)
            .load(coder?.photo)
            .apply(RequestOptions().override(55, 55))
            .into(img_detail_photo)

        binding.tvDetailName.text = coder?.name
        binding.tvDetailUser.text = coder?.userName
        binding.tvDetailDescription.text = coder?.description
        binding.tvCity.text = coder?.city
        binding.tvLocation.text = coder?.location
        binding.tvLink.text = coder?.link
        binding.tvFollower.text = coder?.follower
        binding.tvFollowing.text = coder?.following

        supportActionBar?.title = coder?.name

        binding.btnFollow.setOnClickListener {
            if (btn_follow.text == getString(R.string.follow)) {
                val followed = getString(R.string.followed)
                btn_follow.text = followed.toUpperCase()
                Toast.makeText(
                    it.context,
                    "$followed ${coder?.name}",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                btn_follow.text = getString(R.string.follow)
                val stopFollow = getString(R.string.stop_follow)
                Toast.makeText(
                    it.context,
                    "$stopFollow ${coder?.name}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
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