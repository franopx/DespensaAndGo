package com.franciscogaleno.despensaandgo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.despensaandgo.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    public fun onShoppingListButtonClick(view: View?)
    {
        val intent = Intent(this, ShoppingListActivity::class.java)
        startActivity(intent)
    }
    public fun onProductButtonClick(view:View?)
    {
        val intent = Intent(this, ProductListActivity::class.java)
        startActivity(intent)
    }
    public fun onShopButtonClick(view: View?)
    {
        val intent = Intent(this, ShopListActivity::class.java)
        startActivity(intent)
    }
    public fun onInventoryButtonClick(view: View?)
    {
        val intent = Intent(this, InventoryActivity::class.java)
        startActivity(intent)
    }
}