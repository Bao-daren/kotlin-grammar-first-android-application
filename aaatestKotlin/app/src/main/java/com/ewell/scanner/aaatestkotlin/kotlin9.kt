package com.ewell.scanner.aaatestkotlin

import java.io.File

/**
 *  create by BHB on 5/28/21
 *  标准函数库
 */

fun main() {
//    未使用apply
    val menuFile = File("menu-file.txt")
    menuFile.setReadable(true)
    menuFile.setWritable(true)
    menuFile.setExecutable(true)

    //使用apply 可以减少冗余代码
    val menuFile2 = File("menu-file.txt").apply {
        //相关作用域
        setReadable(true)
        setWritable(true)
        setExecutable(true)
    }


    //未使用let
    val firstElement = listOf(1,2,3).first()
    val firstItemSquare = firstElement * firstElement
    //使用let
    val firstItemSquare2 = listOf(1,2,3).first().let {
        it * it
    }

    //未使用let
    fun formatGreeting(vipGuest :String?):String{
        return if(vipGuest == null){
            "welcome  you will be seated shortly"
        }else{
            "welcome $vipGuest your table is ready"
        }
    }
    // 使用let
    fun formatGreeting2(vipGuest : String?):String{
        return vipGuest?.let { "welcome $vipGuest your table is ready" }?:"welcome  you will be seated shortly"
    }

    //run用来执行函数 或链式调用
    fun nameIsLong(name:String):Boolean{
        println("$name islong= ${name.length >= 20}")
        return name.length >= 20
    }
    //
    nameIsLong("dadsadada")
    // 疑问 为啥返回的是一个 kfunction1 类型
    var result = "bhb".run { ::nameIsLong }
    println(result.invoke("ddddddd"))

    fun playerCreateMessage(nametoLong:Boolean):String{
        return if (nametoLong){
            "name is too long , chooose another"
        }else{
            "welcome adventure"
        }
    }

    fun myPrint(message:String){
        println(message)
    }
    "asdfghjjklzxcvb , sfghljjtioej".run(::nameIsLong).run { ::playerCreateMessage }.run { ::myPrint }

    // with 是run 的变体 他们的功能是一样的单with 的调用方式不同 调用with时需要值参作为其第一个参数传入
    val nameTooShort = with("bhb"){
        length < 5
    }
    println(nameTooShort)

    //also  also函数与let类似 只不过also返回接收者对象 let返回lambda表达式的结果
    // also 用于基于原始对象执行额外的链式调用
    var num = 1
    num.also { println(it) }.also { println(it+it) }

    //takeIf 需要判断lambda表达式 如果结果是true 返回接收者对象  如果是false 则返回null
    // 未使用takeIf
    val file = File("myfile.txt")
    var fileContent = if(file.canRead() && file.canWrite()){
        file.readText()
    }else{
        null
    }

    //使用takeIf
    var fileContent2 = File("myfile.txt").takeIf { it!= null && it.canRead() && it.canWrite() }?.readText()?:"default text"
    println(fileContent2)

    //takeUnless  用法与takeIf相同  只不过只有在表示式结果为false 时才返回接收者对象

}