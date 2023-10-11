package com.franciscogaleno.despensaandgo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.despensaandgo.R
import com.franciscogaleno.despensaandgo.entity.Product

class ProductListAdapter(
    context: Context,
    resource: Int,
    products: List<Product>
) : ArrayAdapter<Product>(context, resource, products) {

    override fun getView(
        position: Int,
        convertView: View?,
        parent: ViewGroup) : View {

        val inflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)
            as LayoutInflater
        val listItemView =
            convertView ?: inflater.inflate(R.layout.item_product, null)

        val product = getItem(position)

        // Bind product to textviews
        val nameTextView = listItemView.findViewById<TextView>(R.id.productName)
        val priceTextView = listItemView.findViewById<TextView>(R.id.priceNumber)
        val shopTextView = listItemView.findViewById<TextView>(R.id.shopName)

        // Set the patient data in the TextViews
        nameTextView.text = product?.name
        priceTextView.text = product?.price.toString()
        shopTextView.text = product?.shop

        return listItemView
    }
}