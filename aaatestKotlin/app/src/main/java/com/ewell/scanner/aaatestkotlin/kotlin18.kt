package com.ewell.scanner.aaatestkotlin

/**
 *  create by BHB on 5/30/21
 *
 *  扩展
 */

//扩展可以在不直接修改类定义的情况下增加类的功能  扩展可以用于自定义类
// 扩展string函数
fun String.addEndFlag(count : Int = 1):String{
    return this + "。".repeat(count)
}

//扩展超类any函数
fun Any.print(){
    println(this)
}

// 扩展string属性
val String.numSize
get() = count{"aeiou".contains(it)}

fun main() {
    // 使用stirng扩展函数
    println("hello".addEndFlag())
    //使用超类扩展函数
    "hello".addEndFlag().print()

    //使用string扩展属性
    "hello".numSize.print()
}