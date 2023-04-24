package com.example.afternoonfirebasedatabaseapp

import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {
    lateinit var editName:EditText
    lateinit var editEmail:EditText
    lateinit var editIDNumber:EditText
    lateinit var btnSave:Button
    lateinit var btnView:Button
    lateinit var progressDialog:ProgressDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editName = findViewById(R.id.mEdtName)
        editEmail = findViewById(R.id.mEdtEmail)
        editIDNumber = findViewById(R.id.mEdtIdNumber)
        btnSave = findViewById(R.id.mBtnSave)
        btnView = findViewById(R.id.mBtnView)
        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Saving")
        progressDialog.setMessage("Please save")
        btnSave.setOnClickListener {
            // Receive data from the user
            var name = editName.text.toString().trim()
            var email = editEmail.text.toString().trim()
            var idNumber = editIDNumber.text.toString().trim()
            var id = System.currentTimeMillis().toString()
            // Check if the user is submitting empty fields
            if (name.isEmpty()){
                editName.setError("Please fill this field")
                editName.requestFocus()
            }else if (email.isEmpty()){
                editName.setError("Please fill this field")
                editName.requestFocus()
            }else if (idNumber.isEmpty()){
                editName.setError("Please fill this field")
                editName.requestFocus()
            }else{
                // Proceed to save data
                var user = User(name, email, idNumber, id)
                // create a reference to Firebase Database
                var ref = FirebaseDatabase.getInstance().
                        getReference().child("Users/"+id)
                // Start saving
                progressDialog.show()
                ref.setValue(user).addOnCompleteListener {
                    progressDialog.dismiss()
                    if(it.isSuccessful) {
                        Toast.makeText(this, "User saved successfully", Toast.LENGTH_LONG).show()
                    }else{
                        Toast.makeText(this,"User saving failed",Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
        btnView.setOnClickListener {
            var intent = Intent(this,UsersActivity::class.java)
            startActivity(intent)
        }
    }
}