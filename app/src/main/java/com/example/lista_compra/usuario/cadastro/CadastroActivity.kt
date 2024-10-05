package com.example.lista_compra.usuario.cadastro
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.lista_compra.R
import com.example.lista_compra.databinding.ActivityCadastrarUserBinding

class CadastroActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCadastrarUserBinding
    private lateinit var viewModel: CadastroViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Inicializa o View Binding
        binding = ActivityCadastrarUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.CadastroActivity)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        viewModel = ViewModelProvider(this).get(CadastroViewModel::class.java)

        viewModel.mensagem.observe(this, Observer { mensagem ->
            Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show()
        })

        binding.botaoCadastro.setOnClickListener {
            val nome = binding.nomeCompleto.text.toString()
            val email = binding.CampEmail.text.toString()
            val senha = binding.CampSenha.text.toString()
            val confirmacaoSenha = binding.confirmarSenha.text.toString()

            viewModel.cadastrar(nome, email, senha, confirmacaoSenha)
        }

        binding.retornarLogin.setOnClickListener {
            finish()
        }
    }
}