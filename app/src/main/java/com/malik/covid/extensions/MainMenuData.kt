package com.malik.covid.extensions

import android.content.Context
import com.malik.covid.R
import com.malik.covid.models.MainMenuItem
import java.util.ArrayList

/**
 * An Extension Method that will be responsible to populate main screen items
 * @return List<MainMenuItem>.
 * @author Dawar Malik.
 */
fun Context.getPopulatedList(): List<MainMenuItem>? {
    val itemList: MutableList<MainMenuItem> = ArrayList()
    itemList.add(
        MainMenuItem(
            R.drawable.ic_info,
            getString(R.string.covid),
            getString(R.string.moreInfo)
        )
    )
    itemList.add(
        MainMenuItem(
            R.drawable.ic_map_pin,
            getString(R.string.heatmap),
            getString(R.string.people_gathering)
        )
    )
    itemList.add(
        MainMenuItem(
            R.drawable.ic_youtube,
            getString(R.string.play_data),
            getString(R.string.play_about)
        )
    )

    return itemList
}
