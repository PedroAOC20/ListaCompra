package com.example.lista_compra.ListaList

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lista_compra.R
import com.example.myapplication.model.Listas

class AdapterLista(private val context: Context, val list_listas: ArrayList<Listas>): RecyclerView.Adapter<AdapterLista.ListasViewHolder>() {

    inner class ListasViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val foto = itemView.findViewById<ImageView>(R.id.foto)
        val nome = itemView.findViewById<TextView>(R.id.nomeProduto)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListasViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val l = LayoutInflater.from(context).inflate(R.layout.activity_lista_list,parent,false)
        return ListasViewHolder(l)
    }

    override fun getItemCount(): Int {
        return list_listas.size
    }

    override fun onBindViewHolder(holder: ListasViewHolder, position: Int) {
        val newList = list_listas[position]
        holder.foto.setImageURI(newList.foto)
        holder.nome.text = newList.nome
    }
}