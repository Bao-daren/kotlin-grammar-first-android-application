@file:JvmName("kkk")

package com.ewell.scanner.aaatestkotlin

import java.io.IOException
import java.lang.Exception


/**
 *  create by BHB on 6/1/21
 *  kotlin与java互操作
 */


fun main(args:Array<String>) {
    //kotlin 调用java代码
    var java20 = kotlin20Java()
    println(java20.javaName)

    //kotlin 调动java代码 但是返回的是一个null
    // 会导致程序报错IllegalStateException: java20.friend must not be null
    var friend = java20.friend
    println(friend?.toLowerCase() ?: "it is null")

    println(java20.point.javaClass)
    java20.point = 10
    println(java20.point.dec())

    handFood("pizza")

    try {
        java20.throwJavaException()
    }catch (e:Exception){
        println("kotlin catch javaException")
    }


    println(translator("dadsadad"))

}

val translator = {
        str:String -> str.toLowerCase().capitalize()
}
val translator2 = {
    str:String , index:Int -> "$str ----- $index"
}

@Throws(IOException::class)
fun throwKotlinException(){
    throw  IOException()
}

// kotlin定义函数 供给java调用
fun getKotlinName():String{
    return "kotlin"
}

@JvmOverloads
fun handFood(left:String = "apple" , right:String = "pear"){
    println("left is $left  right is $right")
}

// 定义kotlin类 以及属性
class Spellbook{
    @JvmField  // 添加注解
    val splls = listOf("a","b","c");

    companion object{
        @JvmField  //  伴生对象添加注解
        val MAX_SPELL_COUNT = 10

        @JvmStatic  //伴生对象的函数添加注解
        fun saySomething() = println("hello world")
    }

}