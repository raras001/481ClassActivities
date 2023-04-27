package com.example.cs481unittesting

import org.junit.Assert.*
import org.junit.Test

class MyClassTest{
    private val myCLass = MyClass()
    @Test
    fun computesFactorial(){
        val n =4
        val result = myCLass.factorial(n)
        assertEquals(24, result)
    }

    @Test
    fun computesFactorialWrong(){
        val n =4
        val result = myCLass.factorial(n)
        assertEquals(20, result)
    }
}