package com.abhishek.instagramprofileclone

import androidx.annotation.DrawableRes

data class ImageWithText(
    @DrawableRes val imageIdRes: Int,
    val description : String
)
