package codeblock;

public class CodeBlockDetail02 {
    public static void main(String[] args) {
        final A a = new A();
    }
}
class A{
    private int n2 = getN2();//普通属性的初始化
    //静态属性的初始化
    private static int n1 = getN1();

    {//普通代码块
        System.out.println("A类 的普通代码块");
    }
    static {//静态代码块
        System.out.println("A类 的静态代码块");
    }
    public static int getN1(){
        System.out.println("getN1被调用");
        return 100;
    }
    public int getN2(){//普通方法 非静态方法
        System.out.println("getN2被调用");
        return 200;
    }
    //无参构造器
    public A(){
        System.out.println("A构造器被调用");
    }
}
