package com.example.minicardgame_20012282


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class result_return : AppCompatActivity() {

    var win_view: TextView? = null
    var lose_view: TextView? = null
    var round_view: TextView? = null
    var amount_view: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_return)

        val round = intent.getStringExtra("round")
        val amount = intent.getStringExtra("amount")

        win_view = findViewById<TextView>(R.id.win_view)
        lose_view = findViewById<TextView>(R.id.lose_view)
        round_view = findViewById<TextView>(R.id.round_view)
        amount_view = findViewById<TextView>(R.id.amount_view)

        val amount_check = amount?.toInt()

        if (amount_check!= null && amount_check > 0){
            round_view?.text = round.toString()
            amount_view?.text = amount.toString()

            win_view?.visibility = View.VISIBLE
            round_view?.visibility = View.VISIBLE
            amount_view?.visibility = View.VISIBLE

        }else if(amount_check!= null && amount_check <= 0){
            round_view?.text = round.toString()
            amount_view?.text = amount.toString()

            lose_view?.visibility = View.VISIBLE
            round_view?.visibility = View.VISIBLE
            amount_view?.visibility = View.VISIBLE

        }



        val restart_btn = findViewById<Button>(R.id.restart_btn)
        restart_btn.setOnClickListener(View.OnClickListener {
            val intent = Intent( this,MainActivity2::class.java)
            startActivity(intent)
        })



    }
}