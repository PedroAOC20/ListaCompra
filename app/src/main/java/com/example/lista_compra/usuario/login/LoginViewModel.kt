package com.example.lista_compra.usuario.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    private val loginModel = LoginModel()

    // LiveData para observar mensagens
    private val _mensagem = MutableLiveData<String>()
    val mensagem: LiveData<String> get() = _mensagem

    fun autenticar(email: String, senha: String) {
        // Chama o método do LoginModel e atualiza a LiveData
        val resultado = loginModel.autenticar(email, senha)
        _mensagem.value = resultado
    }
}