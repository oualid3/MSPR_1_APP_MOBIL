package fr.epsi.mspr_1_app_mobil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import com.google.android.material.button.MaterialButton
import okhttp3.*
import org.json.JSONObject
import java.io.IOException
import java.lang.Exception

class LoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val i = intent
        val agentUrl = i.getStringExtra("agentUrl")
        showBtnBack()

        val username = findViewById<View>(R.id.username) as TextView
        val password = findViewById<View>(R.id.password) as TextView
        val loginbtn = findViewById<View>(R.id.loginbtn) as MaterialButton

        //admin and admin
        loginbtn.setOnClickListener {

            val okHttpClient: OkHttpClient = OkHttpClient.Builder().build()
            val mRequestURL = "http://frosty.thebault.pro/$agentUrl"
            val basicToken = Credentials.basic(username.text.toString(), password.text.toString())
            val request = Request.Builder()
                .url(mRequestURL)
                .addHeader("Authorization", basicToken)
                .get()
                .cacheControl(CacheControl.FORCE_NETWORK)
                .build()

            okHttpClient.newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    e.printStackTrace()
                }
                //{"agent":{
                // "prenom":"Ayano",
                // "nom":"Aishi",
                // "mission":"Surveillante entrepôt",
                // "image":"aaishi/image.png",
                // "materiel":[
                //      {"key":"kit","value":"Kit oreilette"},
                //      {"key":"lacrymo","value":"Bombes lacrymogène"},
                //      {"key":"lampe","value":"Lampe Torche"}
                //      ]
                // }}
                override fun onResponse(call: Call, response: Response) {
                    Log.d("response",response.toString())
                    val data = response.body?.string()
                    if (data != null) {
                        try {
                            val jsAgent = JSONObject(data).getJSONObject("agent")

                            val prenom = jsAgent.getString("prenom")
                            val nom = jsAgent.getString("nom")
                            val mission = jsAgent.getString("mission")
                            val imageUrl = jsAgent.getString("image")
                            val jsMaterielArr = jsAgent.getJSONArray("materiel")

                            val equipements = ArrayList<String>()
                            for (i in 0 until jsMaterielArr.length()) {
                                val jsMaterielObj = jsMaterielArr.getJSONObject(i)
                                val cle = jsMaterielObj.getString("key")
                                val valeur = jsMaterielObj.optString("value","")
                                if(cle.equals(valeur)){
                                    equipements.add(cle)
                                } else {
                                    equipements.add(valeur)
                                }
                            }
                            val agent = Agent(prenom = prenom, nom = nom,mission = mission, picture_url = imageUrl, basicToken = basicToken, materiel = equipements)
                            val newIntent= Intent(application,AgentActivity::class.java)
                            newIntent.putExtra("agent",agent)
                            startActivity(newIntent)
                        } catch (e: Exception){
                            Log.d("Réponse incorrecte",e.printStackTrace().toString())
                            showToast("Login incorrect")
                        }
                    }
                }
            })
        }
    }
}