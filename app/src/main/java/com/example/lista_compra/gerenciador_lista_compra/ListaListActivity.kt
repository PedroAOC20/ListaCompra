package com.example.lista_compra.gerenciador_lista_compra

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lista_compra.ListaList.AdapterLista
import com.example.lista_compra.R
import com.example.lista_compra.databinding.ActivityListaListBinding
import com.example.lista_compra.usuario.login.LoginActivity
import com.example.myapplication.model.Listas
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListaListActivity : AppCompatActivity() {
    private lateinit var addsbtn: FloatingActionButton
    private lateinit var recyclerView: RecyclerView
    private lateinit var list_Lista: ArrayList<Listas>
    private lateinit var list_adapter: AdapterLista
    private var imageView: Uri? = null
    private lateinit var btnimagem: Button
    private lateinit var binding: ActivityListaListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityListaListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.lista_list_activity)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Configurando o clique do botão de logout
        binding.botaoLogoutf.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish() // Finaliza a atividade atual
        }

        val recyclerView_Listas = findViewById<RecyclerView>(R.id.activity_recycleview_listlistas)
        recyclerView_Listas.layoutManager = LinearLayoutManager(this)

        val adapterLista = AdapterLista(this, list_Lista)
        recyclerView_Listas.adapter = adapterLista


        lateinit var binding = ActivityListaListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        addsbtn = findViewById(R.id.addingbtn)
        list_Lista = ArrayList()
        addsbtn.setOnClickListener{addInfo()}
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = list_adapter
    }

    fun pickImage() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, image_request)

    }


    companion object{
        const val image_request = 100
    }

    private fun addInfo() {
        val infltr = LayoutInflater.from(this)
        val v = infltr.inflate(R.layout.activity_add_lista,null)
        val dialogo = AlertDialog.Builder(this)
        val nome_lista = v.findViewById<EditText>(R.id.inputname)
        val imagem_lista = v.findViewById<ImageView>(R.id.inputimage)
        val btnimagem = v.findViewById<Button>(R.id.btn_img)

        btnimagem.setOnClickListener{
            pickImage()
        }

        dialogo.setView(v)
        dialogo.setPositiveButton("Concluido"){
                dialog,_->
            val names = nome_lista.text.toString()
            val imagens = imageView
            Toast.makeText(this, "Adicionando", Toast.LENGTH_SHORT ).show()
            list_Lista.add(Listas("Foto = $imagens", "Nome = $names"))
        }
        dialogo.setNegativeButton("Cancelar"){
                dialog,_->
            dialog.dismiss()
            Toast.makeText(this, "Cancelando", Toast.LENGTH_SHORT ).show()
        }
        dialogo.create()
        dialogo.show()


        override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)
            if(requestCode == image_request && resultCode == RESULT_OK){
                val SelectedImage = data?.data
                imageView = SelectedImage
                imagem_lista.setImageURI(SelectedImage)
            }
        }
    }
}