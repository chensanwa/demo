package com.designpatterns;

/**
 * @program: demo
 * @description: 单例模式
 * @author: Mr.Chen
 * @create: 2018-05-04 21:20
 **/

/**
 * 单例模式
 * 应用场合：对象只需要一个就足够
 * 作用：保证整个应用程序中某个实例只有一个
 * 类型：饿汉模式、懒汉模式
 * 懒汉模式与饿汉模式的区别：
 *      饿汉模式的特点是加载类时比较慢，但运行时获取对象的速度比较快,线程安全
 *      懒汉模式的特点时加载类时比较快，但运行时获取对象的速度比较慢，非线程安全
 */
public class Singleton {

    //1、将构造方法私有化，不允许外部直接创建对象
    private Singleton(){

    }
//
    //2、创建类的唯一实例、使用private static修饰(饿汉模式)
    private static Singleton instance = new Singleton();

    //3、提供一个用于获取实例的方法（饿汉模式）
    public static Singleton getInstance(){
        return instance;
    }

//    //2、声明类的唯一实例，使用private static修饰(懒汉模式)
//    private static Singleton instance;
//
//    //3、提供一个用于获取实例的方法，使用public static修饰（懒汉模式）
//    public static Singleton getInstance(){
//        if (instance == null){
//            instance = new Singleton();
//        }
//        return instance;
//    }


    public static void main(String[] args) {

        //懒汉模式
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        if (singleton1 == singleton2){
            System.out.println("singleton1 == singleton2");
        } else {
            System.out.println("singleton1 != singleton2");
        }

//        //饿汉模式
//        Singleton singleton3 = Singleton.getInstance();
//        Singleton singleton4 = Singleton.getInstance();
//        if (singleton3 == singleton4){
//            System.out.println("singleton3 == singleton4");
//        } else {
//            System.out.println("singleton3 != singleton4");
//        }

    }

}
