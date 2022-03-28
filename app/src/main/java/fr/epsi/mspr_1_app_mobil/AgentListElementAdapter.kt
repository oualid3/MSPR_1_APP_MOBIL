package fr.epsi.mspr_1_app_mobil

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AgentListElementAdapter (private val agents: ArrayList<AgentListElement>): RecyclerView.Adapter<AgentListElementAdapter.ViewHolder>(){

    class ViewHolder (view: View) : RecyclerView.ViewHolder(view){
        val textViewAgentName = view.findViewById<TextView>(R.id.textViewAgentName)
        val contentLayout = view.findViewById<LinearLayout>(R.id.contentLayout)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.cell_agent, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentAgent = agents.get(position)

        holder.textViewAgentName.text=currentAgent.fullname


        holder.contentLayout.setOnClickListener({
            val activity = holder.itemView.context as Activity
            val newIntent= Intent(activity, LoginActivity::class.java)
            newIntent.putExtra("fullname",currentAgent.fullname)
            newIntent.putExtra("agentUrl",currentAgent.agentUrl)
            activity.startActivity(newIntent)
        })
        /*
        holder.contentLayout.setOnClickListener(View.OnClickListener {
            (holder.contentLayout.context.applicationContext as AppEpsi).showToast(student.name)
        })
        */
    }

    override fun getItemCount(): Int {
        return agents.size
    }
}