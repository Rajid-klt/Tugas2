package com.example.tugasmobile2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import android.content.Intent
import com.example.tugasmobile2.databinding.RegisterLayoutBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: RegisterLayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Menggunakan view binding
        binding = RegisterLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //fungsi button
        binding.RegisterBtn2.setOnClickListener{
            val fullName = binding.FullnameInput.text.toString().trim()
            val username = binding.UsernameInput.text.toString().trim()
            val password = binding.PasswordInput.text.toString().trim()
            val confirmPassword = binding.ConfirmPassword.text.toString().trim()

            when{
                fullName.isEmpty() -> showToast("Full Name tidak boleh kosong")
                username.isEmpty() -> showToast("User Name tidak boleh kosong")
                password.isEmpty() -> showToast("Password tidak boleh kosong")
                confirmPassword.isEmpty() -> showToast("Confirm Password tidak boleh kosong")
                password != confirmPassword -> showToast("Password tidak sama")
                else -> {
                    //berhasil Regis
                    showToast("Registrasi Berhasil")

                    //simpan data
                    val sharedpref = getSharedPreferences("UserData", MODE_PRIVATE)
                    val editor = sharedpref.edit()
                    editor.putString("username", username)
                    editor.putString("password", password)
                    editor.apply (  )


                    //logic pindah activity
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)

                    // logic tutup RegisterActivity agar tidak bisa kembali ke sini
                    finish()
                }
            }
        }
    }
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}