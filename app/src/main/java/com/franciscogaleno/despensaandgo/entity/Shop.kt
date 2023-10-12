package com.franciscogaleno.despensaandgo.entity


import android.os.Parcel
import android.os.Parcelable


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

    companion object CREATOR : Parcelable.Creator<Shop> {
        override fun createFromParcel(parcel: Parcel): Shop {
            return Shop(parcel)
        }

        override fun newArray(size: Int): Array<Shop?> {
            return arrayOfNulls(size)
        }
    }
}
