package com.example.myunittesting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.myunittesting.databinding.ActivityMainBinding

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
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel = MainViewModel(CuboidModel())

        binding.edtWidth
        binding.edtLength
        binding.edtHeight
        binding.tvResult
        binding.btnCalculateVolume.setOnClickListener(this)

        binding.btnCalculateSurfaceArea.setOnClickListener(this)

        binding.btnCalculateCircumference.setOnClickListener(this)

        binding.btnSave.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val width = binding.edtWidth.text.toString().trim()
        val length = binding.edtLength.text.toString().trim()
        val height = binding.edtHeight.text.toString().trim()

        when {
            width.isEmpty() -> binding.edtWidth.error = "Field ini tidak boleh kosong"
            length.isEmpty() -> binding.edtLength.error = "Field ini tidak boleh kosong"
            height.isEmpty() -> binding.edtHeight.error = "Field ini tidak boleh kosong"
            else -> {
                val w = width.toDouble()
                val l = length.toDouble()
                val h = height.toDouble()

                when {
                    v.id == R.id.btn_save -> {
                        mainViewModel.save(l, w, h)
                        visible()
                    }
                    v.id == R.id.btn_calculate_volume -> {
                        binding.tvResult.text = mainViewModel.getVolume().toString()
                        gone()
                    }
                    v.id == R.id.btn_calculate_surface_area -> {
                        binding.tvResult.text = mainViewModel.getSurfaceArea().toString()
                        gone()
                    }
                    v.id == R.id.btn_calculate_circumference -> {
                        binding.tvResult.text = mainViewModel.getCircumference().toString()
                        gone()
                    }
                }
            }
        }
    }

    private fun gone() {
        binding.btnCalculateVolume.visibility = View.VISIBLE
        binding.btnCalculateSurfaceArea.visibility = View.VISIBLE
        binding.btnCalculateCircumference.visibility = View.VISIBLE
        binding.btnSave.visibility = View.GONE
    }

    private fun visible() {
        binding.btnCalculateVolume.visibility = View.VISIBLE
        binding.btnCalculateSurfaceArea.visibility = View.VISIBLE
        binding.btnCalculateCircumference.visibility = View.VISIBLE
        binding.btnSave.visibility = View.GONE
    }
}