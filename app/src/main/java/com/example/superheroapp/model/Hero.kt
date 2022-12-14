package com.example.superheroapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Hero(
    @DrawableRes val image : Int,
    @StringRes val nickName : Int,
    @StringRes val abilitiDes : Int
)