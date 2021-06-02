package com.ewell.scanner.aaatestkotlin

/**
 *  create by BHB on 5/26/21
 *
 *  if-else   when  条件语句
 */
fun main() {
    val name = "Madrigal"
    var healthPoint = 99
    if(healthPoint == 100){
        System.out.println(name + " is in excellent condition")
    }else{
        System.out.println(name + " is in awful condition")
    }

    val healthstatus = if (healthPoint >= 90) {
        "is in excellent condition"
    } else {
        " is in awful condition"
    }

    System.out.println(name + healthstatus)

    val helthstatus3= if(healthPoint in 0..99){
        " little hurt"
    }else{
        "manxue"
    }

    System.out.println(name + helthstatus3)

    val race = "gnome4"
    val isNormal = false
    val faction = when(race){
        "gnome" -> "keepers of the Mines"
        "gnome2" -> "keepers of the Mines2"
        "gnome3" -> if(isNormal) "gnome3 isnormal" else "gnome3 is not normal"
        else -> "has some problem"
    }

    System.out.println(name + faction)

    val healthstatus4 = when(healthPoint){
        100 -> "manxue"
        in 90..99 ->" nice status"
        else -> " a little hurt"
    }

    System.out.println(name + healthstatus4)

    val blessed = false
    System.out.println("~~ $name $healthstatus4")
    System.out.println("~~ $name $healthstatus4" + "is blessed === ${if (blessed) "yes" else "no"}")


    // practice
    System.out.println(1 in 1..3)
    System.out.println((1..3).toList())
    System.out.println(1 in 3 downTo 1)     //  downTo  包含结尾
    System.out.println(1 in 1 until 3)
    System.out.println(3 in 1 until 3)  // false   util不包含结尾
    System.out.println(2 in 1..3)       //true
    System.out.println(2 !in 1..3)      //false
    System.out.println('x' in 'a'..'z') //true
    1 in 1..3
    (1..3).toList()
    1 in 3 downTo 1
    1 in 1 until 3
    3 in 1 until 3
    2 in 1..3
    2 !in 1..3
    'x' in 'a'..'z'

}