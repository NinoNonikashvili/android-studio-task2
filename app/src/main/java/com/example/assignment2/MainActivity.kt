package com.example.assignment2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val arr:List<Int> = listOf(3,4,5,5,5)
        val arr2:List<Int> = listOf(3, 5)
        val answer1 = ignoreDuplicate(arr)
        val answer2 = intersection(arr, arr2)
        val answer3 = union(arr, arr2)
        val answer4 = lessThanAverage(arr)
        val answer5 = minAndMax(arr)
        Log.d("success", "$answer1, $answer2, $answer3, $answer4, $answer5")
    }
    fun ignoreDuplicate(arr:List<Int>) :Int{
        var unique :MutableList<Int> = mutableListOf()
        arr.forEach {
            if (!(unique.contains(it)))
                unique.add(it)
        }
        return unique.size
    }
    fun intersection(arr1: List<Int>, arr2 :List<Int>) : List<Int>{
        var common :MutableList<Int> = mutableListOf()
        var c :MutableList<Int> = mutableListOf()
        c +=arr2
        arr1.forEach{
            if(c.contains(it)) {
                c.remove(it)
                common.add(it)
            }
        }
        return common
    }
    fun union(arr1:List<Int>, arr2:List<Int>) :List<Int>{
        var array2:MutableList<Int> = mutableListOf()
        array2 += arr2
        var unionOfTwo:MutableList<Int> = mutableListOf()
        arr1.forEach{if(!array2.contains(it)){
            unionOfTwo.add(it)

        }else{
            array2.remove(it)
        }
        }
        unionOfTwo +=arr2
        return unionOfTwo
    }
    fun lessThanAverage(arr:List<Int>) :List<Int>{
        var average = arr.sum().toDouble()/arr.size
        return arr.filter{it<average}
    }
    fun minAndMax(arr:List<Int>) :List<Int>{
        var a = 0
        var secondMin = 0
        var secondMax = 0
        arr.forEach{ if(it>a) {
            secondMax = a
            a = it
        }}
        arr.forEach{if(a>it){
            secondMin = a
            a = it
        } }
        return listOf(secondMax, secondMin)


    }
}