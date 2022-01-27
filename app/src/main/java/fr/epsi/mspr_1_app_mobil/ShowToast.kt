package fr.epsi.mspr_1_app_mobil

import android.app.Application
import android.widget.Toast

class ShowToast : Application(){

    fun showToast(txt : String){
        Toast.makeText(this,txt,Toast.LENGTH_SHORT).show()
    }

}