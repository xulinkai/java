package com.aggregation.basic.fan.xing;

/**
 * @Desc 泛型类
 */
public class NormalGeneric<T> {

    private T data;

    /**
     * 不是一个泛型方法
     * 只是一个类中普通的成员方法，只不过它的返回值是在生命泛型类已经生命过的泛型
     */
    public T getKey() {
        return data;
    }


    /**
     * 表示传递给方法的参数，必须是T的子类（包括T本身）
     */
    public void print(NormalGeneric<? extends Object> normalGeneric) {

    }

    /**
     * 表示传递给方法的参数，必须是T的超类（包括T本身）
     */
    public void print1(NormalGeneric<? super Object> normalGeneric) {

    }


}
