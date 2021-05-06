package br.com.github.glrmeslp.travels.util

class DaysUtil {

    private val singular = " day"
    private val plural = " days"

    fun formatDays(days: Int): String{
        return if (days == 1) {
            days.toString().plus(singular)
        } else {
            days.toString().plus(plural)
        }
    }
}