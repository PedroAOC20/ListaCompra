package com.example.lista_compra.usuario.util

class ValidadorEmail {

    fun validar(email: String): Boolean {
        // Expressão regular para validar o formato do email
        val regex = Regex("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\$")

        return regex.matches(email)
    }
}