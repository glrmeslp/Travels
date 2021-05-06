package br.com.github.glrmeslp.travels.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import br.com.github.glrmeslp.travels.R
import br.com.github.glrmeslp.travels.model.Package
import br.com.github.glrmeslp.travels.ui.activity.PackageListActivity.Companion.keyPackage
import br.com.github.glrmeslp.travels.util.CoinUtil
import br.com.github.glrmeslp.travels.util.DateUtil
import br.com.github.glrmeslp.travels.util.DaysUtil
import br.com.github.glrmeslp.travels.util.ResourceUtil
import java.util.*

class PackageSummaryActivity : AppCompatActivity() {

    private lateinit var local: TextView
    private lateinit var image: ImageView
    private lateinit var days: TextView
    private lateinit var date: TextView
    private lateinit var price: TextView
    private lateinit var makePayment: Button
    private lateinit var packageTravel: Package
    private val tittleAppBar = "Package Summary"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_package_summary)
        title = tittleAppBar
        initializationComponentsView()
    }

    override fun onResume() {
        super.onResume()
        setValuesComponentsView()
        configureBottomMakePayment()
    }

    private fun setValuesComponentsView() {
        packageTravel = intent.extras!!.getParcelable(keyPackage)!!
        image.setImageResource(
            ResourceUtil().drawable(
                packageTravel.image,
                image.resources,
                image.context
            )
        )
        local.text = packageTravel.local
        days.text = DaysUtil().formatDays(packageTravel.days)
        date.text = DateUtil().dayRangeFromTheCurrentDay(packageTravel.days)
        price.text = CoinUtil().currencyFormatBrazil(packageTravel.price)
    }

    private fun initializationComponentsView() {
        image = findViewById(R.id.iv_package_summary_activity)
        local = findViewById(R.id.tv_local_package_summary_activity)
        days = findViewById(R.id.tv_days_package_summary_activity)
        date = findViewById(R.id.tv_date_package_summary_activity)
        price = findViewById(R.id.tv_price_package_summary_activity)
        makePayment = findViewById(R.id.bt_make_payment_package_summary_activity)
    }

    private fun configureBottomMakePayment(){
        makePayment.setOnClickListener {
            startActivity(Intent(this,PaymentActivity::class.java).putExtra(keyPackage,packageTravel))
        }
    }

}