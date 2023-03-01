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
    var counterState: String = CounterStates.INCREMENT.attrValue
    private var radius = 0.0f
    private var startRadius = 0.0f
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
        textAlign = Paint.Align.CENTER
        textSize = 55.0f
        typeface = Typeface.create("", Typeface.BOLD)
    }

    init {
        isClickable = true

        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.DialCounterView,
            0, 0
        ).apply {
            try {
                counterState = getString(R.styleable.DialCounterView_counterState).toString()
            } finally {
                recycle()
            }
        }
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        radius = (Integer.min(w, h) / 2.2 * 0.8).toFloat()
        startRadius = radius
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        when (counter) {
            in -100..-1 -> {
                paint.color = Color.LTGRAY
                radius = startRadius - 20.0f
            }
            in 0..9 -> {
                radius = startRadius
                paint.color = Color.CYAN
            }
            in 10..19 -> {
                radius = startRadius + 20.0f
                paint.color = Color.MAGENTA
            }
            in 20..100 -> {
                radius = startRadius + 40.0f
                paint.color = Color.BLUE
            }
        }

        canvas.drawCircle((width / 2).toFloat(), (height / 2).toFloat(), radius, paint)

        paint.color = Color.BLACK
        canvas.drawText(counter.toString(), (width / 2).toFloat(), (height / 2).toFloat(), paint)
    }

    override fun performClick(): Boolean {
        if (super.performClick()) return true
        counter = if (counterState == CounterStates.INCREMENT.attrValue) {
            ++counter
        } else {
            --counter
        }

        invalidate()
        return true
    }
}