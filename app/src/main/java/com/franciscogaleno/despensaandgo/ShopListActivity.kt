package com.franciscogaleno.despensaandgo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.despensaandgo.R
import com.franciscogaleno.despensaandgo.adapter.ProductListAdapter
import com.franciscogaleno.despensaandgo.adapter.ShopListAdapter
import com.franciscogaleno.despensaandgo.entity.Shop

class ShopListActivity : AppCompatActivity() {
    private lateinit var listViewProducts: ListView
    private var listOption: Boolean = true
    private var detailOption: Boolean = false
    private lateinit var shops: MutableList<Shop>
    private lateinit var adapterItems: ShopListAdapter
    private lateinit var adapter : ArrayAdapter<Shop>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop_list)

        listViewProducts = findViewById<ListView>(R.id.shopList)

        shops = mutableListOf(
            Shop(
                "Unimarc Centro",
                9, 0,
                21, 30,
                "1 Sur 1531"
            ),
            Shop(
                "Cugat",
                9, 30,
                21, 45,
                "Av. Lircay 2455"
            )
        )

        adapter = ArrayAdapter<Shop>(this, android.R.layout.simple_list_item_1, shops)

        listViewProducts.adapter = adapter

        adapterItems = ShopListAdapter(this, R.layout.item_shop, shops)
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
