package ro.sapientia.android_6eloadas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class DisplayMessageReturnActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("DisplayMessageReturnActivity", "DisplayMessageReturnActivity onCreate called")
        setContentView(R.layout.activity_display_message_return)
        val textView: TextView = findViewById(R.id.textView)
        val button: Button = findViewById(R.id.button4)
        textView.text =  intent.getStringExtra("EXTRA_MESSAGE").toString()
        button.setOnClickListener {
            val intent = Intent()
            intent.putExtra("RETURN_MESSAGE", "Hello from DisplayMessageReturnActivity")
            setResult(RESULT_OK, intent)
            finish()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("DisplayMessageReturnActivity", "onDestroy")
    }
}