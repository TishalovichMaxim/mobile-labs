package com.bsuir.castles.model

class Castle(
    var id: String,
    var name: String,
    var country: String,
    var foundationYear: Int,
    var mainImage: String,
) {
    constructor() : this("", "", "", 0, "") {
    }
}