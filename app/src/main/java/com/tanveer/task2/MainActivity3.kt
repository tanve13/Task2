package com.tanveer.task2

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity3 : AppCompatActivity() {
    var name : EditText?= null
    var contact: EditText?= null
    lateinit var check: Button
    var btnMove : Button?= null
    var previousName=""
    var previousContact=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        name = findViewById(R.id.name)
        contact = findViewById(R.id.contact)
        btnMove = findViewById(R.id.btnMoveToNextScreen)
        intent?.extras?.let {
            previousName = it.getString("name") ?: ""
            previousContact = it.getString("ContactNumber") ?: ""
            println("previous key $previousName $previousContact")
        }

        name?.setText(previousName)
        contact?.setText(previousContact)
        check.setOnClickListener {
            Log.e(TAG, "${name?.text}")
            Toast.makeText(this, "This is toast ${name?.text}", Toast.LENGTH_LONG).show()

        }
        btnMove?.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}