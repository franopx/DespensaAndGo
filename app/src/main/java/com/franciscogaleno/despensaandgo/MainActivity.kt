package com.franciscogaleno.despensaandgo

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.example.despensaandgo.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    public fun onAboutButtonClick(view: View?)
    {
        val builder: AlertDialog.Builder = androidx.appcompat.app.AlertDialog.Builder(this)
        builder.setTitle(getString(R.string.about))
        builder.setMessage(getString(R.string.developer))
        builder.show()
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