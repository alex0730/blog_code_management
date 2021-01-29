package com.lee;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SbblogApplicationTests {

    @Test
    void contextLoads() {

    }

    public static void main(String[] args) {
        // 创建Integer类型的几种方式(取值范围：-128到127之间)
        Integer i1 = 59;
        Integer i2 = new Integer(59);
        Integer i3 = Integer.valueOf(59);
        int i4 = 59;
        Integer i8 = Integer.valueOf(59);
        // 只要是包装类型和基本类型“==”时，包装类型“拆箱”调用Integer.intValue()方法后，比较基本类型的值
        System.out.println("i1 == i4:" + (i1 == i4));// true
        System.out.println("i3 == i4:" + (i3 == i4));// true
        // Integer i1 = 59 会调用Integer的“装箱”调用Integer.valueOf(59)；即Integer i1 = Integer.valueOf(59)；
        // 且59在-128到127之间，所以该值是从“运行时常量池”中取值。
        System.out.println("i1 == i3:" + (i1 == i3));// true
        // Integer.valueOf(59)是从“运行时常量池”中取值；而new Integer(59)是在堆中创建对象，所以二者不是同一个对象
        System.out.println("i2 == i3:" + (i2 == i3));// false

        // 创建Integer类型的几种方式(取值范围：非-128到127之间)
        Integer i5 = 130;
        Integer i7 = Integer.valueOf(130);
        // Integer i1 = 130 会调用Integer的“装箱”调用Integer.valueOf(130)；即Integer i1 = Integer.valueOf(130)；
        // 但130在-128到127之间，所以i5和i7会在堆中各自分配内存，所以二者不是同一对象
        System.out.println("i5 == i7:" + (i5 == i7));// false

//        // 创建字符串类型的几种方式
//        String s1 = "string";
//        String s2 = "string";
//        // new String("string")一共创建了几个对象？如果“运行时常量池”中不存在“string”对象，该语句执行时首先会在字符串常量池中创建一个“string”，
//        // 在执行new语句时在堆去开辟新的空间，创建“string”字符串，如果“运行时常量池”中存在“string”对象，则只会在执行new语句是在堆中创建一个对象。
//        String s6 = new String("string");
//        String s5 = "string" + "string";
//        String s3 = "stringstring";
//        String s4 = s1 + s2;
//        String s7 = new String("stringstring");
//        // “string”字符串都来源于“运行时常量池”，所以“==”是返回“true”。
//        System.out.println("s1 == s2:" + (s1 == s2)); // true
//        // String s1来自于“运行时常量池”，此时String s6会现在“运行时常量池”创建一个“string”对象，
//        // 然后才在堆中分配“string”对象的内存，所以“==”返回false。
//        System.out.println("s1 == s6:" + (s1 == s6));// false
//        System.out.println("s3 == s7:" + (s3 == s7));// false
//        // String s2来自于“运行时常量池”，此时String s6已经在“运行时常量池”创建过一个“string”对象，所以“==”返回true。
//        System.out.println("s2 == s6:" + (s1 == s2));// true
//        // 两个字面量字符串的“+”等同于将两个字面量放在一组""内，所以“==”返回true。
//        System.out.println("s3 == s5:" + (s3 == s5));// true
//        // 两个String对象的“+”等同于(new StringBuilder()).append(s1).append(s2).toString()，是一个新的对象，所有“==”返回true。
//        System.out.println("s3 == s4:" + (s3 == s4));// false
//        System.out.println("s7 == s4:" + (s7 == s4));// false


    }

}
