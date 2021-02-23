package com.yagmurerdogan.customviewsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yagmurerdogan.customviewsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val mViewBinding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mViewBinding.root)

        mViewBinding.happyButton.setOnClickListener {
            mViewBinding.faceView.happienessState = FaceEmoji.HAPPY
        }
        mViewBinding.sadButton.setOnClickListener {
            mViewBinding.faceView.happienessState = FaceEmoji.SAD
        }
    }
}