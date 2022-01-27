package fr.epsi.mspr_1_app_mobil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buttonAgent1: Button = findViewById(R.id.buttonAgent1)
        val buttonAgent2: Button = findViewById(R.id.buttonAgent2)
        val buttonAgent3: Button = findViewById(R.id.buttonAgent3)
        val buttonAgent4: Button = findViewById(R.id.buttonAgent4)
        val buttonAgent5: Button = findViewById(R.id.buttonAgent5)
        val buttonAgent6: Button = findViewById(R.id.buttonAgent6)
        val buttonAgent7: Button = findViewById(R.id.buttonAgent7)
        val buttonAgent8: Button = findViewById(R.id.buttonAgent8)
        val buttonAgent9: Button = findViewById(R.id.buttonAgent9)
        val buttonAgent10: Button = findViewById(R.id.buttonAgent10)
        val buttonAgent11: Button = findViewById(R.id.buttonAgent11)

//        (application as AppEpsi).showToast("Hello Epsi")

        buttonAgent1.setOnClickListener(View.OnClickListener {
            val newIntent= Intent(application,LoginActivity::class.java)
            newIntent.putExtra("title",getString(R.string.Agent1))
            newIntent.putExtra("urlImage","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcROFiHOkKUHVBF3TcyU1NgawBlIV9mIoSGAuA&usqp=CAU")
            startActivity(newIntent)
        })

        buttonAgent2.setOnClickListener(View.OnClickListener {
            val newIntent= Intent(application,LoginActivity::class.java)
            //TEXTE HEADER
            newIntent.putExtra("title",getString(R.string.Agent2))
            //CARTE IDENTITÉ
            newIntent.putExtra("urlImage","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQkkZFu63Vi0djeAwcj0d7aaEgBsS1eHpGLbw&usqp=CAU")
            startActivity(newIntent)
        })

        buttonAgent3.setOnClickListener(View.OnClickListener {
            val newIntent= Intent(application,LoginActivity::class.java)
            //TEXTE HEADER
            newIntent.putExtra("title",getString(R.string.Agent3))
            //CARTE IDENTITÉ
            newIntent.putExtra("urlImage","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQkkZFu63Vi0djeAwcj0d7aaEgBsS1eHpGLbw&usqp=CAU")
            startActivity(newIntent)
        })

        buttonAgent4.setOnClickListener(View.OnClickListener {
            val newIntent= Intent(application,LoginActivity::class.java)
            //TEXTE HEADER
            newIntent.putExtra("title",getString(R.string.Agent4))
            //CARTE IDENTITÉ
            newIntent.putExtra("urlImage","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQkkZFu63Vi0djeAwcj0d7aaEgBsS1eHpGLbw&usqp=CAU")
            startActivity(newIntent)
        })

        buttonAgent5.setOnClickListener(View.OnClickListener {
            val newIntent= Intent(application,LoginActivity::class.java)
            //TEXTE HEADER
            newIntent.putExtra("title",getString(R.string.Agent5))
            //CARTE IDENTITÉ
            newIntent.putExtra("urlImage","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQkkZFu63Vi0djeAwcj0d7aaEgBsS1eHpGLbw&usqp=CAU")
            startActivity(newIntent)
        })

        buttonAgent6.setOnClickListener(View.OnClickListener {
            val newIntent= Intent(application,LoginActivity::class.java)
            //TEXTE HEADER
            newIntent.putExtra("title",getString(R.string.Agent6))
            //CARTE IDENTITÉ
            newIntent.putExtra("urlImage","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQkkZFu63Vi0djeAwcj0d7aaEgBsS1eHpGLbw&usqp=CAU")
            startActivity(newIntent)
        })

        buttonAgent7.setOnClickListener(View.OnClickListener {
            val newIntent= Intent(application,LoginActivity::class.java)
            //TEXTE HEADER
            newIntent.putExtra("title",getString(R.string.Agent7))
            //CARTE IDENTITÉ
            newIntent.putExtra("urlImage","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQkkZFu63Vi0djeAwcj0d7aaEgBsS1eHpGLbw&usqp=CAU")
            startActivity(newIntent)
        })

        buttonAgent8.setOnClickListener(View.OnClickListener {
            val newIntent= Intent(application,LoginActivity::class.java)
            //TEXTE HEADER
            newIntent.putExtra("title",getString(R.string.Agent8))
            //CARTE IDENTITÉ
            newIntent.putExtra("urlImage","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQkkZFu63Vi0djeAwcj0d7aaEgBsS1eHpGLbw&usqp=CAU")
            startActivity(newIntent)
        })
        buttonAgent9.setOnClickListener(View.OnClickListener {
            val newIntent= Intent(application,LoginActivity::class.java)
            //TEXTE HEADER
            newIntent.putExtra("title",getString(R.string.Agent9))
            //CARTE IDENTITÉ
            newIntent.putExtra("urlImage","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQkkZFu63Vi0djeAwcj0d7aaEgBsS1eHpGLbw&usqp=CAU")
            startActivity(newIntent)
        })
        buttonAgent10.setOnClickListener(View.OnClickListener {
            val newIntent= Intent(application,LoginActivity::class.java)
            //TEXTE HEADER
            newIntent.putExtra("title",getString(R.string.Agent10))
            //CARTE IDENTITÉ
            newIntent.putExtra("urlImage","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQkkZFu63Vi0djeAwcj0d7aaEgBsS1eHpGLbw&usqp=CAU")
            startActivity(newIntent)
        })
        buttonAgent11.setOnClickListener(View.OnClickListener {
            val newIntent= Intent(application,LoginActivity::class.java)
            //TEXTE HEADER
            newIntent.putExtra("title",getString(R.string.Agent11))
            //CARTE IDENTITÉ
            newIntent.putExtra("urlImage","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQkkZFu63Vi0djeAwcj0d7aaEgBsS1eHpGLbw&usqp=CAU")
            startActivity(newIntent)
        })
    }
}