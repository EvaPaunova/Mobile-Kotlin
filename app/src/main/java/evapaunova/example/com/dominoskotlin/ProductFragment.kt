package evapaunova.example.com.dominoskotlin

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import evapaunova.example.com.dominoskotlin.model.Pizza
import java.text.DecimalFormat


class ProductFragment : Fragment() {

    private val precision = DecimalFormat("0.00")


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_product, container, false)
        val pizza = arguments?.getSerializable("pizza") as Pizza

        val name:TextView = root.findViewById(R.id.pizza_name)
        name.setText(pizza.name)

        val image:ImageView  = root.findViewById(R.id.pizza_image)
        image.setImageResource(pizza.img)

        val ingredients:TextView  = root.findViewById(R.id.pizza_ingredients)
        val ingred = StringBuilder()
        for (i in 0 until pizza!!.getIngredients().size) {
            if (i != pizza.getIngredients().size - 1) {
                ingred.append(pizza.getIngredients().get(i) + ", ")
            } else {
                ingred.append(pizza.getIngredients().get(i))
            }
        }
        ingredients.setText(ingred.toString())

        val price:TextView = root.findViewById(R.id.pizza_price)
        price.setText("${precision.format(pizza.price)} BGN")

        return root
    }

}// Required empty public constructor
