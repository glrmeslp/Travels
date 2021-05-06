package br.com.github.glrmeslp.travels.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import br.com.github.glrmeslp.travels.R
import br.com.github.glrmeslp.travels.model.Package
import br.com.github.glrmeslp.travels.ui.activity.PackageListActivity.Companion.keyPackage
import br.com.github.glrmeslp.travels.util.CoinUtil

class PaymentActivity : AppCompatActivity() {

    private val tittleAppBar: String = "Payment"
    private lateinit var textViewPrice: TextView
    private lateinit var checkOut: Button
    private lateinit var packageTravel: Package

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)
        title = tittleAppBar
        textViewPrice = findViewById(R.id.tv_price_payment_activity)
        checkOut = findViewById(R.id.bt_check_out_payment_activity)
    }

    override fun onResume() {
        super.onResume()
        setPrice()
        configureClickCheckOutButton()
    }

    private fun setPrice() {
        packageTravel= intent.extras!!.getParcelable(keyPackage)!!
        textViewPrice.text = CoinUtil().currencyFormatBrazil(packageTravel.price)
    }

    private fun configureClickCheckOutButton(){
        checkOut.setOnClickListener {
            startActivity(Intent(this,PurchaseSummaryActivity::class.java).putExtra(keyPackage,packageTravel))
        }
    }
}