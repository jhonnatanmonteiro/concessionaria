package com.perguntados.concessionriaapp

import android.R.attr.name
import android.R.attr.password
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.perguntados.concessionriaapp.databinding.ActivityMainLoginBinding


class MainLogin : AppCompatActivity() {

    private lateinit var binding: ActivityMainLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainLoginBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)
        val decorView = window.decorView
        val uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN
        decorView.systemUiVisibility = uiOptions


        val dbHelper = UserDbHelper(this)

        binding.buttonLogin.setOnClickListener {
            val email = binding.editTextEmail.text.toString()
            val password = binding.editTextPassword.text.toString()

            // Aqui, você deve implementar a lógica de autenticação, por exemplo, verificando no banco de dados
            if (isValidUser(email, password)) {
                // Se o email e a senha estiverem corretos, inicie a CarListActivity
                val intent = Intent(this, CarListActivity::class.java)
                startActivity(intent)
                finish() // Fecha a tela de login para evitar que o usuário volte pressionando o botão "Voltar"
            } else {
                //  mensagem de erro para o usuário
                Toast.makeText(this, "Email ou senha incorretos", Toast.LENGTH_SHORT).show()
            }
        }


        binding.btnCriaConta.setOnClickListener {
            // Redirecionar para a tela de registro de novo usuário
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }


    }

    // iniciar o processo de login com o Google
    private fun signInWithGoogle() {
        // código de login com o Google aqui
    }
    private fun isValidUser(email: String, password: String): Boolean {
        val dbHelper = UserDbHelper(this)
        val db = dbHelper.readableDatabase

        val projection = arrayOf(
            UserContract.UserEntry.ID
        )

        val selection = "${UserContract.UserEntry.COLUMN_EMAIL} = ? AND ${UserContract.UserEntry.COLUMN_PASSWORD} = ?"
        val selectionArgs = arrayOf(email, password)

        val cursor = db.query(
            UserContract.UserEntry.TABLE_NAME,
            projection,
            selection,
            selectionArgs,
            null,
            null,
            null
        )

        val isValid = cursor.count > 0
        cursor.close()

        return isValid
    }

}