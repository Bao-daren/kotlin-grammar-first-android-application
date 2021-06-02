package com.ewell.scanner.aaatestkotlin


/**
 *  create by BHB on 5/25/21
 */
private fun <T> List<T>.rand() =shuffled().first()


private fun Int.roll() = (0 until this)
    .map { (1..6).toList().rand() }
    .sum()
    .toString()

fun main(args:Array<String>){
    System.out.println("hello world")

    var sss = (0 until 3).map { (1..2).toList().rand() }
    println(sss)
    println(sss.sum())
}