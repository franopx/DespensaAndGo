package com.franciscogaleno.despensaandgo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.despensaandgo.R
import com.franciscogaleno.despensaandgo.entity.Shop

class AddShopActivity : AppCompatActivity() {

    lateinit var shopName: EditText
    lateinit var openHour: EditText
    lateinit var openMinutes: EditText
    lateinit var closeHour: EditText
    lateinit var closeMinutes: EditText
    lateinit var location: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_shop)

        shopName = findViewById(R.id.shopNameEditText)
        openHour = findViewById(R.id.openHourEditText)
        openMinutes = findViewById(R.id.openMinutesEditText)
        closeHour = findViewById(R.id.closeHourEditText)
        closeMinutes = findViewById(R.id.closeMinutesEditText)
        location = findViewById(R.id.shopLocationEditText)

        val cancelButton: Button = findViewById(R.id.cancelShopButton)
        val okButton: Button = findViewById(R.id.okShopButton)

        cancelButton.setOnClickListener {
            finish()
        }

        okButton.setOnClickListener {
            val newShop: Shop = Shop(
                shopName.text.toString(),
                Integer.parseInt(openHour.text.toString()),
                Integer.parseInt(openMinutes.text.toString()),
                Integer.parseInt(closeHour.text.toString()),
                Integer.parseInt(closeMinutes.text.toString()),
                location.text.toString()
            )

            val addShopIntent = Intent()
            addShopIntent.putExtra("newShop", newShop)
            setResult(2, addShopIntent)
            finish()
        }
    }
}