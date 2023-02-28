package com.example.lesson31

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class DialCounterView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var counter: Int = 0
    private var radius = 0.0f
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
        textAlign = Paint.Align.CENTER
        textSize = 55.0f
        typeface = Typeface.create("", Typeface.BOLD)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        radius = (Integer.min(w, h) / 2.0 * 0.8).toFloat()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        when (counter) {
            in 0..9 -> paint.color = Color.GREEN
            10 -> {
                radius = radius + 10.0f
                paint.color = Color.YELLOW
            }
            in 10..19 -> paint.color = Color.YELLOW
            20 -> {
                radius = radius + 10.0f
                paint.color = Color.RED
            }
            in 20..100 -> paint.color = Color.RED
        }

        canvas.drawCircle((width / 2).toFloat(), (height / 2).toFloat(), radius, paint)

        paint.color = Color.BLACK

        canvas.drawText(counter.toString(), (width / 2).toFloat(), (height / 2).toFloat(), paint)
    }

    init {
        isClickable = true
    }

    override fun performClick(): Boolean {
        if (super.performClick()) return true
        counter = ++counter

        invalidate()
        return true
    }
}