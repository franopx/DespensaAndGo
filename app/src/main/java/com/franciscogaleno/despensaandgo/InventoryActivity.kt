package com.franciscogaleno.despensaandgo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.despensaandgo.R
import com.franciscogaleno.despensaandgo.adapter.ProductListAdapter
import com.franciscogaleno.despensaandgo.entity.Product

class InventoryActivity : AppCompatActivity() {

    private lateinit var listViewProducts: ListView
    private var listOption: Boolean = true
    private var detailOption: Boolean = false
    private lateinit var products: MutableList<Product>
    private lateinit var adapterItems: ProductListAdapter
    private lateinit var adapter : ArrayAdapter<Product>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inventory)

        listViewProducts = findViewById<ListView>(R.id.inventoryList)

        products = mutableListOf(
            Product(
                "Caja de 12 huevos",
                "Es un huevo",
                5000,
                "Unimarc",
                1
            ),
            Product(
                "Pan Brioche",
                "Rico pancito",
                1590,
                "Cugat",
                1
            )
        )

        adapter = ArrayAdapter<Product>(this, android.R.layout.simple_list_item_1, products)

        listViewProducts.adapter = adapter

        adapterItems = ProductListAdapter(this, R.layout.item_product, products)
        listViewProducts.adapter = adapterItems

        /*
        listViewProducts.setOnItemClickListener { _, _, position, _ ->
            val selectedPatient = products[position]
            listOption = !listOption
            if (detailOption) {
                showPatientDetailDialog(selectedPatient)
            }
            else {
                val intent = Intent(this, PatientDetailActivity::class.java)
                intent.putExtra("patient", selectedPatient)
                startActivity(intent)
            }
        }
         */
    }

}