package com.example.listscroller

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageButton

class CustomFab @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = com.google.android.material.R.attr.floatingActionButtonStyle
) : AppCompatImageButton(context, attrs, defStyleAttr) {

    init {
        setupFab(attrs,defStyleAttr)
    }

    private fun setupFab(attrs: AttributeSet?,defStyleAttr: Int) {
        setOnClickListener {
        }

        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomFab, defStyleAttr, 0)

        val iconDrawable = typedArray.getDrawable(R.styleable.CustomFab_customIcon)
        setImageDrawable(iconDrawable)

        typedArray.recycle()
    }

}