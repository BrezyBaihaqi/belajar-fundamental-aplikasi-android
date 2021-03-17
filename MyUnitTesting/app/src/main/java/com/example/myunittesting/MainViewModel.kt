package com.example.myunittesting

class MainViewModel(private val cuboidModel: CuboidModel) {
    fun circumference(): Double = cuboidModel.getCircumference()

    fun surfaceArea(): Double = cuboidModel.getSurfaceArea()

    fun volume(): Double = cuboidModel.getVolume()

    fun save(l: Double, w: Double, h: Double) {
        cuboidModel.save(l, w, h)
    }
}