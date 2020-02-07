package com.example.animationex

import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), SeekBar.OnSeekBarChangeListener, View.OnClickListener {

    var anim: Animation? = null
    var anims = ArrayList<Animation>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        anim = AnimationUtils.loadAnimation(this, R.anim.start_up_down)

        anims.add(AnimationUtils.loadAnimation(this, R.anim.start_up_down))
        anims.add(AnimationUtils.loadAnimation(this, R.anim.end_up_down))
        anims.add(AnimationUtils.loadAnimation(this, R.anim.top_left_right))
        anims.add(AnimationUtils.loadAnimation(this, R.anim.bottom_left_right))

        anim?.duration = seekBar.progress.toLong()
        vBox.animation = anim

        vBox.animate()

        seekBar.setOnSeekBarChangeListener(this)
        btnChange.setOnClickListener(this)
    }


    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
        txtSpeed.text = seekBar?.progress.toString()
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {
        return
    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {
        performAnimation()
    }

    override fun onClick(v: View?) {
        anim = anims.random()
        performAnimation()
    }

    fun performAnimation(){
        vBox.clearAnimation()
        txtSpeed.text = seekBar?.progress.toString()
        anim?.duration = seekBar?.progress!!.toLong()
        vBox.animation = anim
        vBox.animate()
    }
}
