package com.example.l2012var

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {

    private var textView1: TextView? = null
    private var layout1: ConstraintLayout? = null
    private var start: Boolean = false
    private var counter: Int = 0

    private var n1:Byte = 1
    private var n2:Short = 2
    private var n3:Int = 3
    private var n4:Long = 4
    private var n5:Float = 5.0f
    private var n6:Double = 6.0
    private var b7:Boolean = true
    private var s8:Char = '8'
    private var s9:String = "99 9 99"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView1 = findViewById(R.id.textView1)
        layout1 = findViewById(R.id.layout1)

        Thread{
            start = true
            while (start){
                Thread.sleep(500)

                runOnUiThread(){
                    textView1?.setText(counter.toString())
                    if(counter == 5){
                        layout1?.setBackgroundColor(Color.GRAY)
                    }else if(counter == 10){
                        layout1?.setBackgroundColor(Color.YELLOW)
                    }
                    counter++
                }

            }
        }.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        start = false
    }
}