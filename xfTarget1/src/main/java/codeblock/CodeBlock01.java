package codeblock;

public class CodeBlock01 {
    public static void main(String[] args) {
        final Movie movie = new Movie("Hello World");
        System.out.println("============");
        final Movie movie2 = new Movie("USA",100,"李安");
    }
}
class Movie{
    private String name;
    private double price;
    private String director;

    //三个构造器 -》重载
    //下面三个构造器都有相同的语句
    //这样代码看起来冗余
    //这时可以把相同的语句放入到一个代码块中
    //这样我们不管调用哪个构造器 创建对象 都会先调用代码块的内容
    //代码块的调用优先于构造器
    {
        System.out.println("电影屏幕打开...");
        System.out.println("广告开始了...");
        System.out.println("电影正式开始...");
    }
    public Movie(String name, double price, String director) {
        System.out.println("Movie(String name, double price, String director)被调用");
        this.name = name;
        this.price = price;
        this.director = director;
    }

    public Movie(String name, double price) {

        this.name = name;
        this.price = price;
    }

    public Movie(String name) {
        System.out.println("Movie(String name)被调用");
        this.name = name;
    }
}
