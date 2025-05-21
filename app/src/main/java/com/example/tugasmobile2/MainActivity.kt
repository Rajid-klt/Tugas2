package com.example.tugasmobile2

import android.os.Bundle
import android.widget.Toast
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.example.tugasmobile2.databinding.ActivityMainBinding
import com.example.tugasmobile2.HomePageActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginBtn.setOnClickListener {
            val username =  binding.usernameInput.text.toString().trim()
            val password = binding.PasswordInput.text.toString().trim()

            val sharepref =  getSharedPreferences("UserData", MODE_PRIVATE)
            val savedusername = sharepref.getString("username","")
            val savedpassword = sharepref.getString("password","")

            when{
                username.isEmpty() -> showToast("User name tidak boleh kosong")
                password.isEmpty() -> showToast("password tidak boleh kosong")
                username != savedusername || password != savedpassword -> showToast("username atau Password salah")
                else -> {
                    showToast("Login berhasil")

                    //intent ke homepage
                    val intent = Intent(this, HomePageActivity::class.java)
                    startActivity(intent)
                }
            }
        }

        binding.RegisterBtn.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}