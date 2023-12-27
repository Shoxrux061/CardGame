package uz.isystem.testgame.data.cache

import android.content.Context
import android.content.SharedPreferences

class AppCache private constructor(context: Context) {

    private val coins = "Coins"

    init {
        sharedPreferences = context.getSharedPreferences("cache", Context.MODE_PRIVATE)
    }

    companion object {
        private var appCache: AppCache? = null
        private var sharedPreferences: SharedPreferences? = null

        fun init(context: Context) {
            if (appCache == null) {
                appCache = AppCache(context)
            }
        }
        fun getObject(): AppCache {
            return appCache!!
        }
    }


    fun setCoins(coinsCount: Int) {
        sharedPreferences!!.edit().putInt(coins, coinsCount).apply()
    }

    fun getCoins(): Int {
        return sharedPreferences!!.getInt(coins,0)
    }
}