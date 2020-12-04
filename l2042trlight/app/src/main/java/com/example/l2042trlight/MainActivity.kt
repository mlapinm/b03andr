package com.example.l2042trlight

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import java.util.*

class MainActivity : Activity() {

    var ivTl: ImageView? = null
    var ibStartStop: ImageButton? = null
    var timer: Timer? = null
    var isRun: Boolean = false
    var imArray: IntArray = intArrayOf(R.drawable.semafor_green,
            R.drawable.semafor_yellow, R.drawable.semafor_red)
    var counter: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ivTl = findViewById(R.id.ivTl)
        ibStartStop = findViewById(R.id.ibStartStop)

    }

    fun onClickStartStop(view: View) {
        view as ImageButton
        if(isRun == false){
            mStart()
            view.setImageResource(R.drawable.button_stop)
            isRun = true
        }else{
            timer?.cancel()
            view.setImageResource(R.drawable.button_start)
            isRun = false
        }
    }

    fun mStart(){
        timer = Timer()
        counter = 0
        timer?.schedule(object : TimerTask(){
            override fun run() {
                runOnUiThread {
                    ivTl?.setImageResource(imArray[counter])
                    counter++
                    if(counter == 3){
                        counter = 0
                    }
                }
            }
        },0, 1000)
    }
}