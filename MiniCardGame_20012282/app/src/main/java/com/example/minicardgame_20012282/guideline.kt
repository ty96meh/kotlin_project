package com.example.minicardgame_20012282

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button


class guideline : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guideline)

        val guide_btn = findViewById<Button>(R.id.guide_btn)
        guide_btn.setOnClickListener(View.OnClickListener {
            val intent_2 = Intent( this,MainActivity2::class.java)
            startActivity(intent_2)

        })
    }
}