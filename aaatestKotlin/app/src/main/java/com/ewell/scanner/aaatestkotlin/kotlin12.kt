package com.ewell.scanner.aaatestkotlin

/**
 *  create by BHB on 5/28/21
 *   定义类 初始化
 */


fun main() {

    // 定义类
    class Player {

        //无参构造方法
        constructor(){

        }

        // 有参构造方法
        constructor(name : String){
            this.name = name
        }

        var name = "bhb"
            public get() = field        // get方法  field关键字自动指向支持管理的字段
            internal set(value){         // set方法
                field = value
            }
        // 计算属性
        var rollValue = 1
            get() = (1..6).shuffled().first()
        /**
         *  定义方法  默认修饰符为public 一共有四种修饰符
         *  public 函数或属性对于外部可见
         *  private 函数或属性仅在自己的内部可见
         *  protected 函数或属性仅在类和该类的子类内部可见
         *  internal  函数和属性仅在同一模块内可见
         */
        fun sayHello() {
            println("hello  $name")
        }
    }

    // 创建类
    var player = Player()
    // 调用类方法
    player.sayHello()

    player.name = "baodaren"
    println(player.name)

    var player2 = Player("zhangsan");
    player2.sayHello()


    class Person{
        var player :Player? = Player("bbb")
        fun sayname(){
            if(player != null){
                println(player.name)
            }
        }
    }
    Person().sayname()

    class Student(_name :String){
        var name = _name
        fun saySomething(){
            println("i am student $name")
        }
    }
    var student = Student("bbb")
    student.saySomething()

    // 类名后面的是主构造函数  age为默认参数
    class Teacher(var name:String, var subject :String , var age:Int = 20){


        // constructor 修饰次要构造函数
        constructor():this("defaultname","defaultclass")

        constructor( _name:String):this(_name ,"defaultclass",22)

        fun saySomething(){
            println("i teacher  $name  teach $subject  my age is $age")
        }
    }
    var teacher = Teacher()
    teacher.saySomething()
    var teacher2 = Teacher("bhb" )
    teacher2.saySomething()

    //初始化块  用来检查创建对象时 传入参数的有效性
    class Staff(var age :Int){
        init {
            //判断员工年龄是否大于18
            require(age >= 18){ "age is too small "}
        }
    }

//    var staff = Staff(10) // 抛出异常IllegalArgumentException

    //初始化块  用来检查创建对象时 传入参数的有效性
    class Staff2(var age :Int){
        lateinit var name :String
        init {
            //判断员工年龄是否大于18
            require(age >= 18){ "age is too small "}
        }

        fun saySomething(){
            println("i teacher  $name   my age is $age")
        }
    }


    var staff2 = Staff2(20)
//    staff2.saySomething()  // 调用该方法会抛出异常 UninitializedPropertyAccessException

    // 惰性初始化   一开始不初始化 在初次使用时在初始化  一般用于复杂耗时或者耗费资源的对象

    class Staff3(var age :Int){
        val name by lazy { "bhb" }

        fun saySomething(){
            println("i teacher  $name   my age is $age")
        }
    }

    var staff3 = Staff3(20)
    staff3.saySomething()


    class Sword(_name:String){
        var name = _name
        get()="the sword $field"
        set(value){
            field = value.toString().reversed().capitalize()
        }

        init {
            name = _name
        }
    }

    var sword = Sword("abc")
    println(sword.name)
}