package fr.epsi.mspr_1_app_mobil

import android.os.Bundle
import android.widget.ImageView
import com.squareup.picasso.Picasso

class MaterialsActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_materials)
        showBtnBack()
        intent.getStringExtra("title")?.let { setHeaderTitle(it) }
        val imageViewAgent = findViewById<ImageView>(R.id.imageViewAgent)
        val urlImage= intent.getStringExtra("urlImage")
        Picasso.get().load(urlImage).into(imageViewAgent)
    }
}