package evapaunova.example.com.dominoskotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.ToggleButton
import evapaunova.example.com.dominoskotlin.model.User

class RegisterActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val genderMale: ToggleButton = findViewById(R.id.gender_male)
        val genderFemale: ToggleButton = findViewById(R.id.gender_female)

        genderFemale.setOnClickListener(View.OnClickListener {
            if (genderFemale.isChecked()) {
                genderMale.setChecked(false)
            } else {
                genderMale.setChecked(true)
            }
        })

        genderMale.setOnClickListener(View.OnClickListener {
            if (genderMale.isChecked()) {
                genderFemale.setChecked(false)
            } else {
                genderFemale.setChecked(true)
            }
        })

        val register: Button = findViewById(R.id.button_register)
        register.setOnClickListener(View.OnClickListener {
            val i = Intent(this@RegisterActivity, LoginActivity::class.java)

            val username = findViewById(R.id.username) as TextView
            val password = findViewById(R.id.password) as TextView
            val passwordRepeat = findViewById(R.id.confirm_password) as TextView
            val age = findViewById(R.id.age) as TextView

            var gender = false
            var ageInt = 0


            if (age.getText().toString() != "" && age.getText().toString().length <= 3) {
                ageInt = Integer.parseInt(age.getText().toString())
            } else {
                ageInt = -1
            }

            if (genderFemale.isChecked()) {
                gender = true
            }

            if (!validUsername(username.getText().toString())) {
                username.setError("Wrong username!")
            } else if (!validPassword(password.getText().toString(), passwordRepeat.getText().toString())) {
                password.setError("Wrong password!")
            } else if (!validAge(ageInt)) {
                age.setError("Invalid age!")
            } else {
                val user = User(username.getText().toString(), password.getText().toString(), Integer.parseInt(age.getText().toString()), gender)

                i.putExtra("User", user)

                setResult(567, i)
                finish()
            }
        })
    }

    private fun validUsername(username: String): Boolean {
        return if (username.length < 4) {
            false
        } else true
    }

    private fun validPassword(password: String, repeatPassword: String): Boolean {
        return if (password != repeatPassword || password.length < 4) {
            false
        } else true
    }

    private fun validAge(age: Int): Boolean {
        return if(age < 0 || age > 100) {
            false
        } else true
    }
}
