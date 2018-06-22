package evapaunova.example.com.dominoskotlin

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import kotlinx.android.synthetic.main.icon_image.view.*
import java.util.ArrayList

class IconAdapter(val icons: ArrayList<Int>, val context: Context): RecyclerView.Adapter<IconViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IconViewHolder {
        val li = LayoutInflater.from(context)
        val item = li.inflate(R.layout.icon_image, parent, false)
        return IconViewHolder(item)
    }

    override fun onBindViewHolder(holder: IconViewHolder, position: Int) {
        val iconNumber = icons[position]
        holder.icon.setImageResource(iconNumber)
    }

    override fun getItemCount(): Int {
        return icons.size
    }

}

class IconViewHolder(v: View) : RecyclerView.ViewHolder(v) {

    val icon = v.icon


}