package com.wilson.retrofit_analysis.design_pattern;

/**
 * https://www.runoob.com/design-pattern/proxy-pattern.html
 * <p>
 * <p>
 * 代理模式:一个类代理另外一个类的功能
 * 目的 为其他对象提供代理以控制这个对象的访问
 */
public class ProxyPatternDemo {

    public static void main(String[] arr) {
        Image image = new ProxyImage("test_10mb.jpg");

        // 图像将从磁盘加载
        image.display();
        System.out.println("");
        // 图像不需要从磁盘加载
        image.display();


    }
}


interface Image  {
    void display();
}


class RealImage implements Image {
    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFile();
    }

    private void loadFile() {
        System.out.println("load file ");
    }

    @Override
    public void display() {
        System.out.println("disPlay image");

    }
}


class ProxyImage implements Image {
    private String fileName;

    private RealImage realImage;

    public ProxyImage(String fileName) {
        this.fileName = fileName;

    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }
        realImage.display();


    }
}
