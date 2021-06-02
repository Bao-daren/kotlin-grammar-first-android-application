package com.ewell.scanner.aaatestkotlin

/**
 *  create by BHB on 5/26/21
 *
 *  function  函数
 */
fun main() {
    val name = "Madrigal"
    var healthPoint = 99
    if (healthPoint == 100) {
        System.out.println(name + " is in excellent condition")
    } else {
        System.out.println(name + " is in awful condition")
    }

    val healthstatus = if (healthPoint >= 90) {
        "is in excellent condition"
    } else {
        " is in awful condition"
    }

    System.out.println(name + healthstatus)

    val helthstatus3 = if (healthPoint in 0..99) {
        " little hurt"
    } else {
        "manxue"
    }

    System.out.println(name + helthstatus3)

    val race = "gnome3"
    val faction = when (race) {
        "gnome" -> "keepers of the Mines"
        "gnome2" -> "keepers of the Mines2"
        else -> "has some problem"
    }

    System.out.println(name + faction)

    val healthstatus4 = formmatHealthStatus(healthPoint)

    System.out.println(name + healthstatus4)

    val blessed = false
    System.out.println("~~ $name $healthstatus4")
    printStatus(name, healthstatus4, blessed)
    printStatus(name = "zhangsan" , blessed = true , healthstatus4 = "999") //具名函数参数

//    castFireball(5)
    castFireball() // 默认参数
    castFireballForSingle()  // 单表达式函数
    shouldReturnString()  // TODO == throw NotImplementedError


    // practice
//    System.out.println(1 in 1..3)
//    System.out.println((1..3).toList())
//    System.out.println(1 in 3 downTo 1)     //  downTo  包含结尾
//    System.out.println(1 in 1 until 3)
//    System.out.println(3 in 1 until 3)  // false   util不包含结尾
//    System.out.println(2 in 1..3)       //true
//    System.out.println(2 !in 1..3)      //false
//    System.out.println('x' in 'a'..'z') //true
//    1 in 1..3
//    (1..3).toList()
//    1 in 3 downTo 1
//    1 in 1 until 3
//    3 in 1 until 3
//    2 in 1..3
//    2 !in 1..3
//    'x' in 'a'..'z'

}

private fun printStatus( name: String,healthstatus4: String,blessed: Boolean) {
    System.out.println("~~ $name $healthstatus4" + "is blessed === ${if (blessed) "yes" else "no"}")
}

private fun formmatHealthStatus(healthPoint: Int): String {
    val healthstatus4 = when (healthPoint) {
        100 -> "manxue"
        in 90..99 -> " nice status"
        else -> " a little hurt"
    }
    return healthstatus4
}

private fun formathhhh(heathpoint: Int, isbless: Boolean) {

}

private fun castFireball(count : Int =2 ){
    System.out.println("a glass of fireball springs into existance.(x$count)")
}

private fun castFireballForSingle(count: Int = 2) = System.out.println("single fun ---- a glass of fireball springs into existance.(x$count)")

fun shouldReturnString():String{
    TODO("just todo")
    println("after todo")
}

