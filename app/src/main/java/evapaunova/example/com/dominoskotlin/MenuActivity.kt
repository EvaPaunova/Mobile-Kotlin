package evapaunova.example.com.dominoskotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.ActionBar
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {

    private var first: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        var actionBar = supportActionBar
        actionBar?.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM)
        actionBar?.setCustomView(R.layout.my_layout)
        var textView = actionBar?.customView?.findViewById<TextView>(R.id.titleText)
        textView?.text = resources.getText(R.string.app_menu)

        first = ProductListFragment()
        if (parent_view_p as View? != null) {
            val fm = supportFragmentManager
            val transaction = fm.beginTransaction()
            transaction
                    .replace(R.id.parent_view_p, first)
                    .commit()
        }

    }


}
