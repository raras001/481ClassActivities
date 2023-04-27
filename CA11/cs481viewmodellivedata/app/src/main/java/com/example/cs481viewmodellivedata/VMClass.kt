package com.example.cs481viewmodellivedata

import androidx.lifecycle.ViewModel

class VMClass : ViewModel() {
    var counter = 0
    fun incNumber(){
        counter++
    }
}