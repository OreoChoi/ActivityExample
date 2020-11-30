package com.example.activityexample

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_second.tv_call_count
import kotlinx.android.synthetic.main.activity_third.*

class ThirdActivity : SubAcitivity() {

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        btn_move_third_to_main.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        btn_move_fourth_to_third.setOnClickListener {
            callCount++
            tv_call_count.setText("Call Count : $callCount")
            startActivity(Intent(this, ThirdActivity::class.java))
        }

        btn_move_fourth_to_fourth.setOnClickListener{
            startActivity(Intent(this,FourthActivity::class.java))
        }
    }
}