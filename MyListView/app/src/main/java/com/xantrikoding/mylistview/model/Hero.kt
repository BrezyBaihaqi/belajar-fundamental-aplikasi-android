package com.xantrikoding.mylistview.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Hero (
    var photo: Int,
    var name: String,
    var description: String
) : Parcelable