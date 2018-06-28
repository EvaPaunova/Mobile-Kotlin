package evapaunova.example.com.dominoskotlin

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        Toast.makeText(context, "Notification!!!!!", Toast.LENGTH_LONG).show()
    }
}
