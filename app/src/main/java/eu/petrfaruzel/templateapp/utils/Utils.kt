package eu.petrfaruzel.templateapp.utils

import android.content.Context
import android.media.MediaPlayer
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentActivity
import com.squareup.moshi.Moshi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

val asyncIO = CoroutineScope(Dispatchers.IO)
val asyncMain = CoroutineScope(Dispatchers.Main)

class Utils{

    companion object{
        fun generateStringId(STRING_LENGTH: Int = 10) : String{
            val charPool : List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9')
            val randomString = (1..STRING_LENGTH)
                .map { kotlin.random.Random.nextInt(0, charPool.size) }
                .map(charPool::get)
                .joinToString("");

            return randomString
        }

        fun playSound(context: Context, raw: Int){
            val sound = MediaPlayer.create(context, raw)
            sound.setVolume(1f, 1f)
            sound.start()
            sound.setOnCompletionListener { sound.release() }
        }
    }
}

fun showDialog(activity: FragmentActivity, dialog: DialogFragment){
    if(!dialog.isVisible) dialog.show(activity.supportFragmentManager, "")
}

fun toast(context : Context, message : String){
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}

inline fun <reified T>fromJson(jsonString: String) : T? {
    val jsonAdapter = Moshi.Builder().build().adapter(T::class.java)
    return jsonAdapter.fromJson(jsonString)
}

inline fun <reified T> toJson(dataObject: T) : String {
    val jsonAdapter = Moshi.Builder().build().adapter(T::class.java)
    return jsonAdapter.toJson(dataObject)
}
