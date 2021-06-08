package com.ewell.scanner.aaatestkotlin

/**
 *  create by BHB on 5/30/21
 *  函数式编程基础
 *  函数类别 ： 变换、过滤、合并
 */

fun main() {

    // 变换器函数 常用的变换函数 map、flatMap
    val animals = listOf("zebra" , "giraffe","elephant")
    val babies = animals.map { animals -> "a baby $animals" }
        .map { baby -> "$baby , with the cutest little tail ever!" }
    println(animals)
    println(babies)

    // flatMap  合并两个函数
    var list = listOf(listOf(1,2,3), listOf(4,5,6))
    println(list)
    println(list.flatMap { it })

    //过滤函数 filter
    val numbers = listOf(1,2,3,4,5,6,7,8,9,10)
    // 过滤出偶数
    var filterNumber = numbers.filter { it % 2 == 0 }
    println(filterNumber)

    // 合并函数 zip fold
    val list1 = listOf(1,2,3)
    val list2 = listOf(4,5,6)
    // 返回的是一个包含键值对的新集合
    var list3 = list1.zip(list2)
    var list4 = list3.toMap()
    println(list3)
    println(list4)

    // 根据自定义的表达式计算合并结果 fold(0) 0代表初始值为0
    val foldedValue = listOf(1,2,3,4).fold(0){acc, i ->
        println("acc value: $acc")
        // 每个元素*10 然后依次累加
        acc + (i * 10 )
    }
    println("foldvalue = $foldedValue")



}