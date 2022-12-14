package com.aggregation.mashibing.designPattern.builder;

/**
 * @description:
 * @author:
 * @create: 2019-09-08 00:54
 **/
public class Product {

    private String partA;

    private String partB;

    private String partC;

    @Override
    public String toString() {
        return "Product{" +
                "partA='" + partA + '\'' +
                ", partB='" + partB + '\'' +
                ", partC='" + partC + '\'' +
                '}';
    }

    public void show() {
        System.out.println("product show ...........");
        System.out.println(this);
    }

    public String getPartA() {
        return partA;
    }

    public void setPartA(String partA) {
        this.partA = partA;
    }

    public String getPartB() {
        return partB;
    }

    public void setPartB(String partB) {
        this.partB = partB;
    }

    public String getPartC() {
        return partC;
    }

    public void setPartC(String partC) {
        this.partC = partC;
    }
}
