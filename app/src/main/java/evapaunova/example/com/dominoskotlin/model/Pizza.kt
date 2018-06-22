package evapaunova.example.com.dominoskotlin.model

import java.io.Serializable
import java.util.*

class Pizza(val name: String, val price: Double, private val ingredients: ArrayList<String>, val img: Int) : Serializable {

    fun getIngredients(): List<String> {
        return Collections.unmodifiableList(ingredients)
    }
}
