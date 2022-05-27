package ir.akharinkhabar.card_type

import android.annotation.SuppressLint
import android.app.Application

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var instance: MyApplication
    }

}