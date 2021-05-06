package br.com.github.glrmeslp.travels.util

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class DateUtil {

    var formatUSDate: DateFormat = SimpleDateFormat("MM/dd", Locale("en", "USA"))

    private fun formatDate(date: Date): String {
        return formatUSDate.format(date.time).toString()
    }

    /**
     * @param n the days to add.
     * @return a string "MM/dd - MM/dd of YYYY".
     */
    fun dayRangeFromTheCurrentDay(n: Int): String {
        val currentDay = Calendar.getInstance()
        val dayAfter = Calendar.getInstance()
        dayAfter.add(Calendar.DATE, n)
        return "${formatDate(currentDay.time)} - ${formatDate(dayAfter.time)} of ${dayAfter.get(
            Calendar.YEAR
        )}"
    }

}