package com.ewell.scanner.aaatestkotlin

import kotlin.math.cos

/**
 *  create by BHB on 5/26/21
 *
 *  匿名函数与函数类型
 */

fun main() {
    val numletters = "mississippi".count()
    println(numletters)

    // 只查询's' 出现的次数
    val nums = "mississippi".count({
        letter -> letter == 's'
    })
    println(nums)

    //  使用it 关键字
    val nums2 = "mississippi".count({
            it == 's'
    })
    println(nums2)


    val greetingFunction : (String,Int) -> String = { player,year ->
        val currentyear = 2021
        "welcom to simvillage , $player! (copyright $year)"
        //匿名函数会把最后一行语句当做返回结果  不需要return 关键字
    }


    //  无参匿名函数 可以使用类型推断
    val greetingFunction2 = {
        val currentyear = 2021
        "welcom to simvillage , mayor! (copyright $currentyear)"
        //匿名函数会把最后一行语句当做返回结果  不需要return 关键字
    }

    //  有参匿名函数 可以使用类型推断  但是必须制定参数类型
    val greetingFunctio3  = { player:String,year:Int ->
        //匿名函数会把最后一行语句当做返回结果  不需要return 关键字
        "welcom to simvillage , $player! (copyright $year)"
    }

    // 只有一个参数的匿名函数可以使用  it  关键字
    val greetingFunctionit : (String) -> String = {
        val currentyear = 2021
        //匿名函数会把最后一行语句当做返回结果  不需要return 关键字
        "welcom to simvillage , $it! (copyright $currentyear)"
    }

    println(greetingFunction("bhb" , 1994))
    println(greetingFunctionit("bhb22"))



    fun printCost(numbuilding : Int){
        val cost = 500
        println("cost: ${cost*numbuilding}")
    }
    // 把函数当做入参
    fun runSimulation(player:String , cosprinter :(Int) -> Unit, greetFun:(String,Int) -> String ){
        val numBuildings = (1..3).shuffled().last()
        cosprinter(numBuildings)
        println(greetFun(player,numBuildings))
    }
    //::printCost 为fun的引用   greetingFunctio3为 val 定义的函数引用
    runSimulation("baodaren" , ::printCost, greetingFunctio3 )
    runSimulation("baodaren", ::printCost){ player,year ->
        //匿名函数会把最后一行语句当做返回结果  不需要return 关键字
        "welcom to simvillage , $player! (copyright $year)"
    }

    // 返回类型为 函数
    fun configureGreetingFunction():(String) -> String{
        val type = "hospital"
        var numbuiding = 5
        return {
            playername:String ->
            numbuiding += 1
            "welcom to $type  $numbuiding"
        }
    }

    fun getFuncArr(){
        val getFunc = configureGreetingFunction();
        println(getFunc(""));
        println(getFunc(""));
        println(getFunc(""));
    }

    val getFunc = configureGreetingFunction();
    println(getFunc(""));
    println(getFunc(""));
    println(getFunc(""));  //每次调用numbuiding 的数值都会累加  说明同一个方法内部的变量是互通的 lambda是闭包
    getFuncArr()
}