package com.aggregation.mashibing.designPattern.prototype.v1;

/**
 * @description:
 * @author:
 * @create: 2019-09-08 02:54
 **/
public class Test {

    public static void main(String[] args) throws CloneNotSupportedException {
        //浅克隆
        Person person = new Person();
        Person person1 = (Person) person.clone();
        System.out.println(person1.age);
        System.out.println(person1.score);
        System.out.println(person.location == person1.location);
        person.location.address = "new adress";
        System.out.println(person1.location.address);
        /**
         *克隆的过程，基本类型直接克隆，引用类型 源对象和克隆对象指向同一个内存地址
         */

    }
}

/**
 * @Description: Cloneable 是一个标志性接口
 * @Param:
 * @return:
 * @Date: 2019/9/8  2:57
 */
class Person implements Cloneable {
    int age = 8;
    int score = 100;
    Location location = new Location("adress", 18);

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Location {
    String address;
    int number;

    public Location(String address, int number) {
        this.address = address;
        this.number = number;
    }

    @Override
    public String toString() {
        return "Location{" +
                "address='" + address + '\'' +
                ", number=" + number +
                '}';
    }
}
