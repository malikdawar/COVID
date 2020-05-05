package com.malik.covid.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.malik.covid.R
import com.malik.covid.extensions.getColorCompat
import com.malik.covid.models.MainMenuItem

class MainMenuAdapter(
    private val menuLIst: List<MainMenuItem>,
    private val menuItemClickListener: MenuItemClickListener
) : RecyclerView.Adapter<MainMenuAdapter.MyViewHolder>() {

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var menuItemCard = view.findViewById(R.id.menuItemCard) as CardView
        var menuImgView = view.findViewById(R.id.menuImgView) as ImageView
        var menuTvTitle = view.findViewById(R.id.menuTvTitle) as TextView
        var menuTvDescription = view.findViewById(R.id.menuTvDescription) as TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.main_menu_item, parent, false)

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val distItem = menuLIst[position]

        holder.menuImgView.setImageResource(distItem.icon)
        holder.menuTvTitle.text = distItem.title
        holder.menuTvDescription.text = distItem.description

        holder.menuItemCard.setOnClickListener {
            updateCardColorSchema(holder = holder)
            menuItemClickListener.itemClickListener(distItem)
        }
    }

    private fun updateCardColorSchema(holder: MyViewHolder) {
        holder.menuItemCard.apply {
            setCardBackgroundColor(context.getColorCompat(R.color.colorBlue))
        }
        holder.menuImgView.apply {
            setColorFilter(
                context.getColorCompat(R.color.blackLight),
                android.graphics.PorterDuff.Mode.SRC_IN
            )
        }
        holder.menuTvTitle.apply {
            setTextColor(context.getColorCompat(R.color.blackLight))
        }
        holder.menuTvDescription.apply {
            setTextColor(context.getColorCompat(R.color.blackLight))
        }
    }

    override fun getItemCount(): Int {
        return menuLIst.size
    }

    interface MenuItemClickListener {
        fun itemClickListener(mainMenuItem: MainMenuItem)
    }
}