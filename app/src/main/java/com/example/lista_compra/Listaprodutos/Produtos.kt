package com.example.lista_compra.Listaprodutos

class Produtos {
    data class Listas(
        val name: String,
        val qtd: Int,
        val unidade: Int,
        val categoria: String,
    )
}