package fr.epsi.mspr_1_app_mobil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import fr.epsi.mspr_1_app_mobil.R
import android.widget.TextView
import com.google.android.material.button.MaterialButton
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val username = findViewById<View>(R.id.username) as TextView
        val password = findViewById<View>(R.id.password) as TextView
        val loginbtn = findViewById<View>(R.id.loginbtn) as MaterialButton

        //admin and admin
        loginbtn.setOnClickListener {
            if (username.text.toString() == getString(R.string.Agent1) && password.text.toString() == "admin") {
                //correct
                Toast.makeText(this@LoginActivity, "LOGIN SUCCESSFUL", Toast.LENGTH_SHORT).show()
                val newIntent= Intent(application,AgentActivity::class.java)
                newIntent.putExtra("title",getString(R.string.Agent1))
//                newIntent.putExtra("urlImage","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcROFiHOkKUHVBF3TcyU1NgawBlIV9mIoSGAuA&usqp=CAU")
                startActivity(newIntent)
            } else if (username.text.toString() == getString(R.string.Agent2) && password.text.toString() == "admin2") {
                //correct
                Toast.makeText(this@LoginActivity, "LOGIN SUCCESSFUL", Toast.LENGTH_SHORT).show()
                val newIntent= Intent(application,AgentActivity::class.java)
                newIntent.putExtra("title",getString(R.string.Agent2))
//                newIntent.putExtra("urlImage","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcROFiHOkKUHVBF3TcyU1NgawBlIV9mIoSGAuA&usqp=CAU")
                startActivity(newIntent)
            }
            else  //incorrect
                Toast.makeText(this@LoginActivity, "LOGIN FAILED !!!", Toast.LENGTH_SHORT).show()
        }
    }
}