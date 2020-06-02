package com.wilson.retrofit_analysis.design_pattern;

/**
 * https://www.runoob.com/design-pattern/facade-pattern.html
 * 外观模式 隐藏系统的复杂性 向客户端提供访问系统的接口
 * 优点  减少系统相互依赖 提供了灵活性,安全性
 * 缺点  不符合开闭原则 修改东西比较麻烦
 */
public class FacadePatternDemo {

    public static void main(String[] arr) {
        ShapeMaker shapeMaker = new ShapeMaker();

        shapeMaker.drawCircle();
        shapeMaker.drawRectangle();
        shapeMaker.drawSquare();

        System.out.println("wilson");
    }
}


interface Shape {
    void draw();
}

class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Rectangle::draw()");
    }
}

class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("Square::draw()");
    }
}

class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Circle::draw()");
    }
}

class ShapeMaker {
    private Shape circle;
    private Shape rectangle;
    private Shape square;

    public ShapeMaker() {
        circle = new Circle();
        rectangle = new Rectangle();
        square = new Square();
    }

    public void drawCircle() {
        circle.draw();
    }

    public void drawRectangle() {
        rectangle.draw();
    }

    public void drawSquare() {
        square.draw();
    }
}