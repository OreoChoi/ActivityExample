package com.example.activityexample

import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.tv_call_count
import kotlinx.android.synthetic.main.activity_third.*

class FourthActivity : SubAcitivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fourth)

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