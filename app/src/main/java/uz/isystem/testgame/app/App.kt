package uz.isystem.testgame.app

import android.app.Application
import uz.isystem.testgame.data.cache.AppCache

class App : Application() {
    companion object{
        lateinit var instance : Application
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        AppCache.init(this)
    }
}