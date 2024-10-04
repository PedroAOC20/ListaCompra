package com.example.lista_compra

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lista_compra.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    //Mock de validação de login
    private val validEmail = "user@carbuy.com"
    private val validPassword = "password123"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // Configuração do ViewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.buttonLogin.setOnClickListener {
            val email = binding.campEmail.text.toString().trim()
            val password = binding.campPassword.text.toString().trim()

            // Verificar se os campos não estão vazios e se o email é válido
            if (validateFields(email, password)) {
                if (email == validEmail && password == validPassword) {
                    // Login bem-sucedido, navega para a próxima tela
                    showCustomToast("Login bem-sucedido!")
                    navigateToHome()
                } else {
                    // Exibir mensagem de erro se as credenciais não corresponderem
                    showCustomToast("Credenciais inválidas!")
                }
            }
        }

        binding.buttonRegister.setOnClickListener {
            // Lógica para redirecionar para a tela de registro
            showCustomToast("Redirecionar para tela de cadastro.")
        }
    }

    // Função de validação de campos
    private fun validateFields(email: String, password: String): Boolean {
        if (TextUtils.isEmpty(email)) {
            showCustomToast("Por favor, insira o e-mail.")
            return false
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            showCustomToast("Por favor, insira um e-mail válido.")
            return false
        }

        if (TextUtils.isEmpty(password)) {
            showCustomToast("Por favor, insira a senha.")
            return false
        }

        return true
    }

    // Função para exibir o Toast customizado
    private fun showCustomToast(message: String) {
        val layoutInflater = LayoutInflater.from(this)
        val layout: View = layoutInflater.inflate(R.layout.custom_toast, findViewById(R.id.toast_message))
        val textView: TextView = layout.findViewById(R.id.toast_message)
        textView.text = message

        val toast = Toast(applicationContext)
        toast.duration = Toast.LENGTH_SHORT
        toast.view = layout
        toast.setGravity(Gravity.TOP or Gravity.FILL_HORIZONTAL, 0, 50) // Aparece no topo
        toast.show()
    }

    private fun navigateToHome() {
        // Simular navegação para a próxima tela após o login
        val intent = Intent(this, CadastroActivity::class.java)
        startActivity(intent)
        finish() // Finaliza a LoginActivity
    }
}