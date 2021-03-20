package com.xantrikoding.githubapp.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Coder(
    var name: String,
    var userName: String,
    var description: String,
    var photo: String
) : Parcelable
