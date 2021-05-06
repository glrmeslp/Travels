package br.com.github.glrmeslp.travels.ui.activity

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import br.com.github.glrmeslp.travels.R
import br.com.github.glrmeslp.travels.model.Package
import br.com.github.glrmeslp.travels.ui.activity.PackageListActivity.Companion.keyPackage
import br.com.github.glrmeslp.travels.util.CoinUtil
import br.com.github.glrmeslp.travels.util.DateUtil
import br.com.github.glrmeslp.travels.util.ResourceUtil

class PurchaseSummaryActivity : AppCompatActivity() {

    private lateinit var local: TextView
    private lateinit var image: ImageView
    private lateinit var date: TextView
    private lateinit var price: TextView
    private val tittleAppBar = "Purchase Summary"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_purchase_summary)
        title = tittleAppBar
        initializationComponentsView()
    }

    override fun onResume() {
        super.onResume()
        setValuesComponentsView()
    }

    private fun setValuesComponentsView() {
        val packageTravel: Package = intent.extras!!.getParcelable(keyPackage)!!
        local.text = packageTravel.local
        image.setImageResource(ResourceUtil().drawable(packageTravel.image,image.resources,image.context))
        date.text = DateUtil().dayRangeFromTheCurrentDay(packageTravel.days)
        price.text = CoinUtil().currencyFormatBrazil(packageTravel.price)
    }

    private fun initializationComponentsView(){
        local = findViewById(R.id.tv_local_package_purchase_summary_activity)
        image = findViewById(R.id.iv_package_purchase_summary_activity)
        date = findViewById(R.id.tv_date_package_purchase_summary_activity)
        price = findViewById(R.id.tv_price_package_purchase_summary_activity)
    }
}