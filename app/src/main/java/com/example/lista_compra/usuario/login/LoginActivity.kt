package com.example.lista_compra.usuario.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.lista_compra.R
import com.example.lista_compra.databinding.ActivityLoginBinding
import com.example.lista_compra.usuario.cadastro.CadastroActivity


class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // Inicializa o View Binding
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Inicializa o ViewModel
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        // Observa mudanças na LiveData
        viewModel.mensagem.observe(this, Observer { mensagem ->
            Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show()
            if (mensagem == "Login realizado com sucesso.") {
                // Aguardando o arquivo da tela das listas.
                // finish()
            }
        })

        binding.botaoLogin.setOnClickListener {
            val email = binding.CampEmail.text.toString()
            val senha = binding.CampPassword.text.toString()

            viewModel.autenticar(email, senha)
        }

        binding.botaoCadastro.setOnClickListener {
            startActivity(Intent(this, CadastroActivity::class.java))
        }
    }
}