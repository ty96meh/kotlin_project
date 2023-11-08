package com.example.minicardgame_20012282

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val start_btn = findViewById<Button>(R.id.start_btn)
        start_btn.setOnClickListener(View.OnClickListener {
            val intent = Intent( this,guideline::class.java)
            startActivity(intent)
        })

    }
}