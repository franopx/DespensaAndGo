package com.franciscogaleno.despensaandgo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import com.example.despensaandgo.R
import com.franciscogaleno.despensaandgo.adapter.ProductToInventoryListAdapter
import com.franciscogaleno.despensaandgo.entity.DefaultValues
import com.franciscogaleno.despensaandgo.entity.Product

class InventoryActivity : AppCompatActivity() {

    private lateinit var listViewProducts: ListView
    private var listOption: Boolean = true
    private var detailOption: Boolean = true
    private lateinit var products: MutableList<Product>
    private lateinit var adapterItems: ProductToInventoryListAdapter
    private lateinit var adapter : ArrayAdapter<Product>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inventory)

        listViewProducts = findViewById<ListView>(R.id.inventoryList)

        products = mutableListOf<Product>()

        adapter = ArrayAdapter<Product>(this, android.R.layout.simple_list_item_1, products)
        listViewProducts.adapter = adapter
        adapterItems = ProductToInventoryListAdapter(this, R.layout.item_product_to_inventory, products)
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

        val addButton = findViewById<Button>(R.id.addProductButton)
        addButton.setOnClickListener {
            Log.d("CREATION", "Añadir")
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
            adapterItems.notifyDataSetChanged()
        }
    }
}