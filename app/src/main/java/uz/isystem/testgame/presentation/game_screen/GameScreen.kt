package uz.isystem.testgame.presentation.game_screen

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import uz.isystem.testgame.R
import uz.isystem.testgame.data.cache.AppCache
import uz.isystem.testgame.databinding.ScreenGameBinding
import uz.isystem.testgame.presentation.base.BaseFragment
import java.util.Timer
import java.util.TimerTask

class GameScreen : BaseFragment(R.layout.screen_game) {
    private val binding by viewBinding(ScreenGameBinding::bind)
    private var firstSelect = 0
    private var firstSelectItem: View? = null
    private var firstSelectItemCurtain: View? = null
    private var secondSelectItem: View? = null
    private var secondSelectItemCurtain: View? = null
    private var secondSelect = 0
    private var findedCards = 0
    private var isLoading = false
    private var stepCount = 0
    private var coins = 100
    private var timer : Timer? = null
    private var task : TimerTask? = null
    override fun onCreate(view: View, savedInstanceState: Bundle?) {
        setTimer()
        loadData()
        setClicks()
    }

    private fun setTimer() {
        timer = Timer()
        task = (object : TimerTask() {
            override fun run() {
                Handler(Looper.getMainLooper()).post {
                    countTime()
                }
            }
        })
        timer?.schedule(task,0 ,1000)
    }

    private fun countTime() {
        binding.timer.text = formatTime(stepCount)
        stepCount++
        if (stepCount > 20) {
            if(coins > 10) {
                coins -= 5
            }
        }
        binding.coins.text = coins.toString()
    }

    private fun formatTime(seconds: Int): String {
        val minutes = seconds / 60
        val remainingSeconds = seconds % 60
        return String.format("%02d:%02d", minutes, remainingSeconds)
    }

