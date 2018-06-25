package evapaunova.example.com.dominoskotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import evapaunova.example.com.dominoskotlin.model.User
import java.util.ArrayList
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private var users = ArrayList<User>()

    private lateinit var username: EditText
    private lateinit var password: EditText

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        username = email
        password = password_first

        users.add(User("Eva", "12345", 21, true))

        if (intent != null) {
            val newUser = intent.extras.get("User") as User
            users.add(newUser)
            username.setText(newUser.username)
            password.setText(newUser.password)
        }

        val login: ImageButton = login_button
        login.setOnClickListener(View.OnClickListener {
            var currentUser = User(username.text.toString(), password.text.toString())
            var credentialsOK = false
            for (u in users) {
                if (u.username.equals(currentUser.username) && u.password.equals(currentUser.password)) {
                    credentialsOK = true
                    currentUser = User(u.username, u.password, u.age, u.isFemale)
                    val intent = Intent(this@LoginActivity, LoggedActivity::class.java)
                    val bundle = Bundle()
                    bundle.putSerializable("User", currentUser)
                    intent.putExtras(bundle)
                    startActivity(intent)
                }
            }

            if (!credentialsOK) {
                Toast.makeText(this@LoginActivity, "Wrong credentials!", Toast.LENGTH_SHORT).show()
                password.setText("")
            }
        })

        val register: Button = button_ToRegister
        register.setOnClickListener(View.OnClickListener {
            val i = Intent(this@LoginActivity, RegisterActivity::class.java)
            i.putExtra("requestCode", 234);
            startActivityForResult(i, 234)
        })

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (data != null) {
            val newUser = data.getSerializableExtra("User") as User
            users.add(newUser)
            username.setText(newUser.username)
            password.setText(newUser.password)
        }
    }

    override fun onStop() {
        super.onStop()
        username.setText("")
        password.setText("")
    }
}
