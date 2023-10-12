package com.franciscogaleno.despensaandgo.entity

import android.location.Location
import android.os.Parcel
import android.os.Parcelable
import java.util.Date

data class Shop(
    val name: String?,
    val openHour: Int,
    val openMinutes: Int,
    val closeHour: Int,
    val closeMinutes: Int,
    val street: String?,
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeInt(openHour)
        parcel.writeInt(openMinutes)
        parcel.writeInt(closeHour)
        parcel.writeInt(closeMinutes)
        parcel.writeString(street)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Product> {
        override fun createFromParcel(parcel: Parcel): Product {
            return Product(parcel)
        }

        override fun newArray(size: Int): Array<Product?> {
            return arrayOfNulls(size)
        }
    }
}
