package com.wilson.retrofit_analysis.design_pattern;

/**
 * https://www.runoob.com/design-pattern/strategy-pattern.html
 * 策略模式
 * 定义一组算法，将每个算法都封装起来，并且使他们之间可以互换
 * Retrofit 采用了策略模式
 * 提供了四种CallAdapterFactory：
 * ExecutorCallAdapterFactory（默认）、
 * GuavaCallAdapterFactory、
 * Java8CallAdapterFactory、
 * RxJavaCallAdapterFactory
 *
 *
 * 链接：https://juejin.im/post/5a9f36acf265da23a1416cb6
 */

public class StrategyPatternDemo {

    public static void main(String[] arr) {

        Content content = new Content(new OperationAdd());
        content.executeStrategy(2, 3);
        Content content2 = new Content(new OperationMultiply());
        content.executeStrategy(2, 3);
        Content content3 = new Content(new OperationSubTract());
        content.executeStrategy(2, 3);


    }
}


class Content {

    private Strategy strategy;

    public Content(Strategy strategy) {
        this.strategy = strategy;
    }


    public void executeStrategy(int num1, int num2) {

        this.strategy.doOperation(num1, num2);
    }
}

interface Strategy {
    public int doOperation(int num1, int num2);
}


class OperationAdd implements Strategy {

    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}

class OperationSubTract implements Strategy {

    @Override
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }
}


class OperationMultiply implements Strategy {

    @Override
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }
}




