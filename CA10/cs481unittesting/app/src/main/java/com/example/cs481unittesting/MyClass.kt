package com.example.cs481unittesting

class MyClass {
    fun factorial(n: Int): Int {
        return IntArray(n) {
            it+1
        }.reduce { acc, i->
            acc * i
        }
    }
}