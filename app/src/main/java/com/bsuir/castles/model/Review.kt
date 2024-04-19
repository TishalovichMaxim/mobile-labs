package com.bsuir.castles.model

data class Review(
    val rate: Int,
    val comment: String,
    val userName: String
) {
    constructor() : this(0, "", "") {
    }
}
