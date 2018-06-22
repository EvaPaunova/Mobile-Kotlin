package evapaunova.example.com.dominoskotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val goToLogin : ImageButton = findViewById(R.id.login_button)
        goToLogin.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@MainActivity, LoginActivity::class.java)
            startActivity(intent)
        })

        val goToRegister : ImageButton = findViewById(R.id.register_button)
        goToRegister.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@MainActivity, RegisterActivity::class.java)
            startActivity(intent)
        })

        val goToMenu: ImageButton = findViewById(R.id.menu_button)
        goToMenu.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@MainActivity, MenuActivity::class.java)
            startActivity(intent)
        })
    }
}
