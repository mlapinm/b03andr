package com.example.freon.l2192notb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout

class EditActivity : AppCompatActivity() {

    var mainImageLayout: ConstraintLayout? = null
    var visibleImage: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        mainImageLayout = findViewById<ConstraintLayout>(R.id.mainImageLayout)

    }

    fun onClickAddImage(view: View) {
        if(visibleImage == false){
            mainImageLayout?.visibility = View.VISIBLE
            visibleImage = true
        }else{
            mainImageLayout?.visibility = View.GONE
            visibleImage = false
        }

    }
}