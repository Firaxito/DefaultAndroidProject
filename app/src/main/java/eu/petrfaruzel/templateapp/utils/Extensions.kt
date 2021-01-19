package eu.petrfaruzel.templateapp.utils

import android.content.res.Resources
import android.widget.EditText
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText
import eu.petrfaruzel.templateapp.R

fun RecyclerView.setDivider(@DrawableRes drawableRes: Int = R.drawable.recycler_view_divider) {
    val divider = DividerItemDecoration(
        this.context,
        DividerItemDecoration.VERTICAL
    )
    val drawable = ContextCompat.getDrawable(
        this.context,
        drawableRes
    )
    drawable?.let {
        divider.setDrawable(it)
        addItemDecoration(divider)
    }
}

fun EditText.placeCursorToEnd() {
    this.setSelection(this.text.length)
}

fun TextInputEditText.placeCursorToEnd() {
    this.setSelection(this.text.toString().length)
}

val Int.dp: Int
    get() = (this / Resources.getSystem().displayMetrics.density).toInt()
val Int.px: Int
    get() = (this * Resources.getSystem().displayMetrics.density).toInt()