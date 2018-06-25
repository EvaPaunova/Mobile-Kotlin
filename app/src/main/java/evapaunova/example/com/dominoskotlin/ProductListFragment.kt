package evapaunova.example.com.dominoskotlin

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import evapaunova.example.com.dominoskotlin.model.Pizza
import java.util.ArrayList
import kotlinx.android.synthetic.main.fragment_product_list.*


class ProductListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var iconView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {


        return inflater.inflate(R.layout.fragment_product_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        recyclerView = pizzaList

        val pizzas = ArrayList<Pizza>()

        val ingDiablo = ArrayList<String>()
        ingDiablo.add("Зехтин, шунка, гъби печурки, люта чушка, кашкавал или моцарела, доматен сос, тесто, риган")
        pizzas.add(Pizza("Диабло", 8.90, ingDiablo, R.drawable.diablo))

        val ingKapreze = ArrayList<String>()
        ingKapreze.add("Чери домати, кашкавал или моцарела, босилек, шунка, чесън, доматен сос, тесто")
        pizzas.add(Pizza("Капрезе", 9.80, ingKapreze, R.drawable.kapreze))

        val ingKatana = ArrayList<String>()
        ingKatana.add("Шунка, бекон, кашкавал или моцарела, маслини без костилка и доматен сос, тесто, риган")
        pizzas.add(Pizza("Катано", 11.80, ingKatana, R.drawable.katana))

        val ingMargarita = ArrayList<String>()
        ingMargarita.add("Зехтин, кашкавал или моцарела, доматен сос, тесто, риган ")
        pizzas.add(Pizza("Маргарита", 5.90, ingMargarita, R.drawable.margarita))

        val ingPeperoni = ArrayList<String>()
        ingPeperoni.add("Салам пипероне, кашкавал или моцарела, доматен сос, тесто")
        pizzas.add(Pizza("Пеперони", 9.90, ingPeperoni, R.drawable.peperoni))

        val ingRatatui = ArrayList<String>()
        ingRatatui.add("Червен лук, червени чушки, маслини обезкостени, сирене, домат, кашкавал или моцарела, доматен сос, риган, тесто")
        pizzas.add(Pizza("Рататуй", 9.90, ingRatatui, R.drawable.ratatui))

        val ingRomana = ArrayList<String>()
        ingRomana.add("Крем филаделфия, шунка, кашкавал или моцарела, чери домати, прошуто, доматен сос, тесто, пресен босилек")
        pizzas.add(Pizza("Романа", 14.50, ingRomana, R.drawable.romana))

        val ingValtelina = ArrayList<String>()
        ingValtelina.add("Крем филаделфия, сметана, копа, кашкавал или моцарела, пармезан, чери домати и пресен босилек")
        pizzas.add(Pizza("Валтелина", 19.90, ingValtelina, R.drawable.valtelina))


        recyclerView.adapter = PizzaAdapter(pizzas, requireActivity())
        recyclerView.layoutManager = LinearLayoutManager(activity)


        iconView = categoryList
        val ikonki = ArrayList<Int>()
        ikonki.add(R.drawable.taco)
        ikonki.add(R.drawable.coctail)
        ikonki.add(R.drawable.pizza)
        ikonki.add(R.drawable.soup)
        ikonki.add(R.drawable.eggs)
        ikonki.add(R.drawable.dish)
        ikonki.add(R.drawable.cactus)
        ikonki.add(R.drawable.duner)

        iconView.adapter = IconAdapter(ikonki, requireActivity())
        iconView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, true)
    }

}
