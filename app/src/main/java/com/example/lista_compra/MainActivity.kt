
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lista_compra.R
import com.example.lista_compra.gerenciador_lista_compra.ListaListActivity
import com.example.lista_compra.usuario.login.LoginActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Navega para a LoginActivity
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()

        val intent2 = Intent(this, ListaListActivity::class.java)
        startActivity(intent2)
        finish()
    }
}