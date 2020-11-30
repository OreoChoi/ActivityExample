package com.example.activityexample

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.synthetic.main.activity_main.*

/**
 * 1.액티비티는 ContextWrapper을 상속받은 클래스이며
 *   본인이 Context로 대체가 가능합니다.
 *
 *   getApplication과 baseContext는 다른 context이며 lifecycle에 맞춰 사용해야합니다.
 *   getApplication은 Application Context, baseContext Activity Context로,
 *   소멸되는 시점도 제공하는 정보도 다릅니다.
 * 
 * 2. 액티비티는 화면을 구성하는 단위로 화면은 task라는 스택 내부에 쌓이게 됩니다.
 *    task의 흐름은 manifest 혹은 flag를 통해 조작이 가능합니다.
 * */
class MainActivity : BaseActivity() {
    private var stateBundle:MainBundle = MainBundle()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        printState()

        btn_move_main_to_second.setOnClickListener{
            startActivity(Intent(this,SecondActivity::class.java))
        }
        btn_move_main_to_third.setOnClickListener{
            startActivity(Intent(this,ThirdActivity::class.java))
        }
    }

    override fun onRestoreInstanceState(saveState: Bundle) {
        super.onRestoreInstanceState(saveState)
        stateBundle.state.putAll(saveState)
        printState()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putAll(stateBundle.state)
    }

    fun printState(){
        tv_bundle.setText(
            getString(
                R.string.bundle,
                stateBundle.state.get("String"),
                stateBundle.state.get("Byte"),
                stateBundle.state.get("Int"),
                stateBundle.state.get("Long"),
                stateBundle.state.get("Char"),
                stateBundle.state.get("Float"),
                stateBundle.state.get("Double"),
                stateBundle.state.get("Wash").toString()
            )
        )
    }
}

@Parcelize
data class Wash(val binu: Int = 3) : Parcelable

data class MainBundle(
    val string: String = "",
    val byte: Byte = 1,
    val int: Int = 1,
    val long: Long = 1L,
    val char: Char = 'c',
    val float:Float = 1.0f,
    val double:Double = 1.0,
    val wash:Wash = Wash()
){
    val state:Bundle = Bundle()

    init {
        state.putString("String",string)
        state.putByte("Byte", byte)
        state.putInt("Int", int)
        state.putLong("Long", long)
        state.putChar("Char", char)
        state.putFloat("Float", float)
        state.putDouble("Double", double)
        state.putParcelable("Wash", Wash())
    }
}
