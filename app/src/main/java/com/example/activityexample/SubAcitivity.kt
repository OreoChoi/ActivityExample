package com.example.activityexample

import android.os.Bundle

open class SubAcitivity:BaseActivity(){
    open var callCount: Int = 0

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        callCount = savedInstanceState.getInt("callCount")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("callCount", callCount)
    }
}