package kr.ac.kumoh.ce.s20210025.s23w04carddealer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kr.ac.kumoh.ce.s20210025.s23w04carddealer.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var main: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        main = ActivityMainBinding.inflate(layoutInflater)
        setContentView(main.root)

        val card = Random.nextInt(52)
        //val card = 33
        //Log.i("Card!!!", "$card: ${getCardNumber(card)}")

        val res = resources.getIdentifier(
            getCardNumber(card),
            "drawable",
            packageName
        )

        main.card1.setImageResource(res)
        //main.card1.setImageResource(R.drawable.c_2_of_hearts)
    }

    private fun getCardNumber(c: Int) : String {
        val shape = when (c / 13) {
            0 -> "spades"
            1 -> "diamonds"
            2 -> "hearts"
            3 -> "clubs"
            else -> "error"
        }

        val number = when (c % 13) {
            0 -> "ace"
            in 1 .. 9 -> (c % 13 + 1).toString()
            10 -> "jack"
            11 -> "queen"
            12 -> "king"
            else -> "error"
        }

        return "c_${number}_of_$shape"
    }
}