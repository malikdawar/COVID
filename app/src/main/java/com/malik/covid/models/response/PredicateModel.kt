package com.onlive.covid.models.response

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

/**
 * Created by George Thomas on 12/06/20
 */
class PredicateModel():Parcelable {
    @SerializedName("geographyDatas")
    private val geographyDatas: Array<GeographyDataModel>? = null

    @SerializedName("type")
    private val type: String? = null

    constructor(parcel: Parcel) : this() {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PredicateModel> {
        override fun createFromParcel(parcel: Parcel): PredicateModel {
            return PredicateModel(parcel)
        }

        override fun newArray(size: Int): Array<PredicateModel?> {
            return arrayOfNulls(size)
        }
    }
}