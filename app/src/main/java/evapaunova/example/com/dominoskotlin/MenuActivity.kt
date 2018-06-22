package evapaunova.example.com.dominoskotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View

class MenuActivity : AppCompatActivity() {

    private var first: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        first = ProductListFragment()
        if (findViewById(R.id.parent_view_p) as View? != null) {
            val fm = supportFragmentManager
            val transaction = fm.beginTransaction()
            transaction
                    .replace(R.id.parent_view_p, first)
                    .commit()
        }

    }


}
