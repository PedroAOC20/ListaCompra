package com.example.lista_compra.usuario.util

class ValidadorSenha {
    fun validar(senha: String): Boolean {
        if (senha.length <= 3) {
            return false
        }

        val hasLetter = senha.any { it.isLetter() }
        val hasDigit = senha.any { it.isDigit() }

        return hasLetter && hasDigit
    }
}