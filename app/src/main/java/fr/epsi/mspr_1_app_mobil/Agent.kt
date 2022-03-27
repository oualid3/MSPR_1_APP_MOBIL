package fr.epsi.mspr_1_app_mobil

import java.io.Serializable

class Agent (val prenom: String, val nom: String, val mission: String, val picture_url: String, val materiel: Collection<String>): Serializable{
}