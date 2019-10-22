package com.guet.flexbox.build

import android.graphics.Color
import android.graphics.drawable.GradientDrawable

object Func {
    @JvmName("check")
    @JvmStatic
    fun check(o: Any?): Boolean {
        return when (o) {
            is String -> o.isNotEmpty()
            is Collection<*> -> !o.isEmpty()
            is Number -> o.toInt() != 0
            else -> o != null
        }
    }

    @JvmName("gradient")
    @JvmStatic
    fun gradient(orientation: GradientDrawable.Orientation, vararg colors: String): GradientDrawable {
        return GradientDrawable(orientation, colors.map {
            Color.parseColor(it)
        }.toIntArray())
    }
}
