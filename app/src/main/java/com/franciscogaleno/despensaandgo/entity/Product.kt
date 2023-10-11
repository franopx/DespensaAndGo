package com.franciscogaleno.despensaandgo.entity

import android.os.Parcel
import android.os.Parcelable

data class Product(
    val name: String?,
    val description: String?,
    val brand: String?,
    val price: Int,
    val type: String?,
    val shop: String?, // For now
    val count: Int,
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(description)
        parcel.writeString(brand)
        parcel.writeInt(price)
        parcel.writeString(type)
        parcel.writeString(shop)
        parcel.writeInt(count)
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
