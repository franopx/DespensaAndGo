package com.franciscogaleno.despensaandgo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.despensaandgo.R
import com.franciscogaleno.despensaandgo.entity.Shop

class ShopListAdapter(
    context: Context,
    resource: Int,
    shops: List<Shop>
) : ArrayAdapter<Shop>(context, resource, shops) {

    override fun getView(
        position: Int,
        convertView: View?,
        parent: ViewGroup
    ) : View {

        val inflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)
                    as LayoutInflater
        val listItemView =
            convertView ?: inflater.inflate(R.layout.item_shop, null)

        val shop = getItem(position)

        // Bind shop to textviews
        val nameTextView = listItemView.findViewById<TextView>(R.id.shopNameText)
        val openHourTextView = listItemView.findViewById<TextView>(R.id.shopOpenHourText)
        val closeHourTextView = listItemView.findViewById<TextView>(R.id.shopCloseHourText)
        val openMinutesTextView = listItemView.findViewById<TextView>(R.id.shopOpenMinutesText)
        val closeMinutesTextView = listItemView.findViewById<TextView>(R.id.shopCloseMinutesText)
        val streetTextView = listItemView.findViewById<TextView>(R.id.shopStreetText)

        // Set the patient data in the TextViews
        nameTextView.text = shop?.name
        openHourTextView.text = shop?.openHour.toString()
        openMinutesTextView.text = shop?.openMinutes.toString()
        closeHourTextView.text = shop?.closeHour.toString()
        closeMinutesTextView.text = shop?.closeMinutes.toString()
        streetTextView.text = shop?.street

        return listItemView
    }
}