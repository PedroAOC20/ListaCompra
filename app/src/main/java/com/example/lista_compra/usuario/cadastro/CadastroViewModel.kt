package com.example.lista_compra.usuario.cadastro
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CadastroViewModel : ViewModel() {
    private val cadastroModel = CadastroModel()

    private val _mensagem = MutableLiveData<String>()
    val mensagem: LiveData<String> get() = _mensagem

    fun cadastrar(nome: String, email: String, senha: String, confirmacaoSenha: String) {
        val resultado = cadastroModel.cadastrarUsuario(nome, email, senha, confirmacaoSenha)
        _mensagem.value = resultado
    }
}