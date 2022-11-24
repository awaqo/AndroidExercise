package com.kampusmerdeka.viewmodellatihan

import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    var angka = 0

    fun tambahAngka() {
        angka++
    }
}