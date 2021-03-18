package com.xantrikoding.githubapp.data

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.xantrikoding.githubapp.R
import kotlinx.android.synthetic.main.item_row_coder.*

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DETAIL = "extra_detail"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val imgDetailPhoto: ImageView = findViewById(R.id.img_detail_photo)
        imgDetailPhoto.setImageResource()
    }
}