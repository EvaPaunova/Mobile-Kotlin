package evapaunova.example.com.dominoskotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import android.widget.ToggleButton
import evapaunova.example.com.dominoskotlin.model.User
import kotlinx.android.synthetic.main.registerform.*

class RegisterActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val genderMale: ToggleButton = gender_male
        val genderFemale: ToggleButton = gender_female

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

        val register: ImageButton = button_register
        register.setOnClickListener(View.OnClickListener {
            val i = Intent(this@RegisterActivity, LoginActivity::class.java)

            val email = email as TextView
            val fName = first_name as TextView
            val lName = last_name as TextView
            val password = password as TextView
            val passwordRepeat = confirm_password as TextView
            val age = age as TextView

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

            if (!validUsername(email.getText().toString())) {
                email.setError("Wrong username!")
            } else if (!validPassword(password.getText().toString(), passwordRepeat.getText().toString())) {
                password.setError("Wrong password!")
            } else if (!validAge(ageInt)) {
                age.setError("Invalid age!")
            } else {
                val user = User(fName.text.toString(),lName.text.toString(),email.text.toString(), password.text.toString(), Integer.parseInt(age.text.toString()), gender)

                i.putExtra("User", user)

                if(intent != null && intent.extras != null && intent.extras.getInt("requestCode") == 234){
                    setResult(567, i)
                    finish()
                }
                else{
                    startActivity(i)
                }
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
