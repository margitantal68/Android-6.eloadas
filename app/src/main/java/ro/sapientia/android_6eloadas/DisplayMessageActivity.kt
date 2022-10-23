package ro.sapientia.android_6eloadas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class DisplayMessageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("DisplayMessageActivity", "DisplayMessageActivity onCreate called")
        setContentView(R.layout.activity_display_message)
        val textView: TextView = findViewById(R.id.textView)
        textView.text =  intent.getStringExtra("EXTRA_MESSAGE").toString()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("DisplayMessageActivity", "onDestroy")
    }
}