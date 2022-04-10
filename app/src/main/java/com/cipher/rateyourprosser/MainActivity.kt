package com.cipher.rateyourprosser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.UserHandle
import android.view.LayoutInflater
import android.widget.*
import com.cipher.rateyourprosser.R
import com.cipher.rateyourprosser.Feedback
import com.cipher.rateyourprosser.databinding.ActivityMainBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var database : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        binding.btnsend.setOnClickListener {
            val fbdata = binding.fbdata.text.toString()
            val userName = binding.userName.text.toString()

            database = FirebaseDatabase.getInstance().getReference("Feedbacks")
            val Feedback = Feedback(fbdata,userName)
            database.child(userName).setValue(Feedback).addOnSuccessListener {

                binding.fbdata.text.clear()
                binding.userName.text.clear()

                Toast.makeText(this,"Successfully Saved",Toast.LENGTH_SHORT).show()

            }.addOnFailureListener{
                Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show()

            }


        }


        }
    }
