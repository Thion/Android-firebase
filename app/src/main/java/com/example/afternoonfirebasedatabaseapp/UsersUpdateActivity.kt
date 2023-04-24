package com.example.afternoonfirebasedatabaseapp

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog

class UsersUpdateActivity : AppCompatActivity() {
    lateinit var editName:EditText
    lateinit var editEmail:EditText
    lateinit var editIDNumber:EditText
    lateinit var btnUpdate:Button
    lateinit var progressDialog: ProgressDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_usersupdate)
        editName = findViewById(R.id.mEditName)
        editEmail = findViewById(R.id.mEdtEmail)
        editIDNumber = findViewById(R.id.mEditIDNumber)
        btnUpdate = findViewById(R.id.mBtnUpdateUser)
        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Updating")
        progressDialog.setMessage("Please wait...")

        // Receive data from the intent
        var receivedName = intent.getStringExtra("name")
        var receivedEmail = intent.getStringExtra("Email")
        var receivedIDNumber = intent.getStringExtra("idNumber")
        var receivedId = intent.getStringExtra("id")

        // Display the received data on the edittexts

    }

}