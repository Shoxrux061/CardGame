package uz.isystem.testgame.presentation.result_screen

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.isystem.testgame.R
import uz.isystem.testgame.databinding.ScreenResultBinding
import uz.isystem.testgame.presentation.base.BaseFragment

class ResultScreen : BaseFragment(R.layout.screen_result) {
    private val binding by viewBinding(ScreenResultBinding::bind)
    private val args: ResultScreenArgs by navArgs()
    override fun onCreate(view: View, savedInstanceState: Bundle?) {
        loadData()
        setClicks()
    }

    private fun loadData() {
        val minutes = args.time / 60
        val remainingSeconds = args.time % 60
        val format = String.format("%02d:%02d", minutes, remainingSeconds)
        binding.time.text = format
        binding.coins.text = args.coin.toString()
    }

    private fun setClicks() {
        binding.homeBtn.setOnClickListener {
            findNavController().navigate(ResultScreenDirections.actionResultScreenToMenuScreen())
        }
        binding.replayBtn.setOnClickListener {
            findNavController().navigate(ResultScreenDirections.actionResultScreenToGameScreen())
        }
    }
}