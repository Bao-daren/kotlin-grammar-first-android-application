package com.ewell.scanner.aaatestkotlin

/**
 *  create by BHB on 5/29/21
 *  继承
 */

fun main() {


    //先创建父类  使用关键字open 定义父类名 、 属性和父类方法
    open class Person(){
        open var name = ""
        open fun saySomeThing(){
            println("hello i am a persono")
        }

        fun helloWorld(){
            println("hello world")
        }
    }

    // 子类使用:继承父类
    class Teacher : Person() {

        // 使用override  覆盖父类属性
        override var name =  ""
        get() = field
        set(value) {field = value}

        // 使用 override 覆盖父类方法
        override fun saySomeThing(){
            println("hello i am a teacher my name is  $name")
        }

        fun teach(){
            println("i can teach")
        }

    }

    var person = Person()
    person.saySomeThing()

    // 创建子类
    var teacher : Teacher = Teacher()
    // 调用子类方法
    teacher.name = "bbb"
    teacher.saySomeThing()
    teacher.helloWorld()


    // 类型检测 使用 is 关键字
    println(person is Teacher)
    println(teacher is Person)

    // 类型转换 使用 as 关键字
    fun saysay(any: Any){
        if(any is Person){
            // 使用as转换
            (any as Person).helloWorld()
            // 智能类型转换
            any.helloWorld()
        }else{
            println("just saysay")
        }
    }

    saysay(teacher)

}