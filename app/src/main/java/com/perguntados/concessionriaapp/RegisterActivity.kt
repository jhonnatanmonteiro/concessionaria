package com.perguntados.concessionriaapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.SignInButton
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.perguntados.concessionriaapp.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)
        val decorView = window.decorView
        val uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN
        decorView.systemUiVisibility = uiOptions

        val dbHelper = UserDbHelper(this)

        binding.buttonRegister.setOnClickListener {
            val name = binding.editTextName.text.toString()
            val email = binding.editTextEmail.text.toString()
            val password = binding.editTextPassword.text.toString()
            fun isEmailUnique(email: String): Boolean {
                // Consultar o banco de dados para verificar se o email já existe
                val cursor = dbHelper.queryUserByEmail(email)
                val emailExists = cursor.count > 0
                cursor.close()
                return !emailExists
            }
            // Verificar se o email já existe no banco de dados
            if (isEmailUnique(email)) {


                val userId = dbHelper.insertUser(name, email, password)
                if (userId != -1L) {

                    val intent = Intent(this, MainLogin::class.java)
                    startActivity(intent)
                    finish() // Fecha a tela de registro
                } else {

                    Toast.makeText(this, "Erro ao registrar o usuário.", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "O email já está em uso.", Toast.LENGTH_SHORT).show()

            }


        }}}