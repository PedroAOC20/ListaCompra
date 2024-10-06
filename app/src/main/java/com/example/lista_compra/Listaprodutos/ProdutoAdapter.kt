package com.example.lista_compra.Listaprodutos

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lista_compra.R
import androidx.appcompat.app.AppCompatActivity


class ProdutoAdapter(val c: Context, val list_produto: ArrayList<Produtos>): RecyclerView.Adapter<ProdutoAdapter.ProdutosViewHolder>() {

    inner class ProdutosViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nome = itemView.findViewById<TextView>(R.id.produtosa)
        val qtd = itemView.findViewById<TextView>(R.id.produtouni)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdutosViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val l = inflater.inflate(R.layout.activity_recycleview_listproduto,parent,false  )
        return ProdutosViewHolder(l)
    }

    override fun onBindViewHolder(holder: ProdutosViewHolder, position: Int) {
        val newList = list_produto[position]
        holder.nome.text = newList.nome
        holder

    }

    override fun getItemCount(): Int {
        return list_produto.size
    }

}