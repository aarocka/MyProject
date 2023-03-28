package com.example.myproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    val timeTextView: TextView by lazy {
        findViewById(R.id.textView)
    }

    val startButton: Button by lazy {
        findViewById(R.id.button)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       startButton.setOnClickListener {
            CoroutineScope(Job() + Dispatchers.Default).launch{
                //for loop that countdowns from 100 to 0
                for (i in 100 downTo 0) {
                    //delay for 1 second
                    delay(1000);
                    //update the textview with the current value of i
                    withContext(Dispatchers.Main) {
                        timeTextView.text = i.toString()
                    }
                }
            }
        }



    }


}