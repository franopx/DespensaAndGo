package com.franciscogaleno.despensaandgo

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.despensaandgo.R
import com.franciscogaleno.despensaandgo.entity.DefaultValues
import com.franciscogaleno.despensaandgo.entity.Product


class AddProductActivity : AppCompatActivity() {

    lateinit var productName: EditText
    lateinit var price: EditText
    lateinit var shop: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_product)

        productName = findViewById(R.id.productNameEditText)
        price = findViewById(R.id.productPriceEditText)
        shop = findViewById(R.id.chooseShopButton)

        val cancelButton: Button = findViewById(R.id.cancelProductButton)
        val okButton: Button = findViewById(R.id.okProductButton)

        cancelButton.setOnClickListener {
            finish()
        }

        shop.setOnClickListener {
            var shops = DefaultValues().getShops()
            var shopOptions = arrayOfNulls<String>(shops.size)

            for (i in 0..<shops.size) {
                shopOptions[i] = shops[i].name as String
            }

            val builder: AlertDialog.Builder = androidx.appcompat.app.AlertDialog.Builder(this)
            builder.setTitle("Selecciona una tienda")
            builder.setItems(shopOptions, DialogInterface.OnClickListener { dialog, which ->
                shop.setText(shopOptions[which])
            })
            builder.show()
        }

        okButton.setOnClickListener {
            val newProduct: Product = Product(
                productName.text.toString(),
                "",
                Integer.parseInt(price.text.toString()),
                shop.text.toString(),
                1
            )

            val addProductIntent = Intent()
            addProductIntent.putExtra("newProduct", newProduct)
            setResult(2, addProductIntent)
            finish()
        }
    }
}