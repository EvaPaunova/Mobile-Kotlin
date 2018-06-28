package evapaunova.example.com.dominoskotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.ActionBar
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.TextView
import evapaunova.example.com.dominoskotlin.model.Restaurant
import kotlinx.android.synthetic.main.activity_restaurants_list.*

class RestaurantsListActivity : AppCompatActivity() {

    private lateinit var restaurantsView: RecyclerView
    private val restaurants = ArrayList<Restaurant>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurants_list)

        var actionBar = supportActionBar
        actionBar?.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM)
        actionBar?.setCustomView(R.layout.my_layout)
        var textView = actionBar?.customView?.findViewById<TextView>(R.id.titleText)
        textView?.text = resources.getText(R.string.app_restaurants)

        restaurantsView = restaurants_list

        var res1 = Restaurant("ПЛОВДИВ - ТРАКИЯ","ул. Георги Данчов 16","070012525")
        restaurants.add(res1)
        restaurants.add(res1)
        restaurants.add(res1)
        restaurants.add(res1)
        restaurants.add(res1)
        restaurants.add(res1)
        restaurants.add(res1)
        restaurants.add(res1)
        restaurants.add(res1)
        restaurants.add(res1)
        restaurants.add(res1)
        restaurants.add(res1)
        restaurants.add(res1)
        restaurants.add(res1)
        restaurants.add(res1)
        restaurants.add(res1)

        restaurantsView.adapter = RestaurantsAdapter(restaurants, this)
        restaurantsView.layoutManager = LinearLayoutManager(this)
    }


}