    private fun setClicks() {
        binding.item1.setOnClickListener {
            if (!isLoading) {
                binding.item1.alpha = 1f
                if (firstSelect == 0) {
                    firstSelect = binding.item1.tag.toString().toInt()
                    firstSelectItem = binding.item1
                    firstSelectItemCurtain = binding.curtain1
                    check()
                } else {
                    secondSelect = binding.item1.tag.toString().toInt()
                    secondSelectItem = binding.item1
                    secondSelectItemCurtain = binding.curtain1
                    check()
                }
            }
        }
        binding.item2.setOnClickListener {
            if (!isLoading) {
                binding.item2.alpha = 1f
                if (firstSelect == 0) {
                    firstSelect = binding.item2.tag.toString().toInt()
                    firstSelectItem = binding.item2
                    firstSelectItemCurtain = binding.curtain2
                    check()
                } else {
                    secondSelect = binding.item2.tag.toString().toInt()
                    secondSelectItem = binding.item2
                    secondSelectItemCurtain = binding.curtain2
                    check()
                }
            }
        }
        binding.item3.setOnClickListener {
            if (!isLoading) {
                binding.item3.alpha = 1f
                if (firstSelect == 0) {
                    firstSelect = binding.item3.tag.toString().toInt()
                    firstSelectItem = binding.item3
                    firstSelectItemCurtain = binding.curtain3
                    check()
                } else {
                    secondSelect = binding.item3.tag.toString().toInt()
                    secondSelectItem = binding.item3
                    secondSelectItemCurtain = binding.curtain3
                    check()
                }
            }
        }
        binding.item4.setOnClickListener {
            if (!isLoading) {
                binding.item4.alpha = 1f
                if (firstSelect == 0) {
                    firstSelect = binding.item4.tag.toString().toInt()
                    firstSelectItem = binding.item4
                    firstSelectItemCurtain = binding.curtain4
                    check()
                } else {
                    secondSelect = binding.item4.tag.toString().toInt()
                    secondSelectItem = binding.item4
                    secondSelectItemCurtain = binding.curtain4
                    check()
                }
            }
        }
        binding.item5.setOnClickListener {
            if (!isLoading) {

                binding.item5.alpha = 1f
                if (firstSelect == 0) {
                    firstSelect = binding.item5.tag.toString().toInt()
                    firstSelectItem = binding.item5
                    firstSelectItemCurtain = binding.curtain5
                    check()
                } else {
                    secondSelect = binding.item5.tag.toString().toInt()
                    secondSelectItem = binding.item5
                    secondSelectItemCurtain = binding.curtain5
                    check()
                }
            }
        }
        binding.item6.setOnClickListener {
            if (!isLoading) {

                binding.item6.alpha = 1f
                if (firstSelect == 0) {
                    firstSelect = binding.item6.tag.toString().toInt()
                    firstSelectItem = binding.item6
                    firstSelectItemCurtain = binding.curtain6
                    check()
                } else {
                    secondSelect = binding.item6.tag.toString().toInt()
                    secondSelectItem = binding.item6
                    secondSelectItemCurtain = binding.curtain6
                    check()
                }
            }
        }
        binding.item7.setOnClickListener {
            if (!isLoading) {

                binding.item7.alpha = 1f
                if (firstSelect == 0) {
                    firstSelect = binding.item7.tag.toString().toInt()
                    firstSelectItem = binding.item7
                    firstSelectItemCurtain = binding.curtain7
                    check()
                } else {
                    secondSelect = binding.item7.tag.toString().toInt()
                    secondSelectItem = binding.item7
                    secondSelectItemCurtain = binding.curtain7
                    check()
                }
            }
        }
        binding.item8.setOnClickListener {
            if (!isLoading) {

                binding.item8.alpha = 1f
                if (firstSelect == 0) {
                    firstSelect = binding.item8.tag.toString().toInt()
                    firstSelectItem = binding.item8
                    firstSelectItemCurtain = binding.curtain8
                    check()
                } else {
                    secondSelect = binding.item8.tag.toString().toInt()
                    secondSelectItem = binding.item8
                    secondSelectItemCurtain = binding.curtain8
                    check()
                }
            }
        }
        binding.item9.setOnClickListener {
            if (!isLoading) {

                binding.item9.alpha = 1f
                if (firstSelect == 0) {
                    firstSelect = binding.item9.tag.toString().toInt()
                    firstSelectItem = binding.item9
                    firstSelectItemCurtain = binding.curtain9
                    check()
                } else {
                    secondSelect = binding.item9.tag.toString().toInt()
                    secondSelectItem = binding.item9
                    secondSelectItemCurtain = binding.curtain9
                    check()
                }
            }
        }
        binding.item10.setOnClickListener {
            if (!isLoading) {

                binding.item10.alpha = 1f
                if (firstSelect == 0) {
                    firstSelect = binding.item10.tag.toString().toInt()
                    firstSelectItem = binding.item10
                    firstSelectItemCurtain = binding.curtain10
                    check()
                } else {
                    secondSelect = binding.item10.tag.toString().toInt()
                    secondSelectItem = binding.item10
                    secondSelectItemCurtain = binding.curtain10
                    check()
                }
            }
        }
        binding.item11.setOnClickListener {
            if (!isLoading) {

                binding.item11.alpha = 1f
                if (firstSelect == 0) {
                    firstSelect = binding.item11.tag.toString().toInt()
                    firstSelectItem = binding.item11
                    firstSelectItemCurtain = binding.curtain11
                    check()
                } else {
                    secondSelect = binding.item11.tag.toString().toInt()
                    secondSelectItem = binding.item11
                    secondSelectItemCurtain = binding.curtain11
                    check()
                }
            }
        }

        binding.item12.setOnClickListener {
            if (!isLoading) {

                binding.item12.alpha = 1f
                if (firstSelect == 0) {
                    firstSelect = binding.item12.tag.toString().toInt()
                    firstSelectItem = binding.item12
                    firstSelectItemCurtain = binding.curtain12
                    check()
                } else {
                    secondSelect = binding.item12.tag.toString().toInt()
                    secondSelectItem = binding.item12
                    secondSelectItemCurtain = binding.curtain12
                    check()
                }
            }
        }

        binding.item13.setOnClickListener {
            if (!isLoading) {

                binding.item13.alpha = 1f
                if (firstSelect == 0) {
                    firstSelect = binding.item13.tag.toString().toInt()
                    firstSelectItem = binding.item13
                    firstSelectItemCurtain = binding.curtain13
                    check()
                } else {
                    secondSelect = binding.item13.tag.toString().toInt()
                    secondSelectItem = binding.item13
                    secondSelectItemCurtain = binding.curtain13
                    check()
                }
            }
        }

        binding.item14.setOnClickListener {
            if (!isLoading) {


                binding.item14.alpha = 1f
                if (firstSelect == 0) {
                    firstSelect = binding.item14.tag.toString().toInt()
                    firstSelectItem = binding.item14
                    firstSelectItemCurtain = binding.curtain14
                    check()
                } else {
                    secondSelect = binding.item14.tag.toString().toInt()
                    secondSelectItem = binding.item14
                    secondSelectItemCurtain = binding.curtain14
                    check()
                }
            }

        }
        binding.item15.setOnClickListener {
            if (!isLoading) {

                binding.item15.alpha = 1f
                if (firstSelect == 0) {
                    firstSelect = binding.item15.tag.toString().toInt()
                    firstSelectItem = binding.item15
                    firstSelectItemCurtain = binding.curtain15
                    check()
                } else {
                    secondSelect = binding.item15.tag.toString().toInt()
                    secondSelectItem = binding.item15
                    secondSelectItemCurtain = binding.curtain15
                    check()
                }
            }
        }

        binding.item16.setOnClickListener {
            if (!isLoading) {

                binding.item16.alpha = 1f
                if (firstSelect == 0) {
                    firstSelect = binding.item16.tag.toString().toInt()
                    firstSelectItem = binding.item16
                    firstSelectItemCurtain = binding.curtain16
                    check()
                } else {
                    secondSelect = binding.item16.tag.toString().toInt()
                    secondSelectItem = binding.item16
                    secondSelectItemCurtain = binding.curtain16
                    check()
                }
            }
        }

        binding.item17.setOnClickListener {
            if (!isLoading) {

                binding.item17.alpha = 1f
                if (firstSelect == 0) {
                    firstSelect = binding.item17.tag.toString().toInt()
                    firstSelectItem = binding.item17
                    firstSelectItemCurtain = binding.curtain17
                    check()
                } else {
                    secondSelect = binding.item17.tag.toString().toInt()
                    secondSelectItem = binding.item17
                    secondSelectItemCurtain = binding.curtain17
                    check()
                }
            }
        }

        binding.item18.setOnClickListener {
            if (!isLoading) {

                binding.item18.alpha = 1f
                if (firstSelect == 0) {
                    firstSelect = binding.item18.tag.toString().toInt()
                    firstSelectItem = binding.item18
                    firstSelectItemCurtain = binding.curtain18
                    check()
                } else {
                    secondSelect = binding.item18.tag.toString().toInt()
                    secondSelectItem = binding.item18
                    secondSelectItemCurtain = binding.curtain18
                    check()
                }
            }
        }

        binding.item19.setOnClickListener {
            if (!isLoading) {

                binding.item19.alpha = 1f
                if (firstSelect == 0) {
                    firstSelect = binding.item19.tag.toString().toInt()
                    firstSelectItem = binding.item19
                    firstSelectItemCurtain = binding.curtain19
                    check()
                } else {
                    secondSelect = binding.item19.tag.toString().toInt()
                    secondSelectItem = binding.item19
                    secondSelectItemCurtain = binding.curtain19
                    check()
                }
            }
        }

        binding.item20.setOnClickListener {
            if (!isLoading) {

                binding.item20.alpha = 1f
                if (firstSelect == 0) {
                    firstSelect = binding.item20.tag.toString().toInt()
                    firstSelectItem = binding.item20
                    firstSelectItemCurtain = binding.curtain20
                    check()
                } else {
                    secondSelect = binding.item20.tag.toString().toInt()
                    secondSelectItem = binding.item20
                    secondSelectItemCurtain = binding.curtain20
                    check()
                }
            }
        }
    }

