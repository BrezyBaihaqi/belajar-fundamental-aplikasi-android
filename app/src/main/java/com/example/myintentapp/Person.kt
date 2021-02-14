package com.example.myintentapp

import android.os.Parcel
import android.os.Parcelable

data class Person (
    // data class Person (kelas Java POJO) dibuat sebelum membuat obyek parcelable
    // 4 parameter di data class Person
    val name: String?,
    val age: Int?,
    val email: String?,
    val city: String?
) : Parcelable// Parcelable berfungsi mengirimkan data yg lebih kompleks seperti obyek dan array
{
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeValue(age)
        parcel.writeString(email)
        parcel.writeString(city)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Person> {
        override fun createFromParcel(parcel: Parcel): Person {
            return Person(parcel)
        }

        override fun newArray(size: Int): Array<Person?> {
            return arrayOfNulls(size)
        }
    }
}