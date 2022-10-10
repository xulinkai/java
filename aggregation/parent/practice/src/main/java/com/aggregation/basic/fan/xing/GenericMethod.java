package com.aggregation.basic.fan.xing;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * @Desc
 */
public class GenericMethod {

    /**
     * 泛型方法
     * 在public 与 返回值之间的<T>必不可少 表明这是一个泛型方法，并且声明了一个泛型T
     */
    public <T> T genericData(T t) {
        return null;
    }


    /**
     * 不能在静态域或方法中引用类型变量。因为泛型是要在对象创建的时候才知道是什么类型的，而对象创建的代码执行先后顺序是static的部分，然后才是构造函数等等。
     * 所以在对象初始化之前static的部分已经执行了，如果你在静态部分引用的泛型，那么毫无疑问虚拟机根本不知道是什么东西，因为这个时候类还没有初始化。
     * <p>
     * 是静态方法本身是静态方法 可以
     */
    public static <T> T min(T a, T b) {
        return a;
    }

    public static <T extends Comparable> T min(T a, T b) {
        return a.compareTo(b) > 0 ? a : b;
    }

    public static <T extends Comparable, k extends Comparable> T min1(T a, T b) {
        return a.compareTo(b) > 0 ? a : b;
    }

    /**
     * 泛型只在编译阶段起作用，反射可以绕过泛型
     */
    public void test() throws Exception {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(1);
        al.add(2);
        //获取链表的add方法，注意这里是Object.class，如果写int.class会抛出NoSuchMethodException异常
        Method m = al.getClass().getMethod("add", Object.class);
        //调用反射中的add方法加入一个string类型的元素，因为add方法的实际参数是Object
        m.invoke(al, "hello");
        System.out.println(al.get(2));
    }

    /**
     * 这是因为不管为泛型的类型形参传入哪一种类型实参，对于Java来说，它们依然被当成同一类处理，在内存中也只占用一块内存空间。
     * 从Java泛型这一概念提出的目的来看，其只是作用于代码编译阶段，在编译过程中，对于正确检验泛型结果后，会将泛型的相关信息擦出，
     * 也就是说，成功编译过后的class文件中是不包含任何泛型信息的。泛型信息不会进入到运行时阶段。
     * 在静态方法、静态初始化块或者静态变量的声明和初始化中不允许使用类型形参。由于系统中并不会真正生成泛型类，所以instanceof运算符后不能使用泛型类
     * <p>
     * 反省擦除：编译器编译带类型说明的集合时会去掉类型信息
     */
    public void testType() {
        ArrayList<Integer> collection1 = new ArrayList<>();
        ArrayList<String> collection2 = new ArrayList<>();

        //两者class类型一样,即字节码一致
        System.out.println(collection1.getClass() == collection2.getClass());

        //class均为java.util.ArrayList,并无实际类型参数信息
        System.out.println(collection2.getClass().getName());
    }


}
