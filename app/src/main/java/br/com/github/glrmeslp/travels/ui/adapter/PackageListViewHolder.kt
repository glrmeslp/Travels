package br.com.github.glrmeslp.travels.ui.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import br.com.github.glrmeslp.travels.R
import br.com.github.glrmeslp.travels.util.CoinUtil
import br.com.github.glrmeslp.travels.util.DaysUtil
import br.com.github.glrmeslp.travels.util.ResourceUtil
import java.math.BigDecimal

class PackageListViewHolder(private val view: View){

    private val local: TextView = view.findViewById(R.id.tv_city_name_package_list)
    private val image: ImageView = view.findViewById(R.id.iv_package_list)
    private val days: TextView = view.findViewById(R.id.tv_days_package_list)
    private val price: TextView = view.findViewById(R.id.tv_price_package_list)

    fun setImage(imageName: String) = image.setImageResource(
        ResourceUtil().drawable(imageName, image.resources, view.context))

    fun setLocal(localName: String) {
        local.text = localName
    }

    fun setDays(numberDays: Int) {
        days.text = DaysUtil().formatDays(numberDays)
    }

    fun setPrice(valuePrice: BigDecimal) {
        price.text = CoinUtil().currencyFormatBrazil(valuePrice)
    }

}