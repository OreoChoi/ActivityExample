package com.example.activityexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("String","String")
        outState.putByte("Byte",1)
        outState.putInt("Int",1)
        outState.putLong("Long",1)
        outState.putChar("Char",'c')
        outState.putFloat("Float",1.0f)
        outState.putDouble("Double",1.0)
        outState.put
    }
}