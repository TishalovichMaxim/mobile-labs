package com.bsuir.castles.model

import java.util.Date

data class User(
    val email: String,
    val firstName: String,
    val secondName: String,
    val bio: String,
    val birthdate: Date
)
