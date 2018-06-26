package evapaunova.example.com.dominoskotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import evapaunova.example.com.dominoskotlin.model.Restaurant
import kotlinx.android.synthetic.main.activity_restaurants_list.*

class RestaurantsListActivity : AppCompatActivity() {

    private lateinit var restaurantsView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurants_list)

        restaurantsView = restaurants_list

        val restaurants = ArrayList<Restaurant>()

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
