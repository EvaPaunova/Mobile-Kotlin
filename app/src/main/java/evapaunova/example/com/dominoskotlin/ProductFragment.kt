package evapaunova.example.com.dominoskotlin

import android.app.DatePickerDialog
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import evapaunova.example.com.dominoskotlin.model.Pizza
import java.text.DecimalFormat
import kotlinx.android.synthetic.main.fragment_product.*
import java.text.SimpleDateFormat
import java.util.*

class ProductFragment : Fragment() {

    private val precision = DecimalFormat("0.00")

    private lateinit var name:TextView
    private lateinit var image:ImageView
    private lateinit var ingredients:TextView
    private lateinit var price:TextView
    private lateinit var order: ImageButton
    private lateinit var button_date: ImageButton
    private lateinit var textview_date: TextView
    private var cal = Calendar.getInstance()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_product, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        val pizza = arguments?.getSerializable("pizza") as Pizza

        name = pizza_name
        name.text = pizza.name

        image = pizza_image
        image.setImageResource(pizza.img)

        ingredients= pizza_ingredients
        val ingred = StringBuilder()
        for (i in 0 until pizza!!.getIngredients().size) {
            if (i != pizza.getIngredients().size - 1) {
                ingred.append(pizza.getIngredients().get(i) + ", ")
            } else {
                ingred.append(pizza.getIngredients().get(i))
            }
        }
        ingredients.text = ingred.toString()

        price = pizza_price
        price.text = "${precision.format(pizza.price)} BGN"

        order = add_to_cart
        order.setOnClickListener(View.OnClickListener {
            Toast.makeText(this.context, "Добави в количката " + pizza.name, Toast.LENGTH_SHORT).show()
        })


        textview_date = date
        button_date = calendar_button

        textview_date.text = "--/--/----"


        val dateSetListener = object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(view: DatePicker, year: Int, monthOfYear: Int,
                                   dayOfMonth: Int) {
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                updateDateInView()
            }
        }


        val picker = DatePickerDialog(context,
                dateSetListener,
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH))
        picker.datePicker.setMinDate(System.currentTimeMillis())

        button_date!!.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                picker.show()
            }

        })

    }

    private fun updateDateInView() {
        val myFormat = "MM/dd/yyyy"
        val sdf = SimpleDateFormat(myFormat, Locale.US)
        textview_date.text = sdf.format(cal.getTime())
    }

}
