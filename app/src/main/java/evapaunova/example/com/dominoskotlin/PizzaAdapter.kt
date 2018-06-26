package evapaunova.example.com.dominoskotlin

import android.content.Context
import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import evapaunova.example.com.dominoskotlin.model.Pizza
import kotlinx.android.synthetic.main.pizza_row.view.*
import java.text.DecimalFormat
import java.util.ArrayList

class PizzaAdapter(val pizzas: ArrayList<Pizza>, val context: Context) : RecyclerView.Adapter<PizzaViewHolder>() {

    private val precision = DecimalFormat("0.00")

    override fun getItemCount(): Int {
        return pizzas.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PizzaViewHolder {
        val li = LayoutInflater.from(context)
        val row = li.inflate(R.layout.pizza_row, parent, false)
        return PizzaViewHolder(row)
    }

    override fun onBindViewHolder(holder: PizzaViewHolder, position: Int) {
        val pizza = pizzas[position]
        val bundle = Bundle()
        bundle.putSerializable("pizza", pizza)

        holder.name.text = pizza.name
        holder.price.text = precision.format(pizza.price) + " " + "BGN"
        val ingred = StringBuilder()
        for (i in 0 until pizza.getIngredients().size) {
            if (i != pizza.getIngredients().size - 1) {
                ingred.append(pizza.getIngredients().get(i) + ", ")
            } else {
                ingred.append(pizza.getIngredients().get(i))
            }
        }
        holder.ingredients.text = ingred.toString()
        holder.image.setImageResource(pizza.img)

        holder.orderButton.setOnClickListener { Toast.makeText(context, "Добави в количката " + pizza.name, Toast.LENGTH_SHORT).show() }

        holder.infoButton.setOnClickListener {
            val details = ProductFragment()
            details.arguments = bundle
            val fm = (context as AppCompatActivity).supportFragmentManager
            val transaction = fm.beginTransaction()
            fm.popBackStack("pizza", FragmentManager.POP_BACK_STACK_INCLUSIVE)
            if (context.findViewById(R.id.parent_view_p) as View? != null) {
                transaction
                        .replace(R.id.parent_view_p, details, "fr")

            } else if (context.findViewById(R.id.parent_view_l) as View? != null) {
                val datailsFragment = fm.findFragmentByTag("det")
                if (datailsFragment == null) {
                    transaction
                            .add(R.id.parent_view_l, details, "det")
                } else {
                    transaction
                            .remove(datailsFragment)
                            .add(R.id.parent_view_l, details, "det")
                }

            }
            transaction
                    .addToBackStack("pizza")
                    .commit()
        }

    }

}

class PizzaViewHolder(v: View) : RecyclerView.ViewHolder(v) {

    val image = v.pizza_image
    val name = v.pizza_name
    val price = v.pizza_price
    val ingredients = v.pizza_ingredients
    val orderButton = v.button_order
    val infoButton = v.pizza_dough

}
