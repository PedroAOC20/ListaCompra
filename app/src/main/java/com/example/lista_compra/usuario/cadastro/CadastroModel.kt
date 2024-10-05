package com.example.lista_compra.usuario.cadastro

import com.example.lista_compra.usuario.modelo.Usuario
import com.example.lista_compra.usuario.repositorio.UsuarioRepositorio
import com.example.lista_compra.usuario.util.ValidadorEmail
import com.example.lista_compra.usuario.util.ValidadorSenha

class CadastroModel {
    private val validadorEmail = ValidadorEmail()
    private val validadorSenha = ValidadorSenha()

    fun cadastrarUsuario(nome: String, email: String, senha: String, confirmacaoSenha: String): String {

        // Valida se os campos estão preenchidos
        if (nome.isBlank() || email.isBlank() || senha.isBlank() || confirmacaoSenha.isBlank()) {
            return "Todos os campos devem ser preenchidos."
        }

        // Valida o formato do email
        if (!validadorEmail.validar(email)) {
            return "Email inválido."
        }

        // Verifica se a senha e a confirmação são iguais
        if (senha != confirmacaoSenha) {
            return "As senhas não coincidem."
        }

        // Valida a senha
        if (!validadorSenha.validar(senha)) {
            return "A senha deve ter pelo menos 3 caracteres e incluir letras e números."
        }

        // Cria um novo usuário
        val usuario = Usuario(nome, email, senha)

        // Tenta cadastrar o usuário no repositório
        return if (UsuarioRepositorio.cadastrar(usuario)) {
            "Cadastro realizado com sucesso."
        } else {
            "Email já cadastrado."
        }
    }
}