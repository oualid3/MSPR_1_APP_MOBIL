package fr.epsi.mspr_1_app_mobil

import android.os.Bundle
import android.widget.ImageView
import com.squareup.picasso.Picasso
import android.content.Intent




class AgentActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_materials)
        showBtnBack()

        setHeaderTitle("Agent")
        intent.getSerializableExtra("agent")?.let { it -> {
            val agent: Agent = it as Agent
            val imageViewAgent = findViewById<ImageView>(R.id.imageViewAgent)
            Picasso.get().load("frosty.thebault.pro/"+agent.picture_url).into(imageViewAgent)
        } }
        //https://androidexample.com/create-a-simple-listview

    }
}