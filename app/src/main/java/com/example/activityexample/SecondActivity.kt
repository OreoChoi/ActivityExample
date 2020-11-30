package com.example.activityexample

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.view.View
import kotlinx.android.parcel.Parcelize
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : SubAcitivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        btn_move_main.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        btn_move_current.setOnClickListener {
            callCount++
            tv_call_count.setText("Call Count : $callCount")
            startActivity(Intent(this, SecondActivity::class.java))
        }
    }


}