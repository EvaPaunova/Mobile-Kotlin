package evapaunova.example.com.dominoskotlin

import android.content.Context
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import evapaunova.example.com.dominoskotlin.model.Restaurant
import kotlinx.android.synthetic.main.restaurant_row.view.*
import java.util.ArrayList

class RestaurantsAdapter (val restaurants: ArrayList<Restaurant>, val context: Context) : RecyclerView.Adapter<RestaurantViewHolder>() {


    override fun getItemCount(): Int {
        return restaurants.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        val li = LayoutInflater.from(context)
        val row = li.inflate(R.layout.restaurant_row, parent, false)
        return RestaurantViewHolder(row)
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        val restaurant = restaurants[position]
        val bundle = Bundle()
        bundle.putSerializable("pizza", restaurant)

        holder.name.text = restaurant.name
        holder.address.text = restaurant.address
        holder.phoneNumber.text = restaurant.phoneNumber
    }

}

class RestaurantViewHolder(v: View) : RecyclerView.ViewHolder(v) {

    val name = v.restaurant_name
    val address = v.res_address
    val phoneNumber = v.res_phone


}
