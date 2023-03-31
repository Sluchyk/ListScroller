package com.example.listscroller.model

import androidx.annotation.DrawableRes

data class Affirmation(
    val someText:String,
    @DrawableRes val image:Int
    )