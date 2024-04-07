package com.bsuir.castles.viewmodel

import androidx.lifecycle.ViewModel
import com.bsuir.castles.model.User

class ProfileScreenViewModel : ViewModel() {

    private var _user: User? = null

    var user: User
        get() {
            return _user!!
        }
        set(value) {
            _user = value
        }

}