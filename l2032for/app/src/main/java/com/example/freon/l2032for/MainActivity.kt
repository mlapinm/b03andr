package com.example.freon.l2032for

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import java.lang.reflect.Array

class MainActivity : AppCompatActivity() {

    private var textView1: TextView? = null
    private var textView2: TextView? = null
    private var counter: Int = 0
    var text: String = "В <магазине> осталось 123 яблока а может и <больше> всем привет <как> дела"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView1 = findViewById<TextView>(R.id.textView1)
        textView2 = findViewById<TextView>(R.id.textView2)

        textView1?.setText(text)
        for (i in 0 until text.length - 1){
            if(text[i] == '<'){
                counter++
            }
        }
        textView2?.setText(counter.toString())
        var startPosition = IntArray(counter)
        var endPosition = IntArray(counter)
        var startCounter: Int = 0
        var endCounter: Int = 0
        for (i in 0 until text.length - 1){
            if(text[i] == '<'){
                startPosition[startCounter] = i
                startCounter++
            }
            if(text[i] == '>'){
                endPosition[endCounter] = i
                endCounter++
            }
        }
        var textFounArray = Array(counter){""}
        for(i in 0 until startPosition.size){
            textFounArray[i] = text.substring(startPosition[i]+1, endPosition[i])
        }
        var textFound : String = ""
        var k: Int = 0
        for(i in 0 until textFounArray.size ){
            textFound += textFounArray[i] + " " + k.toString() + " , "
            k++
        }
        textView2?.setText(textFound)
        var s1 : String = text.substringAfter('<')
        var s2 : String = s1.substringBefore('>')
        Toast.makeText(this,s2, Toast.LENGTH_LONG).show()
    }
}