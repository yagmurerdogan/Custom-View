package com.yagmurerdogan.customviewsample

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class FaceEmoji(context: Context, attrs: AttributeSet) : View(context, attrs) {
    companion object {
        private const val DEFAULT_FACE_COLOR = Color.YELLOW
        private const val DEFAULT_EYES_COLOR = Color.BLACK
        private const val DEFAULT_MOUTH_COLOR = Color.BLACK
        private const val DEFAULT_BORDER_COLOR = Color.BLACK
        private const val DEFAULT_BORDER_WIDTH = 4.0f

        const val HAPPY = 0L
        const val SAD = 1L
    }

    private var faceColor = DEFAULT_FACE_COLOR
    private var eyesColor = DEFAULT_EYES_COLOR
    private var mouthColor = DEFAULT_MOUTH_COLOR
    private var borderColor = DEFAULT_BORDER_COLOR
    private var borderWidth = DEFAULT_BORDER_WIDTH


    private var size = 0
    private val paint = Paint()
    private val mouthPath = Path()

    var happienessState = HAPPY
    set(state) {
        field = state
        invalidate()
    }
    init {
        paint.isAntiAlias = true
        setupAttributes(attrs)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        drawFaceBackground(canvas)
        drawEyes(canvas)
        drawMouth(canvas)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        size = Math.min(measuredWidth, measuredHeight)
        setMeasuredDimension(size,size)
    }

    private fun setupAttributes(attrs: AttributeSet?) {
        val typedArray = context.theme.obtainStyledAttributes(
            attrs, R.styleable.FaceEmoji, 0, 0
        )

        happienessState = typedArray.getInt(R.styleable.FaceEmoji_state, HAPPY.toInt()).toLong()
        faceColor = typedArray.getColor(R.styleable.FaceEmoji_faceColor, DEFAULT_FACE_COLOR)
        eyesColor = typedArray.getColor(R.styleable.FaceEmoji_eyesColor, DEFAULT_EYES_COLOR)
        mouthColor = typedArray.getColor(R.styleable.FaceEmoji_mouthColor, DEFAULT_MOUTH_COLOR)
        borderColor = typedArray.getColor(R.styleable.FaceEmoji_borderColor, DEFAULT_BORDER_COLOR)
        borderWidth = typedArray.getDimension(R.styleable.FaceEmoji_borderWidth,DEFAULT_BORDER_WIDTH)
        typedArray.recycle()
    }

    private fun drawFaceBackground(canvas: Canvas?) {
        paint.color = faceColor
        paint.style = Paint.Style.FILL
        val radius = size / 2f
        canvas?.drawCircle(size/2f, size/2f,radius,paint)
        paint.color = borderColor
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = borderWidth
        canvas?.drawCircle(size/2f,size/2f,radius-borderWidth/2f,paint)

    }
    private fun drawEyes(canvas: Canvas?) {
        paint.color = eyesColor
        paint.style = Paint.Style.FILL
        val leftEyeRect = RectF(size*0.32f, size*0.23f, size*0.43f, size*0.50f)
        canvas?.drawOval(leftEyeRect,paint)
        val rightEyeRect = RectF(size*0.57f, size*0.23f, size*0.68f, size*0.50f)
        canvas?.drawOval(rightEyeRect,paint)

    }

    private fun drawMouth(canvas: Canvas?) {
        mouthPath.reset()
        mouthPath.moveTo(size*0.22f, size*0.7f)

        if(happienessState == HAPPY) {
            mouthPath.quadTo(size*0.50f, size*0.80f, size*0.78f, size*0.70f)
            mouthPath.quadTo(size*0.50f, size*0.90f, size*0.22f, size*0.70f)
        } else {
            mouthPath.quadTo(size*0.50f, size*0.50f, size*0.78f, size*0.70f)
            mouthPath.quadTo(size*0.50f, size*0.60f, size*0.22f, size*0.70f)
        }

        paint.color = mouthColor
        paint.style = Paint.Style.FILL
        canvas?.drawPath(mouthPath,paint)

    }


}