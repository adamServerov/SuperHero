package com.example.superheroapp.data

import com.example.superheroapp.R
import com.example.superheroapp.model.Hero


object Heroes {

    val heroList = listOf<Hero>(
        Hero(image = R.drawable.android_superhero1, R.string.super_hero_name1,R.string.super_hero_abil1),
        Hero(image = R.drawable.android_superhero2, R.string.super_hero_name2,R.string.super_hero_abil2),
        Hero(image = R.drawable.android_superhero3, R.string.super_hero_name3,R.string.super_hero_abil3),
        Hero(image = R.drawable.android_superhero4, R.string.super_hero_name4,R.string.super_hero_abil4),
        Hero(image = R.drawable.android_superhero5, R.string.super_hero_name5,R.string.super_hero_abil5),
        Hero(image = R.drawable.android_superhero6, R.string.super_hero_name6,R.string.super_hero_abil6),
    )
}