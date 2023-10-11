package com.franciscogaleno.despensaandgo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.despensaandgo.R
import com.franciscogaleno.despensaandgo.adapter.ProductAdapter
import com.franciscogaleno.despensaandgo.entity.Product

class InventoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inventory)

        val productRecycler = findViewById<RecyclerView>(R.id.inventoryRecycler)
        productRecycler.adapter = ProductAdapter(
            listOf(
                Product(
                    "Caja de 12 huevos",
                    "Es un huevo",
                    "Coliumo",
                    5000,
                    "Comestible",
                    "Unimarc",
                    1
                )
            )
        )
    }
}