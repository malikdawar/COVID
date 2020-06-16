package com.onlive.covid.models.response

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

/**
 * Created by George Thomas on 12/06/20
 */
class GeographyDataModel():Parcelable {
    @SerializedName("altitude")
    private val altitude: String? = null

    @SerializedName("latitude")
    private val latitude: String? = null

    @SerializedName("accuracy")
    private val accuracy: String? = null

    @SerializedName("longitude")
    private val longitude: String? = null

    constructor(parcel: Parcel) : this() {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<GeographyDataModel> {
        override fun createFromParcel(parcel: Parcel): GeographyDataModel {
            return GeographyDataModel(parcel)
        }

        override fun newArray(size: Int): Array<GeographyDataModel?> {
            return arrayOfNulls(size)
        }
    }
}