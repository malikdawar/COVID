package com.onlive.covid.models.response

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.malik.covid.models.BaseResponse

/**
 * Created by George Thomas on 12/06/20
 */
class GroupDetailsResponse() : BaseResponse() ,Parcelable {

    @SerializedName("predicate")
    private val predicate: PredicateModel? = null
    @SerializedName("plugins")
    private val plugins: Array<String>? = null
    @SerializedName("name")
    val name: String? = null
    @SerializedName("description")
    private val description: String? = null
    @SerializedName("id")
    private val id: String? = null
    @SerializedName("version")
    private val version: String? = null

    constructor(parcel: Parcel) : this() {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<GroupDetailsResponse> {
        override fun createFromParcel(parcel: Parcel): GroupDetailsResponse {
            return GroupDetailsResponse(parcel)
        }

        override fun newArray(size: Int): Array<GroupDetailsResponse?> {
            return arrayOfNulls(size)
        }
    }
}