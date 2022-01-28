package fr.epsi.mspr_1_app_mobil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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
            if (username.text.toString() == "admin" && password.text.toString() == "admin") {
                //correct
                Toast.makeText(this@LoginActivity, "LOGIN SUCCESSFUL", Toast.LENGTH_SHORT).show()
            } else  //incorrect
                Toast.makeText(this@LoginActivity, "LOGIN FAILED !!!", Toast.LENGTH_SHORT).show()
        }
    }
}