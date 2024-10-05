package com.example.lista_compra.usuario.modelo

data class Usuario(
    val nome: String,
    val email: String,
    val senha: String
)

object UsuarioRepositorio {
    private val usuarios = mutableListOf<Usuario>()

    fun cadastrar(usuario: Usuario): Boolean {
        // Verifica se o email já está cadastrado
        if (usuarios.any { it.email == usuario.email }) {
            return false // Email já cadastrado
        }
        // Adiciona o usuário à lista
        usuarios.add(usuario)
        return true
    }

    fun autenticar(email: String, senha: String): Usuario? {
        return usuarios.find { it.email == email && it.senha == senha }
    }
}