package br.com.github.glrmeslp.travels.model

import android.os.Parcel
import android.os.Parcelable
import java.math.BigDecimal

class Package(
    val local: String,
    val image: String,
    val days: Int,
    val price: BigDecimal
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readInt(),
        BigDecimal(parcel.readString().toString())
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(local)
        parcel.writeString(image)
        parcel.writeInt(days)
        parcel.writeString(price.toString())
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<Package> {
        override fun createFromParcel(parcel: Parcel): Package {
            return Package(parcel)
        }

        override fun newArray(size: Int): Array<Package?> {
            return arrayOfNulls(size)
        }
    }

}