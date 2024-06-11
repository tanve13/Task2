package com.tanveer.task2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class secondactivity : AppCompatActivity() {
    var name : EditText?= null
    var contact: EditText?= null
    lateinit var check: Button
    var btnMove : Button?= null
    private val TAG ="secondactivity"
    var previousName=""
    var previousContact=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secondactivity)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        name = findViewById(R.id.name)
        contact = findViewById(R.id.contact)
        check = findViewById(R.id.Button)
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
