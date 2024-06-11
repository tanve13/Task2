package com.tanveer.task2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.util.rangeTo
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.tanveer.task2.R.*

class MainActivity : AppCompatActivity() {

    var etContactNumber: EditText?= null
    var button: Button?= null
    var rbYES: RadioButton?= null
    var rbNO: RadioButton?= null
    var etStudyField : EditText?= null
    var name: EditText?= null
    var college: EditText?= null
    var email: EditText?= null
    var rgStudy: RadioGroup?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }

        etContactNumber = findViewById(R.id.etContactNumber)
        name = findViewById(R.id.etName)
        college = findViewById(R.id.etCollege)
        email =findViewById(R.id.etEmail)
        button = findViewById(R.id.Button)
        rbYES = findViewById(R.id.rbYES)
        rbNO = findViewById(R.id.rbNO)
        etStudyField = findViewById(R.id.etStudyField)
        rgStudy = findViewById(R.id.rgStudy)
         var btnNext : Button?= null
        button?.setOnClickListener {
            if(name?.text?.toString()?.trim().isNullOrEmpty()){
                name?.error = resources.getString(R.string.enter_your_name)
            }else if(college?.text?.toString()?.trim().isNullOrEmpty()){
                college?.error= resources.getString(R.string.enter_your_college)
            } else if (etContactNumber?.text.toString().trim().isNullOrEmpty()) {
                etContactNumber?.error = "Enter your number"
            } else if (etContactNumber?.text.toString().trim().length < 10) {
                etContactNumber?.error = "enter a valid 10-digits number"
            }else if((etContactNumber?.text?.toString()?.trim()?.get(0)?.toInt()?:0)<6){
                etContactNumber?.error="enter a valid number"


            }  else if(email?.text?.toString()?.trim().isNullOrEmpty()){
                email?.error = resources.getString(R.string.enter_your_email)
            } else if(rgStudy?.checkedRadioButtonId==-1){
                Toast.makeText(this, "select option", Toast.LENGTH_SHORT).show()
            } else if(rbYES?.isChecked==true && etStudyField?.text?.toString()?.trim().isNullOrEmpty()){
                etStudyField?.error = resources.getString(R.string.enter_your_field)
            } else  {
                Toast.makeText(this, "Successfully submitted", Toast.LENGTH_SHORT).show()
                var intent = Intent(this,secondactivity::class.java)
                intent.putExtra("name",name?.text.toString().trim())
                intent.putExtra("contactNumber",etContactNumber?.text.toString().trim())
                startActivity(intent)
            }
        }
        button?.setOnClickListener {
            if (etStudyField?.text.toString().trim().isNullOrEmpty()) {
                etStudyField?.error = "enter your field"

            } else {
                Toast.makeText(this, "saved successfully", Toast.LENGTH_SHORT).show()
            }
        }
        rbYES?.setOnClickListener {}
        rbYES?.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                etStudyField?.visibility = View.VISIBLE
            } else {
                etStudyField?.visibility = View.GONE
            }
        }
    }
}




