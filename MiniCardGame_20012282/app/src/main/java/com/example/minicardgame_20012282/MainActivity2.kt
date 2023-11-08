package com.example.minicardgame_20012282

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity2 : AppCompatActivity() {

    val cards = arrayOf(
        R.drawable.card_spade_a,
        R.drawable.card_spade_2,
        R.drawable.card_spade_3,
        R.drawable.card_spade_4,
        R.drawable.card_spade_5,
        R.drawable.card_spade_6,
        R.drawable.card_spade_7,
        R.drawable.card_spade_8,
        R.drawable.card_spade_9,
        R.drawable.card_spade_10,
        R.drawable.card_spade_j,
        R.drawable.card_spade_q,
        R.drawable.card_spade_k
    )
    val back_card = R.drawable.card_back

    var amount = 0
    var count_round = 1
    var cardNumber_1 = 0
    var cardNumber_2 = 0
    var busted = 0
    var cardIV_1: ImageView? = null
    var cardIV_2: ImageView? = null
    var amountTV: TextView? = null
    var count_roundTV: TextView? = null

    var next_btn: Button? = null
    var open_btn: Button? = null
    var fold_btn: Button? = null
    var peek_btn: Button? = null
    var change_btn: Button? = null
    var yes_btn: Button? = null
    var no_btn: Button? = null
    var change2_btn: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        cardIV_1 = findViewById<ImageView>(R.id.cardImageView_1)
        cardIV_2 = findViewById<ImageView>(R.id.cardImageView_2)
        amountTV = findViewById<TextView>(R.id.amountTV)
        count_roundTV = findViewById<TextView>(R.id.count_roundTV)
        next_btn = findViewById<Button>(R.id.next_btn)
        open_btn = findViewById<Button>(R.id.open_btn)
        fold_btn = findViewById<Button>(R.id.fold_btn)
        peek_btn = findViewById<Button>(R.id.peek_btn)
        change_btn = findViewById<Button>(R.id.change_btn)
        yes_btn = findViewById<Button>(R.id.yes_btn)
        no_btn = findViewById<Button>(R.id.no_btn)
        change2_btn = findViewById<Button>(R.id.change2_btn)

        val end_btn = findViewById<Button>(R.id.end_btn)
        end_btn.setOnClickListener(View.OnClickListener {
            val round: String = count_round.toString()
            val amount: String = amount.toString()
            val intent = Intent(this, result_return::class.java)
            intent.putExtra("round", round)
            intent.putExtra("amount", amount)
            startActivity(intent)

        })

        val peek_btn = findViewById<Button>(R.id.peek_btn)
        peek_btn.setOnClickListener(View.OnClickListener {
            busted = Random.nextInt(0, 100)
            if (busted >= 70) {
            caught()
            } else {
                peek_btn()
            }
        })

        val change_btn = findViewById<Button>(R.id.change_btn)
        change_btn.setOnClickListener(View.OnClickListener {
            busted = Random.nextInt(0, 100)
            if (busted >= 70) {
                caught()
            } else {
                change_btn()
            }
        })

        val change2_btn = findViewById<Button>(R.id.change2_btn)
        change2_btn.setOnClickListener(View.OnClickListener {
            busted = Random.nextInt(0, 100)
            if (busted >= 70) {
                caught()
            } else {
                change2_btn()
            }
        })

    }

    fun caught(){
        if(this != null){
        val intent_caught = Intent(this,resultCaught::class.java)
        startActivity(intent_caught)
        }
    }

    fun open_btn(view: View) {
        drawCard()
        viewCard()
        calScore(cardNumber_1, cardNumber_2)

        next_btn?.visibility = View.VISIBLE
        next_round()
    }

    fun fold_btn(view: View) {
        drawCard()
        count_round = count_round + 1
        count_roundTV?.text = count_round.toString()
    }

    fun peek_btn() {
        drawCard()
        viewCard()
        yes_btn?.visibility = View.VISIBLE
        no_btn?.visibility = View.VISIBLE
        change2_btn?.visibility = View.VISIBLE
        next_round()
    }

    fun yes_btn(view: View) {
        calScore(cardNumber_1, cardNumber_2)
        yes_btn?.visibility = View.INVISIBLE
        no_btn?.visibility = View.INVISIBLE
        change2_btn?.visibility = View.INVISIBLE
        new_round(view)
    }

    fun no_btn(view: View) {
        yes_btn?.visibility = View.INVISIBLE
        no_btn?.visibility = View.INVISIBLE
        change2_btn?.visibility = View.INVISIBLE
        new_round(view)
    }

    fun change_btn() {
        drawCard()
    }

    fun change2_btn() {
        drawCard()
        viewCard()
    }


    ///////////////////////////////////////////
    fun next_round() {
        open_btn?.visibility = View.INVISIBLE
        fold_btn?.visibility = View.INVISIBLE
        peek_btn?.visibility = View.INVISIBLE
        change_btn?.visibility = View.INVISIBLE
    }

    fun new_round(view: View) { //next_btn
        coverCard()
        next_btn?.visibility = View.INVISIBLE
        open_btn?.visibility = View.VISIBLE
        fold_btn?.visibility = View.VISIBLE
        peek_btn?.visibility = View.VISIBLE
        change_btn?.visibility = View.VISIBLE
        count_round = count_round + 1
        count_roundTV?.text = count_round.toString()
    }

    fun drawCard() {
        cardNumber_1 = Random.nextInt(0, 13)
        cardNumber_2 = Random.nextInt(0, 13)
    }

    fun viewCard() {
        cardIV_1?.setImageResource(cards[cardNumber_1])
        cardIV_2?.setImageResource(cards[cardNumber_2])
    }

    fun coverCard() {
        cardIV_1?.setImageResource(back_card)
        cardIV_2?.setImageResource(back_card)
    }

    fun calScore(cardNumber_1: Int, cardNumber_2: Int) {
        if (cardNumber_1 == 0 && cardNumber_2 == 0) {
            amount = amount + 200
        } else if ((cardNumber_1 == 11 && cardNumber_2 == 11) || (cardNumber_1 == 12 && cardNumber_2 == 12) || (cardNumber_1 == 13 && cardNumber_2 == 13)) {
            amount = amount + 100
        } else if (cardNumber_1 == 9 && cardNumber_2 == 9) {
            amount = amount + 50
        } else if ((cardNumber_1 == 1 && cardNumber_2 == 1) || (cardNumber_1 == 2 && cardNumber_2 == 2) || (cardNumber_1 == 3 && cardNumber_2 == 3) || (cardNumber_1 == 4 && cardNumber_2 == 4) || (cardNumber_1 == 5 && cardNumber_2 == 5) || (cardNumber_1 == 6 && cardNumber_2 == 6) || (cardNumber_1 == 7 && cardNumber_2 == 7) || (cardNumber_1 == 8 && cardNumber_2 == 8)) {
            amount = amount + 20
        } else if ((cardNumber_1 == 0 && cardNumber_2 != 0) || (cardNumber_1 != 0 && cardNumber_2 == 0)) {
            amount = amount + 10
        } else {
            amount = amount - 5
        }
        amountTV?.text = amount.toString()
    }

}


