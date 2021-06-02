package com.ewell.scanner.aaatestkotlin

/**
 *  create by BHB on 5/30/21
 *   接口与抽象类
 */

//定义接口关键字 interface
interface sayEnable{

    //定义属性
    var type:String
    // 定义属性 并提供默认实现
    val hello:String
    get() = "hello world"
    // 定义函数
    fun saySomeThing()
}

fun main() {

    // 实现接口 :接口名
    class Student:sayEnable{
        // 实现属性
        override var type : String = "student"
        // 实现函数
        override fun saySomeThing() {
            println("$hello i am a $type")
        }

    }

    class Teacher:sayEnable{

        override var type : String = "teacher"
        override fun saySomeThing() {
            println("$hello i am a $type")
        }
    }

    var student = Student()
    student.saySomeThing()
    var teacher = Teacher()
    teacher.saySomeThing()

    // 定义抽象类 关键字abstract
    abstract class Person(){
        // 定义抽象方法 关键字abstract
        abstract fun doWork()
    }

    // 继承抽象类 :抽象类名
    class Staff : Person(){
        // 实现抽象方法
        override fun doWork() {
            println("i do somework")
        }
    }
    class Boss : Person(){
        override fun doWork() {
            println("i do busyness")
        }

    }

    //调用
    var staff = Staff()
    staff.doWork()
    var boss = Boss()
    boss.doWork()

}