package eu.petrfaruzel.templateapp.utils

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.util.TypedValue
import android.widget.ImageView
import androidx.annotation.AttrRes
import androidx.annotation.ColorInt


@ColorInt
fun Context.getColorFromAttr(
    @AttrRes attrColor: Int,
    typedValue: TypedValue = TypedValue(),
    resolveRefs: Boolean = true
): Int {
    theme.resolveAttribute(attrColor, typedValue, resolveRefs)
    return typedValue.data
}

fun Int.toHexString(): String {
    return java.lang.String.format("#%06X", 0xFFFFFF and this)
}

fun ImageView.setTint(colorHex : String?){
    if(colorHex != null) setTint(Color.parseColor(colorHex))
}

fun ImageView.setTint(@ColorInt color : Int){
    imageTintList = ColorStateList.valueOf(color)
}

private fun isColorDark(color: Int): Boolean {
    val darkness =
        1 - (0.299 * Color.red(color) + 0.587 * Color.green(color) + 0.114 * Color.blue(color)) / 255
    return darkness > 0.5
}