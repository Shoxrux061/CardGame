package uz.isystem.testgame.presentation.menu_screen

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.isystem.testgame.R
import uz.isystem.testgame.data.cache.AppCache
import uz.isystem.testgame.databinding.ScreenMenuBinding
import uz.isystem.testgame.presentation.base.BaseFragment

class MenuScreen : BaseFragment(R.layout.screen_menu){
    private val binding by viewBinding(ScreenMenuBinding::bind)
    override fun onCreate(view: View, savedInstanceState: Bundle?) {
        binding.coinCount.text = AppCache.getObject().getCoins().toString()
        setActions()
    }

    private fun setActions() {
        binding.playBtn.setOnClickListener {
            findNavController().navigate(MenuScreenDirections.actionMenuScreenToGameScreen())
        }
    }
}
