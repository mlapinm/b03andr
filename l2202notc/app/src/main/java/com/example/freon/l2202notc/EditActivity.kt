package com.example.freon.l2202notc

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.freon.l2202notc.db.MyDbManager

class EditActivity : AppCompatActivity() {

    var mainImageLayout: ConstraintLayout? = null
    var visibleImage: Boolean = false
    val imageRequestCode = 10
    var imMainImage: ImageView? = null
    var tempImageUri = "empty"
    var edTitle: EditText? = null
    var edDesk: EditText? = null
    val myDbManager = MyDbManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        mainImageLayout = findViewById<ConstraintLayout>(R.id.mainImageLayout)
        imMainImage = findViewById<ImageView>(R.id.imMainImage)
        edTitle = findViewById<EditText>(R.id.edTitle)
        edDesk = findViewById<EditText>(R.id.edDesk)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK && requestCode == imageRequestCode ){
            imMainImage?.setImageURI(data?.data)
            tempImageUri = data?.data.toString()
        }
    }

    fun onClickChooseImage(view: View) {
        var intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, imageRequestCode)
    }

    fun onClickSave(view: View) {
        val myTitle = edTitle?.text.toString()
        val myDesk = edDesk?.text.toString()

        if(myTitle != ""){
            myDbManager?.insertToDb(myTitle, myDesk, tempImageUri)
        }


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

    override fun onResume() {
        super.onResume()
        myDbManager?.openDb()
    }

    override fun onDestroy() {
        super.onDestroy()
        myDbManager?.closeDb()
    }


}
