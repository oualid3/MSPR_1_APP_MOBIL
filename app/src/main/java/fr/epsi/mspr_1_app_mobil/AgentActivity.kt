package fr.epsi.mspr_1_app_mobil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class AgentActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agent)
        showBtnBack()
        intent.getStringExtra("title")?.let { setHeaderTitle(it) }
//        val imageViewDetail = findViewById<ImageView>(R.id.imageViewDetail)
//        val urlImage= intent.getStringExtra("urlImage")
//        Picasso.get().load(urlImage).into(imageViewDetail)
    }
}