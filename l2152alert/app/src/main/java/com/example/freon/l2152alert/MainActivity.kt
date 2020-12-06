package com.example.freon.l2152alert

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mMultiDialog()
    }

    private fun mSimpleDialog(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Week")
        builder.setMessage("day")
        builder.setNeutralButton("info"){ dialogInterface: DialogInterface,
                                          i: Int ->
            Toast.makeText(this,"Info", Toast.LENGTH_LONG).show()
        }
        builder.show()
    }

    private fun mMultiDialog(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Week")
        builder.setMultiChoiceItems(R.array.string_array,null){
            dialogInterface: DialogInterface,
            i: Int,
            b: Boolean ->
            Toast.makeText(this,
                    " "+ i + ":" + b, Toast.LENGTH_LONG).show()

        }
        builder.setNeutralButton("info"){ dialogInterface: DialogInterface,
                                          i: Int ->
        Toast.makeText(this,"Info", Toast.LENGTH_LONG).show()
        }
        builder.show()
    }
}