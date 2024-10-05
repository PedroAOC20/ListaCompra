package com.example.lista_compra.gerenciador_lista_compra

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lista_compra.R
import com.example.lista_compra.databinding.ActivityListaListBinding
import com.example.lista_compra.usuario.login.LoginActivity

class ListaListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListaListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityListaListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.lista_list_activity)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Configurando o clique do botão de logout
        binding.botaoLogoutf.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish() // Finaliza a atividade atual
        }

        // Configurando o clique do botão de adicionar
        binding.botaoAdicionar.setOnClickListener {
            //val intent = Intent(this, CriarListaActivity::class.java)
            startActivity(intent)
        }
    }
}