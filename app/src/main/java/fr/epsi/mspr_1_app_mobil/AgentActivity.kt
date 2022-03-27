package fr.epsi.mspr_1_app_mobil

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import com.squareup.picasso.Picasso

import okhttp3.Interceptor

import okhttp3.OkHttpClient
import okhttp3.Request
import com.squareup.picasso.OkHttp3Downloader
import android.widget.ArrayAdapter

class AgentActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agent)
        showBtnBack()

        setHeaderTitle("Agent")
        val agent: Agent? = intent.getSerializableExtra("agent") as Agent?
        if (agent != null) {
            val textViewAgentPrenom = findViewById<TextView>(R.id.textViewAgentPrenom)
            val textViewAgentNom = findViewById<TextView>(R.id.textViewAgentNom)
            val textViewAgentMission = findViewById<TextView>(R.id.textViewAgentMission)
            val imageViewAgent = findViewById<ImageView>(R.id.imageViewAgent)
            val listViewMateriel = findViewById<ListView>(R.id.listMateriel)
            textViewAgentPrenom.text = agent.prenom
            textViewAgentNom.text = agent.nom
            textViewAgentMission.text = agent.mission

            val client: OkHttpClient = OkHttpClient.Builder()
                .addInterceptor(Interceptor { chain ->
                    val newRequest: Request = chain.request().newBuilder()
                        .addHeader("Authorization", agent.basicToken)
                        .build()
                    chain.proceed(newRequest)
                }).build()
            val picasso = Picasso.Builder(this)
                .downloader(OkHttp3Downloader(client))
                .build()
            picasso.load("http://frosty.thebault.pro/"+agent.picture_url).into(imageViewAgent)

            val materielAdapter: ArrayAdapter<String> = ArrayAdapter<String>(this,R.layout.materiel_list_item,agent.materiel.toList())

            listViewMateriel.adapter = materielAdapter
//            listViewMateriel.onItemClickListener = OnItemClickListener { parent, view, position, id ->
//                val itemValue = listViewMateriel.getItemAtPosition(position) as String
//                Toast.makeText(applicationContext,"Position :$position  ListItem : $itemValue", Toast.LENGTH_LONG).show()
//            }
        }

    }
}