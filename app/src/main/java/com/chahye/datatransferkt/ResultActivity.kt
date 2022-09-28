package com.chahye.datatransferkt

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        Toast.makeText(this, "message: ${intent.getStringExtra("message")}", Toast.LENGTH_SHORT).show()

        button_back.setOnClickListener {
            val intent = Intent()
            intent.putExtra("message", "Hey, SecondFragment")
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }

}