package br.com.github.glrmeslp.travels.util

import java.math.BigDecimal
import java.text.DecimalFormat
import java.util.*

class CoinUtil {

    fun currencyFormatBrazil(price: BigDecimal): String {
        DecimalFormat.getCurrencyInstance(Locale("pt","br")).run {
            return format(price).replace("R$","R$ ")
        }
    }
}