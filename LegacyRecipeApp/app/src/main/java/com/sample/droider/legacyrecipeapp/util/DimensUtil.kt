package com.sample.droider.legacyrecipeapp.util

import android.content.Context
import android.util.DisplayMetrics

/**
 * 参考:
 * https://dogwood008.github.io/kotlin-web-site-ja/docs/reference/object-declarations.html
 */
object DimensUtil {

    fun dpToPx(dp: Int, context: Context): Int {
        val displayMetrics = context.resources.displayMetrics
        return Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT))
    }

    fun pxToDp(px: Int, context: Context): Int {
        val displayMetrics = context.resources.displayMetrics
        return Math.round(px / (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT))
    }
}
