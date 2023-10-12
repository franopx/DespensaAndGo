package com.franciscogaleno.despensaandgo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import com.example.despensaandgo.R
import com.franciscogaleno.despensaandgo.adapter.ProductListAdapter
import com.franciscogaleno.despensaandgo.entity.DefaultValues
import com.franciscogaleno.despensaandgo.entity.Product

class ProductListActivity : AppCompatActivity() {
    private lateinit var listViewProducts: ListView
    private lateinit var products: MutableList<Product>
    private lateinit var adapterItems: ProductListAdapter
    private lateinit var adapter : ArrayAdapter<Product>

    lateinit var product: Product
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)

        listViewProducts = findViewById<ListView>(R.id.productList)
        products = DefaultValues().getProducts()
        adapter = ArrayAdapter<Product>(this, android.R.layout.simple_list_item_1, products)
        listViewProducts.adapter = adapter
        adapterItems = ProductListAdapter(this, R.layout.item_product, products)
        listViewProducts.adapter = adapterItems


        val addButton = findViewById<Button>(R.id.addProductToListButton)
        addButton.setOnClickListener {
            val intent = Intent(this, AddProductActivity::class.java)
            startActivityForResult(intent, 1)

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == 2 && requestCode == 1) {
            var addingProduct = data?.getParcelableExtra<Product>("newProduct") as Product
            addingProduct.count = 1
            products.add(addingProduct)
            adapterItems.notifyDataSetChanged()
        }
    }

}