    private fun check() {

        if (firstSelect != 0 && secondSelect == 0 || secondSelect != 0 && firstSelect == 0) {
        } else {
            if (firstSelect == secondSelect && firstSelectItem != secondSelectItem) {
                findedCards++
                checkWin()
                lifecycleScope.launch {
                    secondSelectItem!!.alpha = 1f
                    isLoading = true
                    delay(500L)
                    isLoading = false
                    firstSelectItem!!.visibility = View.INVISIBLE
                    secondSelectItem!!.visibility = View.INVISIBLE
                    firstSelectItemCurtain!!.visibility = View.INVISIBLE
                    secondSelectItemCurtain!!.visibility = View.INVISIBLE
                    firstSelectItemCurtain = null
                    secondSelectItemCurtain = null
                    firstSelect = 0
                    secondSelect = 0
                    firstSelectItem = null
                    secondSelectItem = null
                }

            } else {
                lifecycleScope.launch {
                    secondSelectItem!!.alpha = 1f
                    isLoading = true
                    delay(500L)
                    isLoading = false
                    firstSelectItem!!.alpha = 0f
                    secondSelectItem!!.alpha = 0f
                    firstSelectItemCurtain = null
                    secondSelectItemCurtain = null
                    firstSelect = 0
                    secondSelect = 0
                    firstSelectItem = null
                    secondSelectItem = null
                }
            }
        }
    }

    private fun checkWin() {
        if (findedCards == 10) {
            AppCache.getObject().setCoins(coins + AppCache.getObject().getCoins())
            findNavController().navigate(GameScreenDirections.actionGameScreenToResultScreen(coin = coins,time = stepCount))
        }
    }

    private fun loadData() {
        val num = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val shuffled = num.shuffled()

        for ((j, i) in (0 until binding.column.childCount).withIndex()) {
            val item = binding.column.getChildAt(i) as ImageView
            item.tag = shuffled[j]
            when (item.tag) {
                1 -> {
                    item.setImageDrawable(requireContext().getDrawable(R.drawable.apple))
                }

                2 -> {
                    item.setImageDrawable(requireContext().getDrawable(R.drawable.banana))
                }

                3 -> {
                    item.setImageDrawable(requireContext().getDrawable(R.drawable.butterfly))
                }

                4 -> {
                    item.setImageDrawable(requireContext().getDrawable(R.drawable.cloud))
                }

                5 -> {
                    item.setImageDrawable(requireContext().getDrawable(R.drawable.crystal))
                }

                6 -> {
                    item.setImageDrawable(requireContext().getDrawable(R.drawable.star))
                }

                7 -> {
                    item.setImageDrawable(requireContext().getDrawable(R.drawable.orange))
                }

                8 -> {
                    item.setImageDrawable(requireContext().getDrawable(R.drawable.ic_sun))
                }

                9 -> {
                    item.setImageDrawable(requireContext().getDrawable(R.drawable.moon))
                }

                10 -> {
                    item.setImageDrawable(requireContext().getDrawable(R.drawable.gem))
                }
            }
        }
    }

    override fun onDetach() {
        super.onDetach()
        timer?.cancel()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        timer?.cancel()
    }

    override fun onDestroy() {
        super.onDestroy()
        timer?.cancel()
    }
}