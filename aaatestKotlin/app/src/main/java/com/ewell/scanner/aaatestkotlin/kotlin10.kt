package com.ewell.scanner.aaatestkotlin

import java.util.*

/**
 *  create by BHB on 5/28/21
 *  list 与 set
 */

fun main() {

    // 创建list 并赋初始值     中间<>称为泛型 限制了类型
    var  patronList:List<String> = listOf("aa","bb","cc")
    println(patronList)   // [aa, bb, cc]

    // 获取list元素
    println("${patronList[0]}  ${patronList[1]} ${patronList[2]}" )

    // 超出角标会抛出异常
//    patronList[4]    ArrayIndexOutOfBoundsException

    // 越界取值 getOrElse
    println(patronList.getOrElse(4){"default 4"})

    // getOrNull
    println(patronList.getOrNull(4)?:"default null 4")

    // 判断list 是否包含某个值 contains
    println("list is contain aa ${patronList.contains("aa")}")
    println("list is contain dd ${patronList.contains("dd")}")

    //判断list 是否包含list
    println("list is contain aa bb ${patronList.containsAll(listOf("aa","bb"))}")
    println("list is contain aa cc ${patronList.containsAll(listOf("aa","cc"))}")
    println("list is contain aa dd ${patronList.containsAll(listOf("aa","dd"))}")

    // 删除、添加、修改  list创建的是只读列表  不能修改
    // 需要可变列表可以使用  mutableListOf
    var  mutableList  = mutableListOf("aa","bb","cc")
    mutableList.add("dd")
    mutableList.remove("aa")
    mutableList.remove("ee")
    mutableList.add(0 , "oo")
    mutableList[3] = "33"
    println(mutableList)

    //遍历
    for (item in mutableList){
        println("in 遍历 $item")
    }

    mutableList.forEach {
        println("each 遍历 $it")
    }

    // 遍历每一个元素的值和位置
    mutableList.forEachIndexed { index, s ->
        println("$s you are in $index")
     }

    //解构  把list元素内的值 依次赋值给对应位置的变量
    var (name1,name2,name3)  =  listOf<String>("aa","bb","cc")
    println("name1=$name1")
    // 随机排列
    var menuList = listOf<String>("aa","bb","cc")
    println("random first ==  ${menuList.shuffled().first()}" )


    // set集合
    // set会自动去重
    val planets = setOf<String>("aa","bb","cc","aa","bb","cc"  )
    println(planets)

    //是否包含某个值
    println(planets.contains("aa"))

    // 获取set的 第三个元素
    println(planets.elementAt(2))


    // set只读  需要可以改变的set可以使用 mutableSetOf
    val addSet = mutableSetOf("aa" , "bb" , "cc")

    println(addSet)
    addSet += "dd"
    println(addSet)


    //while 循环与 break
    //数组随机排列取第一个元素   如果满足条件就提前结束  最多循环3次
    var namelist = listOf<String>( "aa","bb","cc","dd","ee")
    var orderCount = 0 ;
    var targetName :String? = null
    while (orderCount < 3){
        orderCount++
        var name = namelist.shuffled().first()
        if(name == "ee"){
            targetName = name
            break
        }
    }
    println("遍历了$orderCount 次 最终找到了name: $targetName")

    // 集合转换
    // 使用toSet与toList函数  或者toMutableList 和 toMutableSet   可以实现list 和set 的相互转换
    // 一个小技巧:  调用toSet去掉list集合里的重复元素

    var changeSet  = listOf("aa","bb","cc","aa").toSet()
    println(changeSet)
    var changeList = changeSet.toList()
    println(changeList)

    //kotlin封装了函数 distinct   先调用toSet在调用toList
    var parotns = listOf("aa","bb","cc","aa").distinct()
    println(parotns)
    println(parotns[0])

    //数组类型
    // kotlin 本身不建议使用 但是如果需要调用一个java方法  java方法的入参是一个数组类型
    val ages = intArrayOf(1,2,3,4,5)

}