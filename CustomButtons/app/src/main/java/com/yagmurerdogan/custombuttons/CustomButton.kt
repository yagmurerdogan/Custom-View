package com.yagmurerdogan.custombuttons

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

@Suppress("DEPRECATION")
class CustomButton(context: Context, attrs: AttributeSet) : View(context, attrs) {

    private val paint = Paint()

    private var textMovie = resources.getString(R.string.textMovie)
    private var textMusic = resources.getString(R.string.textMusic)
    private var textPodcast = resources.getString(R.string.textPodcast)
    private var textEbook = resources.getString(R.string.textEbook)

    private var selectedButtonColor = resources.getColor(R.color.black)
    private var unselectedButtonColor = resources.getColor(R.color.white)

    private var selectedTextColor = resources.getColor(R.color.white)
    private var unselectedTextColor = resources.getColor(R.color.black)

    private var borderColor = resources.getColor(R.color.black)
    private var borderWidth = resources.getDimension(R.dimen.borderWidth)

    private var buttonWidth = resources.getDimension(R.dimen.buttonWidth)
    private var buttonHeight = resources.getDimension(R.dimen.buttonHeight)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        drawBackGround(canvas)
        writeText(canvas)
    }

    private fun drawBackGround(canvas: Canvas?) {


    }
     private fun writeText(canvas: Canvas?) {

     }

}

