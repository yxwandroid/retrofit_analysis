package com.wilson.retrofit_analysis.design_pattern;

/**
 * https://www.runoob.com/design-pattern/decorator-pattern.html
 * 装饰模式
 * 动态地给一个对象添加一些额外的职责。就增加功能来说，装饰器模式相比生成子类更为灵活。
 *
 */
class DecoratorPatternDemo {
    static void main(String[] args) {

        Shape1 circle = new Circle1();
        ShapeDecorator redCircle = new RedShapeDecorator(new Circle1());
        ShapeDecorator redRectangle = new RedShapeDecorator(new Rectangle1());
        //Shape redCircle = new RedShapeDecorator(new Circle());
        //Shape redRectangle = new RedShapeDecorator(new Rectangle());
        System.out.println("Circle with normal border");
        circle.draw();

        System.out.println("\nCircle of red border");
        redCircle.draw();

        System.out.println("\nRectangle of red border");
        redRectangle.draw();
    }
}

interface Shape1 {
    void draw();
}

class Rectangle1 implements Shape1 {

    @Override
    public void draw() {
        System.out.println("Shape: Rectangle");
    }
}

class Circle1 implements Shape1 {

    @Override
    public void draw() {
        System.out.println("Shape: Circle");
    }
}

abstract class ShapeDecorator implements Shape1 {
    protected Shape1 decoratedShape;

    ShapeDecorator(Shape1 decoratedShape) {
        this.decoratedShape = decoratedShape;
    }

    public void draw() {
        decoratedShape.draw();
    }
}

class RedShapeDecorator extends ShapeDecorator {

    RedShapeDecorator(Shape1 decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        setRedBorder(decoratedShape);
    }

    private void setRedBorder(Shape1 decoratedShape) {
        System.out.println("Border Color: Red");
    }
}