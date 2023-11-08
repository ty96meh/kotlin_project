package com.example.minicardgame_20012282

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class resultCaught : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_caught)

        val restart_btn_2 = findViewById<Button>(R.id.restart_btn_2)
        restart_btn_2.setOnClickListener(View.OnClickListener {
            val intent = Intent( this,MainActivity2::class.java)
            startActivity(intent)
        })
    }
}