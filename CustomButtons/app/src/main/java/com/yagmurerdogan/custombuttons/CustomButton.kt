package com.yagmurerdogan.custombuttons

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class CustomButton(context: Context, attrs: AttributeSet) : View(context, attrs) {

    private val paint = Paint()

    private var textMovie = Constants.MOVIE_BUTTON_TEXT
    private var musicMovie = Constants.MUSIC_BUTTON_TEXT
    private var podcastMovie = Constants.PODCAST_BUTTON_TEXT
    private var ebookMovie = Constants.EBOOK_BUTTON_TEXT

    private var selectedButtonColor = Constants.SELECTED_BUTTON_COLOR
    private var unselectedButtonColor = Constants.UNSELECTED_BUTTON_COLOR

    private var selectedTextColor = Constants.SELECTED_TEXT_COLOR
    private var unselectedTextColor = Constants.UNSELECTED_TEXT_COLOR

    private var borderColor = Constants.DEFAULT_BORDER_COLOR
    private var borderWidth = Constants.DEFAULT_BORDER_WIDTH

    private var buttonWidth = Constants.DEFAULT_BUTTON_WIDTH
    private var buttonHeight = Constants.DEFAULT_BUTTON_HEIGHT
    

}

