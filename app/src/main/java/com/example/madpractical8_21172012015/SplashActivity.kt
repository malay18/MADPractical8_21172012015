package com.example.madpractical8_21172012015

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class SplashActivity : AppCompatActivity() , Animation.AnimationListener{
    lateinit var logo_img: ImageView
    lateinit var logoframbyframanimation: AnimationDrawable
    lateinit var twinanimation: Animation
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        logo_img=findViewById(R.id.img)
        logo_img.setBackgroundResource(R.drawable.uvpce_logo_list)
        logoframbyframanimation=logo_img.background as AnimationDrawable
        twinanimation= AnimationUtils.loadAnimation(this,R.anim.twin_animation)
        twinanimation.setAnimationListener(this)
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if(hasFocus){
            logoframbyframanimation.start()
            Timer().schedule(object : TimerTask() {
                override fun run() {
                    logo_img.startAnimation(twinanimation)
                }
            }, 3500)
        }
        else{
            logoframbyframanimation.stop()
        }
    }

    override fun onAnimationStart(animation: Animation) {

    }

    override fun onAnimationEnd(animation: Animation) {
        intent= Intent(this,MainActivity::class.java).apply{
            overridePendingTransition(R.anim.sacle_in,R.anim.scale_out)
            startActivity(this)
            finish()
        }
    }

    override fun onAnimationRepeat(animation: Animation) {

    }

}