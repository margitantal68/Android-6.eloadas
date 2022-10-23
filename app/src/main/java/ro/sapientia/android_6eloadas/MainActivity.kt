package ro.sapientia.android_6eloadas

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts


class MainActivity : AppCompatActivity() {
    val EXTRA_MESSAGE = "EXTRA_MESSAGE"
    // startActivityForResult - OLD STYLE
    val REQUEST_CODE = 1

    // startActivityForResult - NEW STYLE
    val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result: ActivityResult ->
        if( result.resultCode == Activity.RESULT_OK){
            val intentData = result.data
            // Handle the intentData
            val message = intentData?.getStringExtra("RETURN_MESSAGE")
            Toast.makeText(this, "Return message $message", Toast.LENGTH_SHORT).show()

        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("MainActivity", "MainActivity onCreate called")
        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.button)
        val button2: Button = findViewById(R.id.button2)
        val button3: Button = findViewById(R.id.button3)
        val button4: Button = findViewById(R.id.button4)
        val editText: EditText = findViewById(R.id.editText)
        // Start Navigation Activity
        button.setOnClickListener {
            val intent = Intent(this, NavigationActivity::class.java)
            startActivity(intent)
        }
        editText.setOnClickListener{
            editText.text.clear()
        }
        button2.setOnClickListener {
            startDisplayMessageActivity(editText.text.toString())
        }
        button3.setOnClickListener {
            startDisplayMessageReturnActivityOld(editText.text.toString())
        }
        button4.setOnClickListener {
            startDisplayMessageReturnActivityNew(editText.text.toString())
        }
    }

    fun startDisplayMessageActivity(message: String){
        val intent = Intent(this, DisplayMessageActivity::class.java)
        intent.putExtra(EXTRA_MESSAGE, message)
        startActivity(intent)
    }

    //    Start Activity for result - NEW STYLE
    fun startDisplayMessageReturnActivityNew(message: String){
        val intent = Intent(this, DisplayMessageReturnActivity::class.java)
        intent.putExtra(EXTRA_MESSAGE, message)
        startForResult.launch( intent)
    }

    //    Start Activity for result - OLD STYLE
    fun startDisplayMessageReturnActivityOld(message: String){
        val intent = Intent(this, DisplayMessageReturnActivity::class.java)
        intent.putExtra(EXTRA_MESSAGE, message)
        startActivityForResult(intent, REQUEST_CODE)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if( requestCode == REQUEST_CODE){
            if( resultCode == Activity.RESULT_OK){
                val message = data?.getStringExtra("RETURN_MESSAGE")
                Toast.makeText(this, "Return message $message", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("MainActivity", "onDestroy")
    }

}