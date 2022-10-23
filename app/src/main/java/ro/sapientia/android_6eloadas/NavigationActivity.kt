package ro.sapientia.android_6eloadas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class NavigationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)
        Log.i("NavigationActivity", "onCreate")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.i("NavigationActivity", "onDestroy")
    }
}