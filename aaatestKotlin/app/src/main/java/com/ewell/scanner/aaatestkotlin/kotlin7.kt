package com.ewell.scanner.aaatestkotlin

import kotlin.math.roundToInt

/**
 *  create by BHB on 5/27/21
 *  字符串  int double 转换
 */

fun main() {

    // 使用substring 截取字符串
    fun placeOrder(){
        val TAVERN_NAME = "Taernyl's Foolly"
        val indexOfApostorephe = TAVERN_NAME.indexOf('\'')
        val travernMaster = TAVERN_NAME.substring(0 until indexOfApostorephe)
        println("madrigal speak with $travernMaster")
    }

    placeOrder()


    //使用split 分割字符串
    fun splitOrder(){
        val order = "shandy,drangon's breath ,5.91"
        val data = order.split(',')  // data为list类型

        println("type:${data[0]} name:${data[1]} price:${data[2]}")

        //结构赋值
        val(type , name , price) = order.split(',')
        println("type:$type name:$name price:$price")

    }
    splitOrder()

    // 使用replace 替换字符串
    fun replaceStr(name:String) : String{
        return name.replace('a','b');
    }

    // 使用relpace 正则替换
    fun replaceStrReg(name:String) :String {
         return name.replace(Regex("[a]")){
            when(it.value){
                "a" -> "b"
                else -> it.value
            }
        };
    }
    println(replaceStr("aabbcc123"))
    println(replaceStrReg("aabbcc123"))

   //字符串比较
    var name1 = "aaa"
    var name2 = "aaa"
    println(name1 == name2)  //值比较      true
    println(name1 === name2) // 内存地址比较  true

    var c = String(listOf<Char>('a', 'b').toCharArray())
    var d = "ab"
    println("c=$c d=$d c===d ${c === d}") // 内存地址比较  false

    //unicode
    println("unicode:" + '\u0950')

    //遍历字符串
    "bhb".forEach {
        println(it)
    }

    //string转数值类型
    val gold = "1.1".toDouble();
    println(gold)

    // int 转  double
    val money = 99 ;
    var intmoney = 99/100 ;
    var floatmoney = 99/100.0 ;
    println(" $intmoney   $floatmoney")

    //double 格式化
    var doubleMoney = 1.111112222333
    var formatMoney = "%.2f".format(doubleMoney)
    println("$doubleMoney    $formatMoney")

    //double 转 int
    var doubleMoney2 = 1.9911112222333
    println(doubleMoney2.roundToInt()) //四舍五入
    println(doubleMoney2.toInt()) //上取整

}