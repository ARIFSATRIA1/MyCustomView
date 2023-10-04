package com.example.mycustomview.button

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.Gravity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import com.example.mycustomview.R

class MyButton: AppCompatButton {
    private lateinit var enabledBackground: Drawable
    private lateinit var disabledBackground: Drawable
    private var textColor: Int = 0


    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attr: AttributeSet): super(context,attr) {
        init()
    }

    constructor(context: Context,attr: AttributeSet,defStyleAttr: Int): super(context,attr,defStyleAttr) {
        init()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        background = if(isEnabled) enabledBackground else disabledBackground

        setTextColor(textColor)
        textSize = 12f
        gravity = Gravity.CENTER
        text = if (isEnabled) "Submit" else "Isi Dulu"

    }

    private fun init(){
        textColor = ContextCompat.getColor(context, android.R.color.background_light)
        enabledBackground = ContextCompat.getDrawable(context, R.drawable.bg_button) as Drawable
        disabledBackground = ContextCompat.getDrawable(context, R.drawable.bg_button_dissable) as Drawable
    }
}