package evapaunova.example.com.dominoskotlin

import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_oracul.*
import java.net.URL
import org.json.JSONObject
import android.net.Uri
import android.widget.ImageView
import com.bumptech.glide.Glide
import java.io.*


class OraculActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_oracul)

        val ask = ask_button
        ask.setOnClickListener({
            val writeQuestion = textView5
            val showQuestion = question
            showQuestion.text = writeQuestion.text.toString()
            writeQuestion.setText("")
            AskTask().execute()

        })

    }

    inner class AskTask : AsyncTask<Unit, Unit, JSONObject>(){

        override fun doInBackground(vararg params: Unit?): JSONObject {

            val url = URL("https://yesno.wtf/api")

            val connection = url.openConnection()

            val input = connection.getInputStream()
            val br = BufferedReader(InputStreamReader(input))

            val jsonText = br.readLine()

            return JSONObject(jsonText)
        }

        override fun onPostExecute(obj: JSONObject?) {
            val jAns = obj?.get("answer").toString().toUpperCase()
            if(jAns.equals("yes", ignoreCase = true)){
                answer.setTextColor(resources.getColor(R.color.colorGreen))
            }
            else{
                answer.setTextColor(resources.getColor(R.color.colorRed))
            }
            answer.text = jAns

            val jsonGif = obj?.get("image").toString()
            val gifche = gif as ImageView
            val uri = Uri.parse(jsonGif)
            Glide.with(applicationContext).load(uri).into(gifche)
        }

    }

}
