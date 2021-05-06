package br.com.github.glrmeslp.travels.util

import android.content.Context
import android.content.res.Resources

class ResourceUtil {
    private val drawable = "drawable"

    fun drawable(drawableTextName: String, res: Resources, context: Context): Int =
        res.getIdentifier(drawableTextName, drawable, context.packageName)

}