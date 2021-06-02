package com.ewell.scanner.aaatestkotlin

import android.app.Person

/**
 *  create by BHB on 5/29/21
 *  对象
 */

fun main() {

//    // 调用
    Game.play()

    //数据类 关键字data 专门用来存储数据的类
    data class Touch(var x:Int , var y:Int){
        // 重新定义加号运算符 +
        operator fun plus(other:Touch) = Touch(other.x+x,other.y + y)
    }
    var touch1 = Touch(1,1)
    var touch2 = Touch(1,1)
    println(touch1.equals(touch2))
    println(touch1 + touch2)

    println(Direction.EAST)

}

// 枚举类
enum class Direction{
    NORTH,
    EAST,
    SOUTH,
    WEST
}

// 定义类
open class Person(_name:String){
    var name = _name
        get() = field

    open fun saySomething(){
        println("i am $name")
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        return true
    }

    override fun hashCode(): Int {
        return javaClass.hashCode()
    }


    //伴生对象
    companion object{
        var age = "18"
        fun sayAge(){
            println("age is $age")
        }
    }
}

// 声明对象
object Game{
    // 变量
    var person = Person("bbb")
    // 对象表达式 用于需要使用某个类的变体示例 但是只需使用一次
    var teacher = object :com.ewell.scanner.aaatestkotlin.Person("teacher"){
        override fun saySomething(){
            println("i am a teacher my name is  $name")
        }
    }
    // 初始化
    init {
        println(" create game ")
    }

    // 定义对象方法
    fun play(){
        println("${person.name} play game")
    }

}