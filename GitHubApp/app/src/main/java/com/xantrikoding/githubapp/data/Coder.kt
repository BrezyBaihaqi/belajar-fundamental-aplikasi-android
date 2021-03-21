package com.xantrikoding.githubapp.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Coder(
    var name: String,
    var userName: String,
    var description: String,
    var photo: String,
    var city: String,
    var location: String,
    var link: String,
    var follower: String,
    var following: String
) : Parcelable
