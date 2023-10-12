package com.franciscogaleno.despensaandgo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.despensaandgo.R
import com.franciscogaleno.despensaandgo.adapter.ProductListAdapter
import com.franciscogaleno.despensaandgo.entity.DefaultValues
import com.franciscogaleno.despensaandgo.entity.Product


class ProductToInventoryActivity : AppCompatActivity() {

    private lateinit var listViewProducts: ListView
    private var listOption: Boolean = true
    private lateinit var products: MutableList<Product>
    private lateinit var adapterItems: ProductListAdapter
    private lateinit var adapter : ArrayAdapter<Product>

    lateinit var product: Product
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_to_inventory)

        listViewProducts = findViewById<ListView>(R.id.productToInventoryList)
        products = DefaultValues().getProducts()
        adapter = ArrayAdapter<Product>(this, android.R.layout.simple_list_item_1, products)
        listViewProducts.adapter = adapter
        adapterItems = ProductListAdapter(this, R.layout.item_product, products)
        listViewProducts.adapter = adapterItems

        Log.d("CREATION", "created activity")

        listViewProducts.setOnItemClickListener { _, _, position, _ ->
            Log.d("CREATION", "wha...")
            val selectedProduct = products[position]
            listOption = !listOption
            val addProductIntent = Intent()
            addProductIntent.putExtra("addedProduct", selectedProduct)
            setResult(2, addProductIntent)
            finish()
        }
    }

}