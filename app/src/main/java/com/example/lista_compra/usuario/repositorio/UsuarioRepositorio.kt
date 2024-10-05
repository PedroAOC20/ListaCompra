package com.example.lista_compra.usuario.repositorio

import com.example.lista_compra.usuario.modelo.Usuario
import java.util.concurrent.CopyOnWriteArrayList

object UsuarioRepositorio {
    private val usuarios = CopyOnWriteArrayList <Usuario>()

    init {
        // Usuario admin = Mock
        usuarios.add(Usuario("Admin", "admin@admin.com", "admin123"))
    }

    fun cadastrar(usuario: Usuario): Boolean {
        // Verifica se o email já está cadastrado
        if (usuarios.any { it.email == usuario.email }) {
            return false
        }
        usuarios.add(usuario)
        return true
    }

    fun autenticar(email: String, senha: String): Usuario? {
        return usuarios.find { it.email == email && it.senha == senha }
    }
}