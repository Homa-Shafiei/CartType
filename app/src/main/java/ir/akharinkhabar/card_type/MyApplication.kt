package ir.akharinkhabar.card_type

import android.annotation.SuppressLint
import android.app.Application
import com.orhanobut.hawk.Hawk

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
        Hawk.init(this).build()
    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var instance: MyApplication
    }

}