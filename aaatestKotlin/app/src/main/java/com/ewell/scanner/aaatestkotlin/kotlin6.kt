package com.ewell.scanner.aaatestkotlin

import java.lang.Exception
import java.lang.IllegalStateException

/**
 *  create by BHB on 5/27/
 *  null安全与异常
 */

fun main() {

    var singnatrueDrink = "Buttered Ale"
//    singnatrueDrink = null  // String 为非空类型  不允许赋值为null

    var singnEnableNull : String? = "Buttered Ale"
    singnEnableNull = null     //string？为可空类型  允许赋值为null

    //返回类型为String 或者 null
    fun readLine():String?{
        return null
    }

    fun readLine2():String?{
        return ""
    }

    var nullValue = readLine()
    var nullvalue2 : String? = null
//    nullValue.capitalize()   //可能为null 的类型不允许调用方法
    nullValue?.capitalize()   // 安全调用操作符   null就跳过函数  非null才执行

//    使用let函数的安全调用
//    函数返回值不为null时会调用let方法  若返回null则直接返回null
    var nullvalue3 = readLine2()?.let {
        if(it.isNullOrEmpty()){
            "Buttered Ale"
        }else{
            it.capitalize()
        }
    }

    println(nullvalue3)

    // 非空断言操作符 !!.
    // 如果为null 会立刻抛出空指针异常  不介意使用
//    var nullvalue4 = readLine()!!.capitalize();
//    println(nullvalue4)

    // 使用if判断null值情况
    var nullvalue5 = readLine() ;
    if(nullvalue5 != null){
        println(nullvalue5.capitalize())
    }else{
        println(" nullvalue5 is null")
    }

    //空合并操作符  ?:
    // 如果左边的求值结果是null 就使用右边结果的值

    val nullvalue6:String = readLine()?:"Buttered Ale"
    println(nullvalue6)

    var swordJuggling:Int? = null
//    swordJuggling ?: throw IllegalStateException("swordJuggling can not be null")

    class UnSkilledException : IllegalStateException("swordJuggling can not be null")

    try {
        swordJuggling ?: throw UnSkilledException()
        swordJuggling = swordJuggling!!.plus(1)
    }catch (e:Exception){
        println(e)
    }
    println("you juggle $swordJuggling swords!")

    //先决条件函数 checkNotNull  它会检查某个值是否为null 如果不是就返回该值 如果是null就抛出异常
//    checkNotNull(swordJuggling ,{"swordJuggling can not be null"})

    fun printstatus(name:String , bless:Boolean){
        println("name $name , bless : $bless")
    }

//    printstatus(null , null)
}