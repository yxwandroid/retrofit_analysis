package com.wilson.retrofit_analysis.design_pattern;

/**
 * https://www.runoob.com/design-pattern/strategy-pattern.html
 * 策略模式
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




