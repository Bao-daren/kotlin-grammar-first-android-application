package com.ewell.scanner.aaatestkotlin

/**
 *  create by BHB on 5/30/21
 *  泛型
 */

fun main() {

    class Loot{

    }

    //定义泛型类  定义泛型函数 多泛型参数
    // <>符号中放一个字母T  T 是个代表item类型的占位符 然后将item赋值给同样是T类型的属性loot
    // T 可以是任意字母  不过约定俗成使用字母T 便于理解
    // T:Loot  约束性泛型 表示T只能是Loot类型或其子类
    class LootBox<T : Loot>(item:T){
        var loot:T = item
        var open = false
        //定义泛型函数
        fun featch():T?{
            return loot.takeIf { open }
        }

        //多泛型参数  传入一个函数作为传参 该函数需要传入一个T类型的变量 返回一个R类型的值
        fun <R> fetch(lootFun:(T) -> R) : R?{
            return lootFun(loot).takeIf { open }
        }
    }

    var lootBox = LootBox<Loot>(Loot())

    class LootBox2<T:Loot>(vararg item : T){
        var loot : Array<out T> = item
        fun get(index:Int): T {
            return loot.get(index)
        }
    }
    var lootBox2 = LootBox2<Loot>(Loot() , Loot() , Loot())
    var lootIndex = lootBox2.get(0)


    //  in  与 out


    open class Fruit{

    }
    class WaterMellon : Fruit() {

    }

    class Barrel<in T>(item:T){

    }

    var fruitBarrel = Barrel<Fruit>(Fruit())
    var waterMellonBarrel = Barrel<WaterMellon>(WaterMellon())
//    现在尝试给fruitBarrel 重新赋值
//    fruitBarrel = waterMellonBarrel

    waterMellonBarrel = fruitBarrel




}