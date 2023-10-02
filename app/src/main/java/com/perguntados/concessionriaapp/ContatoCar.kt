package com.perguntados.concessionriaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.MultiAutoCompleteTextView
import androidx.appcompat.app.AlertDialog

class ContatoCar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contato_car)



        val multiAutoCompleteTextView = findViewById<MultiAutoCompleteTextView>(R.id.modeloCadastro)

        // Fornecer sugestões em um array
        val suggestions = arrayOf("Opção 1", "Opção 2", "Opção 3", "Opção 4")

        // Crie um ArrayAdapter com as sugestões
        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, suggestions)

        // Configure o adaptador para o MultiAutoCompleteTextView
        multiAutoCompleteTextView.setAdapter(adapter)

        // Defina o caractere delimitador (por exemplo, vírgula)
        multiAutoCompleteTextView.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())


        val multiAutoCompleteTextViewYear = findViewById<MultiAutoCompleteTextView>(R.id.anoCadastro)

        val yearSuggestions = arrayOf("2023", "2022", "2021", "2020", "2019", "2018", "2017", "2016", "2015")

        val yearAdapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, yearSuggestions)

        multiAutoCompleteTextViewYear.setAdapter(yearAdapter)

        multiAutoCompleteTextViewYear.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())


        // Inicialize os elementos de UI
        nomeCadastro = findViewById(R.id.nomeCadastro)
        emailCadastro = findViewById(R.id.emailCadastro)
        cpfCadastro = findViewById(R.id.cpfCadastro)
        telefoneCadastro = findViewById(R.id.telefoneCadastro)
        modeloCadastro = findViewById(R.id.modeloCadastro)
        anoCadastro = findViewById(R.id.anoCadastro)
        val submitButton = findViewById<Button>(R.id.btnCadastro)
        submitButton.setOnClickListener {
            onSubmitButtonClicked()
        }
    }
    private lateinit var nomeCadastro: EditText
    private lateinit var emailCadastro: EditText
    private lateinit var cpfCadastro: EditText
    private lateinit var telefoneCadastro: EditText
    private lateinit var modeloCadastro: MultiAutoCompleteTextView
    private lateinit var anoCadastro: MultiAutoCompleteTextView

    private fun onSubmitButtonClicked() {
        // Obtenha o texto dos campos

        val nome = nomeCadastro.text.toString()
        val email = emailCadastro.text.toString()
        val cpf = cpfCadastro.text.toString()
        val telefone = telefoneCadastro.text.toString()
        val modelo = modeloCadastro.text.toString()
        val ano = anoCadastro.text.toString()

        // Verifique se todos os campos estão preenchidos
        if (nome.isNotEmpty() && email.isNotEmpty() && cpf.isNotEmpty() && telefone.isNotEmpty() && modelo.isNotEmpty() && ano.isNotEmpty()) {
            // Todos os campos estão preenchidos, exiba a mensagem de sucesso
            showAlertDialog("Iremos entrar em contato pelos nossos canais de atendimento.")
        } else {
            // Pelo menos um campo não foi preenchido, exiba a mensagem de erro
            showAlertDialog("Preencha todos os campos para que possamos entrar em contato.")
        }
    }

    private fun showAlertDialog(message: String) {
        val alertDialog = AlertDialog.Builder(this)
            .setMessage(message)
            .setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
            }
            .create()

        alertDialog.show()
    }
}

































