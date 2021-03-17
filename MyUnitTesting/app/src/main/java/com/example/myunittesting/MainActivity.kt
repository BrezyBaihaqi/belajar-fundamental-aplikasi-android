package com.example.myunittesting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.myunittesting.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var mainViewModel: MainViewModel

//    private lateinit var edtWidth: EditText
//    private lateinit var edtLength: EditText
//    private lateinit var edtHeight: EditText
//    private lateinit var tvResult: TextView
//    private lateinit var btnCalculateVolume: Button
//    private lateinit var btnCalculateSurfaceArea: Button
//    private lateinit var btnCalculateCircumference: Button
//    private lateinit var btnSave: Button

    // semua kode di atas di satukan menjadi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = MainViewModel(CuboidModel())

        btn_save.setOnClickListener(this)
        btn_calculate_surface_area.setOnClickListener(this)
        btn_calculate_circumference.setOnClickListener(this)
        btn_calculate_volume.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val length = edt_length.text.toString().trim()
        val width = edt_width.text.toString().trim()
        val height = edt_height.text.toString().trim()

        when {
            length.isEmpty() -> edt_length.error = "Field ini tidak boleh kosong"
            width.isEmpty() -> edt_width.error = "Field ini tidak boleh kosong"
            height.isEmpty() -> edt_height.error = "Field ini tidak boleh kosong"
            else -> {
                val w = width.toDouble()
                val l = length.toDouble()
                val h = height.toDouble()

                when (v.id) {
                    R.id.btn_save -> {
                        mainViewModel.save(l, w, h)
                        visible()
                    }
                    R.id.btn_calculate_volume -> {
                        tv_result.text = mainViewModel.volume().toString()
                        gone()
                    }
                    R.id.btn_calculate_surface_area -> {
                        tv_result.text = mainViewModel.surfaceArea().toString()
                        gone()
                    }
                    R.id.btn_calculate_circumference -> {
                        tv_result.text = mainViewModel.circumference().toString()
                        gone()
                    }
                }
            }
        }
    }

    private fun visible() {
        btn_calculate_volume.visibility = View.VISIBLE
        btn_calculate_circumference.visibility = View.VISIBLE
        btn_calculate_surface_area.visibility = View.VISIBLE
        btn_save.visibility = View.GONE
    }

    private fun gone() {
        btn_calculate_volume.visibility = View.GONE
        btn_calculate_circumference.visibility = View.GONE
        btn_calculate_surface_area.visibility = View.GONE
        btn_save.visibility = View.VISIBLE
    }
}