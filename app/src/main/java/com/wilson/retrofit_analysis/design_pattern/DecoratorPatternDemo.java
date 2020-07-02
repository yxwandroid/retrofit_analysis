package com.wilson.retrofit_analysis.design_pattern;

/**
 * https://www.runoob.com/design-pattern/decorator-pattern.html
 * 装饰模式
 * 动态地给一个对象添加一些额外的职责。就增加功能来说，装饰器模式相比生成子类更为灵活。
 *
 *
 *
 *  retrofit 使用装饰模式的地方
 *      1, 采用了装饰模式：ExecutorCallbackCall = 装饰者，而里面真正去执行网络请求的还是OkHttpCall
 *      2, 使用装饰模式的原因：希望在OkHttpCall发送请求时做一些额外操作。这里的额外操作是线程转换，即将子线程切换到主线程
 *
 *        注意
 *          1,OkHttpCall的enqueue()是进行网络异步请求的：当你调用OkHttpCall.enqueue（）时，回调的callback是在子线程中，需要通过Handler转换到主线程进行回调。ExecutorCallbackCall就是用于线程回调；
 *          2,当然以上是原生Retrofit使用的切换线程方式。如果你用Rxjava，那就不会用到这个ExecutorCallbackCall而是RxJava的Call，此处不过多展开
 *
 * 链接：https://juejin.im/post/5a9f36acf265da23a1416cb6
 *
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