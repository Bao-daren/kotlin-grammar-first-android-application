package com.ewell.scanner.aaatestkotlin;

import androidx.annotation.Nullable;

import java.io.IOException;

import kotlin.jvm.functions.Function1;

/**
 * create by BHB on 6/1/21
 * kotlin与java互操作
 */
public class kotlin20Java {

    private int point = 100;

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public void throwJavaException() throws Exception {
        throw  new Exception();
    }

    public String getJavaName(){
        return "java" ;
    }

    @Nullable   //在java方法中注明允许为空  kotlin调用是就会提示
    public String getFriend(){
        return null;
    }

    //  java调用kotlin函数
    public static void main(String[] args) {
//        System.out.println(Kotlin20Kt.getKotlinName());
        System.out.println(kkk.getKotlinName());

        kkk.handFood();

        // java调用只能通过 get set方法访问属性
        Spellbook spellbook = new Spellbook();
        System.out.println(spellbook.splls);

        // 使用静态属性访问即可
        System.out.println(Spellbook.MAX_SPELL_COUNT);

        Spellbook.saySomething();




        try {
            kkk.throwKotlinException();
        }catch (Exception e){
            System.out.println("java catch kotlinException,,");
        }

        //Function 代表kotlin的fun 后面的数字1或者2 表示方法的传参个数 <>里面代表传参的类型 和 返回的类型
        Function1<String,String> translator = kkk.getTranslator() ;
        // 调用方法使用 invoke 传入传参
        System.out.println(translator.invoke("hhhhaaa")) ;


    }

}
