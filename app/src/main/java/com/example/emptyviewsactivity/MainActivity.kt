package com.example.emptyviewsactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var timerValues = mutableListOf(0,0,0,0)
    private lateinit var countDownTimer: CountDownTimer
    private val countDownInterval: Long = 1000 // 1 second
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        countDownTimer = object : CountDownTimer(Long.MAX_VALUE, countDownInterval)
        {
            override fun onTick(millisUntilFinished: Long)
            {
                if (timerValues[3] > 0)
                {
                    timerValues[3]--
                }
                else if (timerValues[2] > 0)
                {
                    timerValues[2]--
                    timerValues[3] = 9
                }
                else if (timerValues[1] > 0)
                {
                    timerValues[1]--
                    timerValues[2] = 5
                    timerValues[3] = 9
                }
                else if (timerValues[0] > 0)
                {
                    timerValues[0]--
                    timerValues[1] = 9
                }
                else
                {
                    onFinish()
                }
                updateTextViews()
            }

            override fun onFinish()
            {
                countDownTimer.cancel()
            }
        }

        fun timeIncreased1()
        {
            if (timerValues[0]++ == 6) timerValues[0] = 0
        }

        fun timeDecreased1()
        {
            if (timerValues[0]-- == 0) timerValues[0] = 0
        }

        fun timeIncreased2()
        {
            if (timerValues[0] < 6){
                if (timerValues[1]++ == 9) {timeIncreased1(); timerValues[1] = 0}
            }
        }

        fun timeDecreased2()
        {
            if (timerValues[1]-- == 0) timerValues[1] = 0
        }

        fun timeIncreased3()
        {
            if (timerValues[2]++ == 6) timerValues[2] = 0
        }

        fun timeDecreased3()
        {
            if (timerValues[2]-- == 0) timerValues[2] = 0
        }

        fun timeIncreased4()
        {
            if (timerValues[2] < 6){
                if (timerValues[3]++ == 9) {timeIncreased3(); timerValues[3] = 0}
            }
        }

        fun timeDecreased4()
        {
            if (timerValues[3]-- == 0) timerValues[3] = 0
        }

        val buttonClickListener = View.OnClickListener { view ->
            when (view.id)
            {
                R.id.button2 -> timeIncreased1()
                R.id.button1 -> timeDecreased1()

                R.id.button4 -> timeIncreased2()
                R.id.button3 -> timeDecreased2()

                R.id.button6 -> timeIncreased3()
                R.id.button5 -> timeDecreased3()

                R.id.button8 -> timeIncreased4()
                R.id.button7 -> timeDecreased4()

                R.id.buttonStart -> {
                    countDownTimer.start()
                }

                R.id.buttonStop -> {
                    timerValues = mutableListOf(0,0,0,0)
                    countDownTimer.onFinish()
                }

                R.id.buttonPause -> {
                    countDownTimer.onFinish()
                }
            }
            updateTextViews()
        }

        findViewById<Button>(R.id.button1).setOnClickListener(buttonClickListener)
        findViewById<Button>(R.id.button2).setOnClickListener(buttonClickListener)
        findViewById<Button>(R.id.button3).setOnClickListener(buttonClickListener)
        findViewById<Button>(R.id.button4).setOnClickListener(buttonClickListener)
        findViewById<Button>(R.id.button5).setOnClickListener(buttonClickListener)
        findViewById<Button>(R.id.button6).setOnClickListener(buttonClickListener)
        findViewById<Button>(R.id.button7).setOnClickListener(buttonClickListener)
        findViewById<Button>(R.id.button8).setOnClickListener(buttonClickListener)
        findViewById<Button>(R.id.buttonStart).setOnClickListener(buttonClickListener)
        findViewById<Button>(R.id.buttonStop).setOnClickListener(buttonClickListener)
        findViewById<Button>(R.id.buttonPause).setOnClickListener(buttonClickListener)
    }

    private fun updateTextViews()
    {
        findViewById<TextView>(R.id.textView3).text = timerValues[0].toString()
        findViewById<TextView>(R.id.textView2).text = timerValues[1].toString()
        findViewById<TextView>(R.id.textView4).text = timerValues[2].toString()
        findViewById<TextView>(R.id.textView5).text = timerValues[3].toString()
    }
}