package com.example.madpractical8_21172012015

import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    lateinit var alaram_img:ImageView
    lateinit var heart_img: ImageView
    lateinit var alarm_animation: AnimationDrawable
    lateinit var heart_animation:AnimationDrawable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        alaram_img=findViewById(R.id.alaram_list)
        alaram_img.setBackgroundResource(R.drawable.alarm_list)
        alarm_animation=alaram_img.background as AnimationDrawable
        heart_img=findViewById(R.id.heart_list)
        heart_img.setBackgroundResource(R.drawable.heart_list)
        heart_animation=heart_img.background as AnimationDrawable
    }
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if(hasFocus){
            alarm_animation.start()
            heart_animation.start()
        }
        else{
            alarm_animation.stop()
            heart_animation.stop()
        }
    }
}