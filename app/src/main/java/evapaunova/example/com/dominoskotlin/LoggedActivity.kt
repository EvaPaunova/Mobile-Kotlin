package evapaunova.example.com.dominoskotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import evapaunova.example.com.dominoskotlin.model.User

class LoggedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logged)

        val user = intent.extras.getSerializable("User") as User

        val username: TextView = findViewById(R.id.name)
        val age: TextView = findViewById(R.id.age)
        val gender: TextView = findViewById(R.id.gender)

        username.setText(user.username)
        age.setText(user.age.toString() + "")
        if (user.isFemale) {
            gender.setText("female.")
        } else {
            gender.setText("male.")
        }

        val logOut: Button = findViewById(R.id.button_logOut)
        logOut.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@LoggedActivity, LoginActivity::class.java)
            startActivity(intent)
            finish()
        })

        val menu: Button = findViewById(R.id.button_menu)
        menu.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@LoggedActivity, MenuActivity::class.java)
            startActivity(intent)
        })

    }
}

