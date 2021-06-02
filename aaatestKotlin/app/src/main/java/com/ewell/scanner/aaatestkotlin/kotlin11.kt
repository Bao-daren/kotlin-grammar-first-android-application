package com.ewell.scanner.aaatestkotlin

/**
 *  create by BHB on 5/28/21
 *  Map
 */

fun main() {

    //创建一个只读map  关键字mapOf  to
    val readMap = mapOf("aa" to 1.1 ,"bb" to 2.2 , "cc" to 3.3)
    println(readMap)

    // 使用pair创建map
    val readMap2 = mapOf(Pair("aa",1.1) , Pair("bb",2.2) , Pair("cc",3.3) )
    println(readMap2)

    // 可修改的map  MutableMap
    val mutableMap = mutableMapOf("aa" to 1.1 ,"bb" to 2.2 , "cc" to 3.3)

    // 修改map中的值
    mutableMap += "aa" to 100.1
    mutableMap += "dd" to 200.1
    mutableMap["ee"] = 5.5
    println(mutableMap)

    // 读取map集合的值
    println("aa = ${mutableMap["aa"]}")

    mutableMap.putAll(listOf("aa" to 1.1 , "bb" to 2.2))
    mutableMap.getOrPut("ff"){6.6}

    mutableMap -= ("aa")
    println(mutableMap)

    // 遍历map
    mutableMap.forEach { key, value ->
        println(" $key =  $value")
    }

}