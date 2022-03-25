package fr.epsi.mspr_1_app_mobil

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MaterialAdapter (private val materials: ArrayList<Material>): RecyclerView.Adapter<MaterialAdapter.ViewHolder>(){


    class ViewHolder (view: View) : RecyclerView.ViewHolder(view){
        val textViewAgentPrenom = view.findViewById<TextView>(R.id.textViewAgentPrenom)
        val textViewAgentNom = view.findViewById<TextView>(R.id.textViewAgentNom)
        val textViewAgentMission = view.findViewById<TextView>(R.id.textViewAgentMission)
        val imageViewAgent = view.findViewById<ImageView>(R.id.imageViewAgent)
        val contentLayout = view.findViewById<LinearLayout>(R.id.contentLayout)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.cell_material, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentMaterial = materials.get(position)

        holder.textViewAgentPrenom.text=currentMaterial.prenom
        holder.textViewAgentNom.text=currentMaterial.nom
        holder.textViewAgentMission.text=currentMaterial.mission

        Picasso.get().load(currentMaterial.picture_url).into(holder.imageViewAgent)

        holder.contentLayout.setOnClickListener(View.OnClickListener {
            val activity = holder.itemView.context as Activity
            val newIntent= Intent(activity, MaterialsActivity::class.java)
            newIntent.putExtra("prenom",currentMaterial.prenom)
            newIntent.putExtra("name",currentMaterial.nom)
            newIntent.putExtra("mission",currentMaterial.mission)
            newIntent.putExtra("image", "http://frosty.thebault.pro/" + currentMaterial.picture_url)
            activity.startActivity(newIntent)
        })

        /*
        holder.contentLayout.setOnClickListener(View.OnClickListener {
            (holder.contentLayout.context.applicationContext as AppEpsi).showToast(student.name)
        })
        */
    }

    override fun getItemCount(): Int {
        return materials.size
    }
}