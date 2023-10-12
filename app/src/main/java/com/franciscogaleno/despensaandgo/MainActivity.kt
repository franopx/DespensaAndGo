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

    public fun onInventoryButtonClick(view: View?)
    {
        val intent = Intent(this, InventoryActivity::class.java)
        startActivity(intent)
    }
}