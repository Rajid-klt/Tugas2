package com.example.tugasmobile2

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tugasmobile2.databinding.ActivityMainBinding
import com.example.tugasmobile2.databinding.HomePageBinding

class HomePageActivity : AppCompatActivity() {

    private lateinit var binding: HomePageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = HomePageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedpref = getSharedPreferences("UserData", MODE_PRIVATE)
        val savedusername = sharedpref.getString("username","")

        binding.textView.text = "Welcome $savedusername"

        binding.LogOutBtn2.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


    }
}