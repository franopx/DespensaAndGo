package com.franciscogaleno.despensaandgo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import com.example.despensaandgo.R
import com.franciscogaleno.despensaandgo.adapter.ShopListAdapter
import com.franciscogaleno.despensaandgo.entity.DefaultValues
import com.franciscogaleno.despensaandgo.entity.Shop

class ShopListActivity : AppCompatActivity() {
    private lateinit var listViewShops: ListView
    private lateinit var shops: MutableList<Shop>
    private lateinit var adapterItems: ShopListAdapter
    private lateinit var adapter : ArrayAdapter<Shop>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop_list)

        listViewShops = findViewById<ListView>(R.id.shopList)

        shops = DefaultValues().getShops()

        adapter = ArrayAdapter<Shop>(this, android.R.layout.simple_list_item_1, shops)

        listViewShops.adapter = adapter

        adapterItems = ShopListAdapter(this, R.layout.item_shop, shops)
        listViewShops.adapter = adapterItems

        val addShopButton: Button = findViewById(R.id.addShopButton)

        addShopButton.setOnClickListener {
            val intent = Intent(this, AddShopActivity::class.java)
            startActivityForResult(intent, 1)
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == 2 && requestCode == 1) {
            Log.d("CREATION", data?.getParcelableExtra<Shop>("newShop").toString())
            val newShop = data?.getParcelableExtra<Shop>("newShop") as Shop
            shops.add(newShop)
            adapterItems.notifyDataSetChanged()
        }
    }
}
