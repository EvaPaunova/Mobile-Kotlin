package evapaunova.example.com.dominoskotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import evapaunova.example.com.dominoskotlin.model.User
import kotlinx.android.synthetic.main.activity_logged.*

class LoggedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logged)

        val user = intent.extras.getSerializable("User") as User

        val username: TextView = name
        val age: TextView = age
        val gender: TextView = gender

        username.text = user.firstName
        age.text = user.age.toString() + ""
        if (user.isFemale) {
            gender.text = "female."
        } else {
            gender.text = "male."
        }

        val logOut: Button = button_logOut
        logOut.setOnClickListener( {
            val intent = Intent(this@LoggedActivity, LoginActivity::class.java)
            startActivity(intent)
            finish()
        })

        val menu: Button = button_menu
        menu.setOnClickListener({
            val intent = Intent(this@LoggedActivity, RestaurantsListActivity::class.java)
            startActivity(intent)
        })

        val rests: ImageButton = try_button
        rests.setOnClickListener({
            val intent = Intent(this, OraculActivity::class.java)
            startActivity(intent)
        })

    }
}

