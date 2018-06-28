package evapaunova.example.com.dominoskotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.ActionBar
import android.widget.*
import evapaunova.example.com.dominoskotlin.model.User
import java.util.ArrayList
import kotlinx.android.synthetic.main.activity_login.*
import android.widget.TextView



class LoginActivity : AppCompatActivity() {

    private var users = ArrayList<User>()

    private lateinit var email: EditText
    private lateinit var password: EditText

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var actionBar = supportActionBar
        actionBar?.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM)
        actionBar?.setCustomView(R.layout.my_layout)
        var textView = actionBar?.customView?.findViewById<TextView>(R.id.titleText)
        textView?.text = resources.getText(R.string.app_login)


        email = email_
        password = password_first

        users.add(User("Eva", "Paunova", "asdf@mail.bg", "12345", 21, true))

        if (intent != null && intent.extras != null && intent.extras.get("User") != null) {
            val newUser = intent.extras.get("User") as User
            users.add(newUser)
            email.setText(newUser.email)
            password.setText(newUser.password)
        }

        val login: ImageButton = login_button
        login.setOnClickListener(
            {
                var currentUser: User
                var credentialsOK = false
                for (u in users) {
                    if (u.email.equals(email.text.toString()) && u.password.equals(password.text.toString())) {
                        credentialsOK = true
                        currentUser = User(u.firstName,u.lastName,u.email, u.password, u.age, u.isFemale)
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
        register.setOnClickListener(
            {
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
            email.setText(newUser.email)
            password.setText(newUser.password)
        }
    }

    override fun onStop() {
        super.onStop()
        email.setText("")
        password.setText("")
    }
}
