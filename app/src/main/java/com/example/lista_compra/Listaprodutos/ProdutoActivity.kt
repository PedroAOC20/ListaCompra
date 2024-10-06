package com.example.lista_compra.Listaprodutos

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lista_compra.R

class ProdutoActivity : AppCompatActivity() {
    private lateinit var btn_produto: Button
    private lateinit var recyclep: RecyclerView
    private lateinit var produtoList: ArrayList<Produtos>
    private lateinit var produtoAdapter: ProdutoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_produto)
        btn_produto = findViewById(R.id.btn_addproduto)
        recyclep = findViewById(R.id.recyclerViewProduto)
        produtoList = ArrayList()
        produtoAdapter = ProdutoAdapter(this, produtoList)
        recyclep.layoutManager = LinearLayoutManager(this)
        recyclep.adapter = produtoAdapter
        btn_produto.setOnClickListener { addInfo() }
    }

    private fun addInfo() {
        val inflater = LayoutInflater.from(this)
        val l = inflater.inflate(R.layout.add_produto, null)
        val nomeproduto = l.findViewById<EditText>(R.id.nomeproduto)
        val unidade = l.findViewById<EditText>(R.id.produtouni)
        val qtd = l.findViewById<EditText>(R.id.quantidadet)
        val category = l.findViewById<EditText>(R.id.categoria)
        val dialogo = AlertDialog.Builder(this)
        dialogo.setNegativeButton("Cancelar") { dialog, _ ->
            dialog.dismiss()
        }
        dialogo.setPositiveButton("Ok") { dialog, _ ->
            val names = nomeproduto.text.toString()
            val unidades = unidade.text.toString()
            val quantidade = qtd.text.toString()
            val categoria = category.text.toString()
            produtoList.add(Produtos(names, quantidade, unidades, categoria))
            produtoAdapter.notifyDataSetChanged()
            dialog.dismiss()
        }
        dialogo.setView(l)
        dialogo.create()
        dialogo.show()
    }
}

