package fr.epsi.mspr_1_app_mobil

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val Agents = arrayListOf<AgentListElement>()
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewAgent)

        recyclerView.layoutManager = LinearLayoutManager(this)
        val agentAdapter = AgentListElementAdapter(Agents)
        recyclerView.adapter = agentAdapter

        val okHttpClient: OkHttpClient = OkHttpClient.Builder().build()
        val mRequestURL ="http://frosty.thebault.pro/index.json"
        val request = Request.Builder()
            .url(mRequestURL)
            .get()
            .cacheControl(CacheControl.FORCE_NETWORK)
            .build()

        okHttpClient.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
            }

            override fun onResponse(call: Call, response: Response) {
                val data = response.body?.string()
                print(data)
                if(data !=null){
                    val jsOb= JSONObject(data)
                    val jsArray =jsOb.getJSONArray("agents")
                    for(i in 0 until jsArray.length()){
                        val jsAgents = jsArray.getJSONObject(i)
                        val fullname =jsAgents.optString("fullname","")
                        val agentUrl =jsAgents.optString("agentUrl","")
                        val agent = AgentListElement(fullname = fullname, agentUrl = agentUrl)
                        Agents.add(agent)
                    }
                    runOnUiThread( {
                        agentAdapter.notifyDataSetChanged()
                    })
                }
            }
        })
    }
}