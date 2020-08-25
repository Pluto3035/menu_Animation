package com.example.menu_animation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.animation.BounceInterpolator
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var isOpen:Boolean = true
    private val menus :Array<ImageView> by lazy{
        arrayOf(menu1,menu2,menu3,menu4,menu5,menu6)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        menuBtn.setOnClickListener {
            for((i,item)in menus.withIndex()){
                //ObjectAnimator   多个值  1.5, 0.8 0.0
                //ViewPropertyAnimator  一个值
             //旋转 360
                //移动  100
                val ty = if(isOpen) -(i+1)*(menu6.height+70).toFloat()  else 0f
                item.animate()
                    .rotation(360f)
                    .translationY(ty)
                    .interpolator = BounceInterpolator()

            }
            isOpen = !isOpen
        }

        menu1.setOnClickListener{
            Log.v("swl","相机打开了")
        }
    }
}
