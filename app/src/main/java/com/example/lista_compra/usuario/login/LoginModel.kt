package com.example.lista_compra.usuario.login

import com.example.lista_compra.usuario.modelo.Usuario
import com.example.lista_compra.usuario.repositorio.UsuarioRepositorio
import com.example.lista_compra.usuario.util.ValidadorEmail

class LoginModel {
    fun autenticar(email: String, senha: String): String {
        // Verifica se os campos estão preenchidos
        if (email.isBlank() || senha.isBlank()) {
            return "Email e senha devem ser preenchidos."
        }

        val validadorEmail = ValidadorEmail()
        if (!validadorEmail.validar(email)) {
            return "Email inválido."
        }

        // Autentica o usuário no repositório
        val usuario: Usuario? = UsuarioRepositorio.autenticar(email, senha)

        return if (usuario != null) {
            "Login realizado com sucesso."
        } else {
            "Email ou senha incorretos."
        }
    }
}