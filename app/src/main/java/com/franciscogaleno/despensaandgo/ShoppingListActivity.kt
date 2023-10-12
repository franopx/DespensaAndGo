package com.franciscogaleno.despensaandgo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import com.example.despensaandgo.R
import com.franciscogaleno.despensaandgo.adapter.ProductToInventoryListAdapter
import com.franciscogaleno.despensaandgo.entity.Product

class ShoppingListActivity : AppCompatActivity() {

    private lateinit var listViewProducts: ListView
    private var listOption: Boolean = true
    private var detailOption: Boolean = true
    private lateinit var products: MutableList<Product>
    private lateinit var adapterItems: ProductToInventoryListAdapter
    private lateinit var adapter : ArrayAdapter<Product>

    lateinit var totalPrice: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_list)

        totalPrice = findViewById(R.id.totalPriceText)
        listViewProducts = findViewById<ListView>(R.id.shoppingList)
        products = mutableListOf<Product>()
        adapter = ArrayAdapter<Product>(this, android.R.layout.simple_list_item_1, products)
        listViewProducts.adapter = adapter
        adapterItems = ProductToInventoryListAdapter(this, R.layout.item_product_to_inventory, products)
        listViewProducts.adapter = adapterItems

        val addButton = findViewById<Button>(R.id.addProductToShoppingListButton)
        addButton.setOnClickListener {
            val intent = Intent(this, ProductToInventoryActivity::class.java)
            startActivityForResult(intent, 1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == 2 && requestCode == 1) {
            val addingProduct = data?.getParcelableExtra<Product>("addedProduct") as Product

            var productFound = false
            for(product in products)
            {
                if(product.name == addingProduct.name)
                {
                    product.count += 1
                    productFound = true
                    break
                }
            }
            if(!productFound) products.add(addingProduct)
            updateTotalPrice(products)
            adapterItems.notifyDataSetChanged()
        }
    }

    fun updateTotalPrice(products: List<Product>)
    {
        var value : Int = 0
        for(product in products)
        {
            value += product.price * product.count
        }

        totalPrice.setText(value.toString())
    }
}