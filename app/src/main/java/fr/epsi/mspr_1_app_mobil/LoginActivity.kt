package fr.epsi.mspr_1_app_mobil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.google.android.material.button.MaterialButton
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import okhttp3.*
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val i = intent
        val agentUrl = i.getStringExtra("agentUrl")
        val materials = arrayListOf<Material>()
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewMaterial)

        recyclerView.layoutManager = LinearLayoutManager(this)
        val materialsAdapter = MaterialAdapter(materials)
        recyclerView.adapter = materialsAdapter

        val username = findViewById<View>(R.id.username) as TextView
        val password = findViewById<View>(R.id.password) as TextView
        val loginbtn = findViewById<View>(R.id.loginbtn) as MaterialButton

        //admin and admin
        loginbtn.setOnClickListener {

            val okHttpClient: OkHttpClient = OkHttpClient.Builder().build()
            val mRequestURL = "http://frosty.thebault.pro/" + agentUrl
            print(mRequestURL)
            val request = Request.Builder()
                .url(mRequestURL)
                .addHeader("Authorization", Credentials.basic(username.text.toString(), password.text.toString()))
                .get()
                .cacheControl(CacheControl.FORCE_NETWORK)
                .build()

            okHttpClient.newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    e.printStackTrace()
                }

                override fun onResponse(call: Call, response: Response) {
                    print(response)
                    val data = response.body?.string()
                    if (data != null) {
                        val jsOb = JSONObject(data)
                        val jsArray = jsOb.getJSONArray("agents")
                        for (i in 0 until jsArray.length()) {
                            val jsMaterial = jsArray.getJSONObject(i)
                            val prenom = jsMaterial.optString("prenom", "")
                            val nom = jsMaterial.optString("nom", "")
                            val mission = jsMaterial.optString("mission", "")
                            val imageUrl = jsMaterial.optString("image", "")
                            val material = Material(prenom = prenom, nom = nom, mission = mission, picture_url = imageUrl)
                            materials.add(material)
                        }
                        runOnUiThread(Runnable {
                            materialsAdapter.notifyDataSetChanged()
                        })
                    }
                }
            })
        }
    }
}

//            if (username.text.toString() == getString(R.string.Agent1) && password.text.toString() == "admin") {
//                //correct
//                Toast.makeText(this@LoginActivity, "LOGIN SUCCESSFUL", Toast.LENGTH_SHORT).show()
//                val newIntent= Intent(application,MaterialsActivity::class.java)
//                newIntent.putExtra("title",getString(R.string.Agent1))
//                startActivity(newIntent)
//            } else if (username.text.toString() == getString(R.string.Agent2) && password.text.toString() == "admin2") {
//                //correct
//                Toast.makeText(this@LoginActivity, "LOGIN SUCCESSFUL", Toast.LENGTH_SHORT).show()
//                val newIntent= Intent(application,MaterialsActivity::class.java)
//                newIntent.putExtra("title",getString(R.string.Agent2))
//                startActivity(newIntent)
//            }
//            else  //incorrect
//                Toast.makeText(this@LoginActivity, "LOGIN FAILED !!!", Toast.LENGTH_SHORT).show